import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Condutor {
    private final String cpf;
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private Date dataNascimento;
    private ArrayList<Sinistro> listaSinistros;
    private static SimpleDateFormat datasFormatadas = new SimpleDateFormat("dd/MM/yyyy");

    // Método construtor
    public Condutor(String cpf, String nome, String telefone, String endereco, String email, Date dataNascimento) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.dataNascimento = dataNascimento;
        listaSinistros = new ArrayList<Sinistro>();
    }

    // Setters e getters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public ArrayList<Sinistro> getListaSinistros() {
        return listaSinistros;
    }

    public String listarSinistros() {
        String str = "";
        for (Sinistro sinistro : listaSinistros) {
            str += sinistro.toString() + "\n*\n";
        }
        return str;
    }

    public String listarSinistrosId() {
        String str = "";
        for (Sinistro sinistro : listaSinistros) {
            str += sinistro.getId() + "\n*\n";
        }
        return str;
    }

    public void adicionaSinistro(Sinistro sinistro) {
        listaSinistros.add(sinistro);
    }

    public void removeSinistro(Sinistro sinistro) {
        listaSinistros.remove(sinistro);
    }

    @Override
    public String toString() {
        String str = "DADOS DO CONDUTOR\nCPF: " + getCpf() + "\nNome: " + getNome() + "\nTelefone: " + getTelefone()
                    + "\nEndereço: " + getEndereco() + "\nEmail: " + getEmail() + "\nData de nascimento: " + 
                    datasFormatadas.format(getDataNascimento()) + "\nLista de sinistros por Id: " + listarSinistrosId();
        return str;
    }
}
