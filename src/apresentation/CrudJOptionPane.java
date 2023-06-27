package apresentation;

import javax.swing.*;

public class CrudJOptionPane {
	
	private final ClienteJOptionPane _clienteJOPtionPane;
	private final VendaJOptionPane _vendaJOPtionPane;
	private final ItemVendaJOptionPane _itemVendaJOPtionPane;
	private final FuncionarioJOptionPane _funcionarioOPtionPane;
	private final EnderecoJOptionPane _enderecoJOPtionPane;
	private final AgendaJOptionPane _agendaJOptionPane;
	
	public CrudJOptionPane() {
		_clienteJOPtionPane = new ClienteJOptionPane();
	    _vendaJOPtionPane = new VendaJOptionPane();
		_itemVendaJOPtionPane = new ItemVendaJOptionPane();
		_funcionarioOPtionPane = new  FuncionarioJOptionPane();
		_enderecoJOPtionPane = new EnderecoJOptionPane();
		_agendaJOptionPane = new AgendaJOptionPane();
		
	}
	
    public void Executar(){
        boolean sair = false;

        while (!sair) {
            int opcao = exibirMenu();

            switch (opcao) {
                case 0: 
                	 ExecutarCliente();
                    break;
                case 1: 
                	 ExecutarVenda();
                    break;
                case 2: 
                	 ExecutarItemVenda();
                    break;
                case 3: 
                	_funcionarioOPtionPane.Listar();
                	break;
                case 4:
                	_enderecoJOPtionPane.Listar();
                	break;
                case 5:
                	_agendaJOptionPane.Listar();
                	break;
                case 6:
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
    
    public void ExecutarCliente(){
        boolean sair = false;

        while (!sair) {
            int opcao = ExibirMenuCrud("Cliente\n");

            switch (opcao) {
                case 0: 
                	_clienteJOPtionPane.Adicionar();
                    break;
                case 1: 
                	_clienteJOPtionPane.Listar();
                    break;
                case 2: 
                	_clienteJOPtionPane.Editar();
                    break;
                case 3: 
                	_clienteJOPtionPane.Remover();
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
    
    public void ExecutarVenda(){
        boolean sair = false;

        while (!sair) {
            int opcao = ExibirMenuCru("Venda\n");

            switch (opcao) {
	            case 0: 
	            	_vendaJOPtionPane.Adicionar();
	                break;
	            case 1: 
	            	_vendaJOPtionPane.Listar();
	                break;
	            case 2: 
	            	_vendaJOPtionPane.Editar();
	                break;
                case 3: 
                	sair = true;
                    break;
                case 4: 
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
    
    public void ExecutarItemVenda(){
        boolean sair = false;

        while (!sair) {
            int opcao = ExibirMenuCrud("Item da Venda\n");

            switch (opcao) {
            case 0: 
            	_itemVendaJOPtionPane.Adicionar();
                break;
            case 1: 
            	_itemVendaJOPtionPane.Listar();
                break;
            case 2: 
            	_itemVendaJOPtionPane.Editar();
                break;
            case 3: 
            	_itemVendaJOPtionPane.Remover();
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
    
    private int exibirMenu() {
        String[] options = { "Cliente", "Venda", "ItemVenda", "Listar Funcionários","Listar Endereços","Listar Agenda", "Sair" };

        return JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Menu", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
    }
    
    private int ExibirMenuCrud(String nome) {
        String[] options = { "Adicionar", "Listar", "Editar", "Remover","Voltar ao menu principal", "Sair" };

        return JOptionPane.showOptionDialog(null, nome + "Escolha uma opção:", "Menu", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
    }
    
    private int ExibirMenuCru(String nome) {
        String[] options = { "Adicionar", "Listar", "Editar","Voltar ao menu principal", "Sair" };

        return JOptionPane.showOptionDialog(null, nome + "Escolha uma opção:", "Menu", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
    }
    
}
