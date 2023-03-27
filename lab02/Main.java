import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		// Testando os métodos da classe Cliente
		Cliente cliente = new Cliente("Daniel", "464.236.448-02", "15/09/2004", 18, "Rua Pitágoras 123");
		System.out.println(cliente);
	 	System.out.println(cliente.validarCPF(cliente.getCPF()));
		if (cliente.validarCPF(cliente.getCPF()) == false)
			System.out.println("CPF inválido.");
		System.out.println();

		// Testando os métodos da classe Seguradora
		Seguradora seguradora = new Seguradora("Unicamp Seguros", "11999981571", "seguros@dac.unicamp.br", "DAC");
		System.out.println(seguradora);
		System.out.println();

		// Testando os métodos da classe Sinistro
		Sinistro sinistro = new Sinistro();
		System.out.println("DADOS DO SINISTRO");
		sinistro.setData("23/03/2023");
		sinistro.setId(1);
		sinistro.setEndereco("Rua Alfredo Pujol 321");
		System.out.println("Data: " +sinistro.getData());
		System.out.println("ID: " +sinistro.getId());
		System.out.println("Endereco: " +sinistro.getEndereco());
		System.out.println();

		// Criando um segundo objeto da classe sinistro para um melhor teste do método setId
		Sinistro sinistro2 = new Sinistro();
		System.out.println("DADOS DO SEGUNDO SINISTRO");
		sinistro2.setData("17/06/2004");
		sinistro2.setId(1);
		sinistro2.setEndereco("Rua Leôncio de Magalhães");
		System.out.println("Data: " +sinistro.getData());
		System.out.println("ID: " +sinistro.getId());
		System.out.println("Endereco: " +sinistro.getEndereco());
		System.out.println();

		// Testando os métodos da classe Veiculo
		Scanner in = new Scanner(System.in);
		Veiculo veiculo = new Veiculo();
		System.out.println("DADOS DO VEICULO");
		System.out.print("Digite a marca do veiculo: ");
		veiculo.setMarca(in.nextLine());
		System.out.print("Digite o modelo do veiculo: ");
		veiculo.setModelo(in.nextLine());
		System.out.print("Digite a placa do veiculo: ");
		veiculo.setPlaca(in.nextLine());
		System.out.println("Marca: " +veiculo.getMarca());
		System.out.println("Modelo: " +veiculo.getModelo());
		System.out.println("Placa: " +veiculo.getPlaca());

		in.close();
	}
}
