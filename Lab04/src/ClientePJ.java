import java.util.Date;

public class ClientePJ extends Cliente {
    // Atributos
    final String cnpj;
    private Date dataFundacao; 
    private int qtdeFuncionarios;

    // Construtor
    public ClientePJ(String nome, String endereco, String cnpj, Date dataFundacao, int qtdeFuncionarios) {
        super(nome, endereco);
        this.cnpj = cnpj;
        this.dataFundacao = dataFundacao;
        this.qtdeFuncionarios = qtdeFuncionarios;
    }

    public ClientePJ(String cnpj) {
        super();
        this.cnpj = cnpj;
    }

    // Setters e getters
    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public void setQtdeFuncionarios(int qtdeFuncionarios) {
        this.qtdeFuncionarios = qtdeFuncionarios;
    }

    public Date getDataFundacao() {
        return dataFundacao;
    }

    public String getCNPJ() {
        return cnpj;
    }

    public int getQtdeFuncionarios() {
        return qtdeFuncionarios;
    }

    @Override
    public double calculaScore() {
        return CalcSeguro.VALOR_BASE.getFator() * (1 + qtdeFuncionarios / 100) * this.getListaVeiculos().size();
    }

    @Override
    public String toString() {
        String str = "DADOS DO CLIENTE PJ\nNome: " + getNome() + "\nEndereco: " + getEndereco() + 
                    "\nData da fundacao da empresa: " + datasFormatadas.format(getDataFundacao()) + "\nCNPJ: " + getCNPJ()
                    + "\nVeiculos: " + getListaVeiculos() + "\nQuantidade de funcionarios: " + getQtdeFuncionarios();
        return str;
    }
}