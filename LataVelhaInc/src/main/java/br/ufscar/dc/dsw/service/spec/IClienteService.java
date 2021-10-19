package br.ufscar.dc.dsw.service.spec;

import java.util.List;

import br.ufscar.dc.dsw.domain.Cliente;

public interface IClienteService {
	
	Cliente buscarPorId(Long id);

	List<Cliente> buscarTodos();

	void salvar(Cliente Cliente);

	void excluir(Long id);
	
	// Implementar depois
	// boolean ClienteTemPropostasAbertas(Long id);
	
}
