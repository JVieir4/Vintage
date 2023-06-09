package vintage.src;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import vintage.src.artigos.Tipo;
import vintage.src.tshirts.Padroes;
import vintage.src.tshirts.Tamanho;

public class vintage {
    static StringBuilder banner = new StringBuilder(" _    ___       __                 \n")
            .append("| |  / (_)___  / /_____ _____ ____ \n")
            .append("| | / / / __ \\/ __/ __ `/ __ `/ _ \\\n")
            .append("| |/ / / / / / /_/ /_/ / /_/ /  __/\n")
            .append("|___/_/_/ /_/\\__/\\__,_/\\__, /\\___/ \n")
            .append("                      /____/       \n\n");

    private static String timejump = colors.BLACK + "T" + colors.RED + "I" + colors.GREEN + "M" + colors.YELLOW + "E"
            + colors.BLUE + " J" +
            colors.PURPLE + "U" + colors.CYAN + "M" + colors.RESET + "P";
    private static datemanager date = datemanager.getInstance();
    static DecimalFormat df = new DecimalFormat("#.##");

    public static int MenuInicial(boolean clear) {
        if (clear) {
            clearWindow();
        }
        StringBuilder sb = new StringBuilder(
                colors.RED + banner + "Data: " + colors.YELLOW + date.getCurrentDate() + "\n\n");
        sb.append(colors.BLUE + "1) " + colors.RESET + "Iniciar sessão.\n");
        sb.append(colors.BLUE + "2) " + colors.RESET + "Registar nova conta.\n");
        sb.append(colors.BLUE + "3) " + colors.RESET + "Ver utilizadores registados.\n");
        sb.append(colors.BLUE + "4) " + colors.RESET + "Ver transportadoras registadas.\n");
        sb.append(colors.BLUE + "5) " + colors.RESET + "Ver estatísticas.\n");
        sb.append(colors.BLUE + "6) " + colors.RESET + timejump + ".\n");
        sb.append(colors.BLUE + "0) " + colors.RESET + "Sair.\n\n");
        sb.append("Selecione a opção pretendida: " + colors.BLACK);
        System.out.println(sb.toString());
        return intScanner();
    }

    private static void clearWindow() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    public static int menuUtilizador(utilizadores u) {
        df.setMinimumFractionDigits(2);
        StringBuilder sb = new StringBuilder(colors.RED + "\n\n|-----------MENU UTILIZADOR-----------| " + colors.YELLOW
                + date.getCurrentDate() + colors.RED + " |\n\n");
        sb.append(colors.YELLOW + u.getNome() + ":\n");
        sb.append(colors.YELLOW + "Lucro: " + colors.RESET + df.format(u.getLucro()) + " EUR\n");
        sb.append(colors.YELLOW + "Prejuízo: " + colors.RESET + df.format(u.getPrejuizo()) + " EUR\n\n");
        sb.append(colors.BLUE + "1) " + colors.RESET + "Listar um artigo.\n");
        sb.append(colors.BLUE + "2) " + colors.RESET + "Comprar um artigo.\n");
        sb.append(colors.BLUE + "3) " + colors.RESET + "Ver carrinho.\n");
        sb.append(colors.BLUE + "4) " + colors.RESET + "Verificar artigos à venda.\n");
        sb.append(colors.BLUE + "5) " + colors.RESET + "Histórico de artigos vendidos.\n");
        sb.append(colors.BLUE + "6) " + colors.RESET + "Histórico de artigos comprados.\n");
        sb.append(colors.BLUE + "7) " + colors.RESET + "Encomendas pendentes (" + u.getPendentes().size() + ").\n");
        sb.append(colors.BLUE + "0) " + colors.RESET + "Logout.\n\n");
        sb.append("Selecione a opção pretendida: " + colors.BLACK);
        System.out.println(sb.toString());
        return intScanner();
    }

    public static int menuArtigo() {
        StringBuilder sb = new StringBuilder(colors.RED + "\n\n|-----------MENU ARTIGO-----------| " + colors.YELLOW
                + date.getCurrentDate() + colors.RED + " |\n\n");
        sb.append(colors.BLUE + "1) " + colors.RESET + "Sapatilha.\n");
        sb.append(colors.BLUE + "2) " + colors.RESET + "T-Shirt.\n");
        sb.append(colors.BLUE + "3) " + colors.RESET + "Mala.\n");
        sb.append(colors.BLUE + "4) " + colors.RESET + "Outro.\n");
        sb.append(colors.BLUE + "0) " + colors.RESET + "Voltar.\n");
        sb.append("Selecione a opção pretendida: " + colors.BLACK);
        System.out.println(sb.toString());
        return intScanner();
    }

    public static sapatilhas criarSapatilha() {
        System.out.println(colors.RED + "\n\n|-----------NOVA SAPATILHA-----------| " + colors.YELLOW
                + date.getCurrentDate() + colors.RED + " |\n\n" + colors.RESET);
        System.out.println("As sapatilhas são premium? (y/n)" + colors.BLACK);
        boolean premium = isYesNo();
        System.out.println(colors.RESET + "\nAs sapatilhas têm atacadores? (y/n)" + colors.BLACK);
        boolean atacadores = isYesNo();
        System.out.println(colors.RESET + "\nQual é o tamanho das sapatilhas?" + colors.BLACK);
        int tamanho = intScanner();
        System.out.println(colors.RESET + "\nDe que cor são as sapatilhas?" + colors.BLACK);
        String cor = stringScanner();
        System.out.println(colors.RESET + "\nQual é o ano da edição das sapatilhas?" + colors.BLACK);
        int ano = intScanner();
        sapatilhas sap = new sapatilhas(premium, tamanho, atacadores, cor, ano);
        return sap;
    }

    public static tshirts criarTshirts() {
        System.out.println(colors.RED + "\n\n|-----------NOVA TSHIRT-----------| " + colors.YELLOW
                + date.getCurrentDate() + colors.RED + " |\n\n" + colors.RESET);
        System.out.println("Qual é o tamanho da tshirt? (S,M,L,XL)" + colors.BLACK);
        Tamanho tamanho = identificaTamanho();
        System.out.println(colors.RESET + "\nQual é o padrão da tshirt? (Liso, Riscas, Palmeiras)" + colors.BLACK);
        Padroes padrao = identificaPadrao();
        tshirts tshirt = new tshirts(tamanho, padrao);
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
                System.out.println(colors.RESET
                        + "\nPadrão inválido, por favor insira novamente: (Liso, Riscas, Palmeiras)" + colors.BLACK);
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
                System.out.println(
                        colors.RESET + "\nTamanho inválido, por favor insira novamente: (S,M,L,XL)" + colors.BLACK);
            }
        }
        return tamanho;
    }

    public static malas criarMalas() {
        System.out.println(colors.RED + "\n\n|-----------NOVA MALA-----------| " + colors.YELLOW + date.getCurrentDate()
                + colors.RED + " |\n\n" + colors.RESET);
        System.out.println("A mala é premium? (y/n)" + colors.BLACK);
        boolean premium = isYesNo();
        System.out.println(colors.RESET + "\nQual é a largura da mala? (cm)" + colors.BLACK);
        int largura_x = intScanner();
        System.out.println(colors.RESET + "\nQual é a altura da mala? (cm)" + colors.BLACK);
        int altura_y = intScanner();
        System.out.println(colors.RESET + "\nQual é o material da mala?" + colors.BLACK);
        String material = stringScanner();
        System.out.println(colors.RESET + "\nQual é o ano da coleção da mala?" + colors.BLACK);
        int ano = intScanner();
        malas mala = new malas(premium, largura_x, altura_y, material, ano);
        return mala;
    }

    public static artigos criarArtigo(Object obj, gestortransportadoras gt) {
        artigos art;
        System.out.println(colors.RED + "\n\n|-----------NOVO ARTIGO-----------| " + colors.YELLOW
                + date.getCurrentDate() + colors.RED + " |\n\n" + colors.RESET);
        System.out.println("O artigo foi usado? (y/n)" + colors.BLACK);
        boolean estado = isYesNo();
        int ndonos = 0;
        if (estado) {
            System.out.println(colors.RESET + "\nQuantos donos teve o artigo anteriormente?" + colors.BLACK);
            int num = intScanner();
            ndonos = num;
        }
        System.out.println(colors.RESET + "\nEscreva uma breve descrição do artigo." + colors.BLACK);
        String descricao = stringScanner();
        System.out.println(colors.RESET + "\nQual é a marca do artigo." + colors.BLACK);
        String marca = stringScanner();
        System.out.println(colors.RESET + "\nQual é o preço do artigo." + colors.BLACK);
        double preço = doubleScanner();
        System.out.println(colors.RESET + "\nQual transportadora quer utilizar: " + colors.BLACK);
        transportadora t = null;
        if (obj instanceof sapatilhas) {
            sapatilhas sap = (sapatilhas) obj;
            if (sap.getPremium()) {
                t = escolheTransportadora(gt, "escolher: ", true);
            } else {
                t = escolheTransportadora(gt, "escolher: ", false);
            }
            art = new artigos(sap, !estado, ndonos, descricao, marca, preço, t);
        } else if (obj instanceof tshirts) {
            tshirts tshirt = (tshirts) obj;
            t = escolheTransportadora(gt, "escolher: ", false);
            art = new artigos(tshirt, !estado, ndonos, descricao, marca, preço, t);
        } else if (obj instanceof malas) {
            malas mala = (malas) obj;
            if (mala.getPrem()) {
                t = escolheTransportadora(gt, "escolher: ", true);
            } else {
                t = escolheTransportadora(gt, "escolher: ", false);
            }
            art = new artigos(mala, !estado, ndonos, descricao, marca, preço, t);
        } else {
            t = escolheTransportadora(gt, "escolher: ", false);
            art = new artigos(Tipo.Outro, !estado, ndonos, descricao, marca, preço, t);
        }
        return art;
    }

    public static transportadora escolheTransportadora(gestortransportadoras gt, String acao, boolean premium) {
        int prem = 0;
        if (premium) {
            System.out.println(gt.imprime(true));
            prem = 1;
        } else {
            System.out.println(gt.imprime(false));
        }
        transportadora t;
        System.out.println(colors.RESET + "Insira o número da transportadora que deseja " + acao + colors.BLACK);
        int index = intScanner();
        while (index < 1 || index > (gt.getCounter() - (prem * gt.getNotPremiumCounter()))) {
            System.out.println(
                    colors.RESET + "Valor inválido, insira o número de uma das transportadoras: " + colors.BLACK);
            index = intScanner();
        }
        t = gt.getTransportadorabyIndex(index);
        return t;
    }

    public static utilizadores criarUtilizador() {
        System.out.println(colors.RED + "\n\n|-----------NOVO UTILIZADOR-----------| " + colors.YELLOW
                + date.getCurrentDate() + colors.RED + " |\n\n" + colors.RESET);
        System.out.println("Email:" + colors.BLACK);
        String mail = stringScanner();
        String pass1 = "a", pass2 = "b";
        int errado = 0;
        while (!pass1.equals(pass2)) {
            if (errado == 1) {
                System.out
                        .println(colors.RESET + "\nAs palavras-passes não são iguais. Tente outra vez." + colors.BLACK);
            }
            System.out.println(colors.RESET + "\nPalavra-passe:" + colors.BLACK);
            pass1 = stringScanner();
            System.out.println(colors.RESET + "\nConfirmar Palavra-passe:" + colors.BLACK);
            pass2 = stringScanner();
            errado++;
        }
        System.out.println(colors.RESET + "\nNome:" + colors.BLACK);
        String nome = stringScanner();
        System.out.println(colors.RESET + "\nMorada:" + colors.BLACK);
        String morada = stringScanner();
        System.out.println(colors.RESET + "\nNúmero Fiscal:" + colors.BLACK);
        int nfiscal = intScanner();
        System.out.println("");
        utilizadores util = new utilizadores(mail, pass1, nome, morada, nfiscal);
        return util;
    }

    public static int menuComprar() {
        StringBuilder sb = new StringBuilder(colors.RED + "\n\n|-----------MENU COMPRA-----------| " + colors.YELLOW
                + date.getCurrentDate() + colors.RED + " |\n\n");
        sb.append(colors.BLUE + "1) " + colors.RESET + "Ver todos os artigos.\n");
        sb.append(colors.BLUE + "2) " + colors.RESET + "Pesquisar por tipo.\n");
        sb.append(colors.BLUE + "0) " + colors.RESET + "Cancelar.\n\n");
        sb.append("Selecione a opção pretendida: " + colors.BLACK);
        System.out.println(sb.toString());
        return intScanner();
    }

    public static int menuCarrinho() {
        StringBuilder sb = new StringBuilder(colors.RED + "\n\n|-----------MENU CARRINHO-----------| " + colors.YELLOW
                + date.getCurrentDate() + colors.RED + " |\n\n");
        sb.append(colors.BLUE + "1) " + colors.RESET + "Adicionar um artigo.\n");
        sb.append(colors.BLUE + "2) " + colors.RESET + "Remover um artigo.\n");
        sb.append(colors.BLUE + "3) " + colors.RESET + "Concluir.\n");
        sb.append(colors.BLUE + "0) " + colors.RESET + "Voltar.\n\n");
        sb.append("Selecione a opção pretendida: " + colors.BLACK);
        System.out.println(sb.toString());
        return intScanner();
    }

    public static int menuTransportadora(gestortransportadoras gt) {
        StringBuilder sb = new StringBuilder(colors.RED + "\n\n|-----------MENU TRANSPORTADORA-----------| "
                + colors.YELLOW + date.getCurrentDate() + colors.RED + " |\n\n");
        sb.append("\n" + gt.imprime(false));
        sb.append(colors.BLUE + "1) " + colors.RESET + "Adicionar transportadora.\n");
        sb.append(colors.BLUE + "2) " + colors.RESET + "Alterar taxa da transportadora.\n");
        sb.append(colors.BLUE + "3) " + colors.RESET + "Remover transportadora.\n");
        sb.append(colors.BLUE + "0) " + colors.RESET + "Voltar.\n");
        sb.append("Selecione a opção pretendida: " + colors.BLACK);
        System.out.println(sb.toString());
        return intScanner();
    }

    public static transportadora criarTransportadora() {
        System.out.println(colors.RED + "\n\n|-----------NOVA TRANSPORTADORA-----------| " + colors.YELLOW
                + date.getCurrentDate() + colors.RED + " |\n\n");
        System.out.println(colors.RESET + "Qual é o nome da transportadora: " + colors.BLACK);
        String nome = stringScanner();
        System.out.println(colors.RESET + "\nQual é a taxa de expedição da transportadora: " + colors.BLACK);
        int taxa = -1;
        while (taxa < 0 || taxa > 100) {
            taxa = intScanner();
        }
        System.out.println(colors.RESET + "\nA transportadora " + nome + " é premium? (y/n)" + colors.BLACK);
        boolean premium = isYesNo();
        return new transportadora(nome, taxa, premium);
    }

    public static int MenuEstatisticas(String melhorU, String melhorT, double total) {
        df.setMinimumFractionDigits(2);
        StringBuilder sb = new StringBuilder(colors.RED + "\n\n|-----------ESTATÍSTICAS-----------| " + colors.YELLOW
                + date.getCurrentDate() + colors.RED + " |\n\n");
        sb.append(colors.GREEN + "Vendedor com mais lucro:\t" + colors.YELLOW + melhorU);
        sb.append(colors.GREEN + "\nTransportador com mais lucro:\t" + colors.YELLOW + melhorT);
        sb.append(colors.GREEN + "\nLucro do Vintage:\t\t" + colors.YELLOW + df.format(total));
        sb.append(colors.BLUE + "\n1) " + colors.RESET + "Ver histórico de encomendas.\n");
        sb.append(colors.BLUE + "2) " + colors.RESET + "Melhores vendedores / Melhores compradores.\n");
        sb.append(colors.BLUE + "0) " + colors.RESET + "Sair.\n\n");
        sb.append("Selecione a opção pretendida: " + colors.BLACK);
        System.out.println(sb.toString());
        return intScanner();
    }

    public static int MenuTimeJump() {
        StringBuilder sb = new StringBuilder(colors.RED + "\n\n|-----------" + timejump + colors.RED + "-----------| "
                + colors.YELLOW + date.getCurrentDate() + colors.RED + " |\n\n");
        sb.append(colors.BLUE + "1) " + colors.RESET + "Avançar x dias.\n");
        sb.append(colors.BLUE + "2) " + colors.RESET + "Escolher uma data.\n");
        sb.append(colors.BLUE + "0) " + colors.RESET + "Voltar.\n\n");
        sb.append("Selecione a opção pretendida: " + colors.BLACK);
        System.out.println(sb.toString());
        return intScanner();
    }

    public static String stringScanner() {
        Scanner scanner = new Scanner(System.in);
        String txt;
        while (true) {
            String input = scanner.nextLine();
            if (input != null && input != "" && input != "\n") {
                txt = input;
                break;
            } else {
                System.out.println(colors.RESET + "\nInválido, por favor responda novamente: " + colors.BLACK);
            }
        }
        return txt;
    }

    public static int intScanner() {
        Scanner scanner = new Scanner(System.in);
        String pattern = "\\d+";
        int opcao = 0;
        while (true) {
            String input = scanner.next();
            if (input.matches(pattern)) {
                opcao = Integer.parseInt(input);
                break;
            } else {
                System.out.println(colors.RESET + "\nValor inválido, por favor insira um número: " + colors.BLACK);
            }
        }
        scanner.nextLine();
        return opcao;
    }

    public static double doubleScanner() {
        Scanner scanner = new Scanner(System.in);
        String pattern = "\\d+(,\\d{0,2})?|\\d+(\\.\\d{0,2})?";
        double valor = 0;
        while (true) {
            String input = scanner.next();
            input = input.replace(",", ".");
            if (input.matches(pattern)) {
                valor = Double.parseDouble(input);
                break;
            } else {
                System.out.println(colors.RESET + "\nValor inválido, por favor insira um número: " + colors.BLACK);
            }
        }
        scanner.nextLine();
        return valor;
    }

    public static boolean isYesNo() {
        Scanner scanner = new Scanner(System.in);
        String pattern = "(?i)[yn]|yes|no";
        String ans = null;
        while (true) {
            String input = scanner.next();
            if (input.matches(pattern)) {
                ans = input;
                break;
            } else {
                System.out
                        .println(colors.RESET + "\nValor inválido, por favor responda novamente: (y/n)" + colors.BLACK);
            }
        }
        return ans.equalsIgnoreCase("yes") || ans.equalsIgnoreCase("y");
    }

    public static void escolheData() {
        boolean ano = true, mes = true, dia = true;
        int a = 0, m = 0, d = 0;
        while (ano || mes || dia) {
            if (ano) {
                System.out.println(
                        colors.RESET + "\nEscolha o ano: (>" + date.getCurrentDate().getYear() + ")" + colors.BLACK);
                a = intScanner();
                if (a >= date.getCurrentDate().getYear()) {
                    ano = false;
                } else {
                    System.out.print("Ano inválido.\n");
                }
            }
            if (mes && !ano) {
                System.out.println(colors.RESET + "\nEscolha o mês: (1-12)" + colors.BLACK);
                m = intScanner();
                int minM = 0;
                if (a == date.getCurrentDate().getYear()) {
                    minM = date.getCurrentDate().getMonthValue();
                }
                if (m >= minM && m < 12) {
                    mes = false;
                } else {
                    System.out.print("Mês inválido.\n");
                }
            }
            if (dia && !mes && !ano) {
                System.out.println(colors.RESET + "\nEscolha o dia: " + colors.BLACK);
                d = intScanner();
                int minD = 0;
                if (a == date.getCurrentDate().getYear() && m == date.getCurrentDate().getMonthValue()) {
                    minD = date.getCurrentDate().getDayOfMonth();
                }
                if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) {
                    if (d >= minD && d < 32) {
                        dia = false;
                    } else {
                        System.out.print("Dia inválido.\n");
                    }
                } else if (m == 4 || m == 6 || m == 9 || m == 11) {
                    if (d >= minD && d < 31) {
                        dia = false;
                    } else {
                        System.out.print("Dia inválido.\n");
                    }
                } else if ((a % 4 == 0 && a % 100 != 0) || a % 400 == 0) {
                    if (d >= minD && d < 30) {
                        dia = false;
                    } else {
                        System.out.print("Dia inválido.\n");
                    }
                } else {
                    if (d >= minD && d < 29) {
                        dia = false;
                    } else {
                        System.out.print("Dia inválido.\n");
                    }
                }
            }
        }
        long dif = ChronoUnit.DAYS.between(date.getCurrentDate(), LocalDate.of(a, m, d));
        date.advanceDays(dif);
    }
}
