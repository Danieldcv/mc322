import java.util.Random;

public class Sinistro {
    // Atributos
    private int id;
    private String data;
    private String endereco;

    // Método construtor
    public Sinistro(int id, String data, String endereco) {
       this.id = id;
       this.data = data;
       this.endereco = endereco; 
    }

    public Sinistro() {
    }

    // Setters e getters
    public void setId(int id) {
        Random aleatorio = new Random();
        this.id = aleatorio.nextInt(100000000);
    } 

    public void setData(String data) {
        this.data = data;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public String getEndereco() {
        return endereco;
    }
}