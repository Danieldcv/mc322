public enum Listar {
    CLIENTE_SEGURADORA(1),
    SINISTRO_SEGURADORA(2),
    SINISTRO_CLIENTE(3),
    VEICULO_CLIENTE(4),
    VEICULO_SEGURADORA(5),
    VOLTAR(6);

    public final int numero; /* constante associada a cada operação */

    Listar(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }
}
