import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.text.SimpleDateFormat;

public abstract class Seguro {
    private final int id;
    private Date dataInicio;
    private Date dataFim;
    private Seguradora seguradora;
    private ArrayList<Sinistro> listaSinistros;
    private ArrayList<Condutor> listaCondutores;
    private double valorMensal;
    protected static SimpleDateFormat datasFormatadas = new SimpleDateFormat("dd/MM/yyyy");

    // Método construtor
    public Seguro(Date dataInicio, Date dataFim, Seguradora seguradora) {
        id = geraId();
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.seguradora = seguradora;
        listaSinistros = new ArrayList<Sinistro>();
        listaCondutores = new ArrayList<Condutor>();
    }

    // Setters e getters
    protected int geraId(){
        Random aleatorio = new Random();
        return aleatorio.nextInt(100000000);
    } 

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

    public void setValorMensal(double valorMensal) {
        this.valorMensal = valorMensal;
    }

    public int getId() {
        return id;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public Seguradora getSeguradora() {
        return seguradora;
    }

    public ArrayList<Sinistro> getListaSinistros() {
        return listaSinistros;
    }

    public ArrayList<Condutor> getListaCondutores() {
        return listaCondutores;
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

    public String listarCondutores() {
        String str = "";
        for (Condutor condutor : listaCondutores) {
            str += condutor.toString() + "\n*\n";
        }
        return str;
    }

    public double getValorMensal() {
        return valorMensal;
    }

    public boolean autorizarCondutor(Condutor condutor) {
        for (Condutor c : listaCondutores) {
            if (c.equals(condutor)) {
                return false;
            }
        }
        listaCondutores.add(condutor);
        return true;
    }

    public boolean desautorizarCondutor(String cpf) {
        for (Condutor condutor : new ArrayList<Condutor>(listaCondutores)) {
            if (condutor.getCpf().equals(cpf)) {
                listaCondutores.remove(condutor);
                return true;
            }
        }
        return false;
    }

    public abstract double calcularValor();

    public boolean gerarSinistro(Date data, String endereco, Condutor condutor) {
		Sinistro sinistro = new Sinistro(data, endereco, condutor, this);
		for (Sinistro s : listaSinistros) 
			if (s.getCondutor().equals(sinistro.getCondutor()) && s.getData().equals(sinistro.getData()) && 
				s.getEndereco().equals(sinistro.getEndereco())) 
				return false;
		listaSinistros.add(sinistro);
        condutor.adicionaSinistro(sinistro);
        System.out.println("O Id deste sinistro é: " + sinistro.getId() + ". Anote-o para futuras consultas.");
		return true;
	}

    public boolean excluirSinistro(int id, String cpf) {
        for (Sinistro sinistro : new ArrayList<Sinistro>(listaSinistros)) {
            if (sinistro.getId() == id) {
                for (Condutor condutor : listaCondutores) {
                    if (condutor.getCpf().equals(cpf)) {
                        condutor.removeSinistro(sinistro);
                    }
                }
                listaSinistros.remove(sinistro);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String str = "ID: " + getId() + "\nData de início: " + datasFormatadas.format(getDataInicio())
                    + "\nData de fim: " + datasFormatadas.format(getDataFim()) + "\nLista de sinistros: "
                    + listarSinistros() + "Lista de condutores: " + listarCondutores() + "Valor mensal: "
                    + getValorMensal() + "\n";
        return str;
    }
}
