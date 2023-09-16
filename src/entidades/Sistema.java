package entidades;

public abstract class Sistema {
    private String senha;

    public Sistema() {
    }

    public Sistema(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
