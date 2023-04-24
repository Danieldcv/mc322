import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Cliente {
    // Atributos
    private String nome;
    private String endereco;
    private ArrayList <Veiculo> listaVeiculos;
    protected static SimpleDateFormat datasFormatadas = new SimpleDateFormat("dd/MM/yyyy");

    // Método construtor
    public Cliente(String nome, String endereco, ArrayList <Veiculo> listaVeiculos) {
        this.nome = nome;
        this.endereco = endereco;
        this.listaVeiculos = listaVeiculos;

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

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void adicionaVeiculo(Veiculo veiculo) {
        this.listaVeiculos.add(veiculo);
    }

    public ArrayList <Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    @Override
    public String toString() {
        String str = "DADOS DO CLINTE\nNome: " + getNome() + "\nEndereco: " + getEndereco() + "\nVeiculos: " + getListaVeiculos() + "\n";
        return str;
    }
}
