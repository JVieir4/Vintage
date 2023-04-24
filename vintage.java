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
        return intScanner();
    }

    private static void clearWindow(){
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
        return intScanner();
    }

    public static int menuArtigo(){
        StringBuilder sb = new StringBuilder(red + "-----------MENU ARTIGO-----------\n\n");
        sb.append(blue + "1) " + reset + "Listar uma Sapatilha.\n");
        sb.append(blue + "2) " + reset + "Listar uma T-Shirt.\n");
        sb.append(blue + "3) " + reset + "Listar uma Mala.\n");
        sb.append(blue + "4) " + reset + "Outro.\n");
        sb.append(blue + "0) " + reset + "Voltar.\n");
        sb.append("Selecione a opção pretendida: " + black);
        System.out.println(sb.toString());
        return intScanner();
    }

    public static sapatilhas criarSapatilha(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(red + "-----------NOVA SAPATILHA-----------\n\n" + reset);
        System.out.println("As sapatilhas são premium? (y/n)" + black);
        boolean premium = isYesNo();
        System.out.println(reset + "\nAs sapatilhas têm atacadores? (y/n)" + black);
        boolean atacadores = isYesNo();
        System.out.println( reset + "\nQual é o tamanho das sapatilhas?" + black);
        int tamanho = intScanner();
        System.out.println(reset + "\nDe que cor são as sapatilhas?" + black);
        String cor = scanner.nextLine();
        System.out.println(reset + "\nQual é o ano da edição das sapatilhas?" + black);
        int ano = intScanner();
        sapatilhas sap = new sapatilhas(premium,tamanho,atacadores,cor,ano);
        return sap;
    }

    public static tshirts criarTshirts(){
        System.out.println(red + "-----------NOVA TSHIRT-----------\n\n" + reset);
        System.out.println("Qual é o tamanho da tshirt? (S,M,L,XL)" + black);
        Tamanho tamanho = identificaTamanho();
        System.out.println(reset + "\nQual é o padrão da tshirt? (Liso, Riscas, Palmeiras)" + black);
        Padroes padrao = identificaPadrao();
        tshirts tshirt = new tshirts(tamanho,padrao);
        return tshirt;
    }

    private static Padroes identificaPadrao() {
        Scanner scanner = new Scanner(System.in);
        Padroes padrao = null;
        while (padrao == null) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("liso")) {
                padrao = Padroes.Liso;
            } else if (input.equalsIgnoreCase("riscas")) {
                padrao = Padroes.Riscas;
            } else if (input.equalsIgnoreCase("palmeiras")) {
                padrao = Padroes.Palmeiras;
            } else {
                System.out.println(reset + "\nPadrão inválido, por favor insira novamente: (Liso, Riscas, Palmeiras)" + black);
            }
        }
        return padrao;
    }

    private static Tamanho identificaTamanho() {
        Scanner scanner = new Scanner(System.in);
        Tamanho tamanho = null;
        while (tamanho == null) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("s")) {
                tamanho = Tamanho.S;
            } else if (input.equalsIgnoreCase("m")) {
                tamanho = Tamanho.M;
            } else if (input.equalsIgnoreCase("l")) {
                tamanho = Tamanho.L;
            } else if (input.equalsIgnoreCase("xl")) {
                tamanho = Tamanho.XL;
            } else {
                System.out.println(reset + "\nTamanho inválido, por favor insira novamente: (S,M,L,XL)" + black);
            }
        }
        return tamanho;
    }

    public static malas criarMalas(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(red + "-----------NOVA MALA-----------\n\n" + reset);
        System.out.println("A mala é premium? (y/n)" + black);
        boolean premium = isYesNo();
        System.out.println(reset + "\nQual é a largura da mala? (cm)" + black);
        int largura_x = intScanner();
        System.out.println(reset + "\nQual é a altura da mala? (cm)" + black);
        int altura_y = intScanner();
        System.out.println(reset + "\nQual é o material da mala?" + black);
        String material = scanner.nextLine();
        System.out.println(reset + "\nQual é o ano da coleção da mala?" + black);
        int ano = intScanner();
        malas mala = new malas(premium,largura_x,altura_y,material,ano);
        return mala;
    }
 
    public static artigos criarArtigo(Object obj){
        artigos art;
        Scanner scanner = new Scanner(System.in);
        System.out.println(red + "-----------NOVO ARTIGO-----------\n\n" + reset);
        System.out.println("O artigo foi usado? (y/n)" + black);
        boolean estado = isYesNo();
        int ndonos = 0;
        if(estado){
            System.out.println(reset + "\nQuantos donos teve o artigo anteriormente?" + black);
            int num = intScanner();
            ndonos = num;
        }
        System.out.println(reset + "\nEscreva uma breve descrição do artigo." + black);
        String descricao = scanner.nextLine();
        System.out.println(reset + "\nQual é a marca do artigo." + black);
        String marca = scanner.nextLine();
        System.out.println(reset + "\nQual é o código alfanumérico do artigo." + black);
        String codigo = scanner.nextLine();
        System.out.println(reset + "\nQual é o preço do artigo." + black);
        double preço = doubleScanner();
        if (obj instanceof sapatilhas) {
            sapatilhas sap = (sapatilhas) obj;
            art = new artigos(sap,!estado,ndonos,descricao,marca,codigo,preço);
        }
        else if (obj instanceof tshirts) {
            tshirts tshirt = (tshirts) obj;
            art = new artigos(tshirt,!estado,ndonos,descricao,marca,codigo,preço);
        }
        else if (obj instanceof malas) {
            malas mala = (malas) obj;
            art = new artigos(mala,!estado,ndonos,descricao,marca,codigo,preço);
        }
        else{
            art = new artigos(Tipo.Outro,!estado,ndonos,descricao,marca,codigo,preço);
        }
        return art;
    }

    public static utilizadores criarUtilizador(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(red + "-----------NOVO UTILIZADOR-----------\n\n"+ reset);
        System.out.println("Email:" + black);
        String mail = scanner.nextLine();
        String pass1 = "a", pass2 = "b";
        int errado = 0;
        while(!pass1.equals(pass2)){
            if(errado == 1){System.out.println(reset + "\nAs palavras-passes não são iguais. Tente outra vez." + black);}
            System.out.println(reset + "\nPalavra-passe:" + black);
            pass1 = scanner.nextLine();
            System.out.println(reset + "\nConfirmar Palavra-passe:" + black);
            pass2 = scanner.nextLine();
            errado++;
        }
        System.out.println(reset + "\nNome:" + black);
        String nome = scanner.nextLine();
        System.out.println(reset + "\nMorada:" + black);
        String morada = scanner.nextLine();
        System.out.println(reset + "\nNúmero Fiscal:" + black);
        int nfiscal = intScanner();
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
        return intScanner();
    }

    public static int menuCarrinho(){
        StringBuilder sb = new StringBuilder(red + "-----------MENU CARRINHO-----------\n\n");
        sb.append(blue + "1) " + reset + "Adicionar um artigo.\n");
        sb.append(blue + "2) " + reset + "Remover um artigo.\n");
        sb.append(blue + "3) " + reset + "Concluir.\n");
        sb.append(blue + "0) " + reset + "Voltar.\n\n");
        sb.append("Selecione a opção pretendida: " + black);
        System.out.println(sb.toString());
        return intScanner();
    }

    private static int intScanner(){
        Scanner scanner = new Scanner(System.in);
        String pattern = "\\d+";
        int opcao = 0;
        while(true){
            String input = scanner.next();
            if(input.matches(pattern)){
                opcao = Integer.parseInt(input);
                break;
            }
            else{
                System.out.println(reset + "\nValor inválido, por favor insira um número: " + black);
            }
        }
        scanner.nextLine();
        return opcao;
    }

    private static double doubleScanner(){
        Scanner scanner = new Scanner(System.in);
        String pattern = "\\d+(,\\d{0,2})?|\\d+(\\.\\d{0,2})?";
        double valor = 0;
        while(true){
            String input = scanner.next();
            input = input.replace(",", ".");
            if(input.matches(pattern)){
                valor = Double.parseDouble(input);
                break;
            }
            else{
                System.out.println(reset + "\nValor inválido, por favor insira um número: " + black);
            }
        }
        scanner.nextLine();
        return valor;
    }

    private static boolean isYesNo(){
        Scanner scanner = new Scanner(System.in);
        String pattern = "(?i)[yn]|yes|no";
        String ans = null;
        while(true){
            String input = scanner.next();
            if(input.matches(pattern)){
                ans = input;
                break;
            }
            else{
                System.out.println(reset + "\nValor inválido, por favor responda novamente: (y/n)" + black);
            }
        }
        return ans.equalsIgnoreCase("yes") || ans.equalsIgnoreCase("y");
    }
}
