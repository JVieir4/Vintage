package vintage;

import java.util.Scanner;

import vintage.artigos.Tipo;

public class vintage {
    public static int MenuInicial(boolean clear) {
        if(clear){clearWindow();}
        StringBuilder sb = new StringBuilder("-----------MENU INICIAL-----------\n\n");
        sb.append("1) Iniciar sessão.\n");
        sb.append("2) Registar nova conta.\n");
        sb.append("3) Ver utilizadores registados.\n");
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

    public static int menuArtigo(){
        StringBuilder sb = new StringBuilder("-----------MENU ARTIGO-----------\n\n");
        sb.append("1) Listar uma Sapatilha.\n");
        sb.append("2) Listar uma T-Shirt.\n");
        sb.append("3) Listar uma Mala.\n");
        sb.append("4) Outro.\n");
        sb.append("Selecione a opção pretendida: ");
        System.out.println(sb.toString());
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static sapatilhas criarSapatilha(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------NOVA SAPATILHA-----------\n\n");
        System.out.println("As sapatilhas são premium? (y/n)\n");
        String n = scanner.nextLine();
        boolean premium = false;
        if(n.equals("y") || n.equals("Y")){ premium = true;}
        System.out.println("As sapatilhas têm atacadores? (y/n)\n");
        String m = scanner.nextLine();
        boolean atacadores = false;
        if(m.equals("y") || m.equals("Y")){ atacadores = true;}
        System.out.println("Qual é o tamanho das sapatilhas?\n");
        int tamanho = scanner.nextInt();
        scanner.nextLine();
        System.out.println("De que cor são as sapatilhas?\n");
        String cor = scanner.nextLine();
        System.out.println("Qual é o ano da edição das sapatilhas?\n");
        int ano = scanner.nextInt();
        scanner.nextLine();
        sapatilhas sap = new sapatilhas(premium,tamanho,atacadores,cor,ano);
        return sap;
    }

    public static tshirts criarTshirts(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------NOVA TSHIRT-----------\n\n");
        System.out.println("Qual é o tamanho da tshirt? (S,M,L,XL)\n");
        String t = scanner.nextLine();
        Tamanho tamanho;
        tamanho = identificaTamanho(t);
        System.out.println("Qual é o padrão da tshirt? (Liso, Riscas, Palmeiras)\n");
        String p = scanner.nextLine();
        Padroes padrao;
        padrao = identificaPadrao(p);
        tshirts tshirt = new tshirts(tamanho,padrao);
        return tshirt;
    }

    private static Padroes identificaPadrao(String p) {
        if(p.equals("liso") || p.equals("Liso")){
            return Padroes.Liso;
        }
        else if(p.equals("riscas") || p.equals("Riscas")){
            return Padroes.Riscas;
        }
        else if(p.equals("palmeiras") || p.equals("Palmeiras")){
            return Padroes.Palmeiras;
        }
        else{
            return null;
        }
    }

    private static Tamanho identificaTamanho(String t) {
        if(t.equals("s") || t.equals("S")){
            return Tamanho.S;
        }
        else if(t.equals("m") || t.equals("M")){
            return Tamanho.M;
        }
        else if(t.equals("l") || t.equals("L")){
            return Tamanho.L;
        }
        else{
            return Tamanho.XL;
        }
    }

    public static malas criarMalas(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------NOVA MALA-----------\n\n");
        System.out.println("A mala é premium? (y/n)\n");
        String n = scanner.nextLine();
        boolean premium = false;
        if(n.equals("y") || n.equals("Y")){ premium = true;}
        System.out.println("Qual é a largura da mala? (cm)\n");
        int largura_x = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Qual é a altura da mala? (cm)\n");
        int altura_y = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Qual é o material da mala?\n");
        String material = scanner.nextLine();
        System.out.println("Qual é o ano da coleção da mala?\n");
        int ano = scanner.nextInt();
        scanner.nextLine();
        malas mala = new malas(premium,largura_x,altura_y,material,ano);
        return mala;
    }
 
    public static artigos criarArtigo(Object obj){
        artigos art;
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------NOVO ARTIGO-----------\n\n");
        System.out.println("O artigo foi usado? (y/n)\n");
        String n = scanner.nextLine();
        boolean estado = true;
        int ndonos = 0;
        if(n.equals("y") || n.equals("Y")){
            System.out.println("Quantos donos teve o artigo anteriormente?\n");
            int num = scanner.nextInt();
            scanner.nextLine();
            ndonos = num;
            estado = false;
        }
        System.out.println("Escreva uma breve descrição do artigo.\n");
        String descricao = scanner.nextLine();
        System.out.println("Qual é a marca do artigo.\n");
        String marca = scanner.nextLine();
        System.out.println("Qual é o código alfanumérico do artigo.\n");
        String codigo = scanner.nextLine();
        System.out.println("Qual é o preço do artigo.\n");
        double preço = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Há alguma correção no preço? (Descontos ou aumentos [-100, 100]\n");
        int correcao = scanner.nextInt();
        scanner.nextLine();
        if (obj instanceof sapatilhas) {
            sapatilhas sap = (sapatilhas) obj;
            art = new artigos(sap,estado,ndonos,descricao,marca,codigo,preço,correcao);
        }
        else if (obj instanceof tshirts) {
            tshirts tshirt = (tshirts) obj;
            art = new artigos(tshirt,estado,ndonos,descricao,marca,codigo,preço,correcao);
        }
        else if (obj instanceof malas) {
            malas mala = (malas) obj;
            art = new artigos(mala,estado,ndonos,descricao,marca,codigo,preço,correcao);
        }
        else{
            art = new artigos(Tipo.Outro,estado,ndonos,descricao,marca,codigo,preço,correcao);
        }
        return art;
    }
}
