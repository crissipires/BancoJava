package main;

import javax.swing.*;

import model.Banco;
import model.Cliente;
import repository.ClienteRepository;

public class CrudJOptionPane {
	
	private final ClienteRepository _clienteRepository;
	private final Banco _banco;
	
	public CrudJOptionPane() {
		_clienteRepository = new ClienteRepository();
		_banco = new Banco();
	}
	
    public void Executar(){
        boolean sair = false;

        while (!sair) {
            int opcao = exibirMenu();

            switch (opcao) {
                case 0: // Adicionar Cliente
                    adicionarCliente();
                    break;
                case 1: // Listar Clientes
                	listarCliente();
                    break;
                case 2: // Editar Cliente
                    editarCliente();
                    break;
                case 3: // Remover Cliente
                	removerCliente();
                    break;
                case 4: //Buscar por nome
                	buscarPorNome();
                	break;
                case 5: // Adicionar Venda
                    //adicionarVenda();
                    break;
                case 6: // Listar Vendas
                    //listarVendas();
                    break;
                case 7: // Editar Venda
                    //atualizarVenda();
                    break;
                case 8: // Remover Venda
                    //removerVenda();
                    break;
                case 9: // Sair
                    sair = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;
            }
        }
    }
    
    private int exibirMenu() {
        String[] options = { "Adicionar Cliente", "Listar Clientes", "Editar Cliente", "Remover Cliente",
                "Adicionar Venda", "Listar Vendas", "Editar Venda", "Remover Venda", "Sair" };

        return JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Menu", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
    }
    
    private void adicionarCliente() { 	
    	Cliente cliente = ClienteJOPtionPane.criarCliente();
    	_clienteRepository.inserirCliente(_banco.getConexao(), cliente);
    }
    
    private void removerCliente() {
    	int id = ClienteJOPtionPane.removerCliente();
    	_clienteRepository.removerCliente(_banco.getConexao(), id);
    }
    
    private void listarCliente() {
    	_clienteRepository.listarClientes(_banco.getConexao());
    }
    
    private void editarCliente() {
    	Cliente cliente = ClienteJOPtionPane.atualizarCliente();
    	_clienteRepository.editarCliente(_banco.getConexao(), cliente);
    }
    
    private void buscarPorNome() {
    	_clienteRepository.buscarPorNome(_banco.getConexao());
    }
}
