package vintage;

import java.util.Scanner;

public class controloestatisticas {
    public static void run(contas x, gestorencomendas ge, gestortransportadoras gt) throws CloneNotSupportedException{
        Scanner scanner = new Scanner(System.in);
        double lucrototal = ge.lucroTotal();
        int opcao = -1;
        while(opcao < 0 || opcao > 6) {
            opcao = vintage.MenuEstatisticas(x.melhorVendedor(), gt.melhorTransportadora(x), lucrototal);
        }       
        switch(opcao) {
            case 1:
                if(ge.getCounter() == 0){
                    System.out.println("Nenhuma encomenda feita.");
                }
                else{
                    System.out.println(ge);
                }
                controlo.run(x,ge,gt,false);
                break;
            case 2:
                System.out.println("Por fazer");
                break;
            case 0:
                controlo.run(x,ge,gt,false);
        }
    }
}
