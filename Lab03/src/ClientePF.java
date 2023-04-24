import java.util.ArrayList;
import java.util.Date;

public class ClientePF extends Cliente {
    // Atributos
    final String cpf;
    private Date dataNascimento;
    private String educacao;
    private String genero;
    private String classeEconomica;
    private Date dataLicenca;


    // Métodos construtores
    public ClientePF(String nome, String endereco, ArrayList <Veiculo> listaVeiculos, String cpf, Date dataNascimento,
                        String educacao, String genero, String classeEconomica, Date dataLicenca) {
        super(nome, endereco, listaVeiculos);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.educacao = educacao;
        this.genero = genero;
        this.classeEconomica = classeEconomica;
        this.dataLicenca = dataLicenca;
    }

    public ClientePF(String cpf) {
        super();
        this.cpf = cpf;
    }

    // Setters e getters
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setEducacao(String educacao) {
        this.educacao = educacao;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setClasseEconomica(String classeEconomica) {
        this.classeEconomica = classeEconomica;
    }

    public void setDataLicenca(Date dataLicenca) {
        this.dataLicenca = dataLicenca;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String getEducacao() {
        return educacao;
    }

    public String getGenero() {
        return genero;
    }

    public String getClasseEconomica() {
        return classeEconomica;
    }

    public Date getDataLicenca() {
        return dataLicenca;
    }

    public String getCPF() {
        return cpf;
    }

    @Override
    public String toString() {
        String str = "DADOS DO CLIENTE PF\nNome: " + getNome() + "\nData de Nascimento: " + datasFormatadas.format(getDataNascimento()) + 
                    "\nEndereco: " + getEndereco() + "\nEducacao: " + getEducacao() + "\nGenero: " + getGenero() + 
                    "\nClasse Economica: " + getClasseEconomica() + "\nData da licenca: " + datasFormatadas.format(getDataLicenca())
                    + "\nCPF: " + getCPF() + "\nVeiculos: " + getListaVeiculos() + "\n";
        return str;
    }

    public static int calculaVerificador(String cpf, int n) {
        // Função auxiliar à função validarCPF responsável por calcular os digitos verificadores do CPF
        // O parâmetro n indica quantos dígitos do CPF serão usados no cálculo (8 para o 1º dígito e 9 para o 2°)

        int digito; /* variável que armazena cada índice do CPF */
        int multiplicador = 2; /* variável auxiliar responável por armazenar o valor ao qual cada dígito será multiplicado */
        int soma = 0; /* variável responsável por quantabilizar a soma dos produtos de cada dígito pelo multiplicador */
        int resto; /* resto da divisão de soma por 11 */

        for (int i = n; i >= 0; i--) {
            digito = (int) cpf.charAt(i) - 48;
            digito *= multiplicador;
            multiplicador++;
            soma += digito;
        }
        resto = soma % 11;
        if (resto < 2) {
            return -1; 
        }
        else {
            return 11 - resto;
        }
    }

    public static boolean validarCPF(String cpf) {
        cpf = cpf.replaceAll("[^0-9]+", ""); /* elimina todos os dígitos não numéricos */

        if (cpf.length() != 11) {
            // verifica se o CPF digitado não possui 11 dígitos
            return false;
        }

        int contador = 0; /* conta se todos os dígitos do CPF são iguais */
        for (int i = 0; i < cpf.length(); i++) {
            if (cpf.charAt(i) == cpf.charAt(0)) {
                contador++;
            }
        }
        if (contador == 11) {
            return false;
        }

        // Calculando o 1° dígito verificador
        int verificador1 = calculaVerificador(cpf, 8);
        if (verificador1 == -1) {
            if (cpf.charAt(9) != '0') {
                return false;
            }
        }
        else {
            if (verificador1 != ((int) cpf.charAt(9) - 48)) {
                return false;
            }
        }

        // Calculando o 2° dígito verificador
        int verificador2 = calculaVerificador(cpf, 9);
        if (verificador2 == -1 && cpf.charAt(10) != '0') {
            return false;
        }
        else {
            if (verificador2 != ((int) cpf.charAt(10) - 48)) {
                return false;
            }
        }

        return true;
    }
}