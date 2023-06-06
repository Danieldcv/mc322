public enum Listar {
    CLIENTE_SEGURADORA(1),
    SEGURO_SEGURADORA(2),
    SEGURO_CLIENTE(3),
    SINISTRO_CLIENTE(4),
    VEICULO_CLIENTEPF(5),
    FROTA_CLIENTEPJ(6),
    VEICULO_FROTA(7),
    CONDUTOR_SEGURO(8),
    SINISTRO_SEGURO(9),
    SINISTRO_CONDUTOR(10),
    VOLTAR(11);

    public final int numero; /* constante associada a cada operação */

    Listar(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }
}
