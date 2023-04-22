package vintage;

import java.util.Map;
import java.util.Scanner;

public class controloutilizador {
    static encomendas carrinho = new encomendas();
    public static void run(utilizadores u, contas x, gestorencomendas g) throws CloneNotSupportedException{
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
                int escolha = -1;
                while(escolha < 0 || escolha > 2){
                    escolha = vintage.menuComprar();
                }
                comprarArtigo(escolha, u, x, carrinho, g);
                
                /* System.out.println("Insira o número do artigo que deseja comprar:\n"); */

                break;
            case 3:
                System.out.println("Carrinho:\n" + carrinho.imprimeArtigos(carrinho.getArtigos()));
                int op = -1;
                while(op < 0 || op > 3) {
                    op = vintage.menuCarrinho();
                }
                switch(op){
                    case 1:
                        int escolha2 = -1;
                        while(escolha2 < 0 || escolha2 > 2){
                            escolha2 = vintage.menuComprar();
                        }
                        comprarArtigo(escolha2, u, x, carrinho, g);
                        break;
                    case 2:
                        System.out.println(carrinho.imprimeArtigos(carrinho.getArtigos()));
                        /* 
                         * Falta aqui poder remover artigos do carrinho
                         */
                        break;
                    case 3:
                        System.out.println(carrinho);
                        g.adicionarEncomenda(carrinho);
                    case 0:
                        controloutilizador.run(u,x,g);
                        break;
                }
            case 4:
                u.printArtavenda();
                break;  
            case 5:
                System.out.println(u.getArtVendidos());
                break;
            case 6:
                System.out.println(u.getArtComprados());
                break;
            case 0:
                update(x,u);
                controlo.run(x,g,true);
                break;
        }
        update(x,u);
        controloutilizador.run(u,x,g);
    }


    private static void update(contas x,utilizadores u){
        x.getUtilizadores(u.getEmail()).setArtAVenda(u.getArtAVenda());
        x.getUtilizadores(u.getEmail()).setArtComprados(u.getArtComprados());
        x.getUtilizadores(u.getEmail()).setArtVendidos(u.getArtVendidos());
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
                Object obj = null;
                art = vintage.criarArtigo(obj);
                break;
        } 
        return art;
    }

    private static void comprarArtigo(int escolha, utilizadores u, contas x, encomendas carrinho, gestorencomendas g) throws CloneNotSupportedException{
        switch(escolha){
            case 1:
                Map<Integer, artigos> TodosArtigos = x.printStock(u);
                System.out.println("Insira o número do artigo que deseja comprar: (0 para terminar)");
                Scanner scanner = new Scanner(System.in);
                int index = scanner.nextInt();;
                while(index != 0){
                    carrinho.addArtigo(TodosArtigos.get(index));
                    x.removeFromArtavenda(TodosArtigos, index); 
                    index = scanner.nextInt();
                }
                break;
            case 2:
                int tipo = -1;
                while(tipo < 1 || tipo > 4) {
                    tipo = vintage.menuArtigo();
                }
                /* dar print a todos os artigos de x tipo (todas as sapatilhas, ou tshirts, ou malas, ou outros) */
                break;
            case 0:
                controloutilizador.run(u,x,g);
                break;

        }
    }
}
