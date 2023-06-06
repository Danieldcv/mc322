public class Validacao {
    private static int calculaVerificadorPF(String cpf, int n) {
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

    private static int calculaVerificadorPJ(String cnpj, int n) {
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
        int verificador1 = calculaVerificadorPF(cpf, 8);
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
        int verificador2 = calculaVerificadorPF(cpf, 9);
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
        int verificador1 = calculaVerificadorPJ(cnpj, 11);
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
        int verificador2 = calculaVerificadorPJ(cnpj, 12);
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

    public static boolean validarNome(String nome) {
        String nomeAux = nome.replaceAll("[^A-Z, ^a-z, ^\b]", ""); /* ???? */
        if (nomeAux.equals(nome))
            return true;
        else
            return false;
    }
}
