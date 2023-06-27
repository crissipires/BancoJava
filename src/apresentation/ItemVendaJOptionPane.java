package apresentation;

import java.util.List;

import javax.swing.JOptionPane;

import model.Banco;
import model.ItemVenda;
import model.Venda;
import repository.ItemVendaRepository;
import view.ViewItemVenda;

public class ItemVendaJOptionPane {
	
	private final ItemVendaRepository _itemVendaRepository;
	private final Banco _banco;
	
	public ItemVendaJOptionPane() {
		_itemVendaRepository = new ItemVendaRepository();
		_banco = new Banco();
	}
	
	public void Adicionar() {
		ItemVenda itemVenda = CriarItemVenda();
		 _itemVendaRepository.Inserir(_banco.getConexao(), itemVenda);
	}

	public void Listar() {
		 List<ViewItemVenda> listaVendas = _itemVendaRepository.Listar(_banco.getConexao());
		 System.out.println("------- ITENS VENDA -------");
		 for(ViewItemVenda item : listaVendas) {
			 System.out.println("Código da venda: " + item.idVenda);
			 System.out.println("Nome do cliente: " + item.nomeCliente);
		     System.out.println("Descrição do Procedimento: " + item.descricaoProcedimento);
		     System.out.println("Valor: " + item.valor);
		     System.out.println("Quantidade: " + item.quantidade);
		     System.out.println("---------------------------------");
		 }
	}

	public void Editar() {
		ItemVenda itemVenda = AtualizarItemVenda();
		 _itemVendaRepository.Editar(_banco.getConexao(), itemVenda);
	}
	
	public static ItemVenda CriarItemVenda() {
		int codigoVenda = Integer.parseInt(JOptionPane.showInputDialog("Cadastro de ItemVenda\n\nInforme o Código da venda:"));
		int codigoProcedimento = Integer.parseInt(JOptionPane.showInputDialog("Cadastro de ItemVenda\n\nInforme o Código do procedimento:"));
		float valor = Float.parseFloat(JOptionPane.showInputDialog("Cadastro de ItemVenda\n\nInforme o valor da venda:"));
		int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Cadastro de ItemVenda\n\nInforme a quantidade de procedimento(s):"));
		
		return new ItemVenda(codigoVenda, codigoProcedimento, valor, quantidade);
	}
	
	public static ItemVenda AtualizarItemVenda() {
		int codigoItemVenda = Integer.parseInt(JOptionPane.showInputDialog("Edição de ItemVenda\n\nInforme o Código da venda:"));
		int codigoProcedimento = Integer.parseInt(JOptionPane.showInputDialog("Edição de ItemVenda\n\nInforme o Código do procedimento:"));
		float valor = Float.parseFloat(JOptionPane.showInputDialog("Cadastro de ItemVenda\n\nInforme o valor da venda:"));
		int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Cadastro de ItemVenda\n\nInforme a quantidade de itens:"));
		
		return new ItemVenda(codigoItemVenda,codigoProcedimento, valor, quantidade);	
	}
	
	public static int RemoverItemVenda() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o id do item da venda para remover"));
		return id;
	}
	
	
}