package br.com.sari.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import br.com.sari.util.CheckUtil;
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
	public void salvar(HistoricoMedicoDTO historicoMedicoDTO) throws BusinessException {

		try {
			final HistoricoMedico historicoMedico = (HistoricoMedico) converter(historicoMedicoDTO, HistoricoMedico.class);
			historicoMedico.setData(Utils.getDateTimeAtual());
			historicoRepo.save(historicoMedico);
			historicoMedicoDTO = (HistoricoMedicoDTO) converter(historicoMedico, HistoricoMedicoDTO.class);
		} catch (final Exception e) {
			throw new BusinessException(e.getMessage());
		}

	}

	@Override
	public void remover(final Long id) {
		historicoRepo.delete(id);
	}

	@Override
	public List<HistoricoMedicoDTO> listarPorUsuario(final Long idUsuario) throws BusinessException {
		final List<HistoricoMedico> historicoMedicos = historicoRepo.findByUsuarioId(idUsuario);

		if (CheckUtil.IsNullOrEmpty(historicoMedicos)) {
			BusinessExceptionMessages.historicoMedicoNaoEncontrado();
		}

		final List<HistoricoMedicoDTO> historicoMedicosDTO = converterLista(historicoMedicos, HistoricoMedicoDTO.class);


		return historicoMedicosDTO;
	}

}
