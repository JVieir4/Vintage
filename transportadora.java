package vintage;

public class transportadora {
    private String transportadora;
    private double margemlucro;
    private double lucro;

    public transportadora(String nome, double mlucro){
        this.transportadora = nome;
        this.margemlucro = mlucro;
    }

    public double getLucro(){
        return this.lucro;
    }
    public void setLucro(double d){
        this.lucro = d;
    }

    public String getNome(){
        return this.transportadora;
    }
    public void setNome(String n){
        this.transportadora = n;
    }

    public double getTaxa(){
        return this.margemlucro;
    }
    public void setTaxa(double t){
        this.margemlucro = t;
    }
}
