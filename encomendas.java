package vintage;

import java.time.LocalDate;
import java.util.ArrayList;

public class encomendas {
    private Dimensao dimensao;
    private Estado estado;
    private double preco;
    private LocalDate data_de_criacao;
    ArrayList<artigos> artigos;

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

    public encomendas(){
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
        return res + (0.5*novos) + (0.25*usados) /* + taxa de expedição */;
    }

    public Dimensao calculaDimensao(int size){
        if(size < 5){
            return Dimensao.Pequena;
        }
        else if(size >= 5 && size <= 10){
            return Dimensao.Média;
        }
        else{
            return Dimensao.Grande;
        }
    }

    public void addArtigo(artigos novoArtigo) {
        artigos.add(novoArtigo);
    }

    @Override
    public String toString(){
        return "Encomenda " + this.dimensao + " feita em: " + this.data_de_criacao + ".\nEstado: " + this.estado +
        "\nCusto: " + this.preco + "\nArtigos:\n" + this.artigos;
    }
}
