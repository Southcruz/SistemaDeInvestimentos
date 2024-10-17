import java.time.LocalDateTime;

public class Transacao {
    private int id;
    private String tipo;  // "compra" ou "venda"
    private Investimento investimento;
    private int quantidade;
    private double preco;
    private LocalDateTime data;

    // Construtor
    public Transacao(int id, String tipo, Investimento investimento, int quantidade, double preco) {
        this.id = id;
        this.tipo = tipo;
        this.investimento = investimento;
        this.quantidade = quantidade;
        this.preco = preco;
        this.data = LocalDateTime.now();  
    }

    public double calcularValorTotal() {
        return quantidade * preco;
    }

    public void ajustarSaldo(Conta conta) {
        double valorTotal = calcularValorTotal();
        double saldoAtual = conta.getSaldoDisponivel();

        if (tipo.equalsIgnoreCase("compra")) {
            if (saldoAtual >= valorTotal) {
                conta.setSaldoDisponivel(saldoAtual - valorTotal);
                System.out.println("Compra realizada! Valor da transação: " + valorTotal);
            } else {
                System.out.println("Saldo insuficiente para realizar a compra.");
            }
        } 

        else if (tipo.equalsIgnoreCase("venda")) {
            conta.setSaldoDisponivel(saldoAtual + valorTotal);
            System.out.println("Venda realizada! Valor da transação: " + valorTotal);
        }
    }

    public void exibirDetalhes() {
        System.out.println("Transação: " + tipo);
        System.out.println("Investimento: " + investimento.getInstituicao());
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Preço por Unidade: " + preco);
        System.out.println("Valor Total: " + calcularValorTotal());
        System.out.println("Data: " + data);
    }

    public String getTipo() {
        return tipo;
    }

    public Investimento getInvestimento() {
        return investimento;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public LocalDateTime getData() {
        return data;
    }
}
