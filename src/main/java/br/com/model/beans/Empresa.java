package br.com.model.beans;

public class Empresa {

    private int idEmpresa;
    private String numCnpj;
    private String nomeEmpresa;
    private String setor;
    private String localizacao;

    public Empresa() {
    }

    public Empresa(int idEmpresa, String numCnpj, String nomeEmpresa, String setor, String localizacao) {
        this.idEmpresa = idEmpresa;
        this.numCnpj = numCnpj;
        this.nomeEmpresa = nomeEmpresa;
        this.setor = setor;
        this.localizacao = localizacao;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNumCnpj() {
        return numCnpj;
    }

    public void setNumCnpj(String numCnpj) {
        this.numCnpj = numCnpj;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "idEmpresa=" + idEmpresa +
                ", numCnpj='" + numCnpj + '\'' +
                ", nomeEmpresa='" + nomeEmpresa + '\'' +
                ", setor='" + setor + '\'' +
                ", localizacao='" + localizacao + '\'' +
                '}';
    }
}
