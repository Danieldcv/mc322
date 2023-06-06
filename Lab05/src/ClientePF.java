import java.util.ArrayList;
import java.util.Date;

public class ClientePF extends Cliente {
    // Atributos
    private final String cpf;
    private Date dataNascimento;
    private String educacao;
    private String genero;
    private ArrayList<Veiculo> listaVeiculos;

    // Métodos construtores
    public ClientePF(String nome, String endereco, String telefone, String email, String cpf, Date dataNascimento,
                        String educacao, String genero) {
        super(nome, endereco, telefone, email);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.educacao = educacao;
        this.genero = genero;
        listaVeiculos = new ArrayList<Veiculo>();
    }

    // Setters e getters
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setEducacao(String educacao) {
        this.educacao = educacao;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String getEducacao() {
        return educacao;
    }

    public String getGenero() {
        return genero;
    }

    public String getCPF() {
        return cpf;
    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public boolean cadastrarVeiculo(Veiculo veiculo) {
        if (listaVeiculos.contains(veiculo)) {
            return false;
        }
        listaVeiculos.add(veiculo);
        return true;
    }

    public boolean removerVeiculo(String placa) {
        for (Veiculo veiculo : new ArrayList<Veiculo>(listaVeiculos)) {
            if (veiculo.getPlaca().equals(placa)) {
                listaVeiculos.remove(veiculo);
                return true;
            }
        }
        return false;
    }

    public String listarVeiculos() {
        String str = "";
        for (Veiculo veiculo : listaVeiculos) {
            str += veiculo.toString() + "\n*\n";
        }
        return str;
    }

    @Override
    public String toString() {
        String str = "DADOS DO CLIENTE PF\n" + super.toString() + "\nData de Nascimento: " + datasFormatadas.format(getDataNascimento())
                     + "\nEducação: " + getEducacao() + "\nGênero: " + getGenero() + 
                    "\nCPF: " + getCPF() + "\nLISTA DE VEÍCULOS\n" + listarVeiculos();
        return str;
    }
}