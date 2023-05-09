package vintage.src;

import java.util.ArrayList;
import java.util.Iterator;

public class controloutilizador {
    public static void run(int novo, utilizadores u, contas x, gestorencomendas ge, gestortransportadoras gt)
            throws CloneNotSupportedException {
        int opcao = -1;
        while (opcao < 0 || opcao > 7) {
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
                comprarArtigo(escolha, u, x, u.getCarrinho(), ge, gt);
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
                        comprarArtigo(escolha2, u, x, u.getCarrinho(), ge, gt);
                        break;
                    case 2:
                        System.out.println(colors.RESET + u.getCarrinho().imprimeArtigos(u.getCarrinho().getArtigos()));
                        ArrayList<artigos> temp = u.getCarrinho().getArtigos();
                        removerArtigo(u, temp, "carrinho");
                        break;
                    case 3:
                        if (u.getCarrinho().getArtigos().isEmpty()) {
                            System.out.println(colors.RESET + "O carrinho está vazio. Por favor adicione artigos.");
                        } else {
                            System.out.println(u.getCarrinho());
                            u.getArtComprados().addAll(u.getCarrinho().getArtigos());
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
                u.printListaArts(u.getArtAVenda(), "à venda");
                System.out.println(colors.RESET + "Pretende retirar algum artigo? (y/n)" + colors.BLACK);
                if (vintage.isYesNo()) {
                    ArrayList<artigos> temp = u.getArtAVenda();
                    removerArtigo(u, temp, "artigosavenda");
                }
                break;
            case 5:
                if (u.getArtVendidos().isEmpty()) {
                    System.out.println(colors.RESET + "Não vendeu nenhum artigo.");
                    break;
                }
                u.printListaArts(u.getArtVendidos(), "vendidos");
                break;
            case 6:
                if (u.getArtComprados().isEmpty()) {
                    System.out.println(colors.RESET + "Não comprou nenhum artigo.");
                    break;
                }
                u.printListaArts(u.getArtComprados(), "comprados");
                break;
            case 7:
                if (u.getPendentes().isEmpty()) {
                    System.out.println("Nenhuma encomenda por expedir.");
                    break;
                }
                System.out.println(u.imprimePendentes());
                System.out.println(colors.RESET + "Pretende cancelar alguma encomenda? (y/n)" + colors.BLACK);
                if (vintage.isYesNo()) {
                    ArrayList<encomendas> temp = u.getPendentes();
                    ArrayList<String> codigos = new ArrayList<>();
                    System.out.println(
                            colors.RESET + "Insira o número da(s) encomenda(s) que deseja cancelar: (0 para terminar)"
                                    + colors.BLACK);
                    int index = vintage.intScanner();
                    while (index != 0) {
                        if (index <= temp.size()) {
                            String codigo = temp.get(index - 1).getCodigo();
                            codigos.add(codigo);
                        } else {
                            System.out.println(colors.RESET
                                    + "\nValor inválido, por favor insira um número dos apresentados: " + colors.BLACK);
                        }
                        index = vintage.intScanner();
                    }
                    Iterator<encomendas> iterator = temp.iterator();
                    while (iterator.hasNext()) {
                        encomendas e = iterator.next();
                        if (codigos.contains(e.getCodigo()) && !codigos.isEmpty()) {
                            iterator.remove();
                            for (artigos a : e.getArtigos()) {
                                u.getArtComprados().remove(a);
                                a.setDisponivel(true);
                            }
                            double prej = u.getPrejuizo() - e.getPreco();
                            if (prej < 0) {
                                prej = 0;
                            }
                            u.setPrejuizo(prej);
                            u.getPendentes().remove(e);
                            ge.removerEncomenda(e);
                        }
                    }
                }
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
        x.getUtilizadores(u.getEmail()).setLucro(u.getLucro());
        x.getUtilizadores(u.getEmail()).setPrejuizo(u.getPrejuizo());
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

    private static void comprarArtigo(int escolha, utilizadores u, contas x, encomendas carrinho, gestorencomendas ge,
            gestortransportadoras gt) throws CloneNotSupportedException {
        ArrayList<artigos> temp = null;
        switch (escolha) {
            case 1:
                temp = x.Stock(u, "todos");
                break;
            case 2:
                int tipo = -1;
                while (tipo < 1 || tipo > 4) {
                    tipo = vintage.menuArtigo();
                    break;
                }
                switch (tipo) {
                    case 1:
                        temp = x.Stock(u, "sapatilhas");
                        break;
                    case 2:
                        temp = x.Stock(u, "tshirts");
                        break;
                    case 3:
                        temp = x.Stock(u, "malas");
                        break;
                    case 4:
                        temp = x.Stock(u, "outro");
                        break;
                    case 0:
                        controloutilizador.run(0, u, x, ge, gt);
                        break;
                }
                break;
            case 0:
                controloutilizador.run(0, u, x, ge, gt);
                break;
        }
        ArrayList<String> codigos = new ArrayList<>();
        System.out.println("Insira o número do(s) artigo(s) que deseja comprar: (0 para terminar)" + colors.BLACK);
        int index = vintage.intScanner();
        while (index != 0) {
            if (index <= temp.size()) {
                String codigo = temp.get(index - 1).getCodigo();
                codigos.add(codigo);
            } else {
                System.out.println(colors.RESET + "\nValor inválido, por favor insira um número dos apresentados: "
                        + colors.BLACK);
            }
            index = vintage.intScanner();
        }
        Iterator<artigos> iterator = temp.iterator();
        while (iterator.hasNext()) {
            artigos a = iterator.next();
            if (codigos.contains(a.getCodigo())) {
                a.setDisponivel(false);
                carrinho.addArtigo(a);
                iterator.remove();
            }
        }
        ge.adicionarEncomenda(u.getCarrinho());
    }

    private static void removerArtigo(utilizadores u, ArrayList<artigos> temp, String filtro) {
        ArrayList<String> codigos = new ArrayList<>();
        System.out.println(
                colors.RESET + "Insira o número do(s) artigo(s) que deseja remover: (0 para terminar)" + colors.BLACK);
        int index = vintage.intScanner();
        while (index != 0) {
            if (index <= temp.size()) {
                String codigo = temp.get(index - 1).getCodigo();
                codigos.add(codigo);
            } else {
                System.out.println(colors.RESET + "\nValor inválido, por favor insira um número dos apresentados: "
                        + colors.BLACK);
            }
            index = vintage.intScanner();
        }
        Iterator<artigos> iterator = temp.iterator();
        while (iterator.hasNext()) {
            artigos a = iterator.next();
            if (codigos.contains(a.getCodigo())) {
                if (filtro.equals("carrinho")) {
                    a.setDisponivel(true);
                    iterator.remove();
                    u.getCarrinho().removeArtigo(a);
                } else if (filtro.equals("artigosavenda")) {
                    iterator.remove();
                    u.getArtAVenda().remove(a);
                }
            }
        }
    }
}
