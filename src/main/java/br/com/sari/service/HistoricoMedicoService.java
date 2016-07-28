package br.com.sari.service;

import java.util.List;

import br.com.sari.dto.HistoricoMedicoDTO;
import br.com.sari.exception.BusinessException;

public interface HistoricoMedicoService {

	public HistoricoMedicoDTO salvar(HistoricoMedicoDTO historicoMedico) throws BusinessException;

	public void remover(Long id) throws BusinessException;

	List<HistoricoMedicoDTO> listarPorUsuario(Long idUsuario) throws BusinessException;

}
