import java.util.Date;

public class SeguroPF extends Seguro{
    private Veiculo veiculo;
    private ClientePF cliente;

    // Método construtor
    public SeguroPF(Date dataInicio, Date dataFim, Seguradora seguradora, Veiculo veiculo, ClientePF cliente) {
        super(dataInicio, dataFim, seguradora);
        this.veiculo = veiculo;
        this.cliente = cliente;
    }

    // Setters e getters
    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void setCliente(ClientePF cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public ClientePF getCliente() {
        return cliente;
    }

    public double calcularValor() { 
        // Calculando a idade do clientePF
        Date now = new Date();
        int idade;
        int anoAux = (now.getYear() - cliente.getDataNascimento().getYear()) * 365;
        int mesAux = (now.getMonth() - cliente.getDataNascimento().getMonth())* 30;
        int diaAux = now.getDate() - cliente.getDataNascimento().getDate();
        idade = (anoAux + mesAux + diaAux) / 365;

        // Calculando a quantido de sinistros dos condutores
        int qtdSinistrosCondutor = 0;
        for (Condutor condutor : this.getListaCondutores()) {
            qtdSinistrosCondutor += condutor.getListaSinistros().size();
        }

        if (idade >= 18 && idade < 30) {
            double valor = CalcSeguro.VALOR_BASE.getFator() * CalcSeguro.FATOR_18_30.getFator() * 
            (1 + 1.0/ (cliente.getListaVeiculos().size() + 2)) * (2 + this.getListaSinistros().size() / 10.0)
            * (5 + qtdSinistrosCondutor / 10.0);
            return valor;
        }
        else if (idade >= 30 && idade < 60) {
            double valor = CalcSeguro.VALOR_BASE.getFator() * CalcSeguro.FATOR_30_60.getFator() * 
            (1 + 1.0/ (cliente.getListaVeiculos().size() + 2)) * (2 + this.getListaSinistros().size() / 10.0)
            * (5 + qtdSinistrosCondutor / 10.0);
            return valor;
        }
        else {
            double valor = CalcSeguro.VALOR_BASE.getFator() * CalcSeguro.FATOR_60_90.getFator() * 
            (1 + 1.0 / (cliente.getListaVeiculos().size() + 2)) * (2 + this.getListaSinistros().size() / 10.0)
            * (5 + qtdSinistrosCondutor / 10.0);
            return valor;
        }
    }

    @Override
    public String toString() {
        String str = "DADOS DO SEGUROPF\n" + super.toString() + "Veículo (placa): " + getVeiculo().getPlaca() + "\nCliente (CPF): "
                    + getCliente().getCPF();
        return str;
    }
}
