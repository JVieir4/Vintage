package vintage.src;

import java.time.temporal.ChronoUnit;
import java.util.Iterator;

import vintage.src.encomendas.Estado;

public class controlo {
    public static void run(contas x, gestorencomendas ge, gestortransportadoras gt, boolean clear)
            throws CloneNotSupportedException {
        int opcao = -1;
        while (opcao < 0 || opcao > 6) {
            opcao = vintage.MenuInicial(clear);
        }
        switch (opcao) {
            case 1:
                System.out.println(colors.RESET + "Introduza o seu email:" + colors.BLACK);
                String mail = vintage.stringScanner();
                if (x.existeEmail(mail)) {
                    System.out.println(colors.RESET + "\nIntroduza a palavra-passe:" + colors.BLACK);
                    String pass = vintage.stringScanner();
                    if (x.getUtilizadores(mail).getPassword().equals(pass)) {
                        utilizadores eu = x.getUtilizadores(mail).clone();
                        controloutilizador.run(1, eu, x, ge, gt);
                    } else {
                        System.out.println(colors.RESET + "A palavra-passe inserida não está correta.\n");
                        controlo.run(x, ge, gt, false);
                    }
                } else {
                    System.out.println(colors.RESET + "Nenhuma conta encontrada com esse email.\n");
                    controlo.run(x, ge, gt, false);
                }
                break;
            case 2:
                utilizadores novo = vintage.criarUtilizador();
                x.addConta(novo);
                controloutilizador.run(1, novo, x, ge, gt);
                break;
            case 3:
                System.out.println(x);
                controlo.run(x, ge, gt, false);
                break;
            case 4:
                int op = -1;
                while (op < 0 || op > 3) {
                    op = vintage.menuTransportadora(gt);
                }
                switch (op) {
                    case 1:
                        transportadora t = vintage.criarTransportadora();
                        gt.adicionarTransportadora(t);
                        break;
                    case 2:
                        System.out.println(colors.RESET + "Insira o número da transportadora que deseja modificar: "
                                + colors.BLACK);
                        transportadora temp = gt.getTransportadorabyIndex(vintage.intScanner());
                        System.out.println(colors.RESET + "Insira uma nova taxa: (0-100)" + colors.BLACK);
                        int novataxa = 0;
                        while (novataxa < 0 || novataxa > 100) {
                            novataxa = vintage.intScanner();
                        }
                        temp.setTaxa(novataxa);
                        break;
                    case 3:
                        gt.removerTransportadora(vintage.escolheTransportadora(gt, "remover: ", false));
                        break;
                    case 0:
                        break;
                }
                controlo.run(x, ge, gt, false);
                break;
            case 5:
                controloestatisticas.run(x, ge, gt);
                break;
            case 6:
                int escolha = -1;
                while (escolha < 0 || escolha > 2) {
                    escolha = vintage.MenuTimeJump();
                }
                switch (escolha) {
                    case 1:
                        System.out.println(colors.RESET + "Quantos dias deseja avançar?" + colors.BLACK);
                        long dias = vintage.intScanner();
                        datemanager.getInstance().advanceDays(dias);
                        break;
                    case 2:
                        vintage.escolheData();
                    case 0:
                        break;
                }
                update(x, ge, gt);
                controlo.run(x, ge, gt, true);
                break;
            case 0:
                System.exit(0);
                break;
        }
    }

    public static void update(contas x, gestorencomendas ge, gestortransportadoras gt) {
        for (encomendas e : ge.getEncomendas()) {
            long dif = ChronoUnit.DAYS.between(e.getData(), datemanager.getInstance().getCurrentDate());
            if (dif > 2 && e.getEstado() == Estado.Finalizada) {
                e.setEstado(Estado.Expedida);
            }
        }
        x.artigoVendidoForAll();
        for (utilizadores u : x.getContas().values()) {
            double lucro = 0;
            for (artigos a : u.getArtVendidos()) {
                lucro += a.getPreco();
            }
            u.setLucro(u.getLucro() + lucro);
            Iterator<encomendas> iterator = u.getPendentes().iterator();
            while (iterator.hasNext()) {
                encomendas e = iterator.next();
                if (e.getEstado() == Estado.Expedida) {
                    iterator.remove();
                    u.getPendentes().remove(e);
                }
            }
        }
    }
}
