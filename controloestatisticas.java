package vintage;

public class controloestatisticas {
    public static void run(contas x, gestorencomendas ge, gestortransportadoras gt) throws CloneNotSupportedException {
        double lucrototal = ge.lucroTotal();
        int opcao = -1;
        while (opcao < 0 || opcao > 6) {
            opcao = vintage.MenuEstatisticas(x.melhorVendedor(), gt.melhorTransportadora(x), lucrototal);
        }
        switch (opcao) {
            case 1:
                if (ge.getEncomendas().isEmpty()) {
                    System.out.println("Nenhuma encomenda feita.");
                } else {
                    System.out.println(ge);
                }
                controloestatisticas.run(x, ge, gt);
                break;
            case 2:
                System.out.println(x.melhoresVendedores() + "\n");
                System.out.println(x.melhoresCompradores());
                controloestatisticas.run(x, ge, gt);
                break;
            case 0:
                controlo.run(x, ge, gt, false);
        }
    }
}
