package apresentation;

import java.util.List;

import model.Banco;
import model.Funcionario;
import repository.FuncionarioRepository;
import view.ViewFuncionario;

public class FuncionarioJOptionPane {

	private final FuncionarioRepository _funcionarioRepository;
	private final Banco _banco;
	
	public FuncionarioJOptionPane() {
		_funcionarioRepository = new FuncionarioRepository();
		_banco = new Banco();
	}
	
	public void Listar() {
		List<ViewFuncionario> listafuncionarios = _funcionarioRepository.listar(_banco.getConexao());
		System.out.println("------- FUNCIONÁRIOS -------");
		for (ViewFuncionario funcionario : listafuncionarios) {
			System.out.println("Código do Funcionário: " + funcionario.idFuncionario);
			System.out.println("Nome: " + funcionario.nomeFuncionario);
			System.out.println("Cargo: " + funcionario.descricaoCargo);
			System.out.println("---------------------------------");
		}
	}
}
