package vintage;

public class mainV {   
    public static void main(String[] args) throws CloneNotSupportedException{
        transportadora amazon = new transportadora("Amazon", 1.25);
        transportadora OLX = new transportadora("OLX", 0.50);
        sapatilhas A = new sapatilhas(false, 40, true, "azul", 2020);
        artigos artS = new artigos(A, false, 1, "sapatilhas fixes", "Nike", "A1B2C3", 19.99, amazon);
        tshirts B = new tshirts(Tamanho.M, Padroes.Liso);
        artigos artT = new artigos(B, true, 0, "T-Shirt fixe", "Tiffosi", "A0B0C0", 9.99, amazon);
        malas C = new malas(true, 30, 32, "Policarbonato", 2008);
        artigos artM = new artigos(C, false, 2, "Mala fixe", "Samsonite", "A1A1A1", 49.99, OLX);
        
        utilizadores eu = new utilizadores("aaa","pass", "Vieira", "Rua Teste", 123);
        utilizadores tu = new utilizadores("abc@teste.com","abc", "Calafate", "Avenida Teste", 456);
        
        eu.listarArtigo(artS);
        eu.listarArtigo(artM);
        tu.listarArtigo(artT);
        contas x = new contas();
        x.addConta(eu);
        x.addConta(tu);
        gestorencomendas ge = new gestorencomendas();
        gestortransportadoras gt = new gestortransportadoras();
        gt.adicionarTransportadora(OLX);
        gt.adicionarTransportadora(amazon);
        controlo.run(x, ge, gt, true);
    }
}