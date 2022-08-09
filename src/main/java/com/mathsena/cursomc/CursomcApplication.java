package com.mathsena.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mathsena.cursomc.domain.Categoria;
import com.mathsena.cursomc.domain.Cidade;
import com.mathsena.cursomc.domain.Cliente;
import com.mathsena.cursomc.domain.Endereco;
import com.mathsena.cursomc.domain.Estado;
import com.mathsena.cursomc.domain.Produto;
import com.mathsena.cursomc.domain.enums.TipoCliente;
import com.mathsena.cursomc.repositories.CategoriaRepository;
import com.mathsena.cursomc.repositories.CidadeRepository;
import com.mathsena.cursomc.repositories.ClienteRepository;
import com.mathsena.cursomc.repositories.EnderecoRepository;
import com.mathsena.cursomc.repositories.EstadoRepository;
import com.mathsena.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Produto p1 = new Produto(null, "Computador", 2000);
		Produto p2 = new Produto(null, "Impressora", 1000);
		Produto p3 = new Produto(null, "Mouse", 80);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Belo Horizonte", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est1);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null, "Roger Guedes", "rg9@gmail.com", "999.999.999-99", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("11987831912", "11972191019"));
		
		Endereco e1 = new Endereco(null, "Rua Groelandia", "99", "Apto 9", "Jardins", "999909-90", cli1, c2);
		Endereco e2 = new Endereco(null, "Rua Panafiel", "242", "Apto 12", "Anchieta", "999919-90", cli1, c1);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		
	}

}
