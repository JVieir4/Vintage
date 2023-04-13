package vintage;

enum Padroes{
    Liso,
    Riscas,
    Palmeiras
}

enum Tamanho{
    S,
    M,
    L,
    XL
}

public class tshirts {
    private Tamanho tamanho;
    private Padroes padrao;

    public tshirts(Tamanho tam, Padroes padr){
        this.tamanho = tam;
        this.padrao = padr;
    }

    public tshirts(tshirts t){
        this.tamanho = t.getTamanho();
        this.padrao = t.getPadrao();
    }

    public Padroes getPadrao() {
        return this.padrao;
    }
    public void setPadrao(Padroes p){
        this.padrao = p;
    }

    public Tamanho getTamanho() {
        return this.tamanho;
    }
    public void setTamanho(Tamanho ta){
        this.tamanho = ta;
    }
    
}