package vintage;

public class mainV {   
    public static void main(String[] args){
        sapatilhas A = new sapatilhas(false, 40, true, "azul", 2020);
        artigos artS = new artigos(A, false, 1, "sapatilhas fixes", "Nike", "A1B2C3", 19.99, 0);
        tshirts B = new tshirts(Tamanho.M, Padroes.Liso);
        artigos artT = new artigos(B, true, 0, "T-Shirt fixe", "Tiffosi", "A0B0C0", 9.99, 0);
        malas C = new malas(true, 30, 32, "Policarbonato", 2008);
        artigos artM = new artigos(C, false, 2, "Mala fixe", "Samsonite", "A1A1A1", 49.99, 0);
        
        utilizadores eu = new utilizadores("u001", "aaa", "Vieira", "Rua Teste", 123);
        utilizadores tu = new utilizadores("u002", "abc@teste.com", "Calafate", "Avenida Teste", 456);
        
        eu.listarArtigo(artS);
        eu.listarArtigo(artM);
        tu.listarArtigo(artT);
        contas x = new contas();
        x.addConta(eu);
        x.addConta(tu);
        //System.out.println(x);
        //eu.imprime(eu.art_a_venda);
        //vintage.MenuInicial();
        //x.getUtilizadores("aaa");
        controlo.run(x);
    }
}
