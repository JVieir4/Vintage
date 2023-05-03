package vintage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import vintage.artigos.Tipo;

public class controloutilizador {
    private static ArrayList<artigos> TodosArtigos = null;
    public static void run(int novo, utilizadores u, contas x, gestorencomendas ge, gestortransportadoras gt) throws CloneNotSupportedException {
        if (novo == 1) {
            TodosArtigos = x.Stock(u);
        }
        int opcao = -1;
        while (opcao < 0 || opcao > 6) {
            opcao = vintage.menuUtilizador(u);
        }
        switch (opcao) {
            case 1:
                int tipo = -1;
                while (tipo < 0 || tipo > 4) {
                    tipo = vintage.menuArtigo();
                }
                artigos art = criaArtigo(tipo, u, x, ge, gt);
                u.listarArtigo(art);
                break;
            case 2:
                int escolha = -1;
                while (escolha < 0 || escolha > 2) {
                    escolha = vintage.menuComprar();
                }
                comprarArtigo(escolha, u, x, u.getCarrinho(), ge, gt, TodosArtigos);
                break;
            case 3:
                System.out.print(colors.BLUE + "Carrinho:\n" + colors.RESET);
                if (u.getCarrinho().getArtigos().isEmpty()) {
                    System.out.println("O carrinho está vazio.\n");
                } else {
                    System.out.println(u.getCarrinho().imprimeArtigos(u.getCarrinho().getArtigos()));
                }
                int op = -1;
                while (op < 0 || op > 3) {
                    op = vintage.menuCarrinho();
                }
                switch (op) {
                    case 1:
                        int escolha2 = -1;
                        while (escolha2 < 0 || escolha2 > 2) {
                            escolha2 = vintage.menuComprar();
                        }
                        comprarArtigo(escolha2, u, x, u.getCarrinho(), ge, gt, TodosArtigos);
                        break;
                    case 2:
                        System.out.println(colors.RESET + u.getCarrinho().imprimeArtigos(u.getCarrinho().getArtigos()));
                        ArrayList<artigos> temp = u.getCarrinho().getArtigos();
                        ArrayList<String> codigos = new ArrayList<>();
                        System.out.println("Insira o número do(s) artigo(s) que deseja remover: (0 para terminar)" + colors.BLACK);
                        Scanner scanner = new Scanner(System.in);
                        int index = scanner.nextInt();
                        while (index != 0) {
                            if(index <= temp.size()){
                                String codigo = temp.get(index-1).getCodigo();
                                codigos.add(codigo);
                            }
                            index = scanner.nextInt();
                        }
                        Iterator<artigos> iterator = temp.iterator();
                        while (iterator.hasNext()) {
                            artigos a = iterator.next();
                            if (codigos.contains(a.getCodigo())) {
                                a.setDisponivel(true);
                                TodosArtigos.add(a);
                                iterator.remove();
                                u.getCarrinho().removeArtigo(a);
                            }
                        }
                        break;
                    case 3:
                        if (u.getCarrinho().getArtigos().isEmpty()) {
                            System.out.println(colors.RESET + "O carrinho está vazio. Por favor adicione artigos.");
                        } else {
                            //u.getCarrinho().setEstado(Estado.Finalizada);
                            System.out.println(u.getCarrinho());
                            //ge.adicionarEncomenda(new encomendas(u.getCarrinho()));
                            for(artigos a: u.getCarrinho().getArtigos()){
                                a.setDisponivel(false);
                            }
                            u.getArtComprados().addAll(u.getCarrinho().getArtigos());
                            x.artigoVendidoForAll();
                            ge.concluirEncomenda(u);
                            u.getCarrinho().getArtigos().clear();
                            
                        }
                        break;
                    case 0:
                        controloutilizador.run(0, u, x, ge, gt);
                        break;
                }
                break;
            case 4:
                if (u.getArtAVenda().isEmpty()) {
                    System.out.println(colors.RESET + "Não tem artigos à venda.");
                    break;
                }
                u.printArtavenda();
                break;
            case 5:
                if (u.getArtVendidos().isEmpty()) {
                    System.out.println(colors.RESET + "Não vendeu nenhum artigo.");
                    break;
                }
                u.printArtVendidos();
                break;
            case 6:
                if (u.getArtComprados().isEmpty()) {
                    System.out.println(colors.RESET + "Não comprou nenhum artigo.");
                    break;
                }
                u.printArtComprados();
                break;
            case 0:
                update(x, u);
                controlo.run(x, ge, gt, true);
                break;
        }
        update(x, u);
        controloutilizador.run(0, u, x, ge, gt);
    }

    private static void update(contas x, utilizadores u) {
        x.getUtilizadores(u.getEmail()).setArtAVenda(u.getArtAVenda());
        x.getUtilizadores(u.getEmail()).setArtComprados(u.getArtComprados());
        x.getUtilizadores(u.getEmail()).setArtVendidos(u.getArtVendidos());
    }

    private static artigos criaArtigo(int tipo, utilizadores u, contas x, gestorencomendas ge, gestortransportadoras gt)
            throws CloneNotSupportedException {
        artigos art = null;
        switch (tipo) {
            case 1:
                sapatilhas sap = vintage.criarSapatilha();
                art = vintage.criarArtigo(sap, gt);
                break;
            case 2:
                tshirts tshirt = vintage.criarTshirts();
                art = vintage.criarArtigo(tshirt, gt);
                break;
            case 3:
                malas mala = vintage.criarMalas();
                art = vintage.criarArtigo(mala, gt);
                break;
            case 4:
                Object obj = null;
                art = vintage.criarArtigo(obj, gt);
                break;
            case 0:
                controloutilizador.run(0, u, x, ge, gt);
        }
        return art;
    }

    private static void comprarArtigo(int escolha, utilizadores u, contas x, encomendas carrinho, gestorencomendas ge, gestortransportadoras gt,
    ArrayList<artigos> TodosArtigos) throws CloneNotSupportedException {
        switch (escolha) {
            case 1:
                imprime(u, TodosArtigos, "todos");
                break;
            case 2:
                int tipo = -1;
                while (tipo < 1 || tipo > 4) {
                    tipo = vintage.menuArtigo();
                    break;
                }
                switch (tipo) {
                    case 1:
                        imprime(u, TodosArtigos, "sapatilhas");
                        break;
                    case 2:
                        imprime(u, TodosArtigos, "tshirts");
                        break;
                    case 3:
                        imprime(u, TodosArtigos, "malas");
                        break;
                    case 4:
                        imprime(u, TodosArtigos, "outros");
                        break;
                }
                break;
            case 0:
                controloutilizador.run(0, u, x, ge, gt);
                break;
        }
        System.out.println("Insira o número do(s) artigo(s) que deseja comprar: (0 para terminar)" + colors.BLACK);
        int index = vintage.intScanner();
        while (index != 0) {
            artigos a = TodosArtigos.get((index));
            if (a != null) {
                carrinho.addArtigo(a);
                TodosArtigos.remove(index);
            }
            index = vintage.intScanner();
        }
        ge.adicionarEncomenda(u.getCarrinho());
    }

    private static void imprime(utilizadores u, ArrayList<artigos> TodosArtigos, String filtro) {
        int index = 1;
        for (artigos a: TodosArtigos) {
            boolean shouldPrint = false;
            switch (filtro) {
                case "todos":
                    shouldPrint = true;
                    break;
                case "sapatilhas":
                    shouldPrint = a.getTipo() == Tipo.Sapatilha;
                    break;
                case "tshirts":
                    shouldPrint = a.getTipo() == Tipo.TShirt;
                    break;
                case "malas":
                    shouldPrint = a.getTipo() == Tipo.Mala;
                    break;
                case "outros":
                    shouldPrint = a.getTipo() == Tipo.Outro;
                    break;
            }

            if (shouldPrint && !u.carrinhotem(a)) {
                System.out.println(colors.BLUE + index + ") " + a.toString());
            }
            index++;
        }
    }
}
