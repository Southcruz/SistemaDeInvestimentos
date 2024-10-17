import java.time.LocalDate;

public class Simulacao {
    private Investimento investimento;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    // Construtor para inicializar a simulação com o investimento e as datas
    public Simulacao(Investimento investimento, LocalDate dataInicio, LocalDate dataFim)
            throws IllegalArgumentException {
        if (dataFim.isBefore(dataInicio)) {
            throw new IllegalArgumentException("A data final não pode ser anterior à data de início.");
        }
        this.investimento = investimento;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    // Getters e Setters
    public Investimento getInvestimento() {
        return investimento;
    }

    public void setInvestimento(Investimento investimento) {
        this.investimento = investimento;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) throws IllegalArgumentException {
        if (dataFim.isBefore(dataInicio)) {
            throw new IllegalArgumentException("A data final não pode ser anterior à data de início.");
        }
        this.dataFim = dataFim;
    }

    // Método para calcular o período da simulação em dias
    public long calcularPeriodoSimulacao() {
        return dataInicio.until(dataFim).getDays();
    }

    // Método para simular o rendimento do investimento
    public float simularRendimento() throws UnsupportedOperationException {
        long dias = calcularPeriodoSimulacao();

        // Se o investimento for do tipo Renda Fixa
        if (investimento instanceof RendaFixa) {
            RendaFixa rendaFixa = (RendaFixa) investimento;
            return calcularRendimentoRendaFixa(rendaFixa, dias);

            // Se o investimento for do tipo Renda Variável
        } else if (investimento instanceof RendaVariavel) {
            RendaVariavel rendaVariavel = (RendaVariavel) investimento;
            return calcularRendimentoRendaVariavel(rendaVariavel, dias);
        }

        throw new UnsupportedOperationException("Tipo de investimento não suportado para simulação.");
    }

    // Método privado para simular rendimento de Renda Fixa
    private float calcularRendimentoRendaFixa(RendaFixa rendaFixa, long dias) {
        float taxaDiaria = rendaFixa.getTaxaJuros() / 365; // Supondo taxa anual
        return rendaFixa.getValorInicial() * (1 + taxaDiaria * dias);
    }

    // Método privado para simular rendimento de Renda Variável
    private float calcularRendimentoRendaVariavel(RendaVariavel rendaVariavel, long dias) {
        float fatorVolatilidade = rendaVariavel.getVolatilidade() / 100; // Volatilidade como porcentagem
        return rendaVariavel.getPrecoAtual() * (1 + fatorVolatilidade * dias); // Simplificação da simulação
    }

    // Método para exibir o relatório de simulação
    public void exibirRelatorioSimulacao() {
        System.out.println("Relatório de Simulação");
        System.out.println("Investimento: " + investimento.getTipo());
        System.out.println("Data de Início: " + dataInicio);
        System.out.println("Data de Fim: " + dataFim);
        System.out.println("Período Simulado: " + calcularPeriodoSimulacao() + " dias");
        try {
            System.out.println("Rendimento Estimado: R$ " + simularRendimento());
        } catch (UnsupportedOperationException e) {
            System.out.println("Erro na simulação: " + e.getMessage());
        }
    }
}
