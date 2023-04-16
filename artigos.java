package vintage;

public class artigos {
    private Tipo tipo;
    private boolean estado;
    private int ndonos;
    private String descricao;
    private String marca;
    private String codigo;
    private double preco;
    private int correcao;
    private sapatilhas sapatilha;
    private tshirts tshirt;
    private malas mala;

    enum Tipo {
        Sapatilha,
        TShirt,
        Mala
    }

    public artigos(Tipo type, boolean state, int donos, String desc, String brand, String code, double price, int corr){
        this.tipo = type;
        this.estado = state;
        this.ndonos = donos;
        this.descricao = desc;
        this.marca = brand;
        this.codigo = code;
        this.preco = price;
        this.correcao = corr;
    }

    public artigos(sapatilhas sap, boolean state, int donos, String desc, String brand, String code, double price, int corr){
        this.tipo = Tipo.Sapatilha;
        this.estado = state;
        this.ndonos = donos;
        this.descricao = desc;
        this.marca = brand;
        this.codigo = code;
        this.preco = price;
        this.correcao = corr;
        this.sapatilha = sap;
    }

    public artigos(tshirts tshirt, boolean state, int donos, String desc, String brand, String code, double price, int corr){
        this.tipo = Tipo.TShirt;
        this.estado = state;
        this.ndonos = donos;
        this.descricao = desc;
        this.marca = brand;
        this.codigo = code;
        this.preco = price;
        this.correcao = corr;
        this.tshirt = tshirt;
    }

    public artigos(malas mala, boolean state, int donos, String desc, String brand, String code, double price, int corr){
        this.tipo = Tipo.Mala;
        this.estado = state;
        this.ndonos = donos;
        this.descricao = desc;
        this.marca = brand;
        this.codigo = code;
        this.preco = price;
        this.correcao = corr;
        this.mala = mala;
    }

    public artigos(artigos a){
        this.tipo = a.getTipo();
        this.estado = a.getEstado();
        this.ndonos = a.getNdonos();
        this.descricao = a.getDesc();
        this.marca = a.getMarca();
        this.codigo = a.getCodigo();
        this.preco = a.getPreco();
        this.correcao = a.getCorr();
    }

    public int getNdonos() {
        return this.ndonos;
    }
    public void setNdonos(int n) {
        this.ndonos = n;
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

    public double CalculaPreço(){
        switch(tipo){
            case Sapatilha:
                if(sapatilha.getPremium()){
                    this.correcao = -5 * ( /*data atual*/ - sapatilha.getData());
                }
                if(!this.estado /* || data não é a atual */){
                    this.correcao = this.ndonos * 10; // 10 para já como estado de utilização, ou seja 10% gasto
                }
                break;
            case TShirt:
                if(!this.estado && tshirt.getPadrao() != Padroes.Liso){
                    this.correcao = 0;
                }
                else{
                    this.correcao = 50;
                }
                break;
            case Mala:
                if(mala.getPrem()){
                    this.correcao = -5 * ( /*data atual*/ - mala.getData());
                }
                if(!this.estado /* || data não é a atual */){
                    this.correcao = this.ndonos * 10; // 10 para já como estado de utilização, ou seja 10% gasto
                }
        }
        return this.preco = this.preco - ((this.preco * this.correcao)/ 100);
    }

    @Override
    public String toString(){
        switch(tipo){
            case Sapatilha:
                return "Artigo: " + this.tipo + ", Marca: " + this.marca + ", Premium?: " + sapatilha.getPremium() + "\nDescrição: " + this.descricao +
                "\nTamanho: " + sapatilha.getTam() + ", Cor: " + sapatilha.getCor() + ", Atacadores?: " + sapatilha.getAtac() + ", Edição: " + sapatilha.getData() +
                ", Novo?: " + this.estado + "\nPreço: " + CalculaPreço() + "\nCódigo: " + this.codigo;
            case TShirt:
                return "Artigo: " + this.tipo + ", Marca: " + this.marca + "\nDescrição: " + this.descricao + "\nTamanho: " + tshirt.getTamanho() +
                ", Padrão: " + tshirt.getPadrao() + ", Novo?: " + this.estado + "\nPreço: " + CalculaPreço() + "\nCódigo: " + this.codigo;
            case Mala:
                return "Artigo: " + this.tipo + ", Marca: " + this.marca + ", Premium?: " + mala.getPrem() + "\nDescrição: " + this.descricao +
                "\nTamanho: " + mala.getDimx() + "x" + mala.getDimy() + ", Material: " + mala.getMaterial() + ", Edição: " + mala.getData() +
                ", Novo?: " + this.estado + "\nPreço: " + CalculaPreço() + "\nCódigo: " + this.codigo;
        }
        return null;
    }
}
