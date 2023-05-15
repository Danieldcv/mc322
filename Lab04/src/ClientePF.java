import java.util.Date;

public class ClientePF extends Cliente {
    // Atributos
    final String cpf;
    private Date dataNascimento;
    private String educacao;
    private String genero;
    private String classeEconomica;
    private Date dataLicenca;


    // Métodos construtores
    public ClientePF(String nome, String endereco, String cpf, Date dataNascimento,
                        String educacao, String genero, String classeEconomica, Date dataLicenca) {
        super(nome, endereco);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.educacao = educacao;
        this.genero = genero;
        this.classeEconomica = classeEconomica;
        this.dataLicenca = dataLicenca;
    }

    public ClientePF(String cpf) {
        super();
        this.cpf = cpf;
    }

    // Setters e getters
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setEducacao(String educacao) {
        this.educacao = educacao;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setClasseEconomica(String classeEconomica) {
        this.classeEconomica = classeEconomica;
    }

    public void setDataLicenca(Date dataLicenca) {
        this.dataLicenca = dataLicenca;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String getEducacao() {
        return educacao;
    }

    public String getGenero() {
        return genero;
    }

    public String getClasseEconomica() {
        return classeEconomica;
    }

    public Date getDataLicenca() {
        return dataLicenca;
    }

    public String getCPF() {
        return cpf;
    }

    @Override
    public double calculaScore() {
        // Calculando a idade do clientePF
        Date now = new Date();
        int idade;
        int anoAux = (now.getYear() - dataNascimento.getYear()) * 365; /* SERÁ??? */
        int mesAux = (now.getMonth() - dataNascimento.getMonth())* 30;
        int diaAux = now.getDate() - dataNascimento.getDate();
        idade = (anoAux + mesAux + diaAux) / 365;
        // Calculando o score efetivamente
        if (idade >= 18 && idade < 30)
            return CalcSeguro.VALOR_BASE.getFator() * CalcSeguro.FATOR_18_30.getFator() * this.getListaVeiculos().size();
        else if (idade >= 30 && idade < 60)
            return CalcSeguro.VALOR_BASE.getFator() * CalcSeguro.FATOR_30_60.getFator() * this.getListaVeiculos().size();
        else
            return CalcSeguro.VALOR_BASE.getFator() * CalcSeguro.FATOR_60_90.getFator() * this.getListaVeiculos().size();

    }

    @Override
    public String toString() {
        String str = "DADOS DO CLIENTE PF\nNome: " + getNome() + "\nData de Nascimento: " + datasFormatadas.format(getDataNascimento()) + 
                    "\nEndereco: " + getEndereco() + "\nEducacao: " + getEducacao() + "\nGenero: " + getGenero() + 
                    "\nClasse Economica: " + getClasseEconomica() + "\nData da licenca: " + datasFormatadas.format(getDataLicenca())
                    + "\nCPF: " + getCPF() + "\nVeiculos: " + getListaVeiculos() + "\n";
        return str;
    }
}