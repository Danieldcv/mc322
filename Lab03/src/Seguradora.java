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
	public Seguradora(String nome, String telefone, String email, String endereco, ArrayList < Sinistro> listaSinistros, ArrayList <Cliente> listaClientes) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
		this.listaSinistros = listaSinistros;
		this.listaClientes = listaClientes;
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
		for (Cliente c : this.listaClientes) {
			if (c == cliente)
				return false;
		}
		this.listaClientes.add(cliente);
		return true;
	}

	public boolean removerCliente(String nome) {
		for (Cliente cliente : this.listaClientes) {
			if (cliente.getNome().equals(nome)) {
				this.listaClientes.remove(cliente);
				for (Sinistro sinistro : new ArrayList<Sinistro>(this.listaSinistros)) 
					if (sinistro.getCliente().getNome().equals(nome)) 
						this.listaSinistros.remove(sinistro);
				return true;
			}
		}
		return false;
	}

	public String listarClientes() {
		String str = "";
		for (Cliente cliente : this.listaClientes) {
			str += cliente.toString() + "\n*\n";
		}
		return str;
	}

	public boolean gerarSinistro(Date data, String endereco, Veiculo veiculo, Cliente cliente) {
		Sinistro sinistro = new Sinistro();
		sinistro.setId(1);
		sinistro.setData(data);
		sinistro.setEndereco(endereco);
		sinistro.setCliente(cliente);
		sinistro.setSeguradora(this); 
		sinistro.setVeiculo(veiculo);
		for (Sinistro s : this.listaSinistros) 
			if (s.getCliente() == sinistro.getCliente() && s.getData() == sinistro.getData() && 
				s.getEndereco().equals(sinistro.getEndereco()) && s.getVeiculo() == sinistro.getVeiculo()) 
				return false;
		this.listaSinistros.add(sinistro);
		return true;
	}

	public boolean visualizarSinistro(String nome) {
		boolean flag = false;
		for (Sinistro sinistro : this.listaSinistros) {
			if (sinistro.getCliente().getNome() == nome) {
				System.out.println(sinistro);
				flag = true;
			}
		}
		return flag;
	}

	public String listarSinistros() {
		String str = "";
		for (Sinistro sinistro : this.listaSinistros) {
			str += sinistro.toString() + "\n*\n";
		}
		return str;
	}

	@Override
	public String toString() {
		String str = "DADOS DA SEGURADORA\nNome: " + getNome() + "\nTelefone: " + getTelefone() + 
					"\nEmail: " + getEmail() + "\nEndereco: " + getEndereco() + "\nLista de sinistros: " + getListaSinistros()
					+ "\nLista de clientes: " + getListaClientes() + "\n";
		return str;
	}
}
