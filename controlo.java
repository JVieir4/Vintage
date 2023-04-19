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
                    System.out.println("correto");
                }
                else{
                    System.out.println("Nenhuma conta encontrada com esse email.");
                }
            case 2:
            case 0:
        }
    }
}
