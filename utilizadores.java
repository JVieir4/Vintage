package vintage;

public class utilizadores {
    private String systemcode;
    private String email;
    private String nome;
    private String morada;
    private int nfiscal;
    public artigos[] art_a_venda = new artigos[10];
    private artigos[] art_vendidos = new artigos[10];;
    private artigos[] art_comprados = new artigos[10];;

    public utilizadores(String code, String mail, String name, String address, int fiscal){
        this.systemcode = code;
        this.email = mail;
        this.nome = name;
        this.morada = address;
        this.nfiscal = fiscal;
    }

    public utilizadores(utilizadores novo){
        this.systemcode = novo.getCode();
        this.email = novo.getEmail();
        this.nome = novo.getNome();
        this.morada = novo.getMorada();
        this.nfiscal = novo.getFiscal();
    }

    public int getFiscal() {
        return this.nfiscal;
    }
    public void setFiscal(int f) {
        this.nfiscal = f;
    }

    public String getMorada() {
        return this.morada;
    }
    public void setMorada(String m) {
        this.morada = m;
    }

    public String getNome() {
        return this.nome;
    }
    public void setNome(String n) {
        this.nome = n;
    }

    public String getEmail() {
        return this.email;
    }
    public void setEmail(String mail) {
        this.email = mail;
    }

    public String getCode() {
        return this.systemcode;
    }
    public void setCode(String c) {
        this.systemcode = c;
    }

    public void listarArtigo(artigos A){
        for (int i = 0; i < art_a_venda.length; i++){
            if(art_a_venda[i] == null){
                art_a_venda[i] = A;
                break;
            }
        }
        /* Função para colocar um artigo à venda
         * Nesta função são chamados os construtores da classe artigos
         * E esse mesmo artigo é colocado na lista art_a_venda;
         */
    }

    public void comprarArtigo(){
        /* Função para comprar um artigo
         * Esta função mostra uma lista dos artigos disponíveis
         * E esse mesmo artigo é colocado na lista art_comprados;
         */
    }

    public void imprime(artigos[] a){
        for (int i = 0; i < a.length; i++){
            if(a[i] != null){ 
                System.out.println(a[i] + "\n.");
            }
        }
    }

    public utilizadores clone() {
        return new utilizadores(this);
    }

    @Override
    public String toString(){
        return this.nome + "\nEmail: " + this.email + "\nMorada: " + this.morada + "\nNúmero Fiscal: " + this.nfiscal;
    }
}
