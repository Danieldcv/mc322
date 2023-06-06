public enum AtualizarFrota {
    ADICIONAR_VEICULO(1),
    REMOVER_VEICULO(2),
    REMOVER_FROTA(3),
    VOLTAR(4);

    public final int numero; /* constante associada a cada operação */

    AtualizarFrota(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }
}
