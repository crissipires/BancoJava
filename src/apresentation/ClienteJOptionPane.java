package apresentation;

import javax.swing.JOptionPane;

import model.Banco;
import model.Cliente;
import repository.ClienteRepository;
import repository.VendaRepository;

public class ClienteJOptionPane {	
	
	private final ClienteRepository _clienteRepository;
	private final Banco _banco;

	public ClienteJOptionPane() {
		_banco = new Banco();
		_clienteRepository = new ClienteRepository();
	}
	
	public void AdicionarCliente() {
		Cliente cliente = Criar();
		_clienteRepository.inserirCliente(_banco.getConexao(), cliente);
	}

	public void RemoverCliente() {
		int id = Remover();
		_clienteRepository.removerCliente(_banco.getConexao(), id);
	}

	public void ListarCliente() {
		_clienteRepository.listarClientes(_banco.getConexao());
	}

	public void EditarCliente() {
		Cliente cliente = Atualizar();
		_clienteRepository.editarCliente(_banco.getConexao(), cliente);
	}
	
	private  Cliente Criar() {
		String nome = JOptionPane.showInputDialog("Cadastro de Cliente\n\nInforme o nome:");
		String cpf = JOptionPane.showInputDialog("Cadastro de Cliente\n\nInforme o CPF:");
		String dataNascimento = JOptionPane.showInputDialog("Cadastro de Cliente\n\nInforme a data de nascimento:");
		String email = JOptionPane.showInputDialog("Cadastro de Cliente\n\nInforme o e-mail:");
		String numeroTelefone = JOptionPane.showInputDialog("Cadastro de Cliente\n\nInforme o número de telefone:");
		int idEndereco = Integer.parseInt(JOptionPane.showInputDialog("Cadastro de Cliente\n\nInforme o id do endereço"));
		
		Cliente cliente = new Cliente(nome,cpf,dataNascimento,numeroTelefone,email,idEndereco);
		return cliente; 
	}
	
	private Cliente Atualizar() {
		int idCliente = Integer.parseInt(JOptionPane.showInputDialog("Edição de Cliente\n\nInforme o id do cliente que deseja alterar:"));
		String nome = JOptionPane.showInputDialog("Edição de Cliente\n\nInforme o nome:");
		String cpf = JOptionPane.showInputDialog("Edição de Cliente\n\nInforme o CPF:");
		String dataNascimento = JOptionPane.showInputDialog("Edição de Cliente\n\nInforme a data de nascimento:");
		String email = JOptionPane.showInputDialog("Edição de Cliente\n\nInforme o e-mail:");
		String numeroTelefone = JOptionPane.showInputDialog("Edição de Cliente\n\nInforme o número de telefone:");
		int idEndereco =  Integer.parseInt(JOptionPane.showInputDialog("Edição de Cliente\n\nInforme o id do endereço"));
				
		return new Cliente(idCliente,nome,cpf,dataNascimento,numeroTelefone,email,idEndereco);
	}
	
	private  int Remover() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o id do cliente para remover"));
		return id;
	}

}
