package vintage.src;

import java.text.DecimalFormat;
import java.util.UUID;
import vintage.src.tshirts.Padroes;

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
    private transportadora transp;
    private boolean disponivel;
    private static datemanager data = datemanager.getInstance();
    DecimalFormat df = new DecimalFormat("#.##");

    enum Tipo {
        Sapatilha,
        TShirt,
        Mala,
        Outro
    }

    public artigos(Tipo type, boolean state, int donos, String desc, String brand, double price, transportadora t) {
        this.tipo = type;
        this.estado = state;
        this.ndonos = donos;
        this.descricao = desc;
        this.marca = brand;
        this.codigo = UUID.randomUUID().toString().substring(0, 8);
        this.transp = t;
        this.preco = CalculaPreço(price);
        this.disponivel = true;
    }

    public artigos(sapatilhas sap, boolean state, int donos, String desc, String brand, double price,
            transportadora t) {
        this.tipo = Tipo.Sapatilha;
        this.estado = state;
        this.ndonos = donos;
        this.descricao = desc;
        this.marca = brand;
        this.codigo = UUID.randomUUID().toString().substring(0, 8);
        this.sapatilha = sap;
        this.transp = t;
        this.preco = CalculaPreço(price);
        this.disponivel = true;
    }

    public artigos(tshirts tshirt, boolean state, int donos, String desc, String brand, double price,
            transportadora t) {
        this.tipo = Tipo.TShirt;
        this.estado = state;
        this.ndonos = donos;
        this.descricao = desc;
        this.marca = brand;
        this.codigo = UUID.randomUUID().toString().substring(0, 8);
        this.tshirt = tshirt;
        this.transp = t;
        this.preco = CalculaPreço(price);
        this.disponivel = true;
    }

    public artigos(malas mala, boolean state, int donos, String desc, String brand, double price, transportadora t) {
        this.tipo = Tipo.Mala;
        this.estado = state;
        this.ndonos = donos;
        this.descricao = desc;
        this.marca = brand;
        this.codigo = UUID.randomUUID().toString().substring(0, 8);
        this.mala = mala;
        this.transp = t;
        this.preco = CalculaPreço(price);
        this.disponivel = true;
    }

    public transportadora getTransportadora() {
        return this.transp;
    }

    public void setTransportadora(transportadora t) {
        this.transp = t;
    }

    public boolean getDisponivel() {
        return this.disponivel;
    }

    public void setDisponivel(boolean x) {
        this.disponivel = x;
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

    public void setCorr(int c) {
        this.correcao = c;
    }

    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double p) {
        this.preco = p;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String cod) {
        this.codigo = cod;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String m) {
        this.marca = m;
    }

    public boolean getEstado() {
        return this.estado;
    }

    public void setEstado(boolean e) {
        this.estado = e;
    }

    public String getDesc() {
        return this.descricao;
    }

    public void setDesc(String d) {
        this.descricao = d;
    }

    public Tipo getTipo() {
        return this.tipo;
    }

    public void setTipo(Tipo t) {
        this.tipo = t;
    }

    public double CalculaPreço(double price) {
        switch (tipo) {
            case Sapatilha:
                if (sapatilha.getPremium()) {
                    this.correcao = -5 * (data.getCurrentDate().getYear() - sapatilha.getData());
                } else if (!this.estado) {
                    this.correcao = this.ndonos * 5;
                } else if (sapatilha.getTam() > 45) {
                    this.correcao = 20;
                }
                break;
            case TShirt:
                if (!this.estado && tshirt.getPadrao() != Padroes.Liso) {
                    this.correcao = 50;
                }
                break;
            case Mala:
                if (mala.getPrem()) {
                    this.correcao = -5 * (data.getCurrentDate().getYear() - mala.getData());
                } else if (!this.estado) {
                    this.correcao = this.ndonos * 5;
                }
                break;
            case Outro:
                if (!this.estado) {
                    this.correcao = this.ndonos * 5;
                }
                break;
        }
        return price = price - ((price * this.correcao) / 100);
    }

    @Override
    public String toString() {
        df.setMinimumFractionDigits(2);
        String reset = colors.RESET;
        String green = colors.GREEN;
        String yellow = colors.YELLOW;
        switch (tipo) {
            case Sapatilha:
                return yellow + this.tipo +
                        green + "\n- Marca: " + "\t\t" + reset + this.marca +
                        green + "\n- Premium? " + "\t\t" + reset + sapatilha.getPremium() +
                        green + "\n- Descrição: " + "\t\t" + reset + this.descricao +
                        green + "\n- Tamanho: " + "\t\t" + reset + sapatilha.getTam() +
                        green + "\n- Cor: " + "\t\t\t" + reset + sapatilha.getCor() +
                        green + "\n- Atacadores? " + "\t\t" + reset + sapatilha.getAtac() +
                        green + "\n- Edição: " + "\t\t" + reset + sapatilha.getData() +
                        green + "\n- Novo?: " + "\t\t" + reset + this.estado +
                        green + "\n- Preço: " + "\t\t" + reset + df.format(this.preco) + " EUR" +
                        green + "\n- Código: " + "\t\t" + reset + this.codigo +
                        green + "\n- Transportadora: " + "\t" + reset + this.transp.getNome();
            case TShirt:
                return yellow + this.tipo +
                        green + "\n- Marca: " + "\t\t" + reset + this.marca +
                        green + "\n- Descrição: " + "\t\t" + reset + this.descricao +
                        green + "\n- Tamanho: " + "\t\t" + reset + tshirt.getTamanho() +
                        green + "\n- Padrão: " + "\t\t" + reset + tshirt.getPadrao() +
                        green + "\n- Novo? " + "\t\t" + reset + this.estado +
                        green + "\n- Preço: " + "\t\t" + reset + df.format(this.preco) + " EUR" +
                        green + "\n- Código: " + "\t\t" + reset + this.codigo +
                        green + "\n- Transportadora: " + "\t" + reset + this.transp.getNome();
            case Mala:
                return yellow + this.tipo +
                        green + "\n- Marca: " + "\t\t" + reset + this.marca +
                        green + "\n- Premium? " + "\t\t" + reset + mala.getPrem() +
                        green + "\n- Descrição: " + "\t\t" + reset + this.descricao +
                        green + "\n- Tamanho: " + "\t\t" + reset + mala.getDimx() + "x" + mala.getDimy() +
                        green + "\n- Material: " + "\t\t" + reset + mala.getMaterial() +
                        green + "\n- Edição: " + "\t\t" + reset + mala.getData() +
                        green + "\n- Novo? " + "\t\t" + reset + this.estado +
                        green + "\n- Preço: " + "\t\t" + reset + df.format(this.preco) + " EUR" +
                        green + "\n- Código: " + "\t\t" + reset + this.codigo +
                        green + "\n- Transportadora: " + "\t" + reset + this.transp.getNome();
            case Outro:
                return yellow + this.tipo +
                        green + "\n- Marca: " + "\t\t" + reset + this.marca +
                        green + "\n- Descrição: " + "\t\t" + reset + this.descricao +
                        green + "\n- Novo? " + "\t\t" + reset + this.estado +
                        green + "\n- Preço: " + "\t\t" + reset + df.format(this.preco) + " EUR" +
                        green + "\n- Código: " + "\t\t" + reset + this.codigo +
                        green + "\n- Transportadora: " + "\t" + reset + this.transp.getNome();
        }
        return null;
    }
}
