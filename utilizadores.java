package vintage;

import java.util.ArrayList;

public class utilizadores implements Cloneable {
    private String systemcode;
    private String email;
    private String nome;
    private String morada;
    private int nfiscal;
    private ArrayList<artigos> artavenda = new ArrayList<>();
    private ArrayList<artigos> artvendidos = new ArrayList<>();
    private ArrayList<artigos> artcomprados = new ArrayList<>();

    public utilizadores(String code, String mail, String name, String address, int fiscal){
        this.systemcode = code;
        this.email = mail;
        this.nome = name;
        this.morada = address;
        this.nfiscal = fiscal;
    }

    public utilizadores(utilizadores novo){
        this.systemcode = novo.getCode();
        this.email = novo.getEmail();
        this.nome = novo.getNome();
        this.morada = novo.getMorada();
        this.nfiscal = novo.getFiscal();
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

    public void listarArtigo(artigos A){
        artavenda.add(A);
    }

    public void comprarArtigo(){
        /* Função para comprar um artigo
         * Esta função mostra uma lista dos artigos disponíveis
         * E esse mesmo artigo é colocado na lista art_comprados;
         */
    }

    @Override
    public utilizadores clone() throws CloneNotSupportedException {
        utilizadores clone = (utilizadores) super.clone();
        clone.artavenda = new ArrayList<>(this.artavenda);
        return clone;
    }

    @Override
    public String toString(){
        return this.nome + "\nEmail: " + this.email + "\nMorada: " + this.morada + "\nNúmero Fiscal: " + this.nfiscal;
    }
}
