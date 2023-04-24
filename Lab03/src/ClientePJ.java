import java.util.ArrayList;
import java.util.Date;

public class ClientePJ extends Cliente {
    // Atributos
    final String cnpj;
    private Date dataFundacao; 

    // Construtor
    public ClientePJ(String nome, String endereco, ArrayList <Veiculo> listaVeiculos, String cnpj, Date dataFundacao) {
        super(nome, endereco, listaVeiculos);
        this.cnpj = cnpj;
        this.dataFundacao = dataFundacao;
    }

    public ClientePJ(String cnpj) {
        super();
        this.cnpj = cnpj;
    }

    // Setters e getters
    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public Date getDataFundacao() {
        return dataFundacao;
    }

    public String getCNPJ() {
        return cnpj;
    }

    @Override
    public String toString() {
        String str = "DADOS DO CLIENTE PJ\nNome: " + getNome() + "\nEndereco: " + getEndereco() + 
                    "\nData da fundacao da empresa: " + datasFormatadas.format(getDataFundacao()) + "\nCNPJ: " + getCNPJ()
                    + "\nVeiculos: " + getListaVeiculos() + "\n";
        return str;
    }

    public static int calculaVerificador(String cnpj, int n) {
        // Função auxiliar à função validarCPF responsável por calcular os digitos verificadores do CPF
        // O parâmetro n indica quantos dígitos do CPF serão usados no cálculo (11 para o 1º dígito e 12 para o 2°)

        int digito; /* variável que armazena cada índice do CPF */
        int multiplicador = 2; /* variável auxiliar responável por armazenar o valor ao qual cada dígito será multiplicado */
        int soma = 0; /* variável responsável por quantabilizar a soma dos produtos de cada dígito pelo multiplicador */
        int resto; /* resto da divisão de soma por 11 */

        for (int i = n; i >= n - 7; i--) {
            digito = (int) cnpj.charAt(i) - 48;
            digito *= multiplicador;
            multiplicador++;
            soma += digito;
        }
        multiplicador = 2;
        for (int i = n - 8; i >= 0; i--) {
            digito = (int) cnpj.charAt(i) - 48;
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

    // Validando o CNPJ
    public static boolean validarCNPJ(String cnpj) {
        cnpj = cnpj.replaceAll("[^0-9]+", ""); /* elimina todos os dígitos não numéricos */

        if (cnpj.length() != 14) {
            // verifica se o CNPj digitado não possui 14 dígitos
            return false;
        }

        int contador = 0; /* conta se todos os dígitos do CPF são iguais */
        for (int i = 0; i < cnpj.length(); i++) {
            if (cnpj.charAt(i) == cnpj.charAt(0)) {
                contador++;
            }
        }
        if (contador == 14) {
            return false;
        }    

        // Calculando o 1° dígito verificador
        int verificador1 = calculaVerificador(cnpj, 11);
        if (verificador1 == -1) {
            if (cnpj.charAt(12) != '0') {
                return false;
            }
        }
        else {
            if (verificador1 != ((int) cnpj.charAt(12) - 48)) {
                return false;
            }
        }

        // Calculando o 2° dígito verificador
        int verificador2 = calculaVerificador(cnpj, 12);
        if (verificador2 == -1) {
            if (cnpj.charAt(13) != '0') {
                return false;
            }
        }
        else {
            if (verificador2 != ((int) cnpj.charAt(13) - 48)) {
                return false;
            }
        }

        return true;
    }
}