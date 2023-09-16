package entidades;

public class ClientePj {
    private String cnpj;
    private String ie;
    private String nomeFantasia;

    public ClientePj() {
    }

    public ClientePj(String cnpj, String ie, String nomeFantasia) {
        this.cnpj = cnpj;
        this.ie = ie;
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }
}
