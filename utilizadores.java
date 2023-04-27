package vintage;

import java.util.ArrayList;
import java.util.Iterator;

public class utilizadores implements Cloneable {
    private String systemcode;
    private String email;
    private String password;
    private String nome;
    private String morada;
    private int nfiscal;
    private encomendas carrinho;
    private ArrayList<artigos> artavenda = new ArrayList<>();
    private ArrayList<artigos> artvendidos = new ArrayList<>();
    private ArrayList<artigos> artcomprados = new ArrayList<>();

    public utilizadores( String mail,String pass, String name, String address, int fiscal){
        this.email = mail;
        this.password = pass;
        this.nome = name;
        this.morada = address;
        this.nfiscal = fiscal;
        this.carrinho = new encomendas(this.nome);
    }

    public utilizadores(utilizadores novo){
        this.systemcode = novo.getCode();
        this.password = novo.getPassword();
        this.email = novo.getEmail();
        this.nome = novo.getNome();
        this.morada = novo.getMorada();
        this.nfiscal = novo.getFiscal();
    }

    public String getPassword() {
        return this.password;
    }
    public void setPassword(String p) {
        this.password = p;
    }

    public int getFiscal() {
        return this.nfiscal;
    }
    public void setFiscal(int f) {
        this.nfiscal = f;
    }

    public String getMorada() {
        return this.morada;
    }
    public void setMorada(String m) {
        this.morada = m;
    }

    public String getNome() {
        return this.nome;
    }
    public void setNome(String n) {
        this.nome = n;
    }

    public String getEmail() {
        return this.email;
    }
    public void setEmail(String mail) {
        this.email = mail;
    }

    public String getCode() {
        return this.systemcode;
    }
    public void setCode(String c) {
        this.systemcode = c;
    }

    public ArrayList<artigos> getArtAVenda() {
        return this.artavenda;
    }
    public void setArtAVenda(ArrayList<artigos> a) {
        this.artavenda = a;
    }

    public ArrayList<artigos> getArtVendidos() {
        return this.artvendidos;
    }
    public void setArtVendidos(ArrayList<artigos> a) {
        this.artvendidos = a;
    }

    public ArrayList<artigos> getArtComprados() {
        return this.artcomprados;
    }
    public void setArtComprados(ArrayList<artigos> a) {
        this.artcomprados = a;
    }

    public encomendas getCarrinho() {
        return this.carrinho;
    }
    public void setCarrinho(encomendas c){
        this.carrinho = c;
    }

    public void listarArtigo(artigos A){
        artavenda.add(A);
    }


    @Override
    public utilizadores clone() throws CloneNotSupportedException {
        utilizadores clone = (utilizadores) super.clone();
        clone.artavenda = new ArrayList<>(this.artavenda);
        return clone;
    }

    public void printArtavenda() {
        System.out.println(colors.BLUE + "Artigos à venda:");
        for (artigos artigo : artavenda) {
            System.out.println(artigo);
            System.out.println();
        }
    }

    public void printArtVendidos() {
        System.out.println(colors.BLUE + "Artigos vendidos:");
        for (artigos artigo : artvendidos) {
            System.out.println(artigo);
            System.out.println();
        }
    }

    public void printArtComprados() {
        System.out.println(colors.BLUE + "Artigos comprados:");
        for (artigos artigo : artcomprados) {
            System.out.println(artigo);
            System.out.println();
        }
    }

    public void artigoVendido(){
        Iterator<artigos> iterator = artavenda.iterator();
        while (iterator.hasNext()) {
            artigos art = iterator.next();
            if (!art.getDisponivel()) {
                iterator.remove();
                artvendidos.add(art);
            }
        }
    }

    public boolean equals(Object obj) {
        if(obj==this) 
           return true;
        if(obj==null || obj.getClass() != this.getClass()) 
           return false;
        utilizadores u = (utilizadores) obj;
        return u.getCode().equals(this.getCode()) &&
            u.getEmail().equals(this.getEmail()) &&
            u.getFiscal() == this.getFiscal() &&
            u.getMorada().equals(this.getMorada()) &&
            u.getNome().equals(this.getNome()) &&
            u.getPassword().equals(this.getPassword()) &&
            u.getArtAVenda().equals(this.getArtAVenda()) &&
            u.getArtComprados().equals(this.getArtComprados()) &&
            u.getArtVendidos().equals(this.getArtVendidos());
    }

    public boolean carrinhotem(artigos art){
        for(artigos a: carrinho.artigos){
            if(a.equals(art)){
                return true;
            }
        }
        return false;
    }
}
