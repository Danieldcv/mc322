import java.util.ArrayList;
import java.util.Date;

public class Seguradora {
    // Atributos
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
    private ArrayList <Sinistro> listaSinistros;
    private ArrayList <Cliente> listaClientes;
	
	// Método construtor
	public Seguradora(String nome, String telefone, String email, String endereco) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		listaSinistros = new ArrayList<Sinistro>();
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

	public ArrayList <Sinistro> getListaSinistros() {
		return listaSinistros;
	}

	public ArrayList <Cliente> getListaClientes() {
		return listaClientes;
	}

	public boolean cadastrarCliente(Cliente cliente) {
		for (Cliente c : listaClientes) {
			if (c == cliente)
				return false;
		}
		listaClientes.add(cliente);
		return true;
	}

	public boolean removerCliente(String nome) {
		for (Cliente cliente : new ArrayList<Cliente>(listaClientes)) {
			if (cliente.getNome().equals(nome)) {
				listaClientes.remove(cliente);
				for (Sinistro sinistro : new ArrayList<Sinistro>(listaSinistros)) 
					if (sinistro.getCliente().getNome().equals(nome)) 
						listaSinistros.remove(sinistro);
				return true;
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

	public boolean gerarSinistro(Date data, String endereco, String placa, String nomeCliente) {
		Sinistro sinistro = new Sinistro(data, endereco, this);
		for (Cliente cliente : listaClientes) {
			if (cliente.getNome().equals(nomeCliente)) {
				sinistro.setCliente(cliente);
				for (Veiculo veiculo : cliente.getListaVeiculos()) {
					if (veiculo.getPlaca().equals(placa)) {
						sinistro.setVeiculo(veiculo);
					}
				}
			}
		}
		for (Sinistro s : listaSinistros) 
			if (s.getCliente().equals(sinistro.getCliente()) && s.getData().equals(sinistro.getData()) && 
				s.getEndereco().equals(sinistro.getEndereco()) && s.getVeiculo().equals(sinistro.getVeiculo())) 
				return false;
		listaSinistros.add(sinistro);
		return true;
	}

	public boolean visualizarSinistro(String nome) {
		boolean flag = false;
		for (Sinistro sinistro : listaSinistros) {
			if (sinistro.getCliente().getNome().equals(nome)) {
				if (!flag)
					System.out.printf("Lista de sinistros do cliente %s\n", nome);
				System.out.println(sinistro);
				flag = true;
			}
		}
		if (flag)
			System.out.println("FIM DA LISTA.");
		return flag;
	}

	public String listarSinistros() {
		String str = "";
		for (Sinistro sinistro : listaSinistros) {
			str += sinistro.toString() + "\n*\n";
		}
		return str;
	}

	public boolean removerSinistro(Date data, String endereco, String nomeCliente) {
		for (Sinistro sinistro : new ArrayList<Sinistro>(listaSinistros)) {
			if (sinistro.getCliente().getNome().equals(nomeCliente) && sinistro.getData().equals(data) && sinistro.getEndereco().equals(endereco)) {
				listaSinistros.remove(sinistro);
				return true;
			}
		}
		return false;
	}

	public boolean visualizarVeiculo(String nome) {
		boolean flag = false;
		for (Cliente cliente : listaClientes) {
			if (cliente.getNome().equals(nome)) {
				for (Veiculo veiculo : cliente.getListaVeiculos()) {
					if (!flag)
						System.out.printf("Lista de veiculos do cliente %s\n", nome);
					System.out.println(veiculo);
					flag = true;
				}
			}
		}
		if (flag)
			System.out.println("FIM DA LISTA.");
		return flag;
	}

	public String listarVeiculos() {
		String str = "";
		for (Cliente cliente : listaClientes) {
			for (Veiculo veiculo : cliente.getListaVeiculos()) {
				str += veiculo.toString() + "\n*\n";
			}
		}
		return str;
	}

	public void adicionaVeiculoCliente(Veiculo veiculo, String nome) {
		for (Cliente cliente : listaClientes) {
			if (cliente.getNome().equals(nome)) {
				cliente.adicionaVeiculo(veiculo);
			}
		}
	}

	public boolean removerVeiculo(String placa, String nomeCliente) {
		for (Cliente cliente : listaClientes) {
			if (cliente.getNome().equals(nomeCliente)) {
				for (Veiculo veiculo : new ArrayList<Veiculo>(cliente.getListaVeiculos())) {
					if (veiculo.getPlaca().equals(placa)) {
						cliente.getListaVeiculos().remove(veiculo);
						return true;
					}
				}
			}
		}
		return false;
	}

	public double calcularPrecoSeguroCliente(Cliente cliente) {
		// Calculando o numero de sinistros do cliente
		int nSinistros = 0;
		for (Sinistro sinistro : listaSinistros) {
			if (sinistro.getCliente().equals(cliente)) {
				nSinistros++;
			}
		}

		// Calculando o preço efetivamente
		return cliente.calculaScore() * (1 + nSinistros);
	}

	public double calcularReceita() {
		double receita = 0;
		for (Cliente cliente : listaClientes) {
			receita += calcularPrecoSeguroCliente(cliente);
			cliente.setValorSeguro(calcularPrecoSeguroCliente(cliente));
		}
		return receita;
	}

	public boolean transferirSeguro(String nomeCliente1, String nomeCliente2) {
		// O cliente1 transfere o seguro, enquanto o cliente 2 o recebe
		Cliente cliente1 = null, cliente2 = null;
		for (Cliente cliente : listaClientes) {
			if (cliente.getNome().equals(nomeCliente1))
				cliente1 = cliente;
			else if (cliente.getNome().equals(nomeCliente2))
				cliente2 = cliente;
		}
		if (cliente1 == null || cliente2 == null)
			return false;
		for (Veiculo veiculo : cliente1.getListaVeiculos())
			cliente2.adicionaVeiculo(veiculo);
		cliente1.getListaVeiculos().clear();
		cliente1.setValorSeguro(0);
		cliente2.setValorSeguro(calcularPrecoSeguroCliente(cliente2));
		return true;
	}

	@Override
	public String toString() {
		String str = "DADOS DA SEGURADORA\nNome: " + getNome() + "\nTelefone: " + getTelefone() + 
					"\nEmail: " + getEmail() + "\nEndereco: " + getEndereco() + "\nLista de sinistros: " + getListaSinistros()
					+ "\nLista de clientes: " + getListaClientes() + "\n";
		return str;
	}
}
