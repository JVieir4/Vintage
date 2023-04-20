package vintage;

public class controloutilizador {
    public static void run(utilizadores u, contas x) throws CloneNotSupportedException{
        int opcao = -1;
        while(opcao < 0 || opcao > 5) {
            opcao = vintage.menuUtilizador();
        }       
        switch(opcao) {            
            case 1:
                System.out.println("vazio");
                break;
            case 2:
                System.out.println("vazio");
                break;
            case 3:
                System.out.println(u.getArtAVenda());
                break;
            case 4:
                System.out.println("vazio");
                break;
            case 5:
                System.out.println("vazio");
                break;
            case 0:
                controlo.run(x,true);
                break;
        }
        x.addConta(u);
    }
}
