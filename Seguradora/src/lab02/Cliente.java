public class Cliente {
    // Atributos
    private String nome;
    private String cpf;
    private String dataNascimento;
    private int idade;
    private String endereco;

    // Método construtor
    Cliente(String nome, String cpf, String dataNascimento, int idade, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.idade = idade;
        this.endereco = endereco;
    }

    // Setters e getters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getCPF() {
        return cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public int getIdade() {
        return idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public String toString() {
        String str = "DADOS DO CLINTE\nNome: " + getNome() + "\nCPF: " + getCPF() + "\nData de Nascimento: " + getDataNascimento() + "\nIdade: " + getIdade() + "\nEndereco: " + getEndereco();
        return str;
    }

    public int calculaVerificador(String cpf, int n) {
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

    public boolean validarCPF(String cpf) {
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