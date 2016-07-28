package br.com.sari.service.impl;

import static br.com.sari.util.CheckUtil.isNullOrEmpty;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.sari.adapter.DozerAdapter;
import br.com.sari.dto.HistoricoMedicoDTO;
import br.com.sari.entidades.HistoricoMedico;
import br.com.sari.exception.BusinessException;
import br.com.sari.repository.HistoricoMedicoRepository;
import br.com.sari.service.HistoricoMedicoService;
import br.com.sari.util.BusinessExceptionMessages;
import br.com.sari.util.Entidades;
import br.com.sari.util.Utils;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = true, noRollbackFor = Exception.class)
public class HistoricoMedicoServiceImpl extends DozerAdapter implements HistoricoMedicoService {

	@Autowired
	HistoricoMedicoRepository historicoRepo;

	public HistoricoMedicoServiceImpl() {
		super();
	}

	@Override
	public HistoricoMedicoDTO salvar(final HistoricoMedicoDTO historicoMedicoDTO) throws BusinessException {

		try {
			final HistoricoMedico historicoMedico = (HistoricoMedico) converter(historicoMedicoDTO, HistoricoMedico.class);
			historicoMedico.setData(Utils.getDateTimeAtual());
			historicoRepo.save(historicoMedico);
			return (HistoricoMedicoDTO) converter(historicoMedico, HistoricoMedicoDTO.class);
		} catch (final Exception e) {
			throw new BusinessException(e.getMessage());
		}

	}

	@Override
	public void remover(final Long id) throws BusinessException {
		try {
			historicoRepo.delete(id);
		} catch (final EmptyResultDataAccessException e) {
			BusinessExceptionMessages.entidadeNaoEncontrada(Entidades.HISTORICO_MEDICO.getNome(), "Id", id.toString());
		}

	}

	@Override
	public List<HistoricoMedicoDTO> listarPorUsuario(final Long idUsuario) throws BusinessException {
		final List<HistoricoMedico> historicoMedicos = historicoRepo.findByUsuarioId(idUsuario);

		if (isNullOrEmpty(historicoMedicos)) {
			BusinessExceptionMessages.historicoMedicoNaoEncontrado();
		}

		final List<HistoricoMedicoDTO> historicoMedicosDTO = converterLista(historicoMedicos, HistoricoMedicoDTO.class);


		return historicoMedicosDTO;
	}

}
