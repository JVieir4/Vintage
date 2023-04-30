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

    public Map<Integer, artigos> Stock(utilizadores u) {
        Map<Integer, artigos> artigosMap = new HashMap<>();
        int index = 0;
        for (utilizadores util : contas.values()) {
            if (util.equals(u)) {
                continue;
            }
            ArrayList<artigos> artavenda = util.getArtAVenda();
            for (int i = 0; i < artavenda.size(); i++) {
                artigosMap.put(i + 1 + index, artavenda.get(i));
            }
            index += artavenda.size();
        }
        return artigosMap;
    }

    public void removeFromArtavenda(Map<Integer, artigos> TodosArtigos, int index) {
        for (utilizadores util : contas.values()) {
            ArrayList<artigos> artavenda = util.getArtAVenda();
            for (artigos art : artavenda) {
                if (art.getCodigo() == TodosArtigos.get(index).getCodigo()) {
                    artavenda.remove(art);
                    return;
                }
            }
        }
    }

    public void artigoVendidoForAll(){
        for(utilizadores u: contas.values()){
            u.artigoVendido();
        }
    }
    
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append(colors.YELLOW + "Contas:\n");
        contas.keySet().stream().sorted().forEach(key -> {
            utilizadores conta = contas.get(key);
            sb.append(colors.GREEN + key).append("=\t\t" + colors.RESET).append(conta.getNome()).append("\n");
            sb.append(colors.GREEN + "Email: " + "\t\t" + colors.RESET).append(conta.getEmail()).append("\n");
            sb.append(colors.GREEN +"Morada: " + "\t" + colors.RESET).append(conta.getMorada()).append("\n");
            sb.append(colors.GREEN + "Número Fiscal: " + "\t" + colors.RESET).append(conta.getFiscal()).append("\n\n");
        });
        return sb.toString();
    }

    public String melhorVendedor() {
        utilizadores maior = null;
        double maximo = 0;
        for(utilizadores u : contas.values()){
            double temp = 0;
            for(artigos art: u.getArtVendidos()){
                temp += art.getPreco();
            }
            if(temp > maximo){
                maior = u;
                maximo = temp;
            }
        }
        if(maior == null){
            return "N/A";
        }
        return maior.getNome();
    }

    public double maiorLucroTransportadora(String nome_transportadora){
        double lucro = 0;
        for(utilizadores u: contas.values()){
            for(artigos art: u.getArtVendidos()){
                if(art.getTransportadora().getNome().equals(nome_transportadora)){
                    lucro += ((art.getPreco() * art.getTransportadora().getTaxa()) - art.getPreco());
                }
                else{
                    continue;
                }
            }
        }
        return lucro;
    }
}
