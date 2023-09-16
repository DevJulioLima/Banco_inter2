package entidades;

public class ContaBancaria {
    private String numeroConta;
    private double saldo;
    private String agencia;
    private String extrato;

    public ContaBancaria() {
    }

    public ContaBancaria(String numeroConta, double saldo, String agencia, String extrato) {
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.agencia = agencia;
        this.extrato = extrato;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }
    public String getExtrato(){
        return extrato;
    }

    public void setExtrato(String extrato){
        this.extrato = extrato;
    }
}
