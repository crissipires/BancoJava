package apresentation;

import java.util.List;

import javax.swing.JOptionPane;

import model.Banco;
import model.Cliente;
import repository.ClienteRepository;

public class ClienteJOPtionPane {
	
	private final ClienteRepository _clienteRepository;
	private final Banco _banco;
	
	public ClienteJOPtionPane() {
		_clienteRepository = new ClienteRepository();
		_banco = new Banco();
	}
	
    public void Adicionar() { 	
    	Cliente cliente = CriarCliente();
    	_clienteRepository.Inserir(_banco.getConexao(), cliente);
    }
    
    public void Remover() {
    	int id = RemoverCliente();
    	_clienteRepository.Remover(_banco.getConexao(), id);
    }
    
    public void Listar() {
    	List<Cliente> listaClientes = _clienteRepository.Listar(_banco.getConexao());
    	for (Cliente cliente : listaClientes) {
    		System.out.println("ID do Cliente: " + cliente.Id);
    		System.out.println("Nome: " + cliente.Nome);
    		System.out.println("CPF: " + cliente.Cpf);
    		System.out.println("Data de Nascimento: " + cliente.DataNascimento);
    		System.out.println("Email: " + cliente.Email);
    		System.out.println("Número de Telefone: " + cliente.NumeroTelefone);
			System.out.println("---------------------------------");
		}
    }
    
    public void Editar() {
    	Cliente cliente = AtualizarCliente();
    	_clienteRepository.Editar(_banco.getConexao(), cliente);
    }
	
	private Cliente CriarCliente() {
		String nome = JOptionPane.showInputDialog("Cadastro de Cliente\n\nInforme o nome:");
		String cpf = JOptionPane.showInputDialog("Cadastro de Cliente\n\nInforme o CPF:");
		String dataNascimento = JOptionPane.showInputDialog("Cadastro de Cliente\n\nInforme a data de nascimento:");
		String email = JOptionPane.showInputDialog("Cadastro de Cliente\n\nInforme o e-mail:");
		String numeroTelefone = JOptionPane.showInputDialog("Cadastro de Cliente\n\nInforme o número de telefone:");
		int idEndereco = Integer.parseInt(JOptionPane.showInputDialog("Cadastro de Cliente\n\nInforme o id do endereço"));
		
		Cliente cliente = new Cliente(nome,cpf,dataNascimento,numeroTelefone,email,idEndereco);
		return cliente; 
	}
	
	private int RemoverCliente() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o id do cliente para remover"));
		return id;
	}
	
	private Cliente AtualizarCliente() {
		int idCliente = Integer.parseInt(JOptionPane.showInputDialog("Edição de Cliente\n\nInforme o id do cliente que deseja alterar:"));
		String nome = JOptionPane.showInputDialog("Edição de Cliente\n\nInforme o nome:");
		String cpf = JOptionPane.showInputDialog("Edição de Cliente\n\nInforme o CPF:");
		String dataNascimento = JOptionPane.showInputDialog("Edição de Cliente\n\nInforme a data de nascimento:");
		String email = JOptionPane.showInputDialog("Edição de Cliente\n\nInforme o e-mail:");
		String numeroTelefone = JOptionPane.showInputDialog("Edição de Cliente\n\nInforme o número de telefone:");
		int idEndereco =  Integer.parseInt(JOptionPane.showInputDialog("Edição de Cliente\n\nInforme o id do endereço"));
				
		return new Cliente(idCliente,nome,cpf,dataNascimento,numeroTelefone,email,idEndereco);
	}

}
