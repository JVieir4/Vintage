package vintage;

enum Tipo {
    Sapatilhas,
    TShirts,
    Malas
}

public class artigos {
    private Tipo tipo;
    private boolean estado;
    private String descricao;
    private String marca;
    private String codigo;
    private double preco;
    private int correcao;

    public artigos(Tipo type, boolean state, String desc, String brand, String code, double price, int corr){
        this.tipo = type;
        this.estado = state;
        this.descricao = desc;
        this.marca = brand;
        this.codigo = code;
        this.preco = price;
        this.correcao = corr;
    }

    public artigos(artigos a){
        this.tipo = a.getTipo();
        this.estado = a.getEstado();
        this.descricao = a.getDesc();
        this.marca = a.getMarca();
        this.codigo = a.getCodigo();
        this.preco = a.getPreco();
        this.correcao = a.getCorr();
    }

    public int getCorr() {
        return this.correcao;
    }
    public void setCorr(int c){
        this.correcao = c;
    }

    public double getPreco() {
        return this.preco;
    }
    public void setPreco(double p){
        this.preco = p;
    }

    public String getCodigo() {
        return this.codigo;
    }
    public void setCodigo(String cod){
        this.codigo = cod;
    }

    public String getMarca() {
        return this.marca;
    }
    public void setMarca(String m){
        this.marca = m;
    }

    public boolean getEstado() {
        return this.estado;
    }
    public void setEstado(boolean e){
        this.estado = e;
    }

    public String getDesc() {
        return this.descricao;
    }
    public void setDesc(String d){
        this.descricao = d;
    }

    public Tipo getTipo() {
        return this.tipo;
    }
    public void setTipo(Tipo t){
        this.tipo = t;
    }
}
