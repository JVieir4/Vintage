package vintage;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Set;

public class gestorencomendas {
    private Set<encomendas> encomendas;
    private int counter;
    DecimalFormat df = new DecimalFormat("#.##");

    public gestorencomendas() {
        this.encomendas = new HashSet<>();
        this.counter = 0;
    }

    public gestorencomendas(Set<encomendas> encomendas) {
        this.encomendas = encomendas;
        this.counter = encomendas.size();
    }

    public gestorencomendas(gestorencomendas gestorEncs) {
        this.encomendas = new HashSet<>(gestorEncs.getEncomendas());
        this.counter = gestorEncs.getCounter();
    }

    public Set<encomendas> getEncomendas() {
        return this.encomendas;
    }

    public void setEncomendas(Set<encomendas> encomendas) {
        this.encomendas = encomendas;
    }

    public int getCounter() {
        return this.counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void adicionarEncomenda(encomendas encomenda) {
        if(!this.encomendas.contains(encomenda)){
            this.counter++;
        }
        this.encomendas.add(encomenda);
    }

    public void removerEncomenda(encomendas encomenda) {
        this.encomendas.remove(encomenda);
        this.counter--;
    }

    @Override
    public String toString() {
        df.setMinimumFractionDigits(2);
        StringBuilder sb = new StringBuilder(colors.BLUE + "Encomendas:\n");
        for(encomendas e : this.encomendas){
            sb.append(colors.GREEN + e.calculaDimensao(e.getArtigos().size()))
            .append(colors.RESET + " feita em: " + colors.GREEN).append(e.getData())
            .append(colors.RESET + " por: " + colors.BLUE).append(e.getNome())
            .append("." + colors.GREEN + "\nEstado: " + colors.RESET).append(e.getEstado());
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
}

