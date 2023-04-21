package vintage;

public class mainV {   
    public static void main(String[] args) throws CloneNotSupportedException{
        sapatilhas A = new sapatilhas(false, 40, true, "azul", 2020);
        artigos artS = new artigos(A, false, 1, "sapatilhas fixes", "Nike", "A1B2C3", 19.99);
        tshirts B = new tshirts(Tamanho.M, Padroes.Liso);
        artigos artT = new artigos(B, true, 0, "T-Shirt fixe", "Tiffosi", "A0B0C0", 9.99);
        malas C = new malas(true, 30, 32, "Policarbonato", 2008);
        artigos artM = new artigos(C, false, 2, "Mala fixe", "Samsonite", "A1A1A1", 49.99);
        
        utilizadores eu = new utilizadores("aaa", "Vieira", "Rua Teste", 123);
        utilizadores tu = new utilizadores("abc@teste.com", "Calafate", "Avenida Teste", 456);
        
        eu.listarArtigo(artS);
        eu.listarArtigo(artM);
        tu.listarArtigo(artT);
        contas x = new contas();
        x.addConta(eu);
        x.addConta(tu);
        controlo.run(x, true);
    }
}