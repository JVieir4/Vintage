package vintage;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Set;

import vintage.encomendas.Estado;

public class gestorencomendas {
    private Set<encomendas> encomendas;
    DecimalFormat df = new DecimalFormat("#.##");

    public gestorencomendas() {
        this.encomendas = new HashSet<>();
    }

    public gestorencomendas(Set<encomendas> encomendas) {
        this.encomendas = encomendas;
    }

    public gestorencomendas(gestorencomendas gestorEncs) {
        this.encomendas = new HashSet<>(gestorEncs.getEncomendas());
    }

    public Set<encomendas> getEncomendas() {
        return this.encomendas;
    }

    public void setEncomendas(Set<encomendas> encomendas) {
        this.encomendas = encomendas;
    }

    public void adicionarEncomenda(encomendas encomenda) {
        this.encomendas.add(encomenda);
    }

    public void removerEncomenda(encomendas encomenda) {
        this.encomendas.remove(encomenda);
    }

    @Override
    public String toString() {
        df.setMinimumFractionDigits(2);
        StringBuilder sb = new StringBuilder(colors.BLUE + "Encomendas:\n");
        for(encomendas e : this.encomendas){
            if(e.getNartigos() < 1){ continue;}
            sb.append(colors.GREEN + e.calculaDimensao(e.getNartigos()))
            .append(colors.RESET + " feita em: " + colors.GREEN).append(e.getData())
            .append(colors.RESET + " por: " + colors.BLUE).append(e.getNome())
            .append("." + colors.GREEN + "\nEstado: " + colors.RESET).append(e.getEstado())
            .append(colors.GREEN + "\nArtigos: " + colors.RESET + e.getNartigos() + "\n");
        }
        return sb.toString();
    }

    public double lucroTotal() {
        double lucro = 0;
        for(encomendas e: this.encomendas){
            lucro += e.getPreco();
        }
        return lucro;
    }

    public void concluirEncomenda(utilizadores u){
        encomendas nova = new encomendas(u.getNome());
        nova = u.getCarrinho();
        nova.setEstado(Estado.Finalizada);
        encomendas.add(nova);
    }
}

