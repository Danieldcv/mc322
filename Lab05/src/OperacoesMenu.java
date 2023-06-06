import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class OperacoesMenu {
    // Classe auxilir criada para a implementação das operações do Menu Interativo
    private static SimpleDateFormat datasFormatadas = new SimpleDateFormat("dd/MM/yyyy");

    public static void cadastrarClientePF(ArrayList<Seguradora> listaSeguradoras, Scanner entrada) throws Exception{
        System.out.println("Digite seu CPF: ");
        String cpf = entrada.nextLine();
        cpf = cpf.replaceAll("[^0-9]+", "");
        if(!Validacao.validarCPF(cpf)) {
            System.out.println("CPF inválido. Verifique-o e digite-o novamente com os dígitos corretos.");
            cpf = entrada.nextLine();
            cpf = cpf.replaceAll("[^0-9]+", "");
        }
        else
            System.out.println("CPF válido!");

        System.out.println("Digite seu nome completo: ");
        String nome = entrada.nextLine();
        if (Validacao.validarNome(nome))
            System.out.println("Nome válido!");
        else {
            System.out.println("Nome inválido. Digite-o novamente usando apenas letras e espaços, sem caracteres especiais como acento e cedilha");
            System.out.println("Digite seu nome completo novamente: ");
            nome = entrada.nextLine();
        }

        System.out.println("Digite seu telefone: ");
        String telefone = entrada.nextLine();

        System.out.println("Digite seu email: ");
        String email = entrada.nextLine();

        System.out.println("Digite a data de seu nascimento no formato dd/MM/yyyy: ");
        Date dataNascimento = datasFormatadas.parse(entrada.nextLine());

        System.out.println("Digite seu endereço: ");
        String endereco = entrada.nextLine();

        System.out.println("Digite seu grau de escolaridade: ");
        String educacao = entrada.nextLine();

        System.out.println("Digite seu gênero: ");
        String genero = entrada.nextLine();

        ClientePF clientepf = new ClientePF(nome, endereco, telefone, email, cpf, dataNascimento, educacao, genero);
        System.out.println("Digite seu número de veículos: ");
        Integer nVeiculos = Integer.parseInt(entrada.nextLine());
        for (int i = 0; i < nVeiculos; i++) {
            System.out.printf("Digite a marca do veículo %d: ", i + 1);
            String marca = entrada.nextLine();
            System.out.printf("Digite o modelo do veículo %d: ", i + 1);
            String modelo = entrada.nextLine();
            System.out.printf("Digite a placa do veículo %d: ", i + 1);
            String placa = entrada.nextLine();
            System.out.printf("Digite o ano de fabricação do veículo %d: ", i + 1);
            Integer anoFabricacao = Integer.parseInt(entrada.nextLine());
            Veiculo veiculo = new Veiculo(placa, marca, modelo, anoFabricacao);
            clientepf.cadastrarVeiculo(veiculo);
        }

        System.out.println("Digite o CNPJ da seguradora na qual gostaria de se cadastrar: ");
        String cnpjSeguradora = entrada.nextLine();
        cnpjSeguradora = cnpjSeguradora.replaceAll("[^0-9]+", "");
        for (Seguradora seg : listaSeguradoras) {
            if (seg.getCNPJ().equals(cnpjSeguradora)) {
                if (seg.cadastrarCliente(clientepf)) 
                    System.out.println("Cliente PF cadastrado com sucesso!");
                else
                    System.out.println("Erro de cadastro: cliente já cadastrado anteriormente");
            }
        }
    }

    public static void cadastrarClientePJ(ArrayList<Seguradora> listaSeguradoras, Scanner entrada) throws Exception {
        System.out.println("Digite seu CNPJ: ");
        String cnpj = entrada.nextLine();
        cnpj = cnpj.replaceAll("[^0-9]+", "");
        if (!Validacao.validarCNPJ(cnpj)) {
            System.out.println("CNPJ inválido. Verifique-o e digite-o novamente com os dígitos corretos: ");
            cnpj = entrada.nextLine();
            cnpj = cnpj.replaceAll("[^0-9]+", "");
        }
        else
            System.out.println("CNPJ válido!");

        System.out.println("Digite o nome de sua empresa: ");
        String nome = entrada.nextLine();
        if (Validacao.validarNome(nome))
            System.out.println("Nome válido!");
        else {
            System.out.println("Nome inválido. Digite-o novamente usando apenas letras e espaços, sem caracteres especiais como acento e cedilha");
            System.out.println("Digite o nome de sua empresa novamente: ");
            nome = entrada.nextLine();
        }

        System.out.println("Digite a data de fundação de sua empresa no formato dd/MM/yyyy: ");
        Date dataFundacao = datasFormatadas.parse(entrada.nextLine());

        System.out.println("Digite o endereço de sua empresa: ");
        String endereco = entrada.nextLine();

        System.out.println("Digite o telefone de sua empresa: ");
        String telefone = entrada.nextLine();

        System.out.println("Digite o email de sua empresa: ");
        String email = entrada.nextLine();

        System.out.println("Digite a quantidade de funcionários de sua empresa: ");
        Integer qtdeFuncionarios = Integer.parseInt(entrada.nextLine());

        System.out.println("Digite um nome para identificar esta frota: ");
        String nomeFrota = entrada.nextLine();
        Frota frota = new Frota(nomeFrota);
        System.out.println("O code identificador desta frota é: " + frota.getCode() + ". Anote-o para futuras consultas!");

        ClientePJ clientepj = new ClientePJ(nome, endereco, telefone, email, cnpj, dataFundacao, qtdeFuncionarios);
        System.out.println("Digite seu numero de veículos: ");
        Integer nVeiculos = Integer.parseInt(entrada.nextLine());
        for (int i = 0; i < nVeiculos; i++) {
            System.out.printf("Digite a marca do veículo %d: ", i + 1);
            String marca = entrada.nextLine();
            System.out.printf("Digite o modelo do veículo %d: ", i + 1);
            String modelo = entrada.nextLine();
            System.out.printf("Digite a placa do veículo %d: ", i + 1);
            String placa = entrada.nextLine();
            System.out.printf("Digite o ano de fabricação do veículo %d: ", i + 1);
            Integer anoFabricacao = Integer.parseInt(entrada.nextLine());
            Veiculo veiculo = new Veiculo(placa, marca, modelo, anoFabricacao);
            frota.adicionaVeiculo(veiculo);
        }
        if (clientepj.cadastrarFrota(frota)) {
            System.out.println("Frota cadastrada com sucesso!");
        }
        else {
            System.out.println("Erro ao cadastrar frota: frota já cadastrada anteriormente.");
        }

        System.out.println("Digite o CNPJ da seguradora na qual gostaria de efetuar o cadastro: ");
        String cnpjSeguradora = entrada.nextLine();
        cnpjSeguradora = cnpjSeguradora.replaceAll("[^0-9]+", "");
        for (Seguradora seg: listaSeguradoras) {
            if (seg.getCNPJ().equals(cnpjSeguradora)) {
                if (seg.cadastrarCliente(clientepj)) 
                    System.out.println("Cliente PJ cadastrado com sucesso!");
                else
                    System.out.println("Erro de cadastro: cliente já cadastrado anteriormente");
            }
        }
    }

    public static void cadastrarVeiculo(ArrayList<Seguradora> listaSeguradoras, Scanner entrada) {
        System.out.printf("Digite a marca do veículo: ");
        String marca = entrada.nextLine();
        System.out.printf("Digite o modelo do veículo: ");
        String modelo = entrada.nextLine();
        System.out.printf("Digite a placa do veículo: ");
        String placa = entrada.nextLine();
        System.out.printf("Digite o ano de fabricação do veículo: ");
        Integer anoFabricacao = Integer.parseInt(entrada.nextLine());
        Veiculo veiculo = new Veiculo(placa, marca, modelo, anoFabricacao);

        System.out.println("Digite o CPF do cliente a que deseja adicionar este veículo: ");
        String cpfCliente = entrada.nextLine();
        cpfCliente = cpfCliente.replaceAll("[^0-9]+", "");
        System.out.println("Digite o CNPJ da seguradora em que o cliente digitado acima está cadastrado: ");
        String cnpjSeguradora = entrada.nextLine();
        cnpjSeguradora = cnpjSeguradora.replaceAll("[^0-9]+", "");
        for (Seguradora seg : listaSeguradoras) {
            if (seg.getCNPJ().equals(cnpjSeguradora)) {
                for (Cliente cliente : seg.getListaClientes()) {
                    if (cliente.getClass() == ClientePF.class) {
                        if (((ClientePF)cliente).getCPF().equals(cpfCliente)) {
                            if(((ClientePF)cliente).cadastrarVeiculo(veiculo)) 
                                System.out.println("Veículo cadastrado com sucesso!");
                            else
                                System.out.println("Erro de cadastro: veículo já cadastrado anteriormete.");
                        }
                    }
                }
            }
        }
    }

    public static void cadastrarSeguradora(ArrayList<Seguradora> listaSeguradoras, Scanner entrada) {
        System.out.println("Digite o CNPJ da seguradora: ");
        String cnpj = entrada.nextLine();
        cnpj = cnpj.replaceAll("[^0-9]+", "");
        System.out.println("Digite o nome da seguradora: ");
        String nome = entrada.nextLine();
        System.out.println("Digite o telefone da seguradora: ");
        String telefone = entrada.nextLine();
        System.out.println("Digite o email da seguradora: ");
        String email = entrada.nextLine();
        System.out.println("Digite o endereço da seguradora: ");
        String endereco = entrada.nextLine();
        Seguradora seguradora2 = new Seguradora(cnpj, nome, telefone, email, endereco);
        if (! listaSeguradoras.contains(seguradora2)) {
            listaSeguradoras.add(seguradora2);
            System.out.println("Seguradora cadastrada com sucesso!");
        }
        else
            System.out.println("Erro no cadastro: seguradora já cadastrada anteriormente.");
    }

    public static void cadastrarFrota(ArrayList<Seguradora> listaSeguradoras, Scanner entrada) {
        System.out.println("Digite um nome para identificar esta frota: ");
        String nome = entrada.nextLine();
        Frota frota = new Frota(nome);
        System.out.println("O code identificador desta frota é: " + frota.getCode() + ". Anote-o para futuras consultas!");
        
        System.out.println("Digite o número de veículos desta frota: ");
        Integer nVeiculos = Integer.parseInt(entrada.nextLine());
        for (int i = 0; i < nVeiculos; i++) {
            System.out.printf("Digite a marca do veículo %d: ", i + 1);
            String marca = entrada.nextLine();
            System.out.printf("Digite o modelo do veículo %d: ", i + 1);
            String modelo = entrada.nextLine();
            System.out.printf("Digite a placa do veículo %d: ", i + 1);
            String placa = entrada.nextLine();
            System.out.printf("Digite o ano de fabricação do veículo %d: ", i + 1);
            Integer anoFabricacao = Integer.parseInt(entrada.nextLine());
            Veiculo veiculo = new Veiculo(placa, marca, modelo, anoFabricacao);
            if (frota.adicionaVeiculo(veiculo))
                System.out.println("Veículo adicionado à frota com sucesso!");
            else
                System.out.println("Erro: veículo já adicionado anteriomente.");
            System.out.println("*");
        }
    }

    public static void listarClientesSeguradora(ArrayList<Seguradora> listaSeguradoras, Scanner entrada) {
        System.out.println("Digite o CNPJ da seguradora da qual deseja listar os clientes: ");
        String cnpj = entrada.nextLine();
        cnpj = cnpj.replaceAll("[^0-9]+", "");
        for (Seguradora seg : listaSeguradoras) {
            if (seg.getCNPJ().equals(cnpj)) {
                System.out.printf("Lista de clientes cadastrados na seguradora %s\n", seg.getNome());
                System.out.print(seg.listarClientes());
                System.out.println("FIM DA LISTA");
            }
        }
    }

    public static void listarSegurosSeguradora(ArrayList<Seguradora> listaSeguradoras, Scanner entrada) {
        System.out.println("Digite o CNPJ da seguradora da qual deseja listar os seguros: ");
        String cnpj = entrada.nextLine();
        cnpj = cnpj.replaceAll("[^0-9]+", "");
        for (Seguradora seg : listaSeguradoras) {
            if (seg.getCNPJ().equals(cnpj)) {
                System.out.printf("Lista de seguros gerados pela seguradora %s\n", seg.getNome());
                System.out.println(seg.listarSeguros());
                System.out.println("FIM DA LISTA");
            }
        }
    }

    public static void listarSegurosCliente(ArrayList<Seguradora> listaSeguradoras, Scanner entrada) {
        System.out.println("Digite o CPF ou o CNPJ do cliente do qual deseja listar os seguros: ");
        String cpf_cnpj = entrada.nextLine();
        cpf_cnpj = cpf_cnpj.replaceAll("[^0-9]+", "");
        System.out.println("Digite o CNPJ da seguradora na qual o cliente digitado acima está cadastrado: ");
        String cnpj = entrada.nextLine();
        cnpj = cnpj.replaceAll("[^0-9]+", "");
        for (Seguradora seg : listaSeguradoras) {
            if (seg.getCNPJ().equals(cnpj)) {
                ArrayList<Seguro> listaSeguros = seg.getSegurosPorCliente(cpf_cnpj);
                if (listaSeguros.isEmpty())
                    System.out.println("O cliente em questão não possui nenhum seguro.");
                else {
                    System.out.println("LISTA DE SEGUROS DO CLIENTE EM QUESTÃO");
                    for (Seguro seguro : listaSeguros) {
                        System.out.println(seguro);
                        System.out.println("*");
                    }
                    System.out.println("FIM DA LISTA");
                }
            }
        }
    }

    public static void listarSinistrosCliente(ArrayList<Seguradora> listaSeguradoras, Scanner entrada) {
        System.out.println("Digite o CPF ou o CNPJ do cliente do qual deseja listar os sinistros: ");
        String cpf_cnpj = entrada.nextLine();
        cpf_cnpj = cpf_cnpj.replaceAll("[^0-9]+", "");
        System.out.println("Digite o CNPJ da seguradora na qual o cliente digitado acima está cadastrado: ");
        String cnpj = entrada.nextLine();
        cnpj = cnpj.replaceAll("[^0-9]+", "");
        for (Seguradora seg : listaSeguradoras) {
            if (seg.getCNPJ().equals(cnpj)) {
                ArrayList<Sinistro> listaSinistros = seg.getSinistrosPorCliente(cpf_cnpj);
                if (listaSinistros.isEmpty())
                    System.out.println("O cliente em questão não possui nenhum sinistro.");
                else {
                    System.out.println("LISTA DE SINISTROS DO CLIENTE EM QUESTÃO");
                    for (Sinistro sinistro : listaSinistros) {
                        System.out.println(sinistro);
                        System.out.println("*");
                    }
                    System.out.println("FIM DA LISTA");
                }
            }
        }
    }

    public static void listarVeiculosClientePF(ArrayList<Seguradora> listaSeguradoras, Scanner entrada) {
        System.out.println("Digite o CPF do clientePF do qual deseja listar os veículos: ");
        String cpf = entrada.nextLine();
        cpf = cpf.replaceAll("[^0-9]+", "");
        System.out.println("Digite o CNPJ da seguradora na qual o cliente digitado acima está cadastrado: ");
        String cnpj = entrada.nextLine();
        cnpj = cnpj.replaceAll("[^0-9]+", "");
        for (Seguradora seg : listaSeguradoras) {
            if (seg.getCNPJ().equals(cnpj)) {
                ArrayList<Veiculo> listaVeiculos = seg.getVeiculosPorClientePF(cpf);
                if (listaVeiculos.isEmpty()) 
                    System.out.println("O cliente em questão não possui nenhum veículo.");
                else {
                    System.out.println("LISTA DE VEÍCULOS DO CLIENTE EM QUESTÃO");
                    for (Veiculo veiculo : listaVeiculos) {
                        System.out.println(veiculo);
                        System.out.println("*");
                    }
                    System.out.println("FIM DA LISTA");
                }
            }
        }
    }

    public static void listarFrotasClientePJ(ArrayList<Seguradora> listaSeguradoras, Scanner entrada) {
        System.out.println("Digite o CNPJ do clientePJ do qual deseja listar as frotas: ");
        String cnpjCliente = entrada.nextLine();
        cnpjCliente = cnpjCliente.replaceAll("[^0-9]+", "");
        System.out.println("Digite o CNPJ da seguradora na qual o cliente digitado acima está cadastrado: ");
        String cnpjSeguradora = entrada.nextLine();
        cnpjSeguradora = cnpjSeguradora.replaceAll("[^0-9]+", "");
        for (Seguradora seg : listaSeguradoras) {
            if (seg.getCNPJ().equals(cnpjSeguradora)) {
                ArrayList<Frota> listaFrotas = seg.getFrotasPorClietePJ(cnpjCliente);
                if (listaFrotas.isEmpty()) 
                    System.out.println("A empresa em questão não possui nenhuma frota de veículos.");
                else {
                    System.out.println("LISTA DE FROTAS DA EMPRESA EM QUESTÃO");
                    for (Frota frota : listaFrotas) {
                        System.out.println(frota);
                        System.out.println("*");
                    }
                    System.out.println("FIM DA LISTA");
                }
            }
        }
    }

    public static void listarVeiculosFrota(ArrayList<Seguradora> listaSeguradoras, Scanner entrada) {
        System.out.println("Digite o CNPJ do clientePJ cuja frota deseja listar os veículos: ");
        String cnpjCliente = entrada.nextLine();
        cnpjCliente = cnpjCliente.replaceAll("[^0-9]+", "");
        System.out.println("Digite o CNPJ da seguradora na qual o cliente digitado acima está cadastrado: ");
        String cnpjSeguradora = entrada.nextLine();
        cnpjSeguradora = cnpjSeguradora.replaceAll("[^0-9]+", "");
        for (Seguradora seg : listaSeguradoras) {
            if (seg.getCNPJ().equals(cnpjSeguradora)) {
                ArrayList<Frota> listaFrotas = seg.getFrotasPorClietePJ(cnpjCliente);
                if (listaFrotas.isEmpty()) 
                    System.out.println("A empresa em questão não possui nenhuma frota de veículos.");
                else {
                    System.out.println("LISTA DE FROTAS DA EMPRESA EM QUESTÃO POR CODE");
                    for (Frota frota : listaFrotas) 
                        System.out.println(frota.getCode());
                    System.out.println("Digite o Code da frota cujos veículos deseja visualizar: ");
                    String code = entrada.nextLine();
                    for (Frota frota : listaFrotas) {
                        if (frota.getCode().equals(code)) {
                            System.out.println("LISTA DE VEÍCULOS DA FROTA EM QUESTÃO");
                            System.out.print(frota.listarVeiculos());
                            System.out.println("FIM DA LISTA");
                        }
                    }
                }
            }
        }
    }

    public static void listarCondutoresSeguro(ArrayList<Seguradora> listaSeguradoras, Scanner entrada) {
        System.out.println("Digite o CPF ou CNPJ do cliente cujos seguros deseja acessar: ");
        String cpf_cnpj = entrada.nextLine();
        cpf_cnpj = cpf_cnpj.replaceAll("[^0-9]+", "");
        System.out.println("Digite o CNPJ da seguradora na qual o cliente digitado acima está cadastrado: ");
        String cnpj = entrada.nextLine();
        cnpj = cnpj.replaceAll("[^0-9]+", "");
        for (Seguradora seg : listaSeguradoras) {
            if (seg.getCNPJ().equals(cnpj)) {
                ArrayList<Seguro> listaSeguros = seg.getSegurosPorCliente(cpf_cnpj);
                if (listaSeguros.isEmpty())
                    System.out.println("O cliente em questão não possui nenhum seguro.");
                else {
                    System.out.println("LISTA DE SEGUROS, POR ID, DO CLIENTE EM QUESTÃO");
                    for (Seguro seguro : listaSeguros) 
                        System.out.println(seguro.getId());
                    System.out.println("Digite o Id (somente números) do seguro cujos condutores deseja visualizar: ");
                    Integer id = Integer.parseInt(entrada.nextLine());
                    for (Seguro seguro : listaSeguros) {
                        if (seguro.getId() == id) {
                            System.out.println("LISTA DE CONDUTORES DO SEGURO EM QUESTÃO");
                            System.out.print(seguro.listarCondutores());
                            System.out.println("FIM DA LISTA");
                        }
                    }
                }
            }
        }
    }

    public static void listarSinistrosSeguro(ArrayList<Seguradora> listaSeguradoras, Scanner entrada) {
        System.out.println("Digite o CPF ou CNPJ do cliente cujos seguros deseja acessar: ");
        String cpf_cnpj = entrada.nextLine();
        cpf_cnpj = cpf_cnpj.replaceAll("[^0-9]+", "");
        System.out.println("Digite o CNPJ da seguradora na qual o cliente digitado acima está cadastrado: ");
        String cnpj = entrada.nextLine();
        cnpj = cnpj.replaceAll("[^0-9]+", "");
        for (Seguradora seg : listaSeguradoras) {
            if (seg.getCNPJ().equals(cnpj)) {
                ArrayList<Seguro> listaSeguros = seg.getSegurosPorCliente(cpf_cnpj);
                if (listaSeguros.isEmpty())
                    System.out.println("O cliente em questão não possui nenhum seguro.");
                else {
                    System.out.println("LISTA DE SEGUROS, POR ID, DO CLIENTE EM QUESTÃO");
                    for (Seguro seguro : listaSeguros) 
                        System.out.println(seguro.getId());
                    System.out.println("Digite o Id (somente números) do seguro cujos sinistros deseja visualizar: ");
                    Integer id = Integer.parseInt(entrada.nextLine());
                    for (Seguro seguro : listaSeguros) {
                        if (seguro.getId() == id) {
                            System.out.println("LISTA DE SINISTROS DO SEGURO EM QUESTÃO");
                            System.out.print(seguro.listarSinistros());
                            System.out.println("FIM DA LISTA");
                        }
                    }
                }
            }
        }
    }

    public static void listarSinistrosCondutor(ArrayList<Seguradora> listaSeguradoras, Scanner entrada) {
        System.out.println("Digite o CPF do condutor cujos sinistros deseja visualizar");
        String cpf = entrada.nextLine();
        cpf = cpf.replaceAll("[^0-9]+", "");
        System.out.println("Digite o CPF ou CNPJ do cliente titular do seguro associado ao condutor digitado acima: ");
        String cpf_cnpj = entrada.nextLine();
        cpf_cnpj = cpf_cnpj.replaceAll("[^0-9]+", "");
        System.out.println("Digite o CNPJ da seguradora na qual o cliente digitado acima está cadastrado: ");
        String cnpj = entrada.nextLine();
        cnpj = cnpj.replaceAll("[^0-9]+", "");
        for (Seguradora seg : listaSeguradoras) {
            if (seg.getCNPJ().equals(cnpj)) {
                ArrayList<Seguro> listaSeguros = seg.getSegurosPorCliente(cpf_cnpj);
                if (listaSeguros.isEmpty())
                    System.out.println("O cliente em questão não possui nenhum seguro.");
                else {
                    System.out.println("LISTA DE SEGUROS, POR ID, DO CLIENTE EM QUESTÃO");
                    for (Seguro seguro : listaSeguros) 
                        System.out.println(seguro.getId());
                    System.out.println("Digite o Id (somente números) do seguro associado ao condutor em questão: ");
                    Integer id = Integer.parseInt(entrada.nextLine());
                    for (Seguro seguro : listaSeguros) {
                        if (seguro.getId() == id) {
                            for (Condutor condutor : seguro.getListaCondutores()) {
                                if (condutor.getCpf().equals(cpf)) {
                                    System.out.println("LISTA DE SINISTROS DO CONDUTOR EM QUESTÃO");
                                    System.out.print(condutor.listarSinistros());
                                    System.out.println("FIM DA LISTA");
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static void excluirCliente(ArrayList<Seguradora> listaSeguradoras, Scanner entrada) {
        System.out.println("Digite o CPF ou o CNPJ do cliente que deseja remover: ");
        String cpf_cnpj = entrada.nextLine();
        cpf_cnpj = cpf_cnpj.replaceAll("[^0-9]+", "");
        System.out.println("Digite o CNPJ da seguradora na qual o cliente digitado acima está cadastrado: ");
        String cnpj = entrada.nextLine();
        cnpj = cnpj.replaceAll("[^0-9]+", "");
        for (Seguradora seg : listaSeguradoras) {
            if (seg.getCNPJ().equals(cnpj)) {
                if (seg.removerCliente(cpf_cnpj)) 
                    System.out.println("Cliente removido com sucesso!");
                else
                    System.out.println("Erro na remoção. Cliente não encontrado.");
            }
        }
    }

    public static void excluirVeiculo(ArrayList<Seguradora> listaSeguradoras, Scanner entrada) {
        System.out.println("Digite a placa do veículo que deseja remover: ");
        String placa = entrada.nextLine();
        System.out.println("Digite o CPF do cliente cujo veículo deseja remover: ");
        String cpf = entrada.nextLine();
        cpf = cpf.replaceAll("[^0-9]+", "");
        System.out.println("Digite o CNPJ da seguradora na qual o cliente digitado acima está cadastrado: ");
        String cnpj = entrada.nextLine();
        cnpj = cnpj.replaceAll("[^0-9]+", "");
        for (Seguradora seg : listaSeguradoras) {
            if (seg.getCNPJ().equals(cnpj)) {
                for (Cliente cliente : seg.getListaClientes()) {
                    if (cliente.getClass() == ClientePF.class) {
                        if (((ClientePF)cliente).getCPF().equals(cpf)) {
                            if (((ClientePF)cliente).removerVeiculo(placa))
                                System.out.println("Veículo removido com sucesso!");
                            else
                                System.out.println("Erro na remoção: veículo não encontrado.");
                        }
                    }
                }
            }
        }
    }

    public static void excluirSeguro(ArrayList<Seguradora> listaSeguradoras, Scanner entrada) {
        System.out.println("Digite o CPF ou o CNPJ do cliente cujo seguro deseja cancelar: ");
        String cpf_cnpj = entrada.nextLine();
        cpf_cnpj = cpf_cnpj.replaceAll("[^0-9]+", "");
        System.out.println("Digite o CNPJ da seguradora na qual o cliente digitado acima está cadastrado: ");
        String cnpj = entrada.nextLine();
        cnpj = cnpj.replaceAll("[^0-9]+", "");
        for (Seguradora seg : listaSeguradoras) {
            if (seg.getCNPJ().equals(cnpj)) {
                ArrayList<Seguro> listaSeguros = seg.getSegurosPorCliente(cpf_cnpj);
                if (listaSeguros.isEmpty())
                    System.out.println("O cliente em questão não possui nenhum seguro.");
                else {
                    System.out.println("LISTA DE SEGUROS, POR ID, DO CLIENTE EM QUESTÃO");
                    for (Seguro seguro : listaSeguros) 
                        System.out.println(seguro.getId());
                    System.out.println("Digite o Id (somente números) do seguro que deseja cancelar: ");
                    Integer id = Integer.parseInt(entrada.nextLine());
                    if (seg.cancelarSeguro(id))
                        System.out.println("Seguro cancelado com sucesso!");
                    else
                        System.out.println("Erro no cancelamento: seguro não encontrado.");
                }
            }
        }
    }

    public static void excluirSinistro(ArrayList<Seguradora> listaSeguradoras, Scanner entrada) {
        System.out.println("Digite o CPF ou o CNPJ do cliente a cujos seguros deseja ter acesso: ");
        String cpf_cnpj = entrada.nextLine();
        cpf_cnpj = cpf_cnpj.replaceAll("[^0-9]+", "");
        System.out.println("Digite o CNPJ da seguradora na qual o cliente digitado acima está cadastrado: ");
        String cnpj = entrada.nextLine();
        cnpj = cnpj.replaceAll("[^0-9]+", "");
        for (Seguradora seg : listaSeguradoras) {
            if (seg.getCNPJ().equals(cnpj)) {
                ArrayList<Seguro> listaSeguros = seg.getSegurosPorCliente(cpf_cnpj);
                if (listaSeguros.isEmpty())
                    System.out.println("O cliente em questão não possui nenhum seguro.");
                else {
                    System.out.println("LISTA DE SEGUROS, POR ID, DO CLIENTE EM QUESTÃO");
                    for (Seguro seguro : listaSeguros) 
                        System.out.println(seguro.getId());
                    System.out.println("Digite o Id (somente números) do seguro que contém o sinistro que deseja excluir: ");
                    Integer idSeguro = Integer.parseInt(entrada.nextLine());
                    for (Seguro seguro : listaSeguros) {
                        if (seguro.getId() == idSeguro) {
                            System.out.println("LISTA DE SINISTROS, POR ID, DO SEGURO EM QUESTÃO");
                            System.out.print(seguro.listarSinistrosId());
                            System.out.println("Digite o Id (somente números) do sinistro que deseja excluir: ");
                            Integer idSinistro = Integer.parseInt(entrada.nextLine());
                            System.out.println("Digite o CPF do condutor responsável por este sinistro: ");
                            String cpfCondutor = entrada.nextLine();
                            if (seguro.excluirSinistro(idSinistro, cpfCondutor))
                                System.out.println("Sinistro excluído com sucesso!");
                            else
                                System.out.println("Erro: sinistro não encontrado.");
                        }
                    }
                }
            }
        }
    }

    public static void atualizarFrota(ArrayList<Seguradora> listaSeguradoras, Scanner entrada, int opcao2) {
        System.out.println("Digite o CNPJ do cliente responsável pela frota em questão: ");
        String cnpjCliente = entrada.nextLine();
        cnpjCliente = cnpjCliente.replaceAll("[^0-9]+", "");
        System.out.println("Digite o CNPJ da seguradora na qual o cliente digitado acima está cadastrado: ");
        String cnpjSeguradora = entrada.nextLine();
        cnpjSeguradora = cnpjSeguradora.replaceAll("[^0-9]+", "");
        for (Seguradora seg : listaSeguradoras) {
            if (seg.getCNPJ().equals(cnpjSeguradora)) {
                ArrayList<Frota> listaFrotas = seg.getFrotasPorClietePJ(cnpjCliente);
                if (listaFrotas.isEmpty()) 
                    System.out.println("A empresa em questão não possui nenhuma frota.");
                else {
                    System.out.println("LISTA DE FROTAS, POR CODE, DA EMPRESA EM QUESTÃO");
                    for (Frota frota : listaFrotas) {
                        System.out.println(frota.getCode());
                    }
                    System.out.println("Digite o Code da frota que deseja atualizar: ");
                    String code = entrada.nextLine();
                    for (Cliente cliente : seg.getListaClientes()) {
                        if (cliente.getClass() == ClientePJ.class) {
                            if (((ClientePJ)cliente).getCNPJ().equals(cnpjCliente)) {
                                if (opcao2 == AtualizarFrota.ADICIONAR_VEICULO.getNumero()) {
                                    System.out.printf("Digite a marca do veículo: ");
                                    String marca = entrada.nextLine();
                                    System.out.printf("Digite o modelo do veículo: ");
                                    String modelo = entrada.nextLine();
                                    System.out.printf("Digite a placa do veículo: ");
                                    String placa = entrada.nextLine();
                                    System.out.printf("Digite o ano de fabricação do veículo: ");
                                    Integer anoFabricacao = Integer.parseInt(entrada.nextLine());
                                    Veiculo veiculo = new Veiculo(placa, marca, modelo, anoFabricacao);
                                    if (((ClientePJ)cliente).atualizarFrota(code, veiculo))
                                        System.out.println("Frota atualizada com sucesso!");
                                    else
                                        System.out.println("Erro ao atualizar frota.");
                                }

                                else if (opcao2 == AtualizarFrota.REMOVER_VEICULO.getNumero()) {
                                    System.out.printf("Digite a placa do veículo: ");
                                    String placa = entrada.nextLine();
                                    if (((ClientePJ)cliente).atualizarFrota(code, placa))
                                        System.out.println("Frota atualizada com sucesso!");
                                    else
                                        System.out.println("Erro ao autualizar frota.");
                                }

                                else if (opcao2 == AtualizarFrota.REMOVER_FROTA.getNumero()) {
                                    if (((ClientePJ)cliente).atualizarFrota(code))
                                        System.out.println("Frota removida com sucesso!");
                                    else
                                        System.out.println("Erro ao remover frota.");
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static void gerarSeguroPF(ArrayList<Seguradora> listaSeguradoras, Scanner entrada) throws Exception {
        System.out.println("Digite o CPF do cliente titular deste seguro: ");
        String cpf = entrada.nextLine();
        cpf = cpf.replaceAll("[^0-9]+", "");
        System.out.println("Digite a data de início do seguro no formato dd/MM/yyyy: ");
        Date dataInicio = datasFormatadas.parse(entrada.nextLine());
        System.out.println("Digite a data de término do seguro no formato dd/MM/yyyy: ");
        Date dataFim = datasFormatadas.parse(entrada.nextLine());
        System.out.println("Digite o CNPJ da seguradora na qual o cliente titular deste seguro está cadastrado: ");
        String cnpjSeguradora = entrada.nextLine();
        cnpjSeguradora = cnpjSeguradora.replaceAll("[^0-9]+", "");
        for (Seguradora seg : listaSeguradoras) {
            if (seg.getCNPJ().equals(cnpjSeguradora)) {
                for (Cliente cliente : seg.getListaClientes()) {
                    if (cliente.getClass() == ClientePF.class) {
                        if (((ClientePF)cliente).getCPF().equals(cpf)) {
                            System.out.println("LISTA DE VEÍCULOS, POR PLACA, DO CLIENTE EM QUESTÃO");
                            for (Veiculo veiculo : ((ClientePF)cliente).getListaVeiculos()) {
                                System.out.println(veiculo.getPlaca());
                            }
                            System.out.println("Digite a placa, de forma idêntica a como ela aparece na lista acima, do veículo que deseja asscociar a este seguro: ");
                            String placa = entrada.nextLine();
                            for (Veiculo veiculo : ((ClientePF)cliente).getListaVeiculos()) {
                                if (veiculo.getPlaca().equals(placa)) {
                                    if (seg.gerarSeguroPF(dataInicio, dataFim, veiculo, (ClientePF)cliente)) {
                                        System.out.println("SeguroPF gerado com sucesso!");
                                    }
                                    else {
                                        System.out.println("Erro ao gerar SeguroPF: seguro já existente.");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static void gerarSeguroPJ(ArrayList<Seguradora> listaSeguradoras, Scanner entrada) throws Exception {
        System.out.println("Digite o CNPJ do cliente titular deste seguro: ");
        String cnpjCliente = entrada.nextLine();
        cnpjCliente = cnpjCliente.replaceAll("[^0-9]+", "");
        System.out.println("Digite a data de início do seguro no formato dd/MM/yyyy: ");
        Date dataInicio = datasFormatadas.parse(entrada.nextLine());
        System.out.println("Digite a data de término do seguro no formato dd/MM/yyyy: ");
        Date dataFim = datasFormatadas.parse(entrada.nextLine());
        System.out.println("Digite o CNPJ da seguradora na qual o cliente titular deste seguro está cadastrado: ");
        String cnpjSeguradora = entrada.nextLine();
        cnpjSeguradora = cnpjSeguradora.replaceAll("[^0-9]+", "");
        for (Seguradora seg : listaSeguradoras) {
            if (seg.getCNPJ().equals(cnpjSeguradora)) {
                for (Cliente cliente : seg.getListaClientes()) {
                    if (cliente.getClass() == ClientePJ.class) {
                        if (((ClientePJ)cliente).getCNPJ().equals(cnpjCliente)) {
                            System.out.println("LISTA DE FROTAS, POR CODE, DO CLIENTE EM QUESTÃO");
                            for (Frota frota : ((ClientePJ)cliente).getListaFrota()) {
                                System.out.println(frota.getCode());
                            }
                            System.out.println("Digite o code, de forma idêntica a como ela aparece na lista acima, da frota que deseja asscociar a este seguro: ");
                            String code = entrada.nextLine();
                            for (Frota frota : ((ClientePJ)cliente).getListaFrota()) {
                                if (frota.getCode().equals(code)) {
                                    if (seg.gerarSeguroPJ(dataInicio, dataFim, frota, (ClientePJ)cliente)) {
                                        System.out.println("SeguroPJ gerado com sucesso!");
                                    }
                                    else {
                                        System.out.println("Erro ao gerar SeguroPJ: seguro já existente.");
                                    }
                                    
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static void gerarSinistro(ArrayList<Seguradora> listaSeguradoras, Scanner entrada) throws Exception {
        System.out.println("Digite a data referente ao sinistro no formato dd/MM/yyyy: ");
        Date data = datasFormatadas.parse(entrada.nextLine());
        System.out.println("Digite o endereço referente ao sinistro: ");
        String endereco = entrada.nextLine();
        System.out.println("Digite o CPF do condutor responsável pelo sinistro: ");
        String cpfCondutor = entrada.nextLine();
        cpfCondutor = cpfCondutor.replaceAll("[^0-9]+", "");
        System.out.println("Digite o CPF ou o CNPJ do cliente responsável pelo seguro a que deseja associar este sinistro: ");
        String cpf_cnpj = entrada.nextLine();
        cpf_cnpj = cpf_cnpj.replaceAll("[^0-9]+", "");
        System.out.println("Digite o CNPJ da seguradora na qual o cliente digitado acima está cadastrado: ");
        String cnpj = entrada.nextLine();
        cnpj = cnpj.replaceAll("[^0-9]+", "");
        for (Seguradora seg : listaSeguradoras) {
            if (seg.getCNPJ().equals(cnpj)) {
                ArrayList<Seguro> listaSeguros = seg.getSegurosPorCliente(cpf_cnpj);
                if (listaSeguros.isEmpty())
                    System.out.println("O cliente em questão não possui nenhum seguro.");
                else {
                    System.out.println("LISTA DE SEGUROS, POR ID, DO CLIENTE EM QUESTÃO");
                    for (Seguro s : listaSeguros) 
                        System.out.println(s.getId());
                    System.out.println("Digite o Id (somente números) do seguro ao qual deseja asscoiar o sinistro gerado: ");
                    Integer idSeguro = Integer.parseInt(entrada.nextLine());
                    for (Seguro seguro : listaSeguros) {
                        if (seguro.getId() == idSeguro) {
                            for (Condutor condutor : seguro.getListaCondutores()) {
                                if (condutor.getCpf().equals(cpfCondutor)) {
                                    if (seguro.gerarSinistro(data, endereco, condutor)) {
                                        System.out.println("Sinistro gerado com sucesso!");
                                    }
                                    else {
                                        System.out.println("Erro ao gerar sinistro.");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static void autorizarCondutor(ArrayList<Seguradora> listaSeguradoras, Scanner entrada) throws Exception {
        System.out.println("Digite o CPF do condutor em questão: ");
        String cpfCondutor = entrada.nextLine();
        cpfCondutor = cpfCondutor.replaceAll("[^0-9]+", "");

        System.out.println("Digite o nome completo do condutor em questão: ");
        String nome = entrada.nextLine();
        if (Validacao.validarNome(nome))
            System.out.println("Nome válido!");
        else {
            System.out.println("Nome inválido. Digite-o novamente usando apenas letras e espaços, sem caracteres especiais como acento e cedilha");
            System.out.println("Digite o nome completo do condutor novamente: ");
            nome = entrada.nextLine();
        }

        System.out.println("Digite o telefone deste condutor: ");
        String telefone = entrada.nextLine();

        System.out.println("Digite o email deste condutor: ");
        String email = entrada.nextLine();

        System.out.println("Digite a data de nascimento deste condutor no formato dd/MM/yyyy: ");
        Date dataNascimento = datasFormatadas.parse(entrada.nextLine());

        System.out.println("Digite o endereço deste condutor: ");
        String endereco = entrada.nextLine();
        Condutor condutor = new Condutor(cpfCondutor, nome, telefone, endereco, email, dataNascimento);

        System.out.println("Digite o CPF ou o CNPJ do cliente titular do seguro a que se deseja adicionar este condutor: ");
        String cpf_cnpj = entrada.nextLine();
        cpf_cnpj = cpf_cnpj.replaceAll("[^0-9]+", "");

        System.out.println("Digite o CNPJ da seguradora na qual o cliente digitado acima está cadastrado: ");
        String cnpjSeguradora = entrada.nextLine();
        cnpjSeguradora = cnpjSeguradora.replaceAll("[^0-9]+", "");
        for (Seguradora seg : listaSeguradoras) {
            if (seg.getCNPJ().equals(cnpjSeguradora)) {
                ArrayList<Seguro> listaSeguros = seg.getSegurosPorCliente(cpf_cnpj);
                if (listaSeguros.isEmpty())
                    System.out.println("O cliente em questão não possui nenhum seguro.");
                else {
                    System.out.println("LISTA DE SEGUROS, POR ID, DO CLIENTE EM QUESTÃO");
                    for (Seguro seguro : listaSeguros) {
                        System.out.println(seguro.getId());
                    }
                    System.out.println("Digite o Id (somente números) do seguro ao qual deseja adicionar este condutor: ");
                    Integer idSeguro = Integer.parseInt(entrada.nextLine());
                    for (Seguro seguro : listaSeguros) {
                        if (seguro.getId() == idSeguro) {
                            if (seguro.autorizarCondutor(condutor)) {
                                System.out.println("Condutor autorizado com sucesso!");
                            }
                            else {
                                System.out.println("Erro ao autorizar condutor: este condutor já estava previamente autorizado.");
                            }
                        }
                    }
                }
            }
        }
    }

    public static void desautorizarCondutor(ArrayList<Seguradora> listaSeguradoras, Scanner entrada) {
        System.out.println("Digite o CPF do condutor em questão: ");
        String cpfCondutor = entrada.nextLine();
        cpfCondutor = cpfCondutor.replaceAll("[^0-9]+", "");

        System.out.println("Digite o CPF ou o CNPJ do cliente titular do seguro do qual se deseja remover este condutor: ");
        String cpf_cnpj = entrada.nextLine();
        cpf_cnpj = cpf_cnpj.replaceAll("[^0-9]+", "");

        System.out.println("Digite o CNPJ da seguradora na qual o cliente digitado acima está cadastrado: ");
        String cnpjSeguradora = entrada.nextLine();
        cnpjSeguradora = cnpjSeguradora.replaceAll("[^0-9]+", "");
        for (Seguradora seg : listaSeguradoras) {
            if (seg.getCNPJ().equals(cnpjSeguradora)) {
                ArrayList<Seguro> listaSeguros = seg.getSegurosPorCliente(cpf_cnpj);
                if (listaSeguros.isEmpty())
                    System.out.println("O cliente em questão não possui nenhum seguro.");
                else {
                    System.out.println("LISTA DE SEGUROS, POR ID, DO CLIENTE EM QUESTÃO");
                    for (Seguro seguro : listaSeguros) {
                        System.out.println(seguro.getId());
                    }
                    System.out.println("Digite o Id (somente números) do seguro ao qual deseja adicionar este condutor: ");
                    Integer idSeguro = Integer.parseInt(entrada.nextLine());
                    for (Seguro seguro : listaSeguros) {
                        if (seguro.getId() == idSeguro) {
                            if (seguro.desautorizarCondutor(cpfCondutor)) {
                                System.out.println("Condutor desautorizado com sucesso!");
                            }
                            else {
                                System.out.println("Erro ao desautorizar condutor: este condutor já não estava autorizado.");
                            }
                        }
                    }
                }
            }
        }
    }

    public static void consultarValorMensal(ArrayList<Seguradora> listaSeguradoras, Scanner entrada) {
        System.out.println("Digite o CPF ou o CNPJ do cliente titular do seguro do qual deseja consultar o valor mensal: ");
        String cpf_cnpj = entrada.nextLine();
        cpf_cnpj = cpf_cnpj.replaceAll("[^0-9]+", "");

        System.out.println("Digite o CNPJ da seguradora na qual o cliente digitado acima está cadastrado: ");
        String cnpjSeguradora = entrada.nextLine();
        cnpjSeguradora = cnpjSeguradora.replaceAll("[^0-9]+", "");
        for (Seguradora seg : listaSeguradoras) {
            if (seg.getCNPJ().equals(cnpjSeguradora)) {
                ArrayList<Seguro> listaSeguros = seg.getSegurosPorCliente(cpf_cnpj);
                if (listaSeguros.isEmpty())
                    System.out.println("O cliente em questão não possui nenhum seguro.");
                else {
                    System.out.println("LISTA DE SEGUROS, POR ID, DO CLIENTE EM QUESTÃO");
                    for (Seguro seguro : listaSeguros) {
                        System.out.println(seguro.getId());
                    }
                    System.out.println("Digite o Id (somente números) do seguro do qual deseja consultar o valor mensal: ");
                    Integer idSeguro = Integer.parseInt(entrada.nextLine());
                    for (Seguro seguro : listaSeguros) {
                        if (seguro.getId() == idSeguro) {
                            seguro.setValorMensal(seguro.calcularValor());
                            System.out.printf("Valor mensal do seguro em questão: %.2f reais.\n", seguro.getValorMensal());
                        }
                    }
                }
            }
        }
    }

    public static void calcularReceita(ArrayList<Seguradora> listaSeguradoras, Scanner entrada) {
        System.out.println("Digite o CNPJ da seguradora da qual deseja calcular a receita: ");
        String cnpj = entrada.nextLine();
        cnpj = cnpj.replaceAll("[^0-9]+", "");
        for (Seguradora seg : listaSeguradoras) {
            if (seg.getCNPJ().equals(cnpj))
                System.out.printf("Receita da seguradora %s: %.2f reais.\n", seg.getNome(), seg.calcularReceita());
        }
    }
}
