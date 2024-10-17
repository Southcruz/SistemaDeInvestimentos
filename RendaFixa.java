import java.time.LocalDateTime;

public class RendaFixa extends Investimento {
    private LocalDateTime dataVencimento;
    private float taxaJuros;
    private float valorInicial;

    // Construtor
    public RendaFixa(LocalDateTime dataVencimento, float taxaJuros, float valorInicial) {
        super(getId(), getTipo(), getInstituicao(), getQuantidade(), taxaJuros, valorInicial);
        this.dataVencimento = dataVencimento;
        this.taxaJuros = taxaJuros;
        this.valorInicial = valorInicial;
    }

    // Método para calcular o rendimento
    public float calcularRendimento() {
        return 0;
    }

    // Getters e setters
    public LocalDateTime getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDateTime dataVencimento) {
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
