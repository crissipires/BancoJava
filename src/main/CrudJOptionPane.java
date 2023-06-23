package main;

import javax.swing.*;

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
            int opcao = ExibirMenu();

            switch (opcao) {
                case 0: // Adicionar Cliente
                    AdicionarCliente();
                    break;
                case 1: // Listar Clientes
                	ListarCliente();
                    break;
                case 2: // Editar Cliente
                    EditarCliente();
                    break;
                case 3: // Remover Cliente
                	RemoverCliente();
                    break;
                case 4: // Adicionar Venda
                    //adicionarVenda();
                    break;
                case 5: // Listar Vendas
                    //listarVendas();
                    break;
                case 6: // Editar Venda
                    //atualizarVenda();
                    break;
                case 7: // Remover Venda
                    //removerVenda();
                    break;
                case 8: // Sair
                    sair = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;
            }
        }
    }
    
    private int ExibirMenu() {
        String[] options = { "Adicionar Cliente", "Listar Clientes", "Editar Cliente", "Remover Cliente",
                "Adicionar Venda", "Listar Vendas", "Editar Venda", "Remover Venda", "Sair" };

        return JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Menu", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
    }
    
    private void AdicionarCliente() { 	
    	Cliente cliente = ClienteJOPtionPane.CriarCliente();
    	_clienteRepository.InserirCliente(_banco.getConexao(), cliente);
    }
    
    private void RemoverCliente() {
    	int id = ClienteJOPtionPane.RemoverCliente();
    	_clienteRepository.RemoverCliente(_banco.getConexao(), id);
    }
    
    private void ListarCliente() {
    	_clienteRepository.ListarClientes(_banco.getConexao());
    }
    
    private void EditarCliente() {
    	Cliente cliente = ClienteJOPtionPane.AtualizarCliente();
    	_clienteRepository.EditarCliente(_banco.getConexao(), cliente);
    }
}
