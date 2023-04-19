package vintage;

import java.util.Scanner;

public class vintage {
    public static int MenuInicial() {
        clearWindow();
        StringBuilder sb = new StringBuilder("-----------MENU INICIAL-----------\n\n");
        sb.append("1) Iniciar sessão.\n");
        sb.append("2) Registar nova conta.\n");
        //sb.append("3) Carregar logs.\n");
        sb.append("0) Sair.\n\n");
        sb.append("Selecione a opção pretendida: ");
        System.out.println(sb.toString());
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static void clearWindow(){
        for (int i = 0;i<100;i++){
            System.out.println();
        }
    }
}
