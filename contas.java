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
        sb.append("Contas:\n");
        for (Map.Entry<String, utilizadores> entry : contas.entrySet()) {
            String key = entry.getKey();
            utilizadores conta = entry.getValue();
            sb.append(key).append("=").append(conta.getNome()).append("\n");
            sb.append("Email: ").append(conta.getEmail()).append("\n");
            sb.append("Morada: ").append(conta.getMorada()).append("\n");
            sb.append("Número Fiscal: ").append(conta.getFiscal()).append("\n.\n");
        }
        return sb.toString();
    }
    public boolean existeEmail(String s){
        return this.contas.entrySet().stream().anyMatch(a->s.equals(a.getValue().getEmail()));
    }
}
