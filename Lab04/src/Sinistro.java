import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Sinistro {
    // Atributos
    private int id;
    private Date data;
    private String endereco;
    private Seguradora seguradora;
    private Veiculo veiculo;
    private Cliente cliente;
    private static SimpleDateFormat datasFormatadas = new SimpleDateFormat("dd/MM/yyyy");

    // Método construtor
    public Sinistro(int id, Date data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente) {
       this.id = id;
       this.data = data;
       this.endereco = endereco; 
       this.seguradora = seguradora;
       this.veiculo = veiculo;
       this.cliente = cliente;
    }

    public Sinistro() {
    }

    // Setters e getters
    public void setId(int id) {
        Random aleatorio = new Random();
        this.id = aleatorio.nextInt(100000000);
    } 

    public void setData(Date data) { 
        this.data = data;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public Seguradora getSeguradora() {
        return seguradora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getEndereco() {
        return endereco;
    }

    @Override
    public String toString() {
        String str = "INFORMACOES DO SINISTRO\nId: " + getId() + "\nData: " + datasFormatadas.format(getData()) + "\nVeiculo: " + 
                        getVeiculo() +  "\nCliente: " + getCliente() + 
                        "\nEndereco: " + getEndereco() + "\n";
        return str;
    }
}
