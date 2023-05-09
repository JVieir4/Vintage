package vintage.src;


import vintage.src.artigos.Tipo;
import vintage.src.encomendas.Estado;
import vintage.src.tshirts.Padroes;
import vintage.src.tshirts.Tamanho;

public class mainV {
    public static void main(String[] args) throws CloneNotSupportedException {
	// Transportadoras
	transportadora amazon = new transportadora("Amazon", 30, true);
	transportadora UPS = new transportadora("UPS", 15, false);
	transportadora DHL = new transportadora("DHL", 10, false);
	gestortransportadoras gt = new gestortransportadoras();
	gt.adicionarTransportadora(UPS);
	gt.adicionarTransportadora(amazon);
	gt.adicionarTransportadora(DHL);

	// Sapatilhas
	sapatilhas sap1 = new sapatilhas(false, 40, true, "azul", 2020);
	artigos artS = new artigos(sap1, false, 1, "sapatilhas fixes", "Nike", 19.99, amazon);

	sapatilhas sap2 = new sapatilhas(true, 35, true, "rosa", 2012);
	artigos artS2 = new artigos(sap2, false, 3, "sapatilhas rosinhas", "Adidas", 60.00, DHL);

	sapatilhas sap3 = new sapatilhas(false, 39, true, "preto", 2022);
	artigos artS3 = new artigos(sap3, false, 1, "O preto é um bom contraste com o branco", "Veja", 50.99, amazon);

	sapatilhas sap4 = new sapatilhas(true, 37, true, "branco", 2020);
	artigos artS4 = new artigos(sap4, true, 0, "Sapatilhas branquinhas sem nenhuma mancha", "Bufallo", 170.99, UPS);

	// T-Shirts
	tshirts ts1 = new tshirts(Tamanho.M, Padroes.Liso);
	artigos artT = new artigos(ts1, true, 0, "T-Shirt fixe", "Tiffosi", 9.99, amazon);

	tshirts ts2 = new tshirts(Tamanho.L, Padroes.Palmeiras);
	artigos artT2 = new artigos(ts2, false, 1, "Palmeiras bonitas", "Gucci", 35.99, UPS);

	tshirts ts3 = new tshirts(Tamanho.XL, Padroes.Riscas);
	artigos artT3 = new artigos(ts3, false, 1, "Tshirt rosinha com um unicornio", "Brand Melvin", 18.99, DHL);

	tshirts ts4 = new tshirts(Tamanho.S, Padroes.Liso);
	artigos artT4 = new artigos(ts4, false, 12, "Perfeita tshirt para uma criança", "Adidas", 12.99, UPS);

	tshirts tsE = new tshirts(Tamanho.M, Padroes.Liso);
	artigos artTenc = new artigos(tsE, true, 0, "T-Shirt fixe", "Tiffosi", 9.99, amazon);
	artTenc.setDisponivel(false);

	// Malas
	malas ma1 = new malas(true, 30, 32, "Policarbonato", 2008);
	artigos artM = new artigos(ma1, false, 2, "Mala fixe", "Samsonite", 49.99, UPS);

	malas ma2 = new malas(true, 20, 15, "Plastico", 2019);
	artigos artM2 = new artigos(ma2, true, 0, "Nunca usada, e muito incrivel", "Prada", 1300.94, DHL);

	malas ma3 = new malas(false, 50, 59, "ganga", 2023);
	artigos artM3 = new artigos(ma3, true, 0, "Novinho e stylish", "parfois", 40.60, amazon);

	malas ma4 = new malas(true, 25, 29, "ABS", 2019);
	artigos artM4 = new artigos(ma4, false, 2, "Mala dourada perfeita para sair de casa", "Giorgio Armani", 570.99,
	DHL);

	malas maE = new malas(false, 50, 59, "ganga", 2023);
	artigos artMenc = new artigos(maE, true, 0, "Novinho e stylish", "parfois", 40.60, amazon);
	artMenc.setDisponivel(false);

	// Outros
	artigos artO = new artigos(Tipo.Outro, false, 2, "Cartola bonita", "COOLHATS", 69.80, UPS);
	artigos artO2 = new artigos(Tipo.Outro, false, 0, "Casaco preto", "Zara", 39.50, amazon);
	artigos artO3 = new artigos(Tipo.Outro, false, 1, "Calça beje com detalhes de lado", "SUITS", 25.99, DHL);

	// Utilizadores
	utilizadores uti1 = new utilizadores("jvieira@gmail.com", "passe", "João Vieira", "Avenida Afonso Pena", 295334495);
	utilizadores uti2 = new utilizadores("xanax@gmail.com", "xanax", "Alexandra Calafate", "Rua Arlindo Nogueira",
	207238782);
	utilizadores uti3 = new utilizadores("jorg2000@gmail.com", "jojo", "Jorge Borges",
	"Rua Tenente-Coronel Cardoso", 291607497);

	// Listar artigos nos diferentes utilizadores
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
	uti2.listarArtigo(artTenc);

	uti3.listarArtigo(artM4);
	uti3.listarArtigo(artS3);
	uti3.listarArtigo(artS4);
	uti3.listarArtigo(artT4);
	uti3.listarArtigo(artO2);
	uti3.listarArtigo(artMenc);

	// Contas
	contas x = new contas();
	x.addConta(uti1);
	x.addConta(uti2);
	x.addConta(uti3);

	// Encomendas
	encomendas E1 = new encomendas(uti1.getNome());
	E1.getArtigos().add(artTenc);
	E1.setNartigos(1);
	E1.setEstado(Estado.Finalizada);
	E1.calculaPreco(E1.getArtigos());
	uti1.getPendentes().add(E1);
	uti1.getArtComprados().addAll(E1.getArtigos());

	encomendas E2 = new encomendas(uti2.getNome());
	E2.getArtigos().add(artMenc);
	E2.setNartigos(1);
	E2.setEstado(Estado.Expedida);
	E2.calculaPreco(E2.getArtigos());
	uti2.getArtComprados().addAll(E2.getArtigos());
	uti3.getArtVendidos().add(artMenc);

	// Contar prejuízos das encomendas iniciais
	for (utilizadores u : x.getContas().values()) {
	u.setPrejuizo(u.getTotalComprado());
	}

	gestorencomendas ge = new gestorencomendas();
	ge.adicionarEncomenda(E1);
	ge.adicionarEncomenda(E2);
	ge.adicionarEncomenda(E2);

	/* Correr */
	controlo.run(x, ge, gt, true);
	}
}