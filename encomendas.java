package vintage;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;

public class encomendas {
    private String nome;
    private Dimensao dimensao;
    private Estado estado;
    private double preco;
    private LocalDate data_de_criacao;
    ArrayList<artigos> artigos;
    DecimalFormat df = new DecimalFormat("#.##");

    enum Dimensao{
        Grande,
        Média,
        Pequena
    }
    enum Estado{
        Pendente,
        Finalizada,
        Expedida
    }

    public encomendas(String name){
        this.nome = name;
        this.artigos = new ArrayList<>();
        this.estado = Estado.Pendente;
        this.data_de_criacao = LocalDate.of(2023, 4, 22);
    }

    public encomendas(encomendas e){
        this.dimensao = e.getDimensao();
        this.estado = e.getEstado();
        this.artigos = e.getArtigos();
        this.preco = e.getPreco();
    }

    public double getPreco() {
        return this.preco;
    }
    public void setPreco(double p){
        this.preco = p;
    }

    public Dimensao getDimensao() {
        return this.dimensao;
    }
    public void setDimensao(Dimensao d){
        this.dimensao = d;
    }

    public Estado getEstado() {
        return this.estado;
    }
    public void setEstado(Estado es){
        this.estado = es;
    }

    public ArrayList<artigos> getArtigos(){
        return this.artigos;
    }
    public void setArtigos(ArrayList<artigos> a){
        this.artigos = a;
    }

    public double calculaPreco(ArrayList<artigos> a){
        double res = 0;
        int novos = 0;
        int usados = 0;
        for(artigos art : a){
            res += art.CalculaPreço();
            if(art.getEstado()){
                novos++;
            }
            else{
                usados++;
            }
        }
        return res + (0.5*novos) + (0.25*usados) /* + art.getTransportadora().getTaxaExp() */;
    }

    public Dimensao calculaDimensao(int size){
        if(size < 2){
            return Dimensao.Pequena;
        }
        else if(size >= 2 && size <= 5){
            return Dimensao.Média;
        }
        else{
            return Dimensao.Grande;
        }
    }

    public void addArtigo(artigos novoArtigo) {
        artigos.add(novoArtigo);
    }

    public void removeArtigo(artigos art){
        artigos.remove(art);
    }

    public String imprimeArtigos(ArrayList<artigos> art){
        int index = 1;
        StringBuilder sb = new StringBuilder();
        for (artigos artigo : this.artigos) {
            sb.append(index + ") ").append(artigo.toString()).append("\n");
            index++;
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(colors.RESET + "Encomenda " + colors.GREEN).append(calculaDimensao(this.artigos.size()))
          .append(colors.RESET + " feita em: " + colors.GREEN).append(this.data_de_criacao)
          .append(colors.RESET + " por: " + colors.BLUE).append(this.nome)
          .append("." + colors.GREEN + "\nEstado: " + colors.RESET).append(this.estado)
          .append(colors.GREEN + "\nCusto: " + colors.RESET).append(df.format(calculaPreco(this.artigos)))
          .append(colors.BLUE + "\nArtigos:\n" + colors.RESET).append(imprimeArtigos(this.artigos));
        return sb.toString();
    }
}
