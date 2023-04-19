package Vintage;

import java.util.ArrayList;

public class encomendas {
    private Dimensao dimensao;
    private Estado estado;
    ArrayList<artigos> artigos;

    enum Dimensao{
        grande,
        medio,
        pequeno
    }
    enum Estado{
        pendente,
        expedida,
        enviada
    }

    public encomendas(Dimensao dimensao, Estado estado, ArrayList<artigos> artigos){
        this.dimensao = dimensao;
        this.estado = estado;
        this.artigos = artigos;
    }

    public encomendas( encomendas e){
        this.dimensao = e.getDimensao();
        this.estado = e.getEstado();
        this.artigos = e.getArtigos();
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

}
