public class Veiculo {
    // Atributos
    private String placa;
    private String marca;
    private String modelo;
    private int anoFabricacao;

    // Método construtor
    public Veiculo(String placa, String marca, String modelo, int anoFabricacao) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
    }

    // Setters e getters
    public void setPlaca(String placa) {
        this.placa = placa;
    } 

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    @Override
    public String toString() {
        String str = "DADOS DO VEICULO\nPlaca: " + getPlaca() + "\nMarca: " + getMarca() + "\nModelo: " + 
                    getModelo() + "\nAno de fabricacao: " + getAnoFabricacao();
        return str;
    }
}
