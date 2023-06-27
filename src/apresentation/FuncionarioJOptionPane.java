package apresentation;

import java.util.List;

import model.Banco;
import model.Funcionario;
import repository.FuncionarioRepository;

public class FuncionarioJOptionPane {

	private final FuncionarioRepository _funcionarioRepository;
	private final Banco _banco;
	
	public FuncionarioJOptionPane() {
		_funcionarioRepository = new FuncionarioRepository();
		_banco = new Banco();
	}
	
	public void Listar() {
		List<Funcionario> listafuncionarios = _funcionarioRepository.listar(_banco.getConexao());
		System.out.println("------- FUNCIONÁRIOS -------");
		for (Funcionario funcionario : listafuncionarios) {
			System.out.println("Id do Funcionário: " + funcionario.id);
			System.out.println("Nome: " + funcionario.nome);
			System.out.println("CPF: " + funcionario.cpf);
			System.out.println("Telefone: " + funcionario.telefone);
			System.out.println("Data de Nascimento: " + funcionario.dataNascimento);
			System.out.println("Salário: " + funcionario.salario);
			System.out.println("Id do Cargo : " + funcionario.idCargo);
			System.out.println("Id do Endereço: " + funcionario.idEndereco);
			System.out.println("---------------------------------");
		}
	}
}
