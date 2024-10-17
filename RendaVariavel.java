public class RendaVariavel extends Investimento {
    private float volatilidade;
    private float dividendos;

    // Construtor
    public RendaVariavel(float volatilidade, float dividendos) {
        super(id, tipo, instituicao, quantidade, volatilidade, dividendos);
        // Inicializa os valores necessários
        int id = this.getId();
        String tipo = this.getTipo();
        String instituicao = this.getInstituicao();
        int quantidade = this.getQuantidade();
    
    
        this.volatilidade = volatilidade;
        this.dividendos = dividendos;
    }

    // Métodos para calcular o valor de mercado
    public float calcularValorMercado() {
        return 0;
    }

    // Métodos para calcular os dividendos
    public float calcularDividendos() {
       return 0;
    }

    // Getters e Setters
    public float getVolatilidade() {
        return volatilidade;
    }

    public void setVolatilidade(float volatilidade) {
        this.volatilidade = volatilidade;
    }

    public float getDividendos() {
        return dividendos;
    }

    public void setDividendos(float dividendos) {
        this.dividendos = dividendos;
    }
}


