package apresentation;

import java.util.List;

import model.Banco;
import repository.EnderecoRepository;
import view.ViewEndereco;
import model.Endereco;

public class EnderecoJOptionPane {
	private final EnderecoRepository _enderecoRepository;
	private final Banco _banco;

	public EnderecoJOptionPane() {
	    _enderecoRepository = new EnderecoRepository();
	    _banco = new Banco();
	}

	public void Listar() {
	    List<ViewEndereco> listaEnderecos = _enderecoRepository.listar(_banco.getConexao());
	    System.out.println("------- ENDEREÇOS -------");
	    for (ViewEndereco endereco : listaEnderecos) {
	        System.out.println("Código do Endereco: " + endereco.idEndereco);
	        System.out.println("Logradouro: " + endereco.logradouro);
	        System.out.println("Bairro: " + endereco.nomeBairro);
	        System.out.println("Cidade: " + endereco.nomeCidade);
	        System.out.println("Estado: " + endereco.nomeEstado);
	        System.out.println("País: " + endereco.nomePais);
	        System.out.println("---------------------------------");
	    }
	}
}
