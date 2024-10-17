public class Investimento {
    private int id;
    private String tipo;
    private String instituicao;
    private int quantidade;
    private double precoCompra;
    private double precoAtual;

    public Investimento(int id, String tipo, String instituicao, int quantidade, double precoCompra, double precoAtual) {
        this.id = id;
        this.tipo = tipo;
        this.instituicao = instituicao;
        this.quantidade = quantidade;
        this.precoCompra = precoCompra;
        this.precoAtual = precoAtual;
    }

    public double calcularValorAtual() {
        return this.quantidade * this.precoAtual;
    }
    public void atualizarPreco(float novoPreco) {
        this.precoAtual = novoPreco;
    }

    //getters
    public int getId() {
        return id;
    }
    public String getTipo() {
        return tipo;
    }
    public String getInstituicao(){
        return instituicao;
    }
    public int getQuantidade(){
        return quantidade;
    }
    public double getPrecoCompra(){
        return precoCompra;
    }
    public double getPrecoAtual(){
        return precoAtual;
    }

    //setters
    public void setId(int id){
        this.id = id;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public void setInstituicao(String instituicao){
        this.instituicao = instituicao;
    }
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
    public void setPrecoCompra(float precoCompra){
        this.precoCompra = precoCompra;
    }
    public void setPrecoAtual(double precoAtual){
        this.precoAtual = precoAtual;
    }
}