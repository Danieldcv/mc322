import java.util.ArrayList;
import java.util.Date;

public class Seguradora {
    // Atributos
	private final String cnpj;
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
    private ArrayList <Seguro> listaSeguros;
    private ArrayList <Cliente> listaClientes;
	
	// Método construtor
	public Seguradora(String cnpj, String nome, String telefone, String email, String endereco) {
		this.cnpj = cnpj;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		listaSeguros = new ArrayList<Seguro>();
		listaClientes = new ArrayList<Cliente>();
	}
	
	// Setters e getters
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCNPJ() {
		return cnpj;
	}

	public String getNome() {
		return nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getEndereco() {
		return endereco;
	}

	public ArrayList <Seguro> getListaSeguros() {
		return listaSeguros;
	}

	public ArrayList <Cliente> getListaClientes() {
		return listaClientes;
	}

	public boolean gerarSeguroPF(Date dataInicio, Date dataFim, Veiculo veiculo, ClientePF cliente) {
		for (Seguro s : listaSeguros) {
			if (s.getClass() == SeguroPF.class) {
				if(((SeguroPF)s).getVeiculo().getPlaca().equals(veiculo.getPlaca())) {
					return false;
				}
			}
		}
		Seguro seguro = new SeguroPF(dataInicio, dataFim, this, veiculo, cliente);
		listaSeguros.add(seguro);
		System.out.println("O Id deste seguro é: " + seguro.getId() + ". Anote-o para futuras consultas.");
		seguro.setValorMensal(seguro.calcularValor());
		System.out.println("O valor mensal deste seguro é de: " + seguro.getValorMensal() + " reais.");
		return true;
	}

	public boolean gerarSeguroPJ(Date dataInicio, Date dataFim, Frota frota, ClientePJ cliente) {
		for (Seguro s : listaSeguros) {
			if (s.getClass() == SeguroPJ.class) {
				if(((SeguroPJ)s).getFrota().getCode().equals(frota.getCode())) {
					return false;
				}
			}
		}
		Seguro seguro = new SeguroPJ(dataInicio, dataFim, this, frota, cliente);
		listaSeguros.add(seguro);
		System.out.println("O Id deste seguro é: " + seguro.getId() + ". Anote-o para futuras consultas.");
		seguro.setValorMensal(seguro.calcularValor());
		System.out.println("O valor mensal deste seguro é de: " + seguro.getValorMensal() + " reais.");
		return true;
	}

	public boolean cancelarSeguro(int id) {
		for (Seguro seguro : new ArrayList<Seguro>(listaSeguros)) {
			if (seguro.getId() == id) {
				listaSeguros.remove(seguro);
				return true;
			}
		}
		return false;
	}

	public boolean cadastrarCliente(Cliente cliente) {
		for (Cliente c : listaClientes) {
			if (c.equals(cliente))
				return false;
		}
		listaClientes.add(cliente);
		return true;
	}

	public boolean removerCliente(String id) {
		for (Cliente cliente : new ArrayList<Cliente>(listaClientes)) {
			if(cliente.getClass() == ClientePF.class) {
				if (((ClientePF)cliente).getCPF().equals(id)) {
					listaClientes.remove(cliente);
					for (Seguro seguro : new ArrayList<Seguro>(listaSeguros)) {
						if (seguro.getClass() == SeguroPF.class) {
							if(((SeguroPF)seguro).getCliente().getCPF().equals(id)) {
								listaSeguros.remove(seguro);
							}
						} 
					}
					return true;
				}
			}
			else if (cliente.getClass() == ClientePJ.class) {
				if (((ClientePJ)cliente).getCNPJ().equals(id)) {
					listaClientes.remove(cliente);
					for (Seguro seguro : new ArrayList<Seguro>(listaSeguros)) {
						if (seguro.getClass() == SeguroPJ.class) {
							if(((SeguroPJ)seguro).getCliente().getCNPJ().equals(id)) {
								listaSeguros.remove(seguro);
							}
						}
					}
					return true;
				}
			}
		}
		return false;
	}

	public String listarClientes() {
		String str = "";
		for (Cliente cliente : listaClientes) {
			str += cliente.toString() + "\n*\n";
		}
		return str;
	}

	public double calcularReceita() {
		double receita = 0;
		for (Seguro seguro : listaSeguros) {
			receita += seguro.calcularValor();
		}
		return receita;
	}

	public ArrayList<Seguro> getSegurosPorCliente(String cpf_cnpj) {
		Cliente cliente = null;
		ArrayList<Seguro> segurosCliente = new ArrayList<Seguro>();
		for (Cliente c : listaClientes) {
			if (c.getClass() == ClientePF.class) {
				if (((ClientePF)c).getCPF().equals(cpf_cnpj)) {
					cliente = c;
				}
			}
			else if (c.getClass() == ClientePJ.class) {
				if (((ClientePJ)c).getCNPJ().equals(cpf_cnpj)) {
					cliente = c;
				}
			}
		}
		for (Seguro seguro : listaSeguros) {
			if (seguro.getClass() == SeguroPF.class) {
				if(((SeguroPF)seguro).getCliente().equals(cliente)) {
					segurosCliente.add(seguro);
				}
			}
			else if (seguro.getClass() == SeguroPJ.class) {
				if(((SeguroPJ)seguro).getCliente().equals(cliente)) {
					segurosCliente.add(seguro);
				}
			}
		}
		return segurosCliente;
	}

	public ArrayList<Sinistro> getSinistrosPorCliente(String cpf_cnpj) {
		ArrayList<Sinistro> sinistrosCliente = new ArrayList<Sinistro>();
		ArrayList<Seguro> segurosCliente = getSegurosPorCliente(cpf_cnpj);
		for (Seguro seguro : segurosCliente) {
			for (Sinistro sinistro : seguro.getListaSinistros()) {
				sinistrosCliente.add(sinistro);
			}
		}
		return sinistrosCliente;
	}

	public ArrayList<Veiculo> getVeiculosPorClientePF(String cpf) {
		ArrayList<Veiculo> veiculosClientePF = new ArrayList<Veiculo>();
		for (Cliente cliente : listaClientes) {
			if (cliente.getClass() == ClientePF.class) {
				if (((ClientePF)cliente).getCPF().equals(cpf)) {
					for (Veiculo veiculo : ((ClientePF)cliente).getListaVeiculos()) {
						veiculosClientePF.add(veiculo);
					}
				}
			}
		}
		return veiculosClientePF;
	}

	public ArrayList<Frota> getFrotasPorClietePJ(String cnpj) {
		ArrayList<Frota> frotasClientePJ = new ArrayList<Frota>();
		for (Cliente cliente : listaClientes) {
			if (cliente.getClass() == ClientePJ.class) {
				if (((ClientePJ)cliente).getCNPJ().equals(cnpj)) {
					for (Frota frota : ((ClientePJ)cliente).getListaFrota()) {
						frotasClientePJ.add(frota);
					}
				}
			}
		}
		return frotasClientePJ;
	}

	public String listarSeguros() {
		String str = "";
		for (Seguro seguro : listaSeguros) {
			str += seguro.toString() + "\n*\n";
		}
		return str;
	}

	public String listarSegurosId() {
		String str = "";
		for (Seguro seguro : listaSeguros) {
			str += seguro.getId() + "\n*\n";
		}
		return str;
	}

	@Override
	public String toString() {
		String str = "DADOS DA SEGURADORA\nCNPJ: " + getCNPJ() + "\nNome: " + getNome() + "\nTelefone: " + getTelefone() + 
					"\nEmail: " + getEmail() + "\nEndereço: " + getEndereco() + "\nLISTA DE SEGUROS POR ID\n" + listarSegurosId()
					+ "\nLISTA DE CLIENTES\n" + listarClientes();
		return str;
	}
}
