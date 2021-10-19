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
public class Loja extends AbstractEntity<Long>{
	
	@NotBlank(message = "{NotBlank.loja.email}")
	@Size(max = 30)
	@Column(nullable = false, length = 30)
	private String email;
	
	@NotBlank(message = "{NotBlank.loja.senha}")
	@Size(max = 50)
	@Column(nullable = false, length = 50)
	private String senha;
	
	@UniqueCNPJ (message = "{Unique.loja.CNPJ}")
	@NotBlank
	@Size(min = 18, max = 18, message = "{Size.loja.CNPJ}")
	@Column(nullable = false, unique = true, length = 60)
	private String CNPJ;
	
	@NotBlank
	@Size(min = 3, max = 50)
	@Column(nullable = false, unique = true, length = 50)
	private String nome;
	
	@NotBlank
	@Size(min = 1, max = 120 )
	@Column(nullable = false, unique = true, length = 120)
	private String descricao;
	
	public Loja(String email, String senha, String CNPJ, String nome, String descricao) {
		this.email = email;
		this.senha = senha;
		this.CNPJ = CNPJ;
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String password) {
		this.senha = password;
	}

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
