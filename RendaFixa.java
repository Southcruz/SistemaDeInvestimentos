public class RendaFixa extends Investimento {
    private String dataVencimento;
    private float taxaJuros;
    private float valorInicial;

    // Construtor
    public RendaFixa(String dataVencimento, float taxaJuros, float valorInicial) throws IllegalArgumentException {
        if (valorInicial < 0 || taxaJuros < 0) {
            throw new IllegalArgumentException("Valor inicial e taxa de juros devem ser positivos.");
        }
        this.dataVencimento = dataVencimento;
        this.taxaJuros = taxaJuros;
        this.valorInicial = valorInicial;
    }

    // Método para calcular o rendimento
    public float calcularRendimento() {
        return valorInicial * (1 + (taxaJuros / 100));
    }

    // Getters e Setters
    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public float getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(float taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    public float getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(float valorInicial) {
        this.valorInicial = valorInicial;
    }
}
