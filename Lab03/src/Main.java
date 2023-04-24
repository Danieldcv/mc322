import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void leituraDeDados(String tipo, Seguradora seguradora, Scanner entrada) throws Exception{
        // Método que realiza a leitura de dados e o cadastro de um clientepf e de um clientepj na seguradora
        SimpleDateFormat datasFormatadas = new SimpleDateFormat("dd/MM/yyyy");
        if (tipo == "CPF") {
            System.out.println("Digite seu CPF utilizando apenas caracteres numericos: ");
            String cpf = entrada.nextLine();
            if(ClientePF.validarCPF(cpf) == false) {
                System.out.println("CPF invalido. Verifique-o e digite-o novamente com os digitos corretos.");
                cpf = entrada.nextLine();
            }
            else
                System.out.println("CPF valido!");

            System.out.println("Digite seu nome completo: ");
            String nome = entrada.nextLine();

            System.out.println("Digite a data de seu nascimento no formato dd/MM/yyyy: ");
            Date dataNascimento = datasFormatadas.parse(entrada.nextLine());

            System.out.println("Digite a data de sua licenca no formato dd/MM/yyyy: ");
            Date dataLicenca = datasFormatadas.parse(entrada.nextLine());

            System.out.println("Digite seu endereço: ");
            String endereco = entrada.nextLine();

            System.out.println("Digite seu grau de escolaridade: ");
            String educacao = entrada.nextLine();

            System.out.println("Digite seu genero: ");
            String genero = entrada.nextLine();

            System.out.println("Digite sua classe economica: ");
            String classeEconomica = entrada.nextLine();

            System.out.println("Digite seu numero de veiculos: ");
            Integer nVeiculos = Integer.parseInt(entrada.nextLine());
            ArrayList <Veiculo> listaVeiculos = new ArrayList<Veiculo>();
            for (int i = 0; i < nVeiculos; i++) {
                Veiculo veiculo = new Veiculo();
                System.out.printf("Digite a marca do veiculo %d: ", i + 1);
                veiculo.setMarca(entrada.nextLine());
                System.out.printf("Digite o modelo do veiculo %d: ", i + 1);
                veiculo.setModelo(entrada.nextLine());
                System.out.printf("Digite a placa do veiculo %d: ", i + 1);
                veiculo.setPlaca(entrada.nextLine());
                System.out.printf("Digite o ano de fabricacao do veiculo %d: ", i + 1);
                Integer anoFabricacao = Integer.parseInt(entrada.nextLine());
                veiculo.setAnoFabricacao(anoFabricacao);
                listaVeiculos.add(veiculo);
                System.out.println(veiculo); /* método toString() da classe Veiculo */
            }

            ClientePF clientepf = new ClientePF(nome, endereco, listaVeiculos, cpf, dataNascimento, educacao, genero, classeEconomica, dataLicenca);
            if (seguradora.cadastrarCliente(clientepf) == true) {
                System.out.println("Cliente PF cadastrado com sucesso!");
                System.out.println(clientepf); /* método toString() da classe ClientePF */
            }
            else
                System.out.println("Erro de cadastro: cliente ja cadastrado anteriormente");
            System.out.println();
        }
        
        else if (tipo == "CNPJ") {
            System.out.println("Digite seu CNPJ utilizando apenas caracteres numericos: ");
            String cnpj = entrada.nextLine();
            if (ClientePJ.validarCNPJ(cnpj) == false) {
                System.out.println("CNPJ invalido. Verifique-o e digite-o novamente com os digitos corretos.");
                cnpj = entrada.nextLine();
            }
            else
                System.out.println("CNPJ valido!");

            System.out.println("Digite o nome de sua empresa: ");
            String nome = entrada.nextLine();

            System.out.println("Digite a data de fundacao de sua empresa no formato dd/MM/yyyy: ");
            Date dataFundacao = datasFormatadas.parse(entrada.nextLine());

            System.out.println("Digite o endereco de sua empresa: ");
            String endereco = entrada.nextLine();

            System.out.println("Digite seu numero de veiculos: ");
            Integer nVeiculos = Integer.parseInt(entrada.nextLine());
            ArrayList <Veiculo> listaVeiculos = new ArrayList<Veiculo>();
            for (int i = 0; i < nVeiculos; i++) {
                Veiculo veiculo = new Veiculo();
                System.out.printf("Digite a marca do veiculo %d: ", i + 1);
                veiculo.setMarca(entrada.nextLine());
                System.out.printf("Digite o modelo do veiculo %d: ", i + 1);
                veiculo.setModelo(entrada.nextLine());
                System.out.printf("Digite a placa do veiculo %d: ", i + 1);
                veiculo.setPlaca(entrada.nextLine());
                System.out.printf("Digite o ano de fabricacao do veiculo %d: ", i + 1);
                Integer anoFabricacao = Integer.parseInt(entrada.nextLine());
                veiculo.setAnoFabricacao(anoFabricacao);
                listaVeiculos.add(veiculo);
                System.out.println(veiculo); /* método toString() da classe Veiculo */
            }

            ClientePJ clientepj = new ClientePJ(nome, endereco, listaVeiculos, cnpj, dataFundacao);
            if (seguradora.cadastrarCliente(clientepj) == true) {
                System.out.println("Cliente PJ cadastrado com sucesso!");
                System.out.println(clientepj); /* método toString() da classe ClientePJ */
            }
            else
                System.out.println("Erro de cadastro: cliente ja cadastrado anteriormente");
            System.out.println();
        }
    }
    public static void main(String[] args) throws Exception {
        // Instanciando um objeto da classe Seguradora
        Scanner entrada = new Scanner(System.in);
        SimpleDateFormat datasFormatadas = new SimpleDateFormat("dd/MM/yyyy");
        ArrayList <Cliente> listaClientes = new ArrayList<Cliente>();
        ArrayList <Sinistro> listaSinistros = new ArrayList<Sinistro>();
        Seguradora seguradora = new Seguradora("Unicamp Seguros", "11999981571", "seguros@dac.unicamp.br", "DAC", listaSinistros, listaClientes);
        System.out.println(seguradora); /* método toString() da classe Seguradora */
        System.out.println();

        // Cadastrando um cliente PF
        Veiculo meuVeiculo = new Veiculo("DCV1516", "Renault", "Duster", 2018);
        ArrayList <Veiculo> listaVeiculos = new ArrayList<Veiculo>();
        listaVeiculos.add(meuVeiculo);
        Date dataNascimento = datasFormatadas.parse("15/09/2004");
        Date dataLicenca = datasFormatadas.parse("20/01/2023");
        if (ClientePF.validarCPF("46423644802") == false) 
            System.out.println("CPF invalido.");
        ClientePF clientepf = new ClientePF("Daniel", "Rua Doutor Zuquim 1782", listaVeiculos, "46423644802", dataNascimento, 
                            "Ensino medio completo", "Masculino", "Classe media", dataLicenca);
        
        if (seguradora.cadastrarCliente(clientepf) == true) {
            System.out.println("Cliente PF cadastrado com sucesso!");
            System.out.println(clientepf); /* método toString() da classe ClientePF */
        }
        else
            System.out.println("Erro de cadastro: cliente ja cadastrado anteriormente");
        System.out.println();

        // Gerando um sinistro do clientepf cadastrado anteriormente
        Date dataSinistro = datasFormatadas.parse("16/04/2023");
        if (seguradora.gerarSinistro(dataSinistro, "Rua Alfredo Pujol 321", meuVeiculo, clientepf) == true) {
            System.out.println("Sinistro gerado com sucesso!");
        }
        else
            System.out.println("Erro ao gerar sinistro. Sinistro ja gerado anteriormente.");
        System.out.println();

        // Visualizando um sinistro
        if (seguradora.visualizarSinistro(clientepf.getNome()) == false)
            System.out.println("Erro ao visualizar sinistro. O cliente em questao nao tem nenhum sinistro.");


        // Listando os sinistros
        System.out.println("LISTA DE SINISTROS GERADOS");
        System.out.println(seguradora.listarSinistros());
        System.out.println("FIM DA LISTA");

        // Removendo o clientepf cadastrado da seguradora
        if (seguradora.removerCliente(clientepf.getNome()) == true) 
            System.out.println("Cliente PF removido com sucesso!");
        else
            System.out.println("Erro na remocao. Cliente PF nao encontrado");

        // Recebendo os dados de um cliente PF e cadastrando-o na seguradora (OK)
        leituraDeDados("CPF", seguradora, entrada);

        // Recebendo os dados de um cliente PJ e cadastrando-o na seguradora (OK)
        leituraDeDados("CNPJ", seguradora, entrada);

        // Listando os clientes (OK)
        System.out.println("LISTA DE CLIENTES CADASTRADOS");
        System.out.println(seguradora.listarClientes());
        System.out.println("FIM DA LISTA");
        
        entrada.close();
    }
}