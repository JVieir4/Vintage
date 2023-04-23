package vintage;

import java.text.DecimalFormat;

public class artigos {
    private Tipo tipo;
    private boolean estado;
    private int ndonos;
    private String descricao;
    private String marca;
    private String codigo;
    private double preco;
    private int correcao = 0;
    private sapatilhas sapatilha;
    private tshirts tshirt;
    private malas mala;
    DecimalFormat df = new DecimalFormat("#.##");

    enum Tipo {
        Sapatilha,
        TShirt,
        Mala,
        Outro
    }

    public artigos(Tipo type, boolean state, int donos, String desc, String brand, String code, double price){
        this.tipo = type;
        this.estado = state;
        this.ndonos = donos;
        this.descricao = desc;
        this.marca = brand;
        this.codigo = code;
        this.preco = price;
    }

    public artigos(sapatilhas sap, boolean state, int donos, String desc, String brand, String code, double price){
        this.tipo = Tipo.Sapatilha;
        this.estado = state;
        this.ndonos = donos;
        this.descricao = desc;
        this.marca = brand;
        this.codigo = code;
        this.preco = price;
        this.sapatilha = sap;
    }

    public artigos(tshirts tshirt, boolean state, int donos, String desc, String brand, String code, double price){
        this.tipo = Tipo.TShirt;
        this.estado = state;
        this.ndonos = donos;
        this.descricao = desc;
        this.marca = brand;
        this.codigo = code;
        this.preco = price;
        this.tshirt = tshirt;
    }

    public artigos(malas mala, boolean state, int donos, String desc, String brand, String code, double price){
        this.tipo = Tipo.Mala;
        this.estado = state;
        this.ndonos = donos;
        this.descricao = desc;
        this.marca = brand;
        this.codigo = code;
        this.preco = price;
        this.mala = mala;
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
                    this.correcao = -5 * ( 2023 - sapatilha.getData());
                }
                if(!this.estado /* || data não é a atual */){
                    this.correcao = this.ndonos * 10; // 10 para já como estado de utilização, ou seja 10% gasto
                }
                break;
            case TShirt:
                if(!this.estado && tshirt.getPadrao() != Padroes.Liso){
                    this.correcao = 50;
                }
                else{
                    this.correcao = 0;
                }
                break;
            case Mala:
                if(mala.getPrem()){
                    this.correcao = -5 * ( 2023 - mala.getData());
                }
                if(!this.estado /* || data não é a atual */){
                    this.correcao = this.ndonos * 10; // 10 para já como estado de utilização, ou seja 10% gasto
                }
                break;
            case Outro:
                break;
        }
        return this.preco = this.preco - ((this.preco * this.correcao)/ 100);
    }

    @Override
    public String toString(){
        String reset = colors.RESET;
        String green = colors.GREEN;
        String yellow = colors.YELLOW;
        switch(tipo){
            case Sapatilha:
                return yellow + this.tipo +
                green + "\n- Marca: " + "\t" + reset + this.marca +
                green + "\n- Premium? " + "\t" + reset + sapatilha.getPremium() + 
                green + "\n- Descrição: " + "\t" + reset + this.descricao +
                green + "\n- Tamanho: " + "\t" + reset + sapatilha.getTam() +
                green + "\n- Cor: " + "\t\t" + reset + sapatilha.getCor() +
                green + "\n- Atacadores? " + "\t" + reset + sapatilha.getAtac() +
                green +  "\n- Edição: " + "\t" + reset + sapatilha.getData() +
                green + "\n- Novo?: " + "\t" + reset + this.estado +
                green + "\n- Preço: " + "\t" + reset + df.format(CalculaPreço()) +
                green + "\n- Código: " + "\t" + reset + this.codigo;
            case TShirt:
                return yellow + this.tipo +
                green + "\n- Marca: " + "\t" + reset + this.marca +
                green + "\n- Descrição: " + "\t" + reset + this.descricao +
                green + "\n- Tamanho: " + "\t" + reset + tshirt.getTamanho() +
                green + "\n- Padrão: " + "\t" + reset + tshirt.getPadrao() +
                green + "\n- Novo? " + "\t" + reset + this.estado +
                green + "\n- Preço: " + "\t" + reset + df.format(CalculaPreço()) +
                green + "\n- Código: " + "\t" + reset + this.codigo;
            case Mala:
                return yellow +this.tipo +
                green + "\n- Marca: " + "\t" + reset + this.marca +
                green + "\n- Premium? " + "\t" + reset + mala.getPrem() +
                green + "\n- Descrição: " + "\t" + reset + this.descricao +
                green + "\n- Tamanho: " + "\t" + reset + mala.getDimx() + "x" + mala.getDimy() +
                green + "\n- Material: " + "\t" + reset + mala.getMaterial() +
                green + "\n- Edição: " + "\t" + reset + mala.getData() +
                green + "\n- Novo? " + "\t" + reset + this.estado +
                green + "\n- Preço: " + "\t" + reset + df.format(CalculaPreço()) +
                green + "\n- Código: " + "\t" + reset + this.codigo;
            case Outro:
                return yellow + this.tipo +
                green + "\n- Marca: " + "\t" + reset + this.marca +
                green + "\n- Descrição: " + "\t" + reset + this.descricao +
                green + "\n- Novo? " + "\t" + reset + this.estado +
                green + "\n- Preço: " + "\t" + reset + df.format(CalculaPreço()) +
                green + "\n- Código: " + "\t" + reset + this.codigo;
        }
        return null;
    }
}
