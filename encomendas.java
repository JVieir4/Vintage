package vintage;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public class encomendas {
    private String nome;
    private Dimensao dimensao;
    private Estado estado;
    private double preco;
    private int numero_artigos;
    private String codigo;
    private datemanager data = datemanager.getInstance();
    private LocalDate data_de_criacao;
    ArrayList<artigos> artigos;
    DecimalFormat df = new DecimalFormat("#.##");

    enum Dimensao {
        Grande,
        Média,
        Pequena
    }

    enum Estado {
        Pendente,
        Finalizada,
        Expedida
    }

    public encomendas(String name) {
        this.nome = name;
        this.artigos = new ArrayList<>();
        this.estado = Estado.Pendente;
        this.data_de_criacao = data.getCurrentDate();
        this.codigo = UUID.randomUUID().toString().substring(0, 5);
        this.numero_artigos = 0;
    }

    public encomendas(encomendas e) {
        this.nome = e.getNome();
        this.data_de_criacao = getData();
        this.dimensao = e.getDimensao();
        this.estado = e.getEstado();
        this.artigos = e.getArtigos();
        this.preco = e.getPreco();
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String cod) {
        this.codigo = cod;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String n) {
        this.nome = n;
    }

    public int getNartigos() {
        return this.numero_artigos;
    }

    public void setNartigos(int n) {
        this.numero_artigos = n;
    }

    public LocalDate getData() {
        return this.data_de_criacao;
    }

    public void setData(LocalDate d) {
        this.data_de_criacao = d;
    }

    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double p) {
        this.preco = p;
    }

    public Dimensao getDimensao() {
        return this.dimensao;
    }

    public void setDimensao(Dimensao d) {
        this.dimensao = d;
    }

    public Estado getEstado() {
        return this.estado;
    }

    public void setEstado(Estado es) {
        this.estado = es;
    }

    public ArrayList<artigos> getArtigos() {
        return this.artigos;
    }

    public void setArtigos(ArrayList<artigos> a) {
        this.artigos = a;
    }

    public double calculaPreco(ArrayList<artigos> a) {
        double res = 0;
        int novos = 0;
        int usados = 0;
        double pre = 0;
        for (artigos art : a) {
            res += art.getPreco();

            pre += (art.getPreco() * (0.01 * art.getTransportadora().getTaxa() + 1) * (1 + 0.10)); /*
                                                                                                    * Sendo 10% imposto
                                                                                                    */
            if (art.getEstado()) {
                novos++;
            } else {
                usados++;
            }
        }
        pre = (pre + (0.5 * novos) + (0.25 * usados)) * 0.9;
        this.preco = pre;
        return res;
    }

    public Dimensao calculaDimensao(int size) {
        if (size < 2) {
            return Dimensao.Pequena;
        } else if (size >= 2 && size <= 5) {
            return Dimensao.Média;
        } else {
            return Dimensao.Grande;
        }
    }

    public void addArtigo(artigos novoArtigo) {
        artigos.add(novoArtigo);
        this.numero_artigos++;
    }

    public void removeArtigo(artigos art) {
        artigos.remove(art);
        this.numero_artigos--;
    }

    public String imprimeArtigos(ArrayList<artigos> art) {
        int index = 1;
        StringBuilder sb = new StringBuilder();
        for (artigos artigo : this.artigos) {
            sb.append(index + ") ").append(artigo.toString()).append("\n");
            index++;
        }
        return sb.toString();
    }

    public String getArtigosLista() {
        StringBuilder sb = new StringBuilder();
        for (artigos a : this.artigos) {
            sb.append(colors.YELLOW + "\n- " + colors.RESET + a.getTipo() + colors.YELLOW + " da " + colors.RESET
                    + a.getMarca());
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        df.setMinimumFractionDigits(2);
        StringBuilder sb = new StringBuilder();
        sb.append(colors.RESET + "Encomenda " + colors.GREEN).append(calculaDimensao(this.numero_artigos))
                .append(colors.RESET + " feita em: " + colors.GREEN).append(this.data_de_criacao)
                .append(colors.RESET + " por: " + colors.BLUE).append(this.nome)
                .append("." + colors.GREEN + "\nEstado: " + colors.RESET).append(this.estado)
                .append(colors.GREEN + "\nCusto base (sem impostos e taxas): " + colors.RESET)
                .append(df.format(calculaPreco(this.artigos))).append(" EUR")
                .append(colors.GREEN + "\nCusto: " + colors.RESET).append(df.format(this.preco)).append(" EUR")
                .append(colors.BLUE + "\nArtigos:\n" + colors.RESET).append(imprimeArtigos(this.artigos));
        return sb.toString();
    }
}
