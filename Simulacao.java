public class Simulacao {
    private int id;
    private Investimento investimento;
    private int quantidade;
    private double precoSimulado;
    private double resultado;

    public Simulacao(int id, Investimento investimento, int quantidade, double precoSimulado){
        this.id = id;
        this.investimento = investimento;
        this.quantidade = quantidade;
        this.precoSimulado = precoSimulado;
    }
    public void simularInvestimento(){
        resultado = calcularResultadoSimulacao();
        System.out.println("Simulação realizada para o investimento: " + investimento.getInstituicao());
        System.out.println("Preço Simulado: " + precoSimulado);
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Resultado da Simulação: " + resultado);
    }

    public double calcularResultadoSimulacao(){
        double precoAtual = investimento.getPrecoAtual();
        return (precoSimulado - precoAtual) * quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Investimento getInvestimento() {
        return investimento;
    }

    public void setInvestimento(Investimento investimento) {
        this.investimento = investimento;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoSimulado() {
        return precoSimulado;
    }

    public void setPrecoSimulado(double precoSimulado) {
        this.precoSimulado = precoSimulado;
    }

    public double getResultado() {
        return resultado;
    }
}
