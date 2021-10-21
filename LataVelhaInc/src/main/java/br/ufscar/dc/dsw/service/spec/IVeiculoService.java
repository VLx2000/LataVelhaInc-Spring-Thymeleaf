package br.ufscar.dc.dsw.service.spec;

import java.util.List;

import br.ufscar.dc.dsw.domain.Veiculo;
import br.ufscar.dc.dsw.domain.Loja;

public interface IVeiculoService {
	
	Veiculo buscarPorId(Long id);

	List<Veiculo> buscarTodos();
	
	List<Veiculo> buscarPorLoja(Loja loja);

	void salvar(Veiculo veiculo);

	void excluir(Long id);
	
}
