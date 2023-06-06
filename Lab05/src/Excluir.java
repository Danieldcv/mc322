public enum Excluir {
    CLIENTE(1),
    VEICULO(2),
    SEGURO(3),
    SINISTRO(4),
    VOLTAR(5);

    public final int numero; /* constante associada a cada operação */

    Excluir(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }
}
