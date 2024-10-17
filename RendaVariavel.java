public class RendaVariavel extends Investimento {
    private float volatilidade;
    private float dividendos;

    // Construtor
    public RendaVariavel(float volatilidade, float dividendos) throws IllegalArgumentException {
        if (volatilidade < 0 || dividendos < 0) {
            throw new IllegalArgumentException("Volatilidade e dividendos não podem ser negativos.");
        }
        this.volatilidade = volatilidade;
        this.dividendos = dividendos;
    }

    // Método para calcular o valor de mercado
    public float calcularValorMercado() {
        return dividendos * volatilidade;
    }

    // Método para calcular os dividendos
    public float calcularDividendos() {
        return dividendos;
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
