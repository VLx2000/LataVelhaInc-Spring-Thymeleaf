package br.ufscar.dc.dsw.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

//import br.ufscar.dc.dsw.validation.UniqueCPF;

@SuppressWarnings("serial")
@Entity
@Table(name = "Cliente")
public class Cliente extends AbstractEntity<Long>{
	
	@NotBlank(message = "{NotBlank.cliente.email}")
	@Size(max = 30)
	@Column(nullable = false, unique = true, length = 30)
	private String email;
	
	@NotBlank(message = "{NotBlank.cliente.senha}")
	@Size(max = 50)
	@Column(nullable = false, unique = false, length = 50)
	private String senha;
	
	//@UniqueCPF (message = "{Unique.cliente.CPF}")
	@NotBlank
	@Size(min = 14, max = 14, message = "{Size.cliente.CPF}")
	@Column(nullable = false, unique = true, length = 14)
	private String CPF;
	
	@NotBlank
	@Size(min = 3, max = 50)
	@Column(nullable = false, unique = true, length = 50)
	private String nome;

    @NotBlank
	@Size(min = 3, max = 20)
	@Column(nullable = false, unique = true, length = 20)
	private String telefone;

    @NotBlank
	@Size(min = 1, max = 10)
	@Column(nullable = false, unique = false, length = 10)
	private String sexo;
	
	@NotBlank
	@Size(min = 4, max = 10 )
	@Column(nullable = false, unique = false, length = 10)
	private String nascimento;

	@NotBlank
	@Size(min = 1, max = 10 )
	@Column(nullable = false, unique = false, length = 10)
	private String role;

	@Column(nullable = false)
    private boolean enabled;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String CPF) {
		this.CPF = CPF;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

    public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

    public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}