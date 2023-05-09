package vintage.src;

public class sapatilhas {
    private boolean premium;
    private int tamanho;
    private boolean atacadores;
    private String cor;
    private int data;

    public sapatilhas(boolean prem, int tam, boolean atac, String c, int ano /* ,int desc */) {
        this.premium = prem;
        this.tamanho = tam;
        this.atacadores = atac;
        this.cor = c;
        this.data = ano;
        // this.desconto = desc;
    }

    public sapatilhas(sapatilhas s) {
        this.premium = s.getPremium();
        this.tamanho = s.getTam();
        this.atacadores = s.getAtac();
        this.cor = s.getCor();
        this.data = s.getData();
        // this.desconto = s.getDesc();
    }

    public int getData() {
        return this.data;
    }

    public void setData(int a) {
        this.data = a;
    }

    /*
     * public int getDesc() {
     * return this.desconto;
     * }
     * public void setDesc(int d){
     * this.desconto = d;
     * }
     */
    public String getCor() {
        return this.cor;
    }

    public void setCor(String c) {
        this.cor = c;
    }

    public boolean getAtac() {
        return this.atacadores;
    }

    public void setAtac(boolean a) {
        this.atacadores = a;
    }

    public int getTam() {
        return this.tamanho;
    }

    public void setTam(int t) {
        this.tamanho = t;
    }

    public boolean getPremium() {
        return this.premium;
    }

    public void setPremium(boolean p) {
        this.premium = p;
    }
}
