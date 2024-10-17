public class RendaVariavel extends Investimento {
    private float volatilidade;
    private float dividendos;

    // Construtor
    public RendaVariavel(float volatilidade, float dividendos) {
        this.volatilidade = volatilidade;
        this.dividendos = dividendos;
    }

    // Métodos para calcular o valor de mercado
    public float calcularValorMercado() {
        
    }

    // Métodos para calcular os dividendos
    public float calcularDividendos() {
       
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
