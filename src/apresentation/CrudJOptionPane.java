package apresentation;

import javax.swing.*;

import model.Banco;
import model.Cliente;
import model.Venda;
import repository.ClienteRepository;
import repository.VendaRepository;

public class CrudJOptionPane {

	private final ClienteJOptionPane _clienteJOptionPane;
	private final VendaJOptionPane _vendaJOptionPane;
	private final ItemVendaJOptionPane _itemVendaJOptionPane;

	public CrudJOptionPane() {
		_clienteJOptionPane = new ClienteJOptionPane();
		_vendaJOptionPane = new VendaJOptionPane();
		_itemVendaJOptionPane = new ItemVendaJOptionPane();
	}

	public void Executar() {
		boolean sair = false;

		while (!sair) {
			int opcao = ExibirMenu();
			switch (opcao) {
			case 0: 
				ExibirMenuCliente();
				break;
			case 1: 
				ExibirMenuVenda();
				break;
			case 2:
				ExibirMenuItemVenda();
				break;
			case 3:
				sair = true;
				break;
			case -1:
				System.exit(0);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida!");
				break;
			}
		}
	}

	public void ExibirMenuItemVenda() {
		boolean sair = false;

		while (!sair) {
			int opcao = ExibirMenuCrud("ItemVenda");

			switch (opcao) {
			case 0: 
				_itemVendaJOptionPane.AdicionarItemVenda();
				break;
			case 1: 
				_itemVendaJOptionPane.ListarItensVendas();
				break;
			case 2: 
				_itemVendaJOptionPane.EditarItemVenda();
				break;
			case 3: 
				_itemVendaJOptionPane.RemoverItemVenda();
				break;
			case 4: 
				sair = true;
				break;
			case 5: 
				System.exit(0);
				break;
			case -1:
				System.exit(0);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida!");
				break;
			}
		}
	}
	
	public void ExibirMenuCliente() {
		boolean sair = false;

		while (!sair) {
			int opcao = ExibirMenuCrud("Cliente");

			switch (opcao) {
			case 0: 
				_clienteJOptionPane.AdicionarCliente();
				break;
			case 1: 
				_clienteJOptionPane.ListarCliente();
				break;
			case 2: 
				_clienteJOptionPane.EditarCliente();
				break;
			case 3: 
				_clienteJOptionPane.RemoverCliente();
				break;
			case 4: 
				sair = true;
				break;
			case 5: 
				System.exit(0);
				break;
			case -1:
				System.exit(0);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida!");
				break;
			}
		}
	}
	
	public void ExibirMenuVenda() {
		boolean sair = false;

		while (!sair) {
			int opcao = ExibirMenuCrud("Venda");

			switch (opcao) {
			case 0: 
				_vendaJOptionPane.AdicionarVenda();
				break;
			case 1: 
				_vendaJOptionPane.ListarVendas();
				break;
			case 2: 
				_vendaJOptionPane.EditarVenda();
				break;
			case 3:
				_vendaJOptionPane.RemoverVenda();
				break;
			case 4: 
				sair = true;
				break;
			case 5: 		
				System.exit(0);
				break;
			case -1:
				System.exit(0);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida!");
				break;
			}
		}
	}

	private int ExibirMenu() {

		String[] options = { "Cliente", "Vendas","ItemVenda", "Sair" };
		return JOptionPane.showOptionDialog(null, "Crud - Escolha uma opção :", "Menu", JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
	}

	private int ExibirMenuCrud(String nome) {
		String[] options = { "Adicionar", "Listar", "Editar", "Remover", "Voltar menu", "Sair" };

		return JOptionPane.showOptionDialog(null, nome + " - Escolha uma opção :", "Menu", JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
	}
}
