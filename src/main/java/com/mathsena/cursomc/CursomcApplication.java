package com.mathsena.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mathsena.cursomc.domain.Categoria;
import com.mathsena.cursomc.domain.Cidade;
import com.mathsena.cursomc.domain.Cliente;
import com.mathsena.cursomc.domain.Endereco;
import com.mathsena.cursomc.domain.Estado;
import com.mathsena.cursomc.domain.ItemPedido;
import com.mathsena.cursomc.domain.Pagamento;
import com.mathsena.cursomc.domain.PagamentoComBoleto;
import com.mathsena.cursomc.domain.PagamentoComCartao;
import com.mathsena.cursomc.domain.Pedido;
import com.mathsena.cursomc.domain.Produto;
import com.mathsena.cursomc.domain.enums.EstadoPagamento;
import com.mathsena.cursomc.domain.enums.TipoCliente;
import com.mathsena.cursomc.repositories.CategoriaRepository;
import com.mathsena.cursomc.repositories.CidadeRepository;
import com.mathsena.cursomc.repositories.ClienteRepository;
import com.mathsena.cursomc.repositories.EnderecoRepository;
import com.mathsena.cursomc.repositories.EstadoRepository;
import com.mathsena.cursomc.repositories.ItemPedidoRepository;
import com.mathsena.cursomc.repositories.PagamentoRepository;
import com.mathsena.cursomc.repositories.PedidoRepository;
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
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		Categoria cat3 = new Categoria(null, "Roupa, Mesa e Banho");
		Categoria cat4 = new Categoria(null, "Eletrônicos");
		Categoria cat5 = new Categoria(null, "Jardinagem");
		Categoria cat6 = new Categoria(null, "Iluminação");
		Categoria cat7 = new Categoria(null, "Higiêne");


		Produto p1 = new Produto(null, "Computador", 2000);
		Produto p2 = new Produto(null, "Impressora", 1000);
		Produto p3 = new Produto(null, "Mouse", 80);
		Produto p4 = new Produto(null, "Escrivaninha", 150);
		Produto p5 = new Produto(null, "Toalha", 30);
		Produto p6 = new Produto(null, "Colcha", 80);
		Produto p7 = new Produto(null, "TV 4K", 1800);
		Produto p8 = new Produto(null, "Roçadeira", 800);
		Produto p9 = new Produto(null, "Abajour", 800);
		Produto p10 = new Produto(null, "Pendente", 180);
		Produto p11 = new Produto(null, "Shampoo", 10);

		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2, p4));
		cat3.getProdutos().addAll(Arrays.asList(p5, p6));
		cat4.getProdutos().addAll(Arrays.asList(p1, p2, p3, p7));
		cat5.getProdutos().add(p8);
		cat6.getProdutos().addAll(Arrays.asList(p9, p10));
		cat7.getProdutos().add(p11);
		

		p1.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2, cat4));
		p3.getCategorias().addAll(Arrays.asList(cat1, cat4));
		p4.getCategorias().add(cat2);
		p5.getCategorias().add(cat3);
		p6.getCategorias().add(cat3);
		p7.getCategorias().add(cat4);
		p8.getCategorias().add(cat5);
		p9.getCategorias().add(cat6);
		p10.getCategorias().add(cat6);
		p11.getCategorias().add(cat7);

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2,cat3,cat4,cat5,cat6,cat7));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9,p11));

		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Belo Horizonte", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est1);
		
		est1.getCidades().add(c1);
		est2.getCidades().addAll(Arrays.asList(c2,c3));

		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null, "Roger Guedes", "rg9@gmail.com", "999.999.999-99", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("11987831912", "11972191019"));
		
		Endereco e1 = new Endereco(null, "Rua Groelandia", "99", "Apto 9", "Jardins", "999909-90", cli1, c2);
		Endereco e2 = new Endereco(null, "Rua Panafiel", "242", "Apto 12", "Anchieta", "999919-90", cli1, c1);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(List.of(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("08/08/2022 13:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("01/07/2022 14:33"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.QUITADO, ped2, sdf.parse("01/07/2022 14:33"), sdf.parse("02/07/2022 14:33"));
		ped2.setPagamento(pagto2);
		
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1,pagto1));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1,ip2));
		ped2.getItens().add(ip3);
		
		p1.getItens().add(ip1);
		p2.getItens().add(ip3);
		p3.getItens().add(ip2);
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3));
		
	}

}
