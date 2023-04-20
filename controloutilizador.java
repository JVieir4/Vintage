package vintage;

public class controloutilizador {
    public static void run(utilizadores u, contas x) throws CloneNotSupportedException{
        int opcao = -1;
        while(opcao < 0 || opcao > 5) {
            opcao = vintage.menuUtilizador();
        }       
        switch(opcao) {            
            case 1:
                int tipo = -1;
                while(tipo < 1 || tipo > 4) {
                    tipo = vintage.menuArtigo();
                }
                artigos art = criaArtigo(tipo);
                u.listarArtigo(art);
                break;
            case 2:
                System.out.println("vazio");
                break;
            case 3:
                System.out.println(u.getArtAVenda());
                break;
            case 4:
                System.out.println("vazio");
                break;
            case 5:
                System.out.println("vazio");
                break;
            case 0:
                controlo.run(x,true);
                break;
        }
        x.addConta(u);
        controloutilizador.run(u,x);
    }

    private static artigos criaArtigo(int tipo) {
        artigos art = null;
        switch(tipo){
            case 1:
                sapatilhas sap = vintage.criarSapatilha();
                art = vintage.criarArtigo(sap);
                break;
            case 2:
                tshirts tshirt = vintage.criarTshirts();
                art = vintage.criarArtigo(tshirt);
                break;
            case 3:
                malas mala = vintage.criarMalas();
                art = vintage.criarArtigo(mala);
                break;
            case 4:
                /* art = vintage.criarArtigo(Tipo.Outro);
                break;*/
        } 
        return art;
    }
}
