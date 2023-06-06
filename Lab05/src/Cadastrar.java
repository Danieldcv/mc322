public enum Cadastrar {
    CLIENTEPF(1),
    CLIENTEPJ(2),
    VEICULO(3),
    SEGURADORA(4),
    FROTA(5),
    VOLTAR(6);

    public final int numero; /* constante associada a cada operação */

    Cadastrar(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }
}
