public enum Excluir {
    CLIENTE(1),
    VEICULO(2),
    SINISTRO(3),
    VOLTAR(4);

    public final int numero; /* constante associada a cada operação */

    Excluir(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }
}
