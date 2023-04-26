package vintage;

import java.util.Scanner;

public class controlo {
    public static void run(contas x, gestorencomendas ge, gestortransportadoras gt, boolean clear) throws CloneNotSupportedException{
        int opcao = -1;
        while(opcao < 0 || opcao > 3) {
            opcao = vintage.MenuInicial(clear);
        }       
        switch(opcao) {            
            case 1:
                System.out.println(colors.RESET + "Introduza o seu email:" + colors.BLACK);
                Scanner scanner = new Scanner(System.in);
                String mail = scanner.nextLine();
                if(x.existeEmail(mail)){
                    System.out.println(colors.RESET + "\nIntroduza a palavra-passe:" + colors.BLACK);
                    String pass = scanner.nextLine();
                    if(x.getUtilizadores(mail).getPassword().equals(pass)){
                        utilizadores eu = x.getUtilizadores(mail).clone();
                        controloutilizador.run(1, eu, x, ge, gt);
                    }
                    else{
                        System.out.println(colors.RESET + "A palavra-passe inserida não está correta.\n");
                        controlo.run(x,ge,gt,false);
                    }
                }
                else{
                    System.out.println(colors.RESET + "Nenhuma conta encontrada com esse email.\n");
                    controlo.run(x,ge,gt,false);
                }
                break;
            case 2:
                utilizadores novo = vintage.criarUtilizador();
                x.addConta(novo);
                controloutilizador.run(1,novo, x, ge, gt);
                break;
            case 3:
                System.out.println(x);
                controlo.run(x,ge,gt,false);
                break;
            case 0:
                System.exit(0);
                break;
        }
    }
}
