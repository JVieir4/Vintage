package vintage;

import java.util.Scanner;

import vintage.artigos.Tipo;

public class vintage {
    private static String blue = colors.BLUE;
    private static String red = colors.RED;
    private static String reset = colors.RESET;
    private static String black = colors.BLACK;
    public static int MenuInicial(boolean clear) {
        if(clear){clearWindow();}
        StringBuilder sb = new StringBuilder(red + "-----------MENU INICIAL-----------\n\n");
        sb.append(blue + "1) " + reset + "Iniciar sessão.\n");
        sb.append(blue + "2) " + reset + "Registar nova conta.\n");
        sb.append(blue + "3) " + reset +  "Ver utilizadores registados.\n");
        sb.append(blue + "0) " + reset + "Sair.\n\n");
        sb.append("Selecione a opção pretendida: " + black);
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
        StringBuilder sb = new StringBuilder(red + "-----------MENU UTILIZADOR-----------\n\n");
        sb.append(blue + "1) " + reset + "Listar um artigo.\n");
        sb.append(blue + "2) " + reset + "Comprar um artigo.\n");
        sb.append(blue + "3) " + reset + "Ver carrinho.\n");
        sb.append(blue + "4) " + reset + "Verificar artigos à venda.\n");
        sb.append(blue + "5) " + reset + "Histórico de artigos vendidos.\n");
        sb.append(blue + "6) " + reset + "Histórico de artigos comprados.\n");
        sb.append(blue + "0) " + reset + "Logout.\n\n");
        sb.append("Selecione a opção pretendida: " + black);
        System.out.println(sb.toString());
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static int menuArtigo(){
        StringBuilder sb = new StringBuilder(red + "-----------MENU ARTIGO-----------\n\n");
        sb.append(blue + "1) " + reset + "Listar uma Sapatilha.\n");
        sb.append(blue + "2) " + reset + "Listar uma T-Shirt.\n");
        sb.append(blue + "3) " + reset + "Listar uma Mala.\n");
        sb.append(blue + "4) " + reset + "Outro.\n");
        sb.append("Selecione a opção pretendida: " + black);
        System.out.println(sb.toString());
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static sapatilhas criarSapatilha(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(red + "-----------NOVA SAPATILHA-----------\n\n" + reset);
        System.out.println("As sapatilhas são premium? (y/n)\n" + black);
        String n = scanner.nextLine();
        boolean premium = false;
        if(n.equals("y") || n.equals("Y")){ premium = true;}
        System.out.println(reset + "As sapatilhas têm atacadores? (y/n)\n" + black);
        String m = scanner.nextLine();
        boolean atacadores = false;
        if(m.equals("y") || m.equals("Y")){ atacadores = true;}
        System.out.println( reset + "Qual é o tamanho das sapatilhas?\n" + black);
        int tamanho = scanner.nextInt();
        scanner.nextLine();
        System.out.println(reset + "De que cor são as sapatilhas?\n" + black);
        String cor = scanner.nextLine();
        System.out.println(reset + "Qual é o ano da edição das sapatilhas?\n" + black);
        int ano = scanner.nextInt();
        scanner.nextLine();
        sapatilhas sap = new sapatilhas(premium,tamanho,atacadores,cor,ano);
        return sap;
    }

    public static tshirts criarTshirts(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(red + "-----------NOVA TSHIRT-----------\n\n" + reset);
        System.out.println("Qual é o tamanho da tshirt? (S,M,L,XL)\n" + black);
        String t = scanner.nextLine();
        Tamanho tamanho;
        tamanho = identificaTamanho(t);
        System.out.println(reset + "Qual é o padrão da tshirt? (Liso, Riscas, Palmeiras)\n" + black);
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
        System.out.println(red + "-----------NOVA MALA-----------\n\n" + reset);
        System.out.println("A mala é premium? (y/n)\n" + black);
        String n = scanner.nextLine();
        boolean premium = false;
        if(n.equals("y") || n.equals("Y")){ premium = true;}
        System.out.println(reset + "Qual é a largura da mala? (cm)\n" + black);
        int largura_x = scanner.nextInt();
        scanner.nextLine();
        System.out.println(reset + "Qual é a altura da mala? (cm)\n" + black);
        int altura_y = scanner.nextInt();
        scanner.nextLine();
        System.out.println(reset + "Qual é o material da mala?\n" + black);
        String material = scanner.nextLine();
        System.out.println(reset + "Qual é o ano da coleção da mala?\n" + black);
        int ano = scanner.nextInt();
        scanner.nextLine();
        malas mala = new malas(premium,largura_x,altura_y,material,ano);
        return mala;
    }
 
    public static artigos criarArtigo(Object obj){
        artigos art;
        Scanner scanner = new Scanner(System.in);
        System.out.println(red + "-----------NOVO ARTIGO-----------\n\n" + reset);
        System.out.println("O artigo foi usado? (y/n)\n" + black);
        String n = scanner.nextLine();
        boolean estado = true;
        int ndonos = 0;
        if(n.equals("y") || n.equals("Y")){
            System.out.println(reset + "Quantos donos teve o artigo anteriormente?\n" + black);
            int num = scanner.nextInt();
            scanner.nextLine();
            ndonos = num;
            estado = false;
        }
        System.out.println(reset + "Escreva uma breve descrição do artigo.\n" + black);
        String descricao = scanner.nextLine();
        System.out.println(reset + "Qual é a marca do artigo.\n" + black);
        String marca = scanner.nextLine();
        System.out.println(reset + "Qual é o código alfanumérico do artigo.\n" + black);
        String codigo = scanner.nextLine();
        System.out.println(reset + "Qual é o preço do artigo.\n" + black);
        double preço = scanner.nextDouble();
        scanner.nextLine();
        if (obj instanceof sapatilhas) {
            sapatilhas sap = (sapatilhas) obj;
            art = new artigos(sap,estado,ndonos,descricao,marca,codigo,preço);
        }
        else if (obj instanceof tshirts) {
            tshirts tshirt = (tshirts) obj;
            art = new artigos(tshirt,estado,ndonos,descricao,marca,codigo,preço);
        }
        else if (obj instanceof malas) {
            malas mala = (malas) obj;
            art = new artigos(mala,estado,ndonos,descricao,marca,codigo,preço);
        }
        else{
            art = new artigos(Tipo.Outro,estado,ndonos,descricao,marca,codigo,preço);
        }
        return art;
    }

    public static utilizadores criarUtilizador(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(red + "-----------NOVO UTILIZADOR-----------\n\n"+ reset);
        System.out.println("Email:\n" + black);
        String mail = scanner.nextLine();
        String pass1 = "a", pass2 = "b";
        int errado = 0;
        while(!pass1.equals(pass2)){
            if(errado == 1){System.out.println(reset + "As palavras-passes não são iguais. Tente outra vez.\n" + black);}
            System.out.println(reset + "Palavra-passe:\n" + black);
            pass1 = scanner.nextLine();
            System.out.println(reset + "Confirmar Palavra-passe:\n" + black);
            pass2 = scanner.nextLine();
            errado++;
        }
        System.out.println(reset + "Nome:\n" + black);
        String nome = scanner.nextLine();
        System.out.println(reset + "Morada:\n" + black);
        String morada = scanner.nextLine();
        System.out.println(reset + "Número Fiscal:\n" + black);
        int nfiscal = scanner.nextInt();
        scanner.nextLine();
        utilizadores util = new utilizadores(mail, pass1, nome, morada, nfiscal);
        return util;
    }

    public static int menuComprar(){
        StringBuilder sb = new StringBuilder(red + "-----------MENU COMPRA-----------\n\n");
        sb.append(blue + "1) " + reset + "Ver todos os artigos.\n");
        sb.append(blue + "2) " + reset + "Pesquisar por tipo.\n");
        sb.append(blue + "0) " + reset + "Cancelar.\n\n");
        sb.append("Selecione a opção pretendida: " + black);
        System.out.println(sb.toString());
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static int menuCarrinho(){
        StringBuilder sb = new StringBuilder(red + "-----------MENU CARRINHO-----------\n\n");
        sb.append(blue + "1) " + reset + "Adicionar um artigo.\n");
        sb.append(blue + "2) " + reset + "Remover um artigo.\n");
        sb.append(blue + "3) " + reset + "Concluir.\n");
        sb.append(blue + "0) " + reset + "Voltar.\n\n");
        sb.append("Selecione a opção pretendida: " + black);
        System.out.println(sb.toString());
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
