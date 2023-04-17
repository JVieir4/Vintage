package vintage;

import java.util.HashMap;
import java.util.Map;

public class contas {
    private Map<String,utilizadores> contas;

    public contas(){
        this.contas = new HashMap<>();
    }

    public contas(Map<String,utilizadores> c){
        this.setContas(c);
    }

    public contas(contas c){
        this.contas = c.getContas();
    }

    private Map<String, utilizadores> getContas() {
        return this.contas;
    }

    public void setContas(Map<String,utilizadores> c){
        this.contas = c;
    }

    public void addConta (utilizadores conta) {
        this.contas.put(conta.getCode(), conta.clone());
    }

    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("Contas:\n").append(contas.toString()).append('\n');
        return sb.toString();
    }

    public boolean existeEmail(String s){
        return this.contas.entrySet().stream().anyMatch(a->s.equals(a.getValue().getEmail()));
    }
}
