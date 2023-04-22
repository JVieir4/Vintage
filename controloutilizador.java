package vintage;

import java.util.Map;
import java.util.Scanner;

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
                int escolha = -1;
                while(escolha < 0 || escolha > 2){
                    escolha = vintage.menuComprar();
                }
                encomendas carrinho = new encomendas();
                comprarArtigo(escolha, u, x, carrinho);
                
                /* System.out.println("Insira o número do artigo que deseja comprar:\n"); */

                break;
            case 3:
                u.printArtavenda();
                break;
            case 4:
                System.out.println(u.getArtVendidos());
                break;
            case 5:
                System.out.println(u.getArtComprados());
                break;
            case 0:
                update(x,u);
                controlo.run(x,true);
                break;
        }
        update(x,u);
        controloutilizador.run(u,x);
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

    private static void comprarArtigo(int escolha, utilizadores u, contas x, encomendas carrinho) throws CloneNotSupportedException{
        switch(escolha){
            case 1:
                Map<Integer, artigos> TodosArtigos = x.printStock(u);
                System.out.println("Insira o número do artigo que deseja comprar: ");
                Scanner scanner = new Scanner(System.in);
                int index = scanner.nextInt();
                carrinho.addArtigo(TodosArtigos.get(index));
                x.removeFromArtavenda(TodosArtigos, index);
                break;
            case 2:
                int tipo = -1;
                while(tipo < 1 || tipo > 4) {
                    tipo = vintage.menuArtigo();
                }
                /* dar print a todos os artigos de x tipo (todas as sapatilhas, ou tshirts, ou malas, ou outros) */
                break;
            case 0:
                controloutilizador.run(u,x);
                break;

        }
    }
}
