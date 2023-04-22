package vintage;

import java.util.HashSet;
import java.util.Set;

public class gestorencomendas {
    private Set<encomendas> encomendas;
    private int counter;

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
        this.encomendas.add(encomenda);
        this.counter++;
    }

    public void removerEncomenda(encomendas encomenda) {
        this.encomendas.remove(encomenda);
        this.counter--;
    }

    @Override
    public String toString() {
        return "gestorencomendas{" +
                "encomendas=" + this.encomendas +
                ", counter=" + this.counter +
                '}';
    }
}

