package vintage.src;

public class transportadora {
    private String transportadora;
    private boolean premium;
    private int taxa;
    private double lucro;

    public transportadora(String nome, int tx, boolean prem) {
        this.transportadora = nome;
        this.taxa = tx;
        this.premium = prem;
    }

    public boolean getPremium() {
        return this.premium;
    }

    public void setPremium(boolean p) {
        this.premium = p;
    }

    public double getLucro() {
        return this.lucro;
    }

    public void setLucro(double d) {
        this.lucro = d;
    }

    public String getNome() {
        return this.transportadora;
    }

    public void setNome(String n) {
        this.transportadora = n;
    }

    public double getTaxa() {
        return this.taxa;
    }

    public void setTaxa(int t) {
        this.taxa = t;
    }
}
