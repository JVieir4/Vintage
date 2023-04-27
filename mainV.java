package vintage;

public class mainV {   
    public static void main(String[] args) throws CloneNotSupportedException{
        /* Transportadoras */
        transportadora amazon = new transportadora("Amazon", 1.25);
        transportadora OLX = new transportadora("OLX", 1.15);
        //nova

        /* Artigos (4 sapatilhas, 4 tshirts, 4 malas, 3 outros */
        sapatilhas A = new sapatilhas(false, 40, true, "azul", 2020);
        artigos artS = new artigos(A, false, 1, "sapatilhas fixes", "Nike", "A1B2C3", 19.99, amazon);
        tshirts B = new tshirts(Tamanho.M, Padroes.Liso);
        artigos artT = new artigos(B, true, 0, "T-Shirt fixe", "Tiffosi", "A0B0C0", 9.99, amazon);
        malas C = new malas(true, 30, 32, "Policarbonato", 2008);
        artigos artM = new artigos(C, false, 2, "Mala fixe", "Samsonite", "A1A1A1", 49.99, OLX);
        //novo
        //novo
        //novo
        //novo
        //...

        /* Utilizadores */
        utilizadores eu = new utilizadores("aaa","pass", "Vieira", "Rua Teste", 123456789);
        utilizadores tu = new utilizadores("abc@teste.com","abc", "Calafate", "Avenida Teste", 987654321);
        //novo


        /* Listar artigos nos diferentes utilizadores */
        eu.listarArtigo(artS);
        eu.listarArtigo(artM);
        tu.listarArtigo(artT);

        /* Contas */
        contas x = new contas();
        x.addConta(eu);
        x.addConta(tu);

        /* Encomendas */
        gestorencomendas ge = new gestorencomendas();

        /* Transportadoras */
        gestortransportadoras gt = new gestortransportadoras();
        gt.adicionarTransportadora(OLX);
        gt.adicionarTransportadora(amazon);

        /* Correr */
        controlo.run(x, ge, gt, true);
    }
}