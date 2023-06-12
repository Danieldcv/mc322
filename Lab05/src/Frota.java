import java.util.ArrayList;

public class Frota {
    private String code;
    private ArrayList<Veiculo> listaVeiculos;

    // Método construtor
    public Frota(String nomeFrota) {
        code = geraCode(nomeFrota);
        listaVeiculos = new ArrayList<Veiculo>();
    }

    //Setters e getters
    public String geraCode(String nomeFrota) {
        Integer aux = new Integer(nomeFrota.hashCode());
        return Integer.toString(aux);
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public String listarVeiculos() {
        String str = "";
        for (Veiculo veiculo : listaVeiculos) {
            str += veiculo.toString() + "\n*\n";
        }
        return str;
    }

    public boolean adicionaVeiculo(Veiculo veiculo) {
        if (listaVeiculos.contains(veiculo))
            return false;
        listaVeiculos.add(veiculo);
        return true;
    }

    public boolean removeVeiculo(Veiculo veiculo) {
        for (Veiculo v : new ArrayList<Veiculo>(listaVeiculos)) {
            if (v.equals(veiculo)) {
                listaVeiculos.remove(veiculo);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String str = "DADOS DA FROTA\n" + "Code: " + getCode() + "\nLISTA DE VEÍCULOS\n" + listarVeiculos();
        return str;
    }
}
