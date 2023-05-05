package vintage;

import java.util.ArrayList;
import java.util.Iterator;

import vintage.encomendas.Estado;

public class utilizadores implements Cloneable {
    private String systemcode;
    private String email;
    private String password;
    private String nome;
    private String morada;
    private int nfiscal;
    private double lucro = 0;
    private double prejuizo = 0;
    private ArrayList<encomendas> encomendas;
    private ArrayList<encomendas> pendentes;
    private ArrayList<artigos> artavenda = new ArrayList<>();
    private ArrayList<artigos> artvendidos = new ArrayList<>();
    private ArrayList<artigos> artcomprados = new ArrayList<>();

    public utilizadores(String mail, String pass, String name, String address, int fiscal) {
        this.email = mail;
        this.password = pass;
        this.nome = name;
        this.morada = address;
        this.nfiscal = fiscal;
        this.encomendas = new ArrayList<encomendas>();
        this.pendentes = new ArrayList<encomendas>();
    }

    public utilizadores(utilizadores novo) {
        this.systemcode = novo.getCode();
        this.password = novo.getPassword();
        this.email = novo.getEmail();
        this.nome = novo.getNome();
        this.morada = novo.getMorada();
        this.nfiscal = novo.getFiscal();
    }

    public double getLucro() {
        return this.lucro;
    }

    public void setLucro(double l) {
        this.lucro = l;
    }

    public double getPrejuizo() {
        return this.prejuizo;
    }

    public void setPrejuizo(double p) {
        this.prejuizo = p;
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

    public ArrayList<encomendas> getPendentes() {
        return this.pendentes;
    }

    public void setPendentes(ArrayList<encomendas> p) {
        this.pendentes = p;
    }

    public encomendas getCarrinho() {
        if (encomendas.isEmpty() || encomendas.get(encomendas.size() - 1).getEstado() != Estado.Pendente) {
            encomendas newEncomenda = new encomendas(this.nome);
            newEncomenda.setEstado(Estado.Pendente);
            encomendas.add(newEncomenda);
        }
        return encomendas.get(encomendas.size() - 1);
    }

    public void listarArtigo(artigos A) {
        artavenda.add(A);
    }

    @Override
    public utilizadores clone() throws CloneNotSupportedException {
        utilizadores clone = (utilizadores) super.clone();
        clone.artavenda = new ArrayList<>(this.artavenda);
        return clone;
    }

    public void printListaArts(ArrayList<artigos> lista, String filtro) {
        int index = 1;
        System.out.println(colors.BLUE + "Artigos " + filtro + ":");
        for (artigos artigo : lista) {
            System.out.println(colors.BLUE + index + ") " + artigo + "\n");
            index++;
        }
    }

    public void artigoVendido() {
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
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
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

    public boolean carrinhotem(artigos art) {
        for (artigos a : getCarrinho().artigos) {
            if (a.equals(art)) {
                return true;
            }
        }
        return false;
    }

    public double getTotalVendas() {
        double total = 0;
        for (artigos art : this.artvendidos) {
            total += art.getPreco();
        }
        return total;
    }

    public double getTotalComprado() {
        double total = 0;
        for (artigos art : this.artcomprados) {
            total += art.getPreco();
        }
        return total;
    }

    public String imprimePendentes() {
        int index = 1;
        StringBuilder sb = new StringBuilder(
                colors.BLUE + "Encomendas pendentes: (Tem 48h para as cancelar, antes da expedição)\n\n");
        for (encomendas e : this.pendentes) {
            sb.append(colors.BLUE + index + ") " + colors.GREEN + e.calculaDimensao(e.getNartigos()))
                    .append(colors.RESET + " feita em: " + colors.GREEN).append(e.getData())
                    .append(colors.GREEN + "\nArtigos: " + colors.RESET + e.getArtigosLista() + "\n\n");
            index++;
        }
        return sb.toString();
    }
}
