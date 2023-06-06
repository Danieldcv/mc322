import java.util.Date;

public class SeguroPJ extends Seguro{
    Frota frota;
    ClientePJ cliente;

    // Método construtor
    public SeguroPJ(Date dataInicio, Date dataFim, Seguradora seguradora, Frota frota, ClientePJ cliente) {
        super(dataInicio, dataFim, seguradora);
        this.frota = frota;
        this.cliente = cliente;
    }

    // Setters e getters
    public void setFrota(Frota frota) {
        this.frota = frota;
    }

    public void setCliente(ClientePJ cliente) {
        this.cliente = cliente;
    }

    public Frota getFrota() {
        return frota;
    }

    public ClientePJ getCliente() {
        return cliente;
    }

    public double calcularValor() {
        // Calculando a idade da empresa
        Date now = new Date();
        int anosPosFundacao;
        int anoAux = (now.getYear() - cliente.getDataFundacao().getYear()) * 365;
        int mesAux = (now.getMonth() - cliente.getDataFundacao().getMonth())* 30;
        int diaAux = now.getDate() - cliente.getDataFundacao().getDate();
        anosPosFundacao = (anoAux + mesAux + diaAux) / 365;

        // Calculando a quantido de sinistros dos condutores
        int qtdSinistrosCondutor = 0;
        for (Condutor condutor : this.getListaCondutores()) {
            qtdSinistrosCondutor += condutor.getListaSinistros().size();
        }

        return CalcSeguro.VALOR_BASE.getFator() * (10 + (cliente.getQtdeFuncionarios() / 10.0)) *
        (1 + 1.0 / (frota.getListaVeiculos().size() + 2)) * (1 + 1.0 / (anosPosFundacao + 2))
        * (2 + this.getListaSinistros().size() / 10.0) * (5 + qtdSinistrosCondutor / 10.0);
    }

    @Override
    public String toString() {
        String str = "DADOS DO CLIENTEPJ\n" + super.toString() + "Frota (Code): " + getFrota().getCode() + "\nCliente (CNPJ): " + getCliente().getCNPJ();
        return str;
    }
}
