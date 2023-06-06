import java.text.SimpleDateFormat;

public abstract class Cliente {
    // Atributos
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    protected static SimpleDateFormat datasFormatadas = new SimpleDateFormat("dd/MM/yyyy");

    // Método construtor
    public Cliente(String nome, String endereco, String telefone, String email) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    // Setters e getters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        String str = "Nome: " + getNome() + "\nEndereço: " + getEndereco() + "\nTelefone: " + getTelefone()
                    + "\nEmail: " + getEmail();
        return str;
    }
}
