package vintage;

import java.util.Scanner;

public class controlo {
    public static void run(contas x, gestorencomendas g, boolean clear) throws CloneNotSupportedException{
        int opcao = -1;
        while(opcao < 0 || opcao > 3) {
            opcao = vintage.MenuInicial(clear);
        }       
        switch(opcao) {            
            case 1:
                System.out.println("Introduza o seu email:\n");
                Scanner scanner = new Scanner(System.in);
                String mail = scanner.nextLine();
                if(x.existeEmail(mail)){
                    System.out.println("Introduza a palavra-passe:\n");
                    String pass = scanner.nextLine();
                    if(x.getUtilizadores(mail).getPassword().equals(pass)){
                        utilizadores eu = x.getUtilizadores(mail).clone();
                        controloutilizador.run(eu, x, g);
                    }
                    else{
                        System.out.println("A palavra-passe inserida não está correta.\n");
                        controlo.run(x,g,false);
                    }
                }
                else{
                    System.out.println("Nenhuma conta encontrada com esse email.\n");
                    controlo.run(x,g,false);
                }
                break;
            case 2:
                utilizadores novo = vintage.criarUtilizador();
                x.addConta(novo);
                controloutilizador.run(novo, x, g);
                break;
            case 3:
                System.out.println(x);
                controlo.run(x,g,false);
                break;
            case 0:
                System.exit(0);
                break;
        }
    }
}
