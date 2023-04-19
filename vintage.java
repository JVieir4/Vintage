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

    public static void clearWindow(){
        for (int i = 0;i<100;i++){
            System.out.println();
        }
    }

    public static int menuUtilizador(){
        StringBuilder sb = new StringBuilder("-----------MENU UTILIZADOR-----------\n\n");
        sb.append("1) Listar um artigo.\n");
        sb.append("2) Comprar um artigo.\n");
        sb.append("3) Verificar artigos à venda.\n");
        sb.append("4) Histórico de artigos vendidos.\n");
        sb.append("5) Histórico de artigos comprados.\n");
        sb.append("0) Logout.\n\n");
        sb.append("Selecione a opção pretendida: ");
        System.out.println(sb.toString());
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
