package br.ufscar.dc.dsw.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "Veiculo")
public class Veiculo extends AbstractEntity<Long>{

	@NotBlank(message = "{NotBlank.veiculo.placa}")
	@Size(max = 20)
	@Column(nullable = false, unique = true, length = 20)
	private String placa;
	
	@NotBlank(message = "{NotBlank.veiculo.modelo}")
	@Size(max = 20)
	@Column(nullable = false, length = 20)
    private String modelo;
	
	@NotBlank(message = "{NotBlank.veiculo.chassi}")
	@Size(max = 17)
	@Column(nullable = false, unique = true, length = 17)
    private String chassi;
	
	@NotNull(message = "{NotNull.veiculo.ano}")
	@Column(nullable = false, length = 5)
    private Integer ano;
	
	@NotNull(message = "{NotNull.veiculo.quilometragem}")
	@Column(nullable = false, length = 10)
    private Integer quilometragem;
	
	@NotBlank(message = "{NotBlank.veiculo.descricao}")
	@Size(max = 120)
	@Column(nullable = false, length = 120)
    private String descricao;
	
	@NotNull(message = "{NotNull.veiculo.preco}")
	@Column(nullable = false, columnDefinition = "DECIMAL(10,2) DEFAULT 0.0")
    private BigDecimal preco;
    
    @NotNull(message = "{NotNull.veiculo.loja}")
	@ManyToOne
	@JoinColumn(name = "id_loja")
    private Loja loja;
    
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(Integer quilometragem) {
        this.quilometragem = quilometragem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    @Override
    public String toString() {
    	return modelo + ", " + chassi + "(" + quilometragem + ")"; 
    }
    
    
	
}
