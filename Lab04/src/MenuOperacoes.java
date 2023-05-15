public enum MenuOperacoes {
    CADASTRAR(1), 
    LISTAR(2), 
    EXCLUIR(3), 
    GERAR_SINISTRO(4), 
    TRANSFERIR_SEGURO(5), 
    CALCULAR_RECEITA(6), 
    SAIR(0);

    public final int numero; /* constante associada a cada operação */

    MenuOperacoes(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }
}
