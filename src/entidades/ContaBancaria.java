package entidades;

public class ContaBancaria {
    private String numeroConta;
    private float saldo;
    private String agencia;
    private float extrato;

    public ContaBancaria(String numeroConta, float saldo, String agencia) {
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.agencia = agencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }
    public float getExtrato(){
        return extrato;
    }

    public void setExtrato(float extrato){
        this.extrato = extrato;
    }
}
