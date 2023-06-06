import java.util.ArrayList;
import java.util.Date;

public class ClientePJ extends Cliente {
    // Atributos
    private final String cnpj;
    private Date dataFundacao; 
    private int qtdeFuncionarios;
    private ArrayList<Frota> listaFrota;

    // Construtor
    public ClientePJ(String nome, String endereco, String telefone, String email, String cnpj, 
                    Date dataFundacao, int qtdeFuncionarios) {
        super(nome, endereco, telefone, email);
        this.cnpj = cnpj;
        this.dataFundacao = dataFundacao;
        this.qtdeFuncionarios = qtdeFuncionarios;
        listaFrota = new ArrayList<Frota>();
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

    public ArrayList<Frota> getListaFrota() {
        return listaFrota;
    }

    public boolean cadastrarFrota(Frota frota) {
        if (listaFrota.contains(frota))
            return false;
        listaFrota.add(frota);
        return true;
    }

    public boolean atualizarFrota(String code, Veiculo veiculo) {
        // Adiciona um veículo a uma frota
        for (Frota frota : listaFrota) {
            if (frota.getCode().equals(code)) {
                if (frota.getListaVeiculos().contains(veiculo)) {
                    return false;
                }
                frota.getListaVeiculos().add(veiculo);
                return true;
            }
        }
        return false;
    }

    public boolean atualizarFrota(String code, String placa) {
        // Remove um veículo de uma frota
        for (Frota frota : listaFrota) {
            if (frota.getCode().equals(code)) {
                for (Veiculo veiculo : new ArrayList<Veiculo>(frota.getListaVeiculos())) {
                    if (veiculo.getPlaca().equals(placa)) {
                        frota.getListaVeiculos().remove(veiculo);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean atualizarFrota(String code) {
        // Remove a frota inteira
        for (Frota frota : listaFrota) {
            if (frota.getCode().equals(code)) {
                listaFrota.remove(frota);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Veiculo> getVeiculosPorFrota(String code) {
        ArrayList<Veiculo> veiculosFrota = new ArrayList<Veiculo>();
        for (Frota frota : listaFrota) {
            if (frota.getCode().equals(code)) {
                for (Veiculo veiculo : frota.getListaVeiculos()) {
                    veiculosFrota.add(veiculo);
                }
                break;
            }
        }
        return veiculosFrota;
    }

    public String listarFrota() {
        String str = "";
        for (Frota frota : listaFrota) {
            str += frota.toString() + "\n*\n";
        }
        return str;
    }

    public String listarVeiculos() {
        String str = "";
        for (Frota frota : listaFrota) {
            for (Veiculo veiculo : frota.getListaVeiculos()) {
                str += veiculo.toString() + "\n*\n";
            }
        }
        return str;
    }

    @Override
    public String toString() {
        String str = "DADOS DO CLIENTE PJ\n" + super.toString() +"\nData da fundacao da empresa: " + 
                    datasFormatadas.format(getDataFundacao()) + "\nCNPJ: " + getCNPJ()
                    + "\nQuantidade de funcionarios: " + getQtdeFuncionarios() + "\nLISTA DE FROTAS\n"
                    + listarFrota();
        return str;
    }
}