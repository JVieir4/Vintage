package vintage.src;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class gestortransportadoras {
    private ArrayList<transportadora> transportadoras;
    private int counter;
    DecimalFormat df = new DecimalFormat("#");

    public gestortransportadoras() {
        this.transportadoras = new ArrayList<transportadora>();
        this.counter = 0;
    }

    public gestortransportadoras(ArrayList<transportadora> transportadoras) {
        this.transportadoras = transportadoras;
        this.counter = transportadoras.size();
    }

    public ArrayList<transportadora> getTransportadora() {
        return this.transportadoras;
    }

    public void setTransportadora(ArrayList<transportadora> transportadoras) {
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

    public String imprime(boolean prem) {
        StringBuilder sb = new StringBuilder();
        int index = 1;
        for (transportadora t : this.transportadoras) {
            if (prem && t.getPremium()) {
                sb.append(colors.BLUE + index + ") " + colors.YELLOW + t.getNome() +
                        "\n" + colors.GREEN + "Taxa de expedição: " + colors.RESET + df.format(t.getTaxa()) + "%\n\n");
                index++;
            } else if (!prem) {
                sb.append(colors.BLUE + index + ") " + colors.YELLOW + t.getNome() +
                        "\n" + colors.GREEN + "Taxa de expedição: " + colors.RESET + df.format(t.getTaxa()) + "%\n\n");
                index++;
            }
        }
        return sb.toString();
    }

    public transportadora getTransportadorabyIndex(int index) {
        if (index - 1 >= 0 && index - 1 < counter) {
            return transportadoras.get(index - 1);
        }
        return null;
    }

    public String melhorTransportadora(contas x) {
        transportadora melhor = null;
        double maximo = 0;
        for (transportadora t : this.transportadoras) {
            double temp = x.maiorLucroTransportadora(t.getNome());
            if (temp > maximo) {
                melhor = t;
                maximo = temp;
            }
        }
        if (melhor == null) {
            return "N/A";
        }
        return melhor.getNome();
    }

    public int getNotPremiumCounter() {
        int n = 0;
        for (transportadora t : this.transportadoras) {
            if (!t.getPremium()) {
                n++;
            }
        }
        return n;
    }
}
