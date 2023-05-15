import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Cliente {
    // Atributos
    private String nome;
    private String endereco;
    private ArrayList <Veiculo> listaVeiculos;
    private double valorSeguro;
    protected static SimpleDateFormat datasFormatadas = new SimpleDateFormat("dd/MM/yyyy");

    // Método construtor
    public Cliente(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        valorSeguro = 0.0;
        listaVeiculos = new ArrayList<Veiculo>();
    }

    public Cliente() {

    }

    // Setters e getters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setValorSeguro(double valorSeguro) {
        this.valorSeguro = valorSeguro;
    }
    
    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public double getValorSeguro() {
        return valorSeguro;
    }

    public void adicionaVeiculo(Veiculo veiculo) {
        listaVeiculos.add(veiculo);
    }

    public ArrayList <Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public double calculaScore() {
        return 0.0;
    }

    @Override
    public String toString() {
        String str = "DADOS DO CLINTE\nNome: " + getNome() + "\nEndereco: " + getEndereco() + "\nVeiculos: " + getListaVeiculos() + "\n";
        return str;
    }
}
