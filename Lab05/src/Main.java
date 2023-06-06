import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void Menu(Seguradora seguradora, Scanner entrada) throws Exception {
        System.out.println("Bem vindo ao Menu de Operações!");
        Integer opcao1, opcao2;
        ArrayList <Seguradora> listaSeguradoras = new ArrayList<Seguradora>();
        listaSeguradoras.add(seguradora);
        do {
            System.out.println("O que gostaria de fazer agora?");
            System.out.println("1.Cadastrar;");
            System.out.println("2.Listar;");
            System.out.println("3.Excluir;");
            System.out.println("4.Atualizar uma frota;");
            System.out.println("5.Gerar um seguroPF");
            System.out.println("6.Gerar um seguroPJ");
            System.out.println("7.Gerar um sinistro;");
            System.out.println("8.Autorizar um condutor;");
            System.out.println("9.Desautorizar um condutor;");
            System.out.println("10.Consultar o valor mensal atualizado de um seguro;");
            System.out.println("11.Calcular receita de uma seguradora;");
            System.out.println("0.Sair.");
            System.out.println("Digite apenas o número correspondente a UMA das opções acima: ");
            opcao1 = Integer.parseInt(entrada.nextLine());

            if (opcao1 == MenuOperacoes.SAIR.getNumero())
                break;

            else if (opcao1 == MenuOperacoes.CADASTRAR.getNumero()) {
                System.out.println("Qual tipo de cadastro gostaria de fazer?");
                System.out.println("1.Cadastrar um clientePF;");
                System.out.println("2.Cadastrar um clientePJ;");
                System.out.println("3.Cadastrar um veículo associado a um clientePF;");
                System.out.println("4.Cadastrar uma seguradora;");
                System.out.println("5.Cadastrar uma frota associada a um clientePJ");
                System.out.println("6.Voltar para as opções anteriores.");
                System.out.println("Digite apenas o número correspondente a UMA das opções acima: ");
                opcao2 = Integer.parseInt(entrada.nextLine());

                if (opcao2 == Cadastrar.VOLTAR.getNumero()) {
                    continue;
                }

                else if (opcao2 == Cadastrar.CLIENTEPF.getNumero()) {
                    OperacoesMenu.cadastrarClientePF(listaSeguradoras, entrada);
                    System.out.println("***");
                }  

                else if (opcao2 == Cadastrar.CLIENTEPJ.getNumero()) {
                    OperacoesMenu.cadastrarClientePJ(listaSeguradoras, entrada);
                    System.out.println("***");
                }

                else if (opcao2 == Cadastrar.VEICULO.getNumero()) {
                    OperacoesMenu.cadastrarVeiculo(listaSeguradoras, entrada);
                    System.out.println("***");
                }

                else if (opcao2 == Cadastrar.SEGURADORA.getNumero()) {
                    OperacoesMenu.cadastrarSeguradora(listaSeguradoras, entrada);
                    System.out.println("***");
                }

                else if (opcao2 == Cadastrar.FROTA.getNumero()) {
                    OperacoesMenu.cadastrarFrota(listaSeguradoras, entrada);
                    System.out.println("***");
                }
            }
            
            else if (opcao1 == MenuOperacoes.LISTAR.getNumero()) {
                System.out.println("O que gostaria de listar?");
                System.out.println("1.Listar clientes por seguradora: ");
                System.out.println("2.Listar seguros por seguradora;");
                System.out.println("3.Listar seguros por cliente;");
                System.out.println("4.Listar sinistros por cliente;");
                System.out.println("5.Listar veículos por clientePF;");
                System.out.println("6.Listar frotas por clientePJ;");
                System.out.println("7.Listar veículos por frota;");
                System.out.println("8.Listar condutores por seguro;");
                System.out.println("9.Listar sinistros por seguro;");
                System.out.println("10.Listar sinistros por condutor;");
                System.out.println("11.Voltar para as opções anteriores.");
                System.out.println("Digite apenas o número correspondente a UMA das opções acima: ");
                opcao2 = Integer.parseInt(entrada.nextLine());

                if (opcao2 == Listar.VOLTAR.getNumero()) {
                    continue;
                }

                else if (opcao2 == Listar.CLIENTE_SEGURADORA.getNumero()) {
                    OperacoesMenu.listarClientesSeguradora(listaSeguradoras, entrada);
                    System.out.println("***");
                }

                else if (opcao2 == Listar.SEGURO_SEGURADORA.getNumero()) {
                    OperacoesMenu.listarSegurosSeguradora(listaSeguradoras, entrada);
                    System.out.println("***");
                }

                else if (opcao2 == Listar.SEGURO_CLIENTE.getNumero()) {
                    OperacoesMenu.listarSegurosCliente(listaSeguradoras, entrada);
                    System.out.println("***");
                }

                else if (opcao2 == Listar.SINISTRO_CLIENTE.getNumero()) {
                    OperacoesMenu.listarSinistrosCliente(listaSeguradoras, entrada);
                    System.out.println("***");
                }

                else if (opcao2 == Listar.VEICULO_CLIENTEPF.getNumero()) {
                    OperacoesMenu.listarVeiculosClientePF(listaSeguradoras, entrada);
                    System.out.println("***");
                }

                else if (opcao2 == Listar.FROTA_CLIENTEPJ.getNumero()) {
                    OperacoesMenu.listarFrotasClientePJ(listaSeguradoras, entrada);
                    System.out.println("***");
                }

                else if (opcao2 == Listar.VEICULO_FROTA.getNumero()) {
                    OperacoesMenu.listarVeiculosFrota(listaSeguradoras, entrada);
                    System.out.println("***");
                }

                else if (opcao2 == Listar.CONDUTOR_SEGURO.getNumero()) {
                    OperacoesMenu.listarCondutoresSeguro(listaSeguradoras, entrada);
                    System.out.println("***");
                }

                else if (opcao2 == Listar.SINISTRO_SEGURO.getNumero()) {
                    OperacoesMenu.listarSinistrosSeguro(listaSeguradoras, entrada);
                    System.out.println("***");
                }

                else if (opcao2 == Listar.SINISTRO_CONDUTOR.getNumero()) {
                    OperacoesMenu.listarSinistrosCondutor(listaSeguradoras, entrada);
                    System.out.println("***");
                }
            }

            else if (opcao1 == MenuOperacoes.EXCLUIR.getNumero()) {
                System.out.println("O que gostaria de excluir?");
                System.out.println("1.Excluir um cliente de uma seguradora;");
                System.out.println("2.Excluir um veículo de um clientePF;");
                System.out.println("3.Excluir/Cancelar um seguro de um cliente;");
                System.out.println("4.Excluir um sinistro de um seguro;");
                System.out.println("5.Voltar para as opções anteriores.");
                System.out.println("Digite apenas o número correspondente a UMA das opções acima: ");
                opcao2 = Integer.parseInt(entrada.nextLine());

                if (opcao2 == Excluir.VOLTAR.getNumero()) {
                    continue;
                }

                else if (opcao2 == Excluir.CLIENTE.getNumero()) {
                    OperacoesMenu.excluirCliente(listaSeguradoras, entrada);
                    System.out.println("***");
                }

                else if (opcao2 == Excluir.VEICULO.getNumero()) {
                    OperacoesMenu.excluirVeiculo(listaSeguradoras, entrada);
                    System.out.println("***");
                }

                else if (opcao2 == Excluir.SEGURO.getNumero()) {
                    OperacoesMenu.excluirSeguro(listaSeguradoras, entrada);
                    System.out.println("***");
                }

                else if (opcao2 == Excluir.SINISTRO.getNumero()) {
                    OperacoesMenu.excluirSinistro(listaSeguradoras, entrada);
                    System.out.println("***");
                }
            }
            
            else if (opcao1 == MenuOperacoes.ATUALIZAR_FROTA.getNumero()) {
                System.out.println("De que maneira deseja atualizar a frota?");
                System.out.println("1.Adicionar um veículo;");
                System.out.println("2.Remover um veículo;");
                System.out.println("3.Remover toda a frota.");
                System.out.println("4.Voltar para as opções anteriores.");
                System.out.println("Digite apenas o número correspondente a UMA das opções acima: ");
                opcao2 = Integer.parseInt(entrada.nextLine());

                if (opcao2 == AtualizarFrota.VOLTAR.getNumero()) {
                    continue;
                }
                else {
                    OperacoesMenu.atualizarFrota(listaSeguradoras, entrada, opcao2);
                }
                System.out.println("***");
            }

            else if (opcao1 == MenuOperacoes.GERAR_SEGUROPF.getNumero()) {
                OperacoesMenu.gerarSeguroPF(listaSeguradoras, entrada);
                System.out.println("***");
            }

            else if (opcao1 == MenuOperacoes.GERAR_SEGUROPJ.getNumero()) {
                OperacoesMenu.gerarSeguroPJ(listaSeguradoras, entrada);
                System.out.println("***");
            }

            else if (opcao1 == MenuOperacoes.GERAR_SINISTRO.getNumero()) {
                OperacoesMenu.gerarSinistro(listaSeguradoras, entrada);
                System.out.println("***");
            }

            else if (opcao1 == MenuOperacoes.AUTORIZAR_CONDUTOR.getNumero()) {
                OperacoesMenu.autorizarCondutor(listaSeguradoras, entrada);
                System.out.println("***");
            }

            else if (opcao1 == MenuOperacoes.DESAUTORIZAR_CONDUTOR.getNumero()) {
                OperacoesMenu.desautorizarCondutor(listaSeguradoras, entrada);
                System.out.println("***");
            }

            else if (opcao1 == MenuOperacoes.CONSULTAR_VALOR.getNumero()) {
                OperacoesMenu.consultarValorMensal(listaSeguradoras, entrada);
                System.out.println("***");
            }

            else if (opcao1 == MenuOperacoes.CALCULAR_RECEITA.getNumero()) {
                OperacoesMenu.calcularReceita(listaSeguradoras, entrada);
                System.out.println("***");
            }

        } while(opcao1 != MenuOperacoes.SAIR.getNumero());
        System.out.println("SAIU DO MENU.");
    }
    public static void main(String[] args) throws Exception {
        // Auxiliares
        Scanner entrada = new Scanner(System.in);
        SimpleDateFormat datasFormatadas = new SimpleDateFormat("dd/MM/yyyy");

        // Instanciando 1 objeto da classe Seguradora
        if (!Validacao.validarCNPJ("33552326000180"))
            System.out.println("CNPJ inválido.");
        Seguradora seguradora = new Seguradora("33552326000180", "Unicamp Seguros", "11999981571", "seguros@dac.unicamp.br", "DAC");

        // Instanciando 4 objetos da classe Veiculo
        Veiculo veiculo1 = new Veiculo("DCV1516", "Renault", "Duster", 2018);
        Veiculo veiculo2 = new Veiculo("AMS2001", "Honda", "Civic", 2013);
        Veiculo veiculo3 = new Veiculo("DIB4712", "Jeep", "Compass", 2019);
        Veiculo veiculo4 = new Veiculo("ALX6022", "Jeep", "Renegade", 2020);

        // Instanciando 2 objetos da classe Frota e adionando 1 veículo a cada uma delas
        Frota frota1 = new Frota("Mercedes");
        Frota frota2 = new Frota("Iveco");
        if (frota1.adicionaVeiculo(veiculo2))
            System.out.println("Veículo adicionado com sucesso!");
        else
            System.out.println("Erro: veículo já adicionado anteriormente.");
        if (frota2.adicionaVeiculo(veiculo3))
            System.out.println("Veículo adicionado com sucesso!");
        else
            System.out.println("Erro: veículo já adicionado anteriormente.");

        // Instanciando 1 objeto da classe ClientePF e cadastrando-o na seguradora
        Date dataNascimento = datasFormatadas.parse("15/09/2004");
        if (!Validacao.validarCPF("46423644802"))
            System.out.println("CPF inválido.");
        ClientePF clientepf = new ClientePF("Daniel", "Rua Doutor Zuquim 1782", "11964188885", 
                        "daniel.cjsp@gmail.com", "46423644802", dataNascimento, 
                        "Ensino médio completo", "Masculino");
        if (clientepf.cadastrarVeiculo(veiculo1))
            System.out.println("Veículo cadastrado com sucesso!");
        else
            System.out.println("Erro de cadastro: veículo já cadastrado anteriormente.");
        if (seguradora.cadastrarCliente(clientepf)) 
            System.out.println("Cliente PF cadastrado com sucesso!");
        else
            System.out.println("Erro de cadastro: cliente já cadastrado anteriormente.");
        System.out.println("***");

        // Instanciando 1 objeto da classe ClientePJ e cadastrando-o na seguradora
        Date dataFundacao = datasFormatadas.parse("21/07/2004");
        if (!Validacao.validarCNPJ("69479158000192"))
            System.out.println("CNPJ inválido.");
        ClientePJ clientepj = new ClientePJ("Daniboy Empreendimentos", "Rua Leoncio de Magalhaes 479", 
                    "11940768221","daniboy.company@gmailcom", "69.479.158/0001-92", 
                                dataFundacao, 100);
        if (clientepj.cadastrarFrota(frota1))
            System.out.println("Frota cadastrada com sucesso!");
        else
            System.out.println("Erro de cadastro: frota já cadastrada anteriormente.");
        if (clientepj.atualizarFrota(frota1.getCode(), veiculo4))
            System.out.println("Frota atualizada com sucesso!");
        else
            System.out.println("Erro ao atualizar frota.");
        if (seguradora.cadastrarCliente(clientepj)) 
            System.out.println("Cliente PJ cadastrado com sucesso!");
        else
            System.out.println("Erro de cadastro: cliente já cadastrado anteriormente.");
        System.out.println("***");

        // Instanciando 1 objeto da classe SeguroPF
        Date dataInicio = datasFormatadas.parse("01/06/2021");
        Date dataFim = datasFormatadas.parse("01/06/2024");
        if (seguradora.gerarSeguroPF(dataInicio, dataFim, veiculo1, clientepf))
            System.out.println("Seguro gerado com sucesso!");
        else    
            System.out.println("Erro ao gerar seguro: o veículo em questão já possui um seguro.");

        // Instanciando 1 objeto da classe SeguroPJ
        dataInicio = datasFormatadas.parse("04/07/2021");
        dataFim = datasFormatadas.parse("04/07/2024");
        if (seguradora.gerarSeguroPJ(dataInicio, dataFim, frota1, clientepj))
            System.out.println("Seguro gerado com sucesso!");
        else    
            System.out.println("Erro ao gerar seguro: o veículo em questão já possui um seguro.");

        // Instanciando 2 objetos da classe Condutor e autorizando cada um deles em um seguro
        dataNascimento = datasFormatadas.parse("21/09/2004");
        if (!Validacao.validarCPF("18361641220"))
            System.out.println("CPF inválido.");
        Condutor condutor1 = new Condutor("18361641220", "Luccas Guedes Janune", "11983127656", 
                    "Rua Pedro Doll 417", "luccas.cjsp@gmail.com", dataNascimento);
        if (seguradora.getListaSeguros().get(0).autorizarCondutor(condutor1))
            System.out.println("Condutor 1 autorizado com sucesso");
        else
            System.out.println("Erro ao autorizar condutor 1");
        
        dataNascimento = datasFormatadas.parse("30/01/2004");
        if (!Validacao.validarCPF("18133208882"))
            System.out.println("CPF inválido.");
        Condutor condutor2 = new Condutor("18133208882", "William Hyde Santoro", "11999761370", 
                            "Rua Augusto Tolle 539", "william.cjsp@gmail.com", dataNascimento);
        if (seguradora.getListaSeguros().get(1).autorizarCondutor(condutor2))
            System.out.println("Condutor 2 autorizado com sucesso");
        else
            System.out.println("Erro ao autorizar condutor 2");
        
        // Instanciando 2 objetos da classe Sinistro (por meio do método gerarSinistro da classe Seguro)
        Date dataSinistro1 = datasFormatadas.parse("16/04/2023");
        if (seguradora.getListaSeguros().get(0).gerarSinistro(dataSinistro1, "Rua Alfredo Pujol 321", condutor1))
            System.out.println("Sinistro gerado com sucesso!");
        else
            System.out.println("Erro ao gerar sinistro. Sinistro já gerado anteriormente.");

        Date dataSinistro2 = datasFormatadas.parse("22/04/2023");
        if (seguradora.getListaSeguros().get(1).gerarSinistro(dataSinistro2, "Rua Cataguases 754", condutor2))
            System.out.println("Sinistro gerado com sucesso!");
        else
            System.out.println("Erro ao gerar sinistro. Sinistro já gerado anteriormente.");

        // Chamando os métodos toString() de cada classe
        System.out.println("TESTANDO OS MÉTODOS toString() DE CADA CLASSE");
        System.out.println(seguradora);
        System.out.println("***");
        System.out.println(veiculo1);
        System.out.println("***");
        System.out.println(frota1);
        System.out.println("***");
        System.out.println(frota2);
        System.out.println("***");
        System.out.println(clientepf);
        System.out.println("***");
        System.out.println(clientepj);
        System.out.println("***");
        System.out.println(seguradora.getListaSeguros().get(0)); /* toString() da classe SeguroPF */
        System.out.println("***");
        System.out.println(seguradora.getListaSeguros().get(1)); /* toString() da classe SeguroPJ */
        System.out.println("***");
        System.out.println(condutor1);
        System.out.println("***");
        System.out.println(seguradora.getListaSeguros().get(0).getListaSinistros().get(0)); /* toSring() da classe Sinistro */
        System.out.println("FIM DOS TESTES COM OS MÉTODOS toString()");

        // Chamando o método calcularReceita() para a Seguradora instanciada
        System.out.printf("Receita da seguradora %s: %.2f reais.\n", seguradora.getNome(), seguradora.calcularReceita());
        System.out.println("***");

        // Os demais métodos não chamados aqui, como listar e excluir, podem ser testados por meio do menu interativo.

        // Chamando o menu de operações
        Menu(seguradora, entrada);
        
        entrada.close();
    }
}