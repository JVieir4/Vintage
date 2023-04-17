package vintage;

public class mainV {   
    public static void main(String[] args){
        sapatilhas A = new sapatilhas(false, 40, true, "azul", 2020);
        artigos artS = new artigos(A, false, 1, "sapatilhas fixes", "Nike", "A1B2C3", 19.99, 0);
        //System.out.println(artS + "\n");
         
        tshirts B = new tshirts(Tamanho.M, Padroes.Liso);
        artigos artT = new artigos(B, true, 0, "T-Shirt fixe", "Tiffosi", "A0B0C0", 9.99, 0);
        /*
        System.out.println(artT + "\n");
        malas C = new malas(true, 30, 32, "Policarbonato", 2008);
        artigos artM = new artigos(C, false, 2, "Mala fixe", "Samsonite", "A1A1A1", 49.99, 0);
        System.out.println(artM);
         */
        
        utilizadores eu = new utilizadores("u001", "teste@abc.com", "Vieira", "rua teste", 123);
        eu.listarArtigo(artS);
        eu.listarArtigo(artT);
        contas x = new contas();
        x.addConta(eu);
        System.out.println(x);
        //eu.imprime(eu.art_a_venda);
    }
}
