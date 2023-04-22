package vintage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class contas {
    private Map<String,utilizadores> contas;
    private int utilcounter;

    public contas(){
        this.contas = new HashMap<>();
        utilcounter = 0;
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

    public void addConta (utilizadores conta) throws CloneNotSupportedException {
        String code = generateCode();
        conta.setCode(code);
        this.contas.put(conta.getCode(), conta.clone());
    }

    private String generateCode() {
        utilcounter++;
        String code = "u" + String.format("%03d", utilcounter);
        return code;
    }

    public void deleteConta(String email) {
        String keyToRemove = null;
        for (Map.Entry<String, utilizadores> entry : this.contas.entrySet()) {
            utilizadores util = entry.getValue();
            if (email.equals(util.getEmail())) {
                keyToRemove = entry.getKey();
                break;
            }
        }
        if (keyToRemove != null) {
            this.contas.remove(keyToRemove);
        }
    }

    public utilizadores getUtilizadores(String mail){
        for (Map.Entry<String, utilizadores> entry : contas.entrySet()) {
            utilizadores util = entry.getValue();
            if (mail.equals(util.getEmail())){
                return util;
            }
        }
        return null;
    }

    public boolean existeEmail(String s){
        return this.contas.entrySet().stream().anyMatch(a->s.equals(a.getValue().getEmail()));
    }

    public Map<Integer, artigos> printStock(utilizadores u) {
        Map<Integer, artigos> artigosMap = new HashMap<>();
        int index = 0;
        for (utilizadores util : contas.values()) {
            if (util.equals(u)) {
                continue; // Skip the given utilizadores u
            }
            System.out.println("Username: " + util.getNome());
            ArrayList<artigos> artavenda = util.getArtAVenda();
            System.out.println("Artigos à venda:");
            for (int i = 0; i < artavenda.size(); i++) {
                System.out.println((i + 1 + index) + ". " + artavenda.get(i));
                artigosMap.put(i + 1 + index, artavenda.get(i)); // Add index and artigos object to map
                System.out.println();
            }
            index += artavenda.size();
            System.out.println("------------");
        }
        return artigosMap;
    }

    public void removeFromArtavenda(Map<Integer, artigos> TodosArtigos, int index) {
        for (utilizadores util : contas.values()) {
            ArrayList<artigos> artavenda = util.getArtAVenda();
            for (artigos art : artavenda) {
                if (art.getCodigo() == TodosArtigos.get(index).getCodigo()) {
                    artavenda.remove(art);
                    return; // assuming each artigos object has a unique codigo, remove and exit loop
                }
            }
        }
    }
    
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("Contas:\n");
        contas.keySet().stream().sorted().forEach(key -> {
            utilizadores conta = contas.get(key);
            sb.append(key).append("=").append(conta.getNome()).append("\n");
            sb.append("Email: ").append(conta.getEmail()).append("\n");
            sb.append("Morada: ").append(conta.getMorada()).append("\n");
            sb.append("Número Fiscal: ").append(conta.getFiscal()).append("\n.\n");
        });
        return sb.toString();
    }

}
