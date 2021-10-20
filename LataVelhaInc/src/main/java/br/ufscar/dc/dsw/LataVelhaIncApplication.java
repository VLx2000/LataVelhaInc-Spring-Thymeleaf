package br.ufscar.dc.dsw;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.ufscar.dc.dsw.dao.IClienteDAO;
import br.ufscar.dc.dsw.dao.ILojaDAO;
import br.ufscar.dc.dsw.dao.IVeiculoDAO;
//import br.ufscar.dc.dsw.dao.IPropostaDAO;

import br.ufscar.dc.dsw.domain.Cliente;
import br.ufscar.dc.dsw.domain.Loja;
import br.ufscar.dc.dsw.domain.Veiculo;
//import br.ufscar.dc.dsw.domain.Proposta;


@SpringBootApplication
public class LataVelhaIncApplication {

	public static void main(String[] args) {
		SpringApplication.run(LataVelhaIncApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(IClienteDAO clienteDAO, ILojaDAO lojaDAO, /*BCryptPasswordEncoder encoder,*/ IVeiculoDAO veiculoDAO) {
		return (args) -> {
			
			Cliente c1 = new Cliente();
			c1.setNome("admin");
			c1.setSenha(/*encoder.encode*/("admin"));
			c1.setCPF("012.345.678-90");
			c1.setEmail("admin@gmail.com");
			c1.setTelefone("0800-2222");
			c1.setSexo("F");
			c1.setDataNascimento("13/03/95");
			c1.setRole("ROLE_ADMIN");
			c1.setEnabled(true);
			clienteDAO.save(c1);
			
			Cliente c2 = new Cliente();
			c2.setNome("Airto Cena");
			c2.setSenha(/*encoder.encode*/("123"));
			c2.setCPF("985.849.614-10");
			c2.setEmail("cliente1@gmail.com");
			c2.setTelefone("0800-2222");
			c2.setSexo("M");
			c2.setDataNascimento("23/08/01");
			c2.setRole("ROLE_USER");
			c2.setEnabled(true);
			clienteDAO.save(c2);
			
			Cliente c3 = new Cliente();
			c3.setNome("Michael Wazowski");
			c3.setSenha(/*encoder.encode*/("123"));
			c3.setCPF("367.318.380-04");
			c3.setEmail("cliente2@gmail.com");
			c3.setTelefone("0800-2222");
			c3.setSexo("M");
			c3.setDataNascimento("28/01/75");
			c3.setRole("ROLE_USER");
			c3.setEnabled(true);
			clienteDAO.save(c3);
			
			Loja l1 = new Loja();
			l1.setCNPJ("55.789.390/0008-99");
			l1.setNome("Carros e Ventiladores SA");
			l1.setSenha(/*encoder.encode*/("123"));
			l1.setEmail("loja1@gmail.com");
			l1.setDescricao("Sim, carros e ventiladores");
			lojaDAO.save(l1);
			
			Loja l2 = new Loja();
			l2.setCNPJ("71.150.470/0001-40");
			l2.setNome("Ferro velho do Maicao");
			l2.setSenha(/*encoder.encode*/("123"));
			l2.setEmail("loja2@gmail.com");
			l2.setDescricao("Desde 1934 fazendo história");
			lojaDAO.save(l2);
			
			Loja l3 = new Loja();
			l3.setCNPJ("32.106.536/0001-82");
			l3.setNome("Tesla saocarlense");
			l3.setSenha(/*encoder.encode*/("123"));
			l3.setEmail("loja3@gmail.com");
			l3.setDescricao("Não vendemos elétricos nem foguetes");
			lojaDAO.save(l3);
			
			Veiculo v1 = new Veiculo();
			v1.setPlaca("AAA0-5435");
			v1.setModelo("Corsa");
			v1.setChassi("1A1A1111111111111");
			v1.setAno(1999);
			v1.setQuilometragem(120000);
			v1.setDescricao("Corsa 2005 turbinado");
			v1.setPreco(BigDecimal.valueOf(5.999));
			v1.setLoja(l1);
			veiculoDAO.save(v1);

			Veiculo v2 = new Veiculo();
			v2.setPlaca("AAA0-7456");
			v2.setModelo("Fusca");
			v2.setChassi("1A1A1555555111111");
			v2.setAno(1997);
			v2.setQuilometragem(500000);
			v2.setDescricao("Fusca 97 rebaixado");
			v2.setPreco(BigDecimal.valueOf(3.999));
			v2.setLoja(l2);
			veiculoDAO.save(v2);

			Veiculo v3 = new Veiculo();
			v3.setPlaca("AAA0-1112");
			v3.setModelo("Uno");
			v3.setChassi("1A1A1112222222111");
			v3.setAno(2007);
			v3.setQuilometragem(220000);
			v3.setDescricao("Uno Mile 2007");
			v3.setPreco(BigDecimal.valueOf(7.999));
			v3.setLoja(l3);
			veiculoDAO.save(v3);			
		};
	}
}
