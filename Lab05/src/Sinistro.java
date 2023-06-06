import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Sinistro {
    // Atributos
    private final int id;
    private Date data;
    private String endereco;
    private Condutor condutor;
    private Seguro seguro;
    private static SimpleDateFormat datasFormatadas = new SimpleDateFormat("dd/MM/yyyy");

    // Método construtor
    public Sinistro(Date data, String endereco, Condutor condutor, Seguro seguro) {
       this.id = geraId();
       this.data = data;
       this.endereco = endereco;
       this.condutor = condutor; 
       this.seguro = seguro;
    }

    // Setters e getters
    public int geraId(){
        Random aleatorio = new Random();
        return aleatorio.nextInt(100000000);
    } 

    public void setData(Date data) { 
        this.data = data;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setCondutor(Condutor condutor) {
        this.condutor = condutor;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }

    public int getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public String getEndereco() {
        return endereco;
    }

    public Condutor getCondutor() {
        return condutor;
    }

    public Seguro getSeguro() {
        return seguro;
    }

    @Override
    public String toString() {
        String str = "INFORMACOES DO SINISTRO\nId: " + getId() + "\nData: " + datasFormatadas.format(getData()) 
                    + "\nEndereco: " + getEndereco() + "\nCondutor: " + getCondutor() + 
                    "Seguro(Id): " + getSeguro().getId();
        return str;
    }
}
