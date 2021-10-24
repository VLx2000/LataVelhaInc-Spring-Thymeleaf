package br.ufscar.dc.dsw.domain;

//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.ufscar.dc.dsw.validation.UniqueCNPJ;


@SuppressWarnings("serial")
@Entity
@Table(name = "Loja")
public class Loja extends Usuario{
	
	@UniqueCNPJ (message = "{Unique.loja.CNPJ}")
	@NotBlank
	@Size(min = 14, max = 18, message = "{Size.loja.CNPJ}")
	@Column(nullable = false, unique = true, length = 60)
	private String CNPJ;
	
	@NotBlank
	@Size(min = 3, max = 50)
	@Column(nullable = false, unique = true, length = 50)
	private String nome;
	
	@NotBlank
	@Size(min = 1, max = 120 )
	@Column(nullable = false, unique = false, length = 120)
	private String descricao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String CNPJ) {
		this.CNPJ = CNPJ;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
