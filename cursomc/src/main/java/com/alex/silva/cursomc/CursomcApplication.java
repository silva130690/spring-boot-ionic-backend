package com.alex.silva.cursomc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.alex.silva.cursomc.domain.Categoria;
import com.alex.silva.cursomc.domain.Cidade;
import com.alex.silva.cursomc.domain.Cliente;
import com.alex.silva.cursomc.domain.Endereco;
import com.alex.silva.cursomc.domain.Estado;
import com.alex.silva.cursomc.domain.ItemPedido;
import com.alex.silva.cursomc.domain.Pagamento;
import com.alex.silva.cursomc.domain.PagamentoComBoleto;
import com.alex.silva.cursomc.domain.PagamentoComCartao;
import com.alex.silva.cursomc.domain.Pedido;
import com.alex.silva.cursomc.domain.Produto;
import com.alex.silva.cursomc.domain.enums.EstadoPagamento;
import com.alex.silva.cursomc.domain.enums.TipoCliente;
import com.alex.silva.cursomc.repositories.CategoriaRepository;
import com.alex.silva.cursomc.repositories.CidadeRepository;
import com.alex.silva.cursomc.repositories.ClienteRepository;
import com.alex.silva.cursomc.repositories.EnderecoRepository;
import com.alex.silva.cursomc.repositories.EstadoRepository;
import com.alex.silva.cursomc.repositories.ItemPedidoRepository;
import com.alex.silva.cursomc.repositories.PagamentoRepository;
import com.alex.silva.cursomc.repositories.PedidoRepository;
import com.alex.silva.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication  implements CommandLineRunner{//Permitir executar um method aux no inicio da aplicacao. 
   
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
		// TODO Auto-generated method stub - Salvando registo no banco de dados.

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto  pdt1  = new Produto(null, "Computador", 2000.00);
		Produto  pdt2  = new Produto(null, "Impressora", 300.00 );
		Produto  pdt3  = new Produto(null, "Mouse", 100.00);
		
		
		//Adiconando os elementos na lista.
		
		//Categoria
		cat1.getProdutos().addAll(Arrays.asList(pdt1,pdt2,pdt3));
		cat2.getProdutos().addAll(Arrays.asList(pdt2));
		
		//Produto
		pdt1.getCategorias().addAll(Arrays.asList(cat1));
		pdt2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		pdt3.getCategorias().addAll(Arrays.asList(cat1));
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(pdt1,pdt2,pdt3));
		
		//Estado
		Estado estd1 = new Estado(null, "MG - Minas Gerais");
		Estado estd2 = new Estado(null, "SP - São Paulo");

		Cidade cdd1 = new Cidade(null, "Uberlândia", estd1);
		Cidade cdd2 = new Cidade(null, "São Paulo", estd2);
		Cidade cdd3 = new Cidade(null, "Campinas", estd2);

		estd1.getCidades().addAll(Arrays.asList(cdd1));
		estd2.getCidades().addAll(Arrays.asList(cdd2, cdd3));
		
		//Salvando o registro no banco.
		estadoRepository.saveAll(Arrays.asList(estd1,estd2));
		cidadeRepository.saveAll(Arrays.asList(cdd1,cdd2,cdd3));
		
		//Instanciando um cliente
		
		Cliente c1 = new Cliente(null,"Maria","maria@gmail.com","09571375403",TipoCliente.PESSOAFISICA);
		c1.getTelefones().addAll(Arrays.asList("9.8888-7777","9.9999-8888"));
		

		Endereco e1 = new Endereco(null,"Rua ternura","67","Apt45","Jardim Angela","35432467",c1,cdd1);
		Endereco e2 = new Endereco(null,"Rua Major","67","Apt45","Dezano","35432467",c1,cdd1);
        c1.getEnderecos().addAll(Arrays.asList(e1,e2));
        
        clienteRepository.saveAll(Arrays.asList(c1));
        enderecoRepository.saveAll(Arrays.asList(e1,e2));
        
        //Instanciando uma data para registro do pedido
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        
        Pedido ped1 = new Pedido(null,sdf.parse("30/09/2017 10:32"),c1,e1);
        Pedido ped2 = new Pedido(null,sdf.parse("10/10/2017 19:35"),c1,e2);
        
        Pagamento pagt1 = new PagamentoComCartao(null,EstadoPagamento.QUITADO,ped1,6);
        ped1.setPagamento(pagt1);
        
        
        Pagamento pagt2 = new PagamentoComBoleto(null,EstadoPagamento.PENDENTE,ped2,sdf.parse("20/10/2017 00:00"),null);
	    ped2.setPagamento(pagt2);
	    
	    c1.getPedidos().addAll(Arrays.asList(ped1,ped2));
	    
	    
	    ItemPedido ip1 = new ItemPedido(ped1,pdt1,00.00,1,2000.00);
	    ItemPedido ip2 = new ItemPedido(ped1 ,pdt3 ,00.00 ,2,100.00);
	    ItemPedido ip3 = new ItemPedido(ped2,pdt2,100.00,1,800.00);
	    
	    pdt1.getItens().addAll(Arrays.asList(ip1,ip2));
	    pdt2.getItens().addAll(Arrays.asList(ip3));
	    
	    
	    pdt1.getItens().addAll(Arrays.asList(ip1));
	    pdt2.getItens().addAll(Arrays.asList(ip3));
	    pdt3.getItens().addAll(Arrays.asList(ip2));
	    
	    pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
	    pagamentoRepository.saveAll(Arrays.asList(pagt1,pagt2));
	    
	    itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3));
	    
	}
	
}
