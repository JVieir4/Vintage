package vintage;

import vintage.artigos.Tipo;
public class mainV {   
    public static void main(String[] args) throws CloneNotSupportedException{
        /* Transportadoras */
        transportadora amazon = new transportadora("Amazon", 1.50);
        transportadora OLX = new transportadora("OLX", 1.15);
        transportadora DHL = new transportadora("DHL", 1.30);

        /* Artigos (4 sapatilhas, 4 tshirts, 4 malas, 3 outros */
        sapatilhas A = new sapatilhas(false, 40, true, "azul", 2020);
        artigos artS = new artigos(A, false, 1, "sapatilhas fixes", "Nike", "A1B2C3", 19.99, amazon);

        tshirts B = new tshirts(Tamanho.M, Padroes.Liso);
        artigos artT = new artigos(B, true, 0, "T-Shirt fixe", "Tiffosi", "A0B0C0", 9.99, amazon);

        malas C = new malas(true, 30, 32, "Policarbonato", 2008);
        artigos artM = new artigos(C, false, 2, "Mala fixe", "Samsonite", "A1A1A1", 49.99, OLX);

        sapatilhas D = new sapatilhas(true, 35, true,"rosa", 2012);
        artigos artS2 = new artigos(D, false, 3, "sapatilhas rosinhas", "Adidas", "A2B3C4", 60.00, DHL);

        tshirts E = new tshirts(Tamanho.L,Padroes.Palmeiras);
        artigos artT2 =new artigos(E, true, 1, "Palmeiras bonitas", "Gucci", "B2A5D1", 35.99, OLX);

        malas F = new malas(true,20,15,"Plastico", 2019);
        artigos artM2 = new artigos(F, false, 0, "Nunca Usada, e muito incrivel", "Prada", "F5A7D1", 1300.94, DHL);

        sapatilhas G = new sapatilhas(false, 39, true, "preto", 2022);
        artigos artS3 = new artigos(G, false, 1, "O preto é um bom contraste com o branco", "Veja", "A7A7A0", 50.99, amazon);

        tshirts H = new tshirts(Tamanho.XL,Padroes.Riscas);
        artigos artT3 = new artigos(H, true, 1, "Tshirt rosinha com um unicornio", "Brand Melvin", "A3S5E2", 18.99, DHL);

        malas I = new malas(false,50,59,"ganga",2023);
        artigos artM3 = new artigos(I, false, 0, "Novinho e stylish", "parfois", "A8A0D3", 40.60, amazon);

        sapatilhas J = new sapatilhas(true, 37, true, "branco", 2020);
        artigos artS4 = new artigos(J, false, 0, "Sapatilhas branquinhas sem nenhuma mancha", "Bufallo", "A5D1F9", 170.99, OLX);

        tshirts K = new tshirts(Tamanho.S,Padroes.Liso);
        artigos artT4 =new artigos(K, true, 12, "Perfeita tshirt para uma criança", "Adidas", "A7F6S6", 12.99, OLX);

        malas L = new malas(true, 25,29,"ABS", 2019);
        artigos artM4 = new artigos(L, false, 2, "Mala dourada perfeita para sair de casa", "Giorgio Armani", "A5S1G7", 570.99, DHL);

        artigos artO = new artigos(Tipo.Outro, false, 2, "Cartola bonita", "COOLHATS", "A5D7F2", 69.80, OLX);
        artigos artO2 = new artigos(Tipo.Outro, false, 0, "Casaco preto", "Zara", "G7S9Q1", 39.50, amazon);
        artigos artO3 = new artigos(Tipo.Outro, false, 1, "Calça beje com detalhes de lado", "SUITS", "G5A0F2", 25.99, DHL);
        //...

        /* Utilizadores */
        utilizadores uti1 = new utilizadores("aaa","pass", "Vieira", "Rua Teste", 123456789);
        utilizadores uti2 = new utilizadores("abc@teste.com","abc", "Calafate", "Avenida Teste", 987654321);
        utilizadores uti3 = new utilizadores("carlitos@teste.com","carlitos", "Carla", "Rua 123", 749382947);


        /* Listar artigos nos diferentes utilizadores */
        uti1.listarArtigo(artS);
        uti1.listarArtigo(artM);
        uti1.listarArtigo(artM2);
        uti1.listarArtigo(artS2);
        uti1.listarArtigo(artO3);

        uti2.listarArtigo(artT);
        uti2.listarArtigo(artT2);
        uti2.listarArtigo(artT3);
        uti2.listarArtigo(artM3);
        uti2.listarArtigo(artO);

        uti3.listarArtigo(artM4);
        uti3.listarArtigo(artS3);
        uti3.listarArtigo(artS4);
        uti3.listarArtigo(artT4);
        uti3.listarArtigo(artO2);

        /* Contas */
        contas x = new contas();
        x.addConta(uti1);
        x.addConta(uti2);
        x.addConta(uti3);

        /* Encomendas */
        gestorencomendas ge = new gestorencomendas();

        /* Transportadoras */
        gestortransportadoras gt = new gestortransportadoras();
        gt.adicionarTransportadora(OLX);
        gt.adicionarTransportadora(amazon);
        gt.adicionarTransportadora(DHL);

        /* Correr */
        controlo.run(x, ge, gt, true);
    }
}