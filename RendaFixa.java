public class RendaFixa extends Investimento {
    private date dataVencimento;
    private float taxaJuros;
    private float valorInicial;

    // Construtor
    public RendaFixa(date dataVencimento, float taxaJuros, float valorInicial) {
        this.dataVencimento = dataVencimento;
        this.taxaJuros = taxaJuros;
        this.valorInicial = valorInicial;
    }

    // Método para calcular o rendimento
    public float calcularRendimento() {
        
    }

    // Getters e setters
    public date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(date dataVencimento) {
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
