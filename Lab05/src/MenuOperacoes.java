public enum MenuOperacoes {
    CADASTRAR(1), 
    LISTAR(2), 
    EXCLUIR(3), 
    ATUALIZAR_FROTA(4),
    GERAR_SEGUROPF(5),
    GERAR_SEGUROPJ(6),
    GERAR_SINISTRO(7), 
    AUTORIZAR_CONDUTOR(8),
    DESAUTORIZAR_CONDUTOR(9),
    CONSULTAR_VALOR(10),
    CALCULAR_RECEITA(11), 
    SAIR(0);

    public final int numero; /* constante associada a cada operação */

    MenuOperacoes(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }
}
