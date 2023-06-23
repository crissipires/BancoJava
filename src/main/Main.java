package main;

import java.sql.Connection;

import javax.swing.JOptionPane;

public class Main {
	
	public static void main(String[] args) {
		
		Banco banco = new Banco();
		Connection conexao = banco.getConexao();
		
		ClienteRepository clienteRepository = new ClienteRepository();
		clienteRepository.listaClientes(conexao);
		
		//-----------------testes do crud
		
		Cliente cliente = new Cliente();
		cliente.nome = JOptionPane.showInputDialog("Cadastro de Cliente\n\nInforme o nome:");
		cliente.cpf = JOptionPane.showInputDialog("Cadastro de Cliente\n\nInforme o CPF:");
		cliente.dataNascimento = JOptionPane.showInputDialog("Cadastro de Cliente\n\nInforme a data de nascimento:");
		cliente.email = JOptionPane.showInputDialog("Cadastro de Cliente\n\nInforme o e-mail:");
		cliente.numeroTelefone = JOptionPane.showInputDialog("Cadastro de Cliente\n\nInforme o número do telefone:");
		
		clienteRepository.insereCliente(conexao, cliente);
		clienteRepository.editaCliente(conexao);
		clienteRepository.removeCliente(conexao);
		clienteRepository.findByName(conexao);
		
		banco.fechaConexao();
		
	}
}