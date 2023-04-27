package vintage;

import java.util.HashSet;
import java.util.Set;

public class gestortransportadoras {
    private Set<transportadora> transportadoras;
    private int counter;

    public gestortransportadoras() {
        this.transportadoras = new HashSet<>();
        this.counter = 0;
    }

    public gestortransportadoras(Set<transportadora> transportadoras) {
        this.transportadoras = transportadoras;
        this.counter = transportadoras.size();
    }

    public gestortransportadoras(gestortransportadoras gestorTrans) {
        this.transportadoras = new HashSet<>(gestorTrans.getTransportadora());
        this.counter = gestorTrans.getCounter();
    }

    public Set<transportadora> getTransportadora() {
        return this.transportadoras;
    }

    public void setTransportadora(Set<transportadora> transportadoras){
        this.transportadoras = transportadoras;
    }

    public int getCounter() {
        return this.counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void adicionarTransportadora(transportadora t) {
        this.transportadoras.add(t);
        this.counter++;
    }

    public void removerTransportadora(transportadora t) {
        this.transportadoras.remove(t);
        this.counter--;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int index = 1;
        for(transportadora t : this.transportadoras){
            sb.append(colors.BLUE + index + ") " + colors.YELLOW + t.getNome() +
            "\n" + colors.GREEN + "Taxa de expedição: " + colors.RESET + t.getTaxa() + "\n\n");
            index++;
        }
        return sb.toString();
    }

    public transportadora getTransportadorabyIndex(int index) {
        if (index-1 >= 0 && index-1 < counter) {
            return transportadoras.toArray(new transportadora[0])[index-1];
        }
        return null;
    }
}
