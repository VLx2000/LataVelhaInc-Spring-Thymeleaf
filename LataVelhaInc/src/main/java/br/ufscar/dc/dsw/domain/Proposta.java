package br.ufscar.dc.dsw.domain;

import java.math.BigDecimal;

//import javax.persistence.CascadeType;

//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

//import javax.persistence.OneToMany;
import javax.persistence.Table;
//import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@SuppressWarnings("serial")
@Entity
@Table(name = "Proposta")
public class Proposta extends AbstractEntity<Long>{
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "loja_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Loja loja;
	
	@OneToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Veiculo veiculo;
	
	@NotNull(message = "{NotNull.proposta.valor}")
	@Column(nullable = false, columnDefinition = "DECIMAL(10,2) DEFAULT 0.0")
    private BigDecimal valor;
	
	@NotNull(message = "{NotNull.proposta.data_p")
	@Size(max = 10)
	@Column(nullable = false, length = 10)
    private String data;
	
	@NotNull(message = "{NotNull.proposta.estado")
	@Size(max = 11)
	@Column(nullable = false, length = 11)
    private String estado;

	@NotNull(message = "{NotNull.proposta.parcelamento")
	@Size(max = 20)
	@Column(nullable = false, length = 20)
    private String parcelamento;
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}
	
	public void setLoja(Loja loja) {
		this.loja = loja;
	}
	
	public Loja getLoja() {
		return this.loja;
	}
	
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	public Veiculo getVeiculo() {
		return this.veiculo;
	}
	
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public BigDecimal getValor() {
		return this.valor;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public String getData() {
		return this.data;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getEstado() {
		return this.estado;
	}
	
	public void setParcelamento(String parcelamento) {
		this.parcelamento = parcelamento;
	}
	
	public String getParcelamento() {
		return this.parcelamento;
	}
	
    @Override
    public String toString() {
    	return valor + ", " + data+ ", " + estado + ", " + parcelamento ; 
    }
}