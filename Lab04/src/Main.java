import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void Menu(Seguradora seguradora, Scanner entrada) throws Exception {
        SimpleDateFormat datasFormatadas = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Bem vindo!");
        Integer opcao1, opcao2;
        ArrayList <Seguradora> listaSeguradoras = new ArrayList<Seguradora>();
        listaSeguradoras.add(seguradora);
        do {
            System.out.println("O que gostaria de fazer agora?");
            System.out.println("1.Cadastrar;");
            System.out.println("2.Listar;");
            System.out.println("3.Excluir;");
            System.out.println("4.Gerar um sinistro;");
            System.out.println("5.Transferir seguro;");
            System.out.println("6.Calcular receita de uma seguradora;");
            System.out.println("0.Sair.");
            System.out.println("Digite apenas o número correspondente a UMA das opções acima: ");
            opcao1 = Integer.parseInt(entrada.nextLine());

            if (opcao1 == MenuOperacoes.SAIR.getNumero())
                break;

            else if (opcao1 == MenuOperacoes.CADASTRAR.getNumero()) {
                System.out.println("Qual tipo de cadastro gostaria de fazer?");
                System.out.println("1.Cadastrar um clientePF;");
                System.out.println("2.Cadastrar um clientePJ;");
                System.out.println("3.Cadastrar um veículo associado a um cliente;");
                System.out.println("4.Cadastrar uma seguradora;");
                System.out.println("5.Voltar para as opções anteriores.");
                System.out.println("Digite apenas o número correspondente a UMA das opções acima: ");
                opcao2 = Integer.parseInt(entrada.nextLine());

                if (opcao2 == Cadastrar.VOLTAR.getNumero()) {
                    continue;
                }

                else if (opcao2 == Cadastrar.CLIENTEPF.getNumero()) {
                    System.out.println("Digite seu CPF: ");
                    String cpf = entrada.nextLine();
                    if(!Validacao.validarCPF(cpf)) {
                        System.out.println("CPF inválido. Verifique-o e digite-o novamente com os dígitos corretos.");
                        cpf = entrada.nextLine();
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

                    System.out.println("Digite a data de seu nascimento no formato dd/MM/yyyy: ");
                    Date dataNascimento = datasFormatadas.parse(entrada.nextLine());

                    System.out.println("Digite a data de sua licenca no formato dd/MM/yyyy: ");
                    Date dataLicenca = datasFormatadas.parse(entrada.nextLine());

                    System.out.println("Digite seu endereço: ");
                    String endereco = entrada.nextLine();

                    System.out.println("Digite seu grau de escolaridade: ");
                    String educacao = entrada.nextLine();

                    System.out.println("Digite seu gênero: ");
                    String genero = entrada.nextLine();

                    System.out.println("Digite sua classe econômica: ");
                    String classeEconomica = entrada.nextLine();

                    ClientePF clientepf = new ClientePF(nome, endereco, cpf, dataNascimento, educacao, genero, classeEconomica, dataLicenca);
                    System.out.println("Digite seu número de veículos: ");
                    Integer nVeiculos = Integer.parseInt(entrada.nextLine());
                    for (int i = 0; i < nVeiculos; i++) {
                        Veiculo veiculo = new Veiculo();
                        System.out.printf("Digite a marca do veículo %d: ", i + 1);
                        veiculo.setMarca(entrada.nextLine());
                        System.out.printf("Digite o modelo do veículo %d: ", i + 1);
                        veiculo.setModelo(entrada.nextLine());
                        System.out.printf("Digite a placa do veículo %d: ", i + 1);
                        veiculo.setPlaca(entrada.nextLine());
                        System.out.printf("Digite o ano de fabricação do veículo %d: ", i + 1);
                        Integer anoFabricacao = Integer.parseInt(entrada.nextLine());
                        veiculo.setAnoFabricacao(anoFabricacao);
                        clientepf.adicionaVeiculo(veiculo);
                    }

                    System.out.println("Digite o nome da seguradora na qual gostaria de se cadastrar: ");
                    String nomeSeguradora = entrada.nextLine();
                    for (Seguradora seg : listaSeguradoras) {
                        if (seg.getNome().equals(nomeSeguradora)) {
                            if (seg.cadastrarCliente(clientepf)) 
                                System.out.println("Cliente PF cadastrado com sucesso!");
                            else
                                System.out.println("Erro de cadastro: cliente já cadastrado anteriormente");
                        }
                    }
                    System.out.println();
                }  

                else if (opcao2 == Cadastrar.CLIENTEPJ.getNumero()) {
                    System.out.println("Digite seu CNPJ: ");
                    String cnpj = entrada.nextLine();
                    if (!Validacao.validarCNPJ(cnpj)) {
                        System.out.println("CNPJ inválido. Verifique-o e digite-o novamente com os dígitos corretos.");
                        cnpj = entrada.nextLine();
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

                    System.out.println("Digite a quantidade de funcionários de sua empresa: ");
                    Integer qtdeFuncionarios = Integer.parseInt(entrada.nextLine());

                    ClientePJ clientepj = new ClientePJ(nome, endereco, cnpj, dataFundacao, qtdeFuncionarios);
                    System.out.println("Digite seu numero de veículos: ");
                    Integer nVeiculos = Integer.parseInt(entrada.nextLine());
                    for (int i = 0; i < nVeiculos; i++) {
                        Veiculo veiculo = new Veiculo();
                        System.out.printf("Digite a marca do veículo %d: ", i + 1);
                        veiculo.setMarca(entrada.nextLine());
                        System.out.printf("Digite o modelo do veículo %d: ", i + 1);
                        veiculo.setModelo(entrada.nextLine());
                        System.out.printf("Digite a placa do veículo %d: ", i + 1);
                        veiculo.setPlaca(entrada.nextLine());
                        System.out.printf("Digite o ano de fabricação do veículo %d: ", i + 1);
                        Integer anoFabricacao = Integer.parseInt(entrada.nextLine());
                        veiculo.setAnoFabricacao(anoFabricacao);
                        clientepj.adicionaVeiculo(veiculo);
                    }

                    System.out.println("Digite o nome da seguradora na qual gostaria de efetuar o cadastro: ");
                    String nomeSeguradora = entrada.nextLine();
                    for (Seguradora seg : listaSeguradoras) {
                        if (seg.getNome().equals(nomeSeguradora)) {
                            if (seg.cadastrarCliente(clientepj)) 
                                System.out.println("Cliente PJ cadastrado com sucesso!");
                            else
                                System.out.println("Erro de cadastro: cliente já cadastrado anteriormente.");
                        }
                    }
                    System.out.println();
                }

                else if (opcao2 == Cadastrar.VEICULO.getNumero()) {
                    Veiculo veiculo = new Veiculo();
                    System.out.printf("Digite a marca do veículo: ");
                    veiculo.setMarca(entrada.nextLine());
                    System.out.printf("Digite o modelo do veículo: ");
                    veiculo.setModelo(entrada.nextLine());
                    System.out.printf("Digite a placa do veículo: ");
                    veiculo.setPlaca(entrada.nextLine());
                    System.out.printf("Digite o ano de fabricação do veículo: ");
                    Integer anoFabricacao = Integer.parseInt(entrada.nextLine());
                    veiculo.setAnoFabricacao(anoFabricacao);
                    System.out.println("Digite o nome completo do cliente a que deseja adicionar este veículo: ");
                    String nome = entrada.nextLine();
                    seguradora.adicionaVeiculoCliente(veiculo, nome);
                    System.out.println();
                }

                else if (opcao2 == Cadastrar.SEGURADORA.getNumero()) {
                    System.out.println("Digite o nome da seguradora: ");
                    String nome = entrada.nextLine();
                    System.out.println("Digite o telefone da seguradora: ");
                    String telefone = entrada.nextLine();
                    System.out.println("Digite o email da seguradora: ");
                    String email = entrada.nextLine();
                    System.out.println("Digite o endereço da seguradora: ");
                    String endereco = entrada.nextLine();
                    Seguradora seguradora2 = new Seguradora(nome, telefone, email, endereco);
                    listaSeguradoras.add(seguradora2);
                    System.out.println();
                }
            }
            
            else if (opcao1 == MenuOperacoes.LISTAR.getNumero()) {
                System.out.println("O que gostaria de listar?");
                System.out.println("1.Listas clientes por seguradora: ");
                System.out.println("2.Listar sinistros por seguradora;");
                System.out.println("3.Listar sinistros por cliente;");
                System.out.println("4.Listar veículos por cliente;");
                System.out.println("5.Listar veículos por seguradora;");
                System.out.println("6.Voltar para as opções anteriores.");
                System.out.println("Digite apenas o número correspondente a UMA das opções acima: ");
                opcao2 = Integer.parseInt(entrada.nextLine());

                if (opcao2 == Listar.VOLTAR.getNumero()) {
                    continue;
                }

                else if (opcao2 == Listar.CLIENTE_SEGURADORA.getNumero()) {
                    System.out.println("Digite o nome da seguradora da qual deseja listar os clientes: ");
                    String nome = entrada.nextLine();
                    for (Seguradora seg : listaSeguradoras) {
                        if (seg.getNome().equals(nome)) {
                            System.out.printf("Lista de clientes cadastrados na seguradora %s\n", nome);
                            System.out.println(seg.listarClientes());
                            System.out.println("FIM DA LISTA");
                        }
                    }
                    System.out.println();
                }

                else if (opcao2 == Listar.SINISTRO_SEGURADORA.getNumero()) {
                    System.out.println("Digite o nome da seguradora da qual deseja listar os sinistros: ");
                    String nome = entrada.nextLine();
                    for (Seguradora seg : listaSeguradoras) {
                        if (seg.getNome().equals(nome)) {
                            System.out.printf("Lista de sinistros gerados pela seguradora %s\n", nome);
                            System.out.println(seguradora.listarSinistros());
                            System.out.println("FIM DA LISTA");
                        }
                    }
                    System.out.println();
                }

                else if (opcao2 == Listar.SINISTRO_CLIENTE.getNumero()) {
                    System.out.println("Digite o nome completo do cliente do qual deseja listar os sinistros: ");
                    String nomeCliente = entrada.nextLine();
                    System.out.println("Digite o nome da seguradora na qual o cliente digitado acima está cadastrado: ");
                    String nomeSeguradora = entrada.nextLine();
                    for (Seguradora seg : listaSeguradoras) {
                        if (seg.getNome().equals(nomeSeguradora)) {
                            if (!seg.visualizarSinistro(nomeCliente))
                                System.out.println("Erro ao visualizar sinistro. O cliente em questão não tem nenhum sinistro.");
                        }
                    }
                    System.out.println();
                }

                else if (opcao2 == Listar.VEICULO_CLIENTE.getNumero()) {
                    System.out.println("Digite o nome completo do cliente do qual deseja listar os veículos: ");
                    String nomeCliente = entrada.nextLine();
                    System.out.println("Digite o nome da seguradora na qual o cliente digitado acima está cadastrado: ");
                    String nomeSeguradora = entrada.nextLine();
                    for (Seguradora seg : listaSeguradoras) {
                        if (seg.getNome().equals(nomeSeguradora)) {
                            if (!seg.visualizarVeiculo(nomeCliente))
                                System.out.println("Erro ao visualizar veículos. O cliente em questão não tem nenhum veículo.");
                        }
                    }
                    System.out.println();
                }

                else if (opcao2 == Listar.VEICULO_SEGURADORA.getNumero()) {
                    System.out.println("Digite o nome da seguradora da qual deseja listar os veículos: ");
                    String nome = entrada.nextLine();
                    for (Seguradora seg : listaSeguradoras) {
                        if (seg.getNome().equals(nome)) {
                            System.out.printf("Lista de veículos cadastrados na seguradora %s\n", nome);
                            System.out.println(seguradora.listarVeiculos());
                            System.out.println("FIM DA LISTA");
                        }
                    }
                    System.out.println();
                }
            }

            else if (opcao1 == MenuOperacoes.EXCLUIR.getNumero()) {
                System.out.println("O que gostaria de excluir?");
                System.out.println("1.Excluir um cliente de uma seguradora;");
                System.out.println("2.Excluir um veículo de um cliente;");
                System.out.println("3.Excluir um sinistro de uma seguradora.");
                System.out.println("4.Voltar para as opções anteriores.");
                System.out.println("Digite apenas o número correspondente a UMA das opções acima: ");
                opcao2 = Integer.parseInt(entrada.nextLine());

                if (opcao2 == Excluir.VOLTAR.getNumero()) {
                    continue;
                }

                else if (opcao2 == Excluir.CLIENTE.getNumero()) {
                    System.out.println("Digite o nome completo do cliente que deseja remover: ");
                    String nomeCliente = entrada.nextLine();
                    System.out.println("Digite o nome da seguradora na qual o cliente digitado acima está cadastrado: ");
                    String nomeSeguradora = entrada.nextLine();
                    for (Seguradora seg : listaSeguradoras) {
                        if (seg.getNome().equals(nomeSeguradora)) {
                            if (seguradora.removerCliente(nomeCliente)) 
                                System.out.println("Cliente removido com sucesso!");
                            else
                                System.out.println("Erro na remoção. Cliente não encontrado.");
                        }
                    }
                    System.out.println();
                }

                else if (opcao2 == Excluir.VEICULO.getNumero()) {
                    System.out.println("Digite a placa do veículo que deseja remover: ");
                    String placa = entrada.nextLine();
                    System.out.println("Digite o nome completo do cliente cujo veículo deseja remover: ");
                    String nomeCliente = entrada.nextLine();
                    System.out.println("Digite o nome da seguradora na qual o cliente digitado acima está cadastrado: ");
                    String nomeSeguradora = entrada.nextLine();
                    for (Seguradora seg : listaSeguradoras) {
                        if (seg.getNome().equals(nomeSeguradora)) {
                            if (seg.removerVeiculo(placa, nomeCliente)) 
                                System.out.println("Veículo removido com sucesso!");
                            else 
                                System.out.println("Erro na remoção. Veículo não encontrado.");
                        }
                    }
                    System.out.println();
                }

                else if (opcao2 == Excluir.SINISTRO.getNumero()) {
                    System.out.println("Digite a data referente ao sinistro no formato dd/MM/yyyy: ");
                    Date data = datasFormatadas.parse(entrada.nextLine());
                    System.out.println("Digite o endereco referente ao sinistro: ");
                    String endereco = entrada.nextLine();
                    System.out.println("Digite o nome completo do cliente cujo veículo deseja remover: ");
                    String nomeCliente = entrada.nextLine();
                    System.out.println("Digite o nome da seguradora na qual o cliente digitado acima está cadastrado: ");
                    String nomeSeguradora = entrada.nextLine();
                    for (Seguradora seg : listaSeguradoras) {
                        if (seg.getNome().equals(nomeSeguradora)) {
                            if (seg.removerSinistro(data, endereco, nomeCliente)) 
                                System.out.println("Sinistro removido com sucesso!");
                            else
                                System.out.println("Erro na remoção. Sinistro não encontrado.");
                        }
                    }
                    System.out.println();
                }
            }

            else if (opcao1 == MenuOperacoes.GERAR_SINISTRO.getNumero()) {
                System.out.println("Digite a data referente ao sinistro no formato dd/MM/yyyy: ");
                Date data = datasFormatadas.parse(entrada.nextLine());
                System.out.println("Digite o endereco referente ao sinistro: ");
                String endereco = entrada.nextLine();
                System.out.println("Digite a placa do veículo envolvido no acidente: ");
                String placa = entrada.nextLine();
                System.out.println("Digite seu nome completo: ");
                String nomeCliente = entrada.nextLine();
                System.out.println("Digite o nome da seguradora na qual deseja gerar o sinistro: ");
                String nomeSeguradora = entrada.nextLine();
                for (Seguradora seg : listaSeguradoras) {
                    if (seg.getNome().equals(nomeSeguradora)) {
                        if (seg.gerarSinistro(data, endereco, placa, nomeCliente))
                            System.out.println("Sinistro gerado com sucesso!");
                        else
                            System.out.println("Erro ao gerar sinistro. Sinistro já gerado anteriormente.");
                    }
                }
                System.out.println();
            }

            else if (opcao1 == MenuOperacoes.TRANSFERIR_SEGURO.getNumero()) {
                System.out.println("Digite o nome da seguradora na qual deseja transferir o seguro entre clientes: ");
                String nomeSeguradora = entrada.nextLine();
                System.out.println("Digite o nome do cliente que irá transferir o seguro: ");
                String nomeCliente1 = entrada.nextLine();
                System.out.println("Digite o nome do cliente que irá receber o seguro: ");
                String nomeCliente2 = entrada.nextLine();
                for (Seguradora seg : listaSeguradoras) {
                    if (seg.getNome().equals(nomeSeguradora)) {
                        if (seg.transferirSeguro(nomeCliente1, nomeCliente2))
                            System.out.println("Seguro transferido com sucesso!");
                        else    
                            System.out.println("Erro ao transferir seguro. Um dos clientes passados não foi encontrado na seguradora.");
                    }
                }
            }

            else if (opcao1 == MenuOperacoes.CALCULAR_RECEITA.getNumero()) {
                System.out.println("Digite o nome da seguradora da qual deseja calcular a receita: ");
                String nomeSeguradora = entrada.nextLine();
                for (Seguradora seg : listaSeguradoras) {
                    if (seg.getNome().equals(nomeSeguradora))
                        System.out.println("Receita da seguradora " + nomeSeguradora + ": " + seg.calcularReceita());
                }
            }

        } while(opcao1 != MenuOperacoes.SAIR.getNumero());
        System.out.println("SAIU DO MENU.");
    }
    public static void main(String[] args) throws Exception {
        // Auxiliares
        Scanner entrada = new Scanner(System.in);
        SimpleDateFormat datasFormatadas = new SimpleDateFormat("dd/MM/yyyy");

        // Instanciando 1 objeto da classe Seguradora
        Seguradora seguradora = new Seguradora("Unicamp Seguros", "11999981571", "seguros@dac.unicamp.br", "DAC");

        // Instanciando 2 objetos da classe Veiculo
        Veiculo veiculo1 = new Veiculo("DCV1516", "Renault", "Duster", 2018);
        Veiculo veiculo2 = new Veiculo("AMS2001", "Honda", "Civic", 2013);

        // Instanciando 1 objeto da classe ClientePF e cadastrando-o na seguradora
        Date dataNascimento = datasFormatadas.parse("15/09/2004");
        Date dataLicenca = datasFormatadas.parse("20/01/2023");
        if (!Validacao.validarCPF("464.236.448-02"))
            System.out.println("CPF inválido.");
        ClientePF clientepf = new ClientePF("Daniel", "Rua Doutor Zuquim 1782", "464.236.448-02", dataNascimento, 
                            "Ensino médio completo", "Masculino", "Classe média", dataLicenca);
        clientepf.adicionaVeiculo(veiculo1);
        if (seguradora.cadastrarCliente(clientepf)) 
            System.out.println("Cliente PF cadastrado com sucesso!");
        else
            System.out.println("Erro de cadastro: cliente já cadastrado anteriormente");
        System.out.println();

        // Instanciando 1 objeto da classe ClientePJ e cadastrando-o na seguradora
        Date dataFundacao = datasFormatadas.parse("21/07/2004");
        if (!Validacao.validarCNPJ("69.479.158/0001-92"))
            System.out.println("CNPJ invalido.");
        ClientePJ clientepj = new ClientePJ("Daniboy Empreendimentos", "Rua Leoncio de Magalhaes 479",
                                "69.479.158/0001-92", dataFundacao, 100);
        clientepj.adicionaVeiculo(veiculo2);
        if (seguradora.cadastrarCliente(clientepj)) 
            System.out.println("Cliente PJ cadastrado com sucesso!");
        else
            System.out.println("Erro de cadastro: cliente ja cadastrado anteriormente");
        System.out.println();

        // Gerando 2 sinistros na seguradora (1 para cada cliente instanciado)
        Date dataSinistro1 = datasFormatadas.parse("16/04/2023");
        if (seguradora.gerarSinistro(dataSinistro1, "Rua Alfredo Pujol 321", veiculo1.getPlaca(), clientepf.getNome()))
            System.out.println("Sinistro gerado com sucesso!");
        else
            System.out.println("Erro ao gerar sinistro. Sinistro ja gerado anteriormente.");
        
        Date dataSinistro2 = datasFormatadas.parse("22/04/2023");
        if (seguradora.gerarSinistro(dataSinistro2, "Rua Cataguases 754", veiculo2.getPlaca(), clientepj.getNome()))
            System.out.println("Sinistro gerado com sucesso!");
        else
            System.out.println("Erro ao gerar sinistro. Sinistro ja gerado anteriormente.");
        
        // Chamando os métodos da classe Seguradora
        System.out.printf("Lista de clientes cadastrados na seguradora %s\n", seguradora.getNome());
        System.out.println(seguradora.listarClientes());
        System.out.println("FIM DA LISTA\n");

        if (!seguradora.visualizarSinistro(clientepf.getNome()))
            System.out.println("Erro ao visualizar sinistro. O cliente em questao nao tem nenhum sinistro.");
        
        System.out.printf("Lista de sinistros gerados pela seguradora %s\n", seguradora.getNome());
        System.out.println(seguradora.listarSinistros());
        System.out.println("FIM DA LISTA\n");
        
        clientepf.setValorSeguro(seguradora.calcularPrecoSeguroCliente(clientepf));
        clientepj.setValorSeguro(seguradora.calcularPrecoSeguroCliente(clientepj));
        System.out.println("Receita da seguradora " + seguradora.getNome() + ": " + seguradora.calcularReceita());
        // Note que o método calcularReceita() já atualiza o atributo valorSeguro de cada cliente cadastrado na seguradora
        
        // Chamando o menu de operações
        Menu(seguradora, entrada);
        
        entrada.close();
    }
}