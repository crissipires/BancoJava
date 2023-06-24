package main;

import javax.swing.JOptionPane;

import model.Cliente;

public class ClienteJOPtionPane {
	
	public static Cliente criarCliente() {
		String nome = JOptionPane.showInputDialog("Cadastro de Cliente\n\nInforme o nome:");
		String cpf = JOptionPane.showInputDialog("Cadastro de Cliente\n\nInforme o CPF:");
		String dataNascimento = JOptionPane.showInputDialog("Cadastro de Cliente\n\nInforme a data de nascimento:");
		String email = JOptionPane.showInputDialog("Cadastro de Cliente\n\nInforme o e-mail:");
		String numeroTelefone = JOptionPane.showInputDialog("Cadastro de Cliente\n\nInforme o número de telefone:");
		int idEndereco = Integer.parseInt(JOptionPane.showInputDialog("Cadastro de Cliente\n\nInforme o id do endereço"));
		
		Cliente cliente = new Cliente(nome,cpf,dataNascimento,numeroTelefone,email,idEndereco);
		return cliente; 
	}
	
	public static int removerCliente() {
		int id = Integer.parseInt(JOptionPane.showInputDialog("Informe o id do cliente para remover"));
		return id;
	}
	
	public static Cliente atualizarCliente() {
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
