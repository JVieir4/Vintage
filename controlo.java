package vintage;

import java.util.Scanner;

public class controlo {
    public static void run(contas x, boolean clear) throws CloneNotSupportedException{
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
                    utilizadores eu = x.getUtilizadores(mail).clone();
                    x.deleteConta(mail);
                    controloutilizador.run(eu, x);
                }
                else{
                    System.out.println("Nenhuma conta encontrada com esse email.\n");
                    controlo.run(x,false);
                }
                break;
            case 2:
                System.out.println("vazio");
                break;
            case 3:
                System.out.println(x);
                controlo.run(x,false);
                break;
            case 0:
                System.exit(0);
                break;
        }
    }
}
