package br.ufscar.dc.dsw.domain;

//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.ufscar.dc.dsw.validation.UniqueCPF;


@SuppressWarnings("serial")
@Entity
@Table(name = "Cliente")
public class Cliente extends AbstractEntity<Long>{
	
	@NotBlank(message = "{NotBlank.cliente.email}")
	@Size(max = 30)
	@Column(nullable = false, length = 30)
	private String email;
	
	@NotBlank(message = "{NotBlank.cliente.senha}")
	@Size(max = 50)
	@Column(nullable = false, length = 50)
	private String senha;
	
	@UniqueCPF (message = "{Unique.cliente.CPF}")
	@NotBlank
	@Size(min = 20, max = 20, message = "{Size.cliente.CPF}")
	@Column(nullable = false, unique = true, length = 20)
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
	@Column(nullable = false, unique = true, length = 10)
	private String sexo;
	
	@NotBlank
	@Size(min = 8, max = 10 )
	@Column(nullable = false, unique = true, length = 10)
	private String data_nascimento;

	@NotBlank
	@Size(min = 1, max = 10 )
	@Column(nullable = false, unique = true, length = 10)
	private String papel;
	
	public Cliente(String email, String senha, String CPF, String nome, String telefone, String sexo, String data_nascimento, String papel) {
		this.email = email;
		this.senha = senha;
		this.CPF = CPF;
		this.nome = nome;
		this.telefone = telefone;
        this.sexo = sexo;
        this.data_nascimento = data_nascimento;
		this.papel = papel;
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

    public String getDataNascimento() {
		return data_nascimento;
	}

	public void setDataNascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getPapel() {
		return papel;
	}

	public void setPapel(String papel) {
		this.papel = papel;
	}
}