package vintage;

import java.util.Scanner;

public class controlo {
    public static void run(contas x){
        int opcao = -1;
        while(opcao < 0 || opcao > 2) {
            opcao = vintage.MenuInicial();
        }       
        switch(opcao) {            
            case 1:
                System.out.println("Introduza o seu email:\n");
                Scanner scanner = new Scanner(System.in);
                String mail = scanner.nextLine();
                if(x.existeEmail(mail)){
                    utilizadores eu = x.getUtilizadores(mail);
                    //System.out.println(eu);
                    eu.imprime(eu.art_a_venda);
                    controloutilizador.run(eu);
                }
                else{
                    System.out.println("Nenhuma conta encontrada com esse email.");
                }
                break;
            case 2:
                System.out.println("vazio");
                break;
            case 0:
                System.exit(0);
                break;
        }
    }
}
