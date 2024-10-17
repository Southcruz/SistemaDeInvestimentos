import java.util.ArrayList;
import java.util.List;

public class Conta {
    private String numero;
    private double saldoDisponivel;  // Ajustado para double
    private List<Investimento> investimentos;
    private List<Transacao> transacoes;

    // Construtor padrão
    public Conta() {
        this.investimentos = new ArrayList<>();
        this.transacoes = new ArrayList<>();
    }

    // Construtor com parâmetros
    public Conta(String numero, double saldoInicial) {
        this.numero = numero;
        this.saldoDisponivel = saldoInicial;
        this.investimentos = new ArrayList<>();
        this.transacoes = new ArrayList<>();
    }

    // Método para adicionar uma transação (compra ou venda)
    public void adicionarTransacao(Transacao transacao) {
        double valorTransacao = transacao.calcularValorTotal();

        if (transacao.getTipo().equalsIgnoreCase("compra")) {
            if (saldoDisponivel >= valorTransacao) {
                saldoDisponivel -= valorTransacao;  // Debita o valor da compra
                adicionarOuAtualizarInvestimento(transacao.getInvestimento(), transacao.getQuantidade());
                transacoes.add(transacao);
                System.out.println("Compra realizada com sucesso.");
            } else {
                System.out.println("Saldo insuficiente para realizar a compra.");
            }
        } else if (transacao.getTipo().equalsIgnoreCase("venda")) {
            saldoDisponivel += valorTransacao;  // Credita o valor da venda
            ajustarOuRemoverInvestimento(transacao.getInvestimento(), transacao.getQuantidade());
            transacoes.add(transacao);
            System.out.println("Venda realizada com sucesso!");
        }
    }

    // Método para adicionar ou atualizar um investimento no portfólio
    public void adicionarOuAtualizarInvestimento(Investimento investimento, int quantidade) {
        for (Investimento inv : investimentos) {
            if (inv.getId() == investimento.getId()) {
                inv.setQuantidade(inv.getQuantidade() + quantidade);  // Atualiza a quantidade
                return;
            }
        }
        investimentos.add(investimento);  // Se o investimento não existir, adiciona-o
    }

    // Método para ajustar ou remover o investimento após uma venda
    public void ajustarOuRemoverInvestimento(Investimento investimento, int quantidadeVendida) {
        for (Investimento inv : investimentos) {
            if (inv.getId() == investimento.getId()) {
                if (inv.getQuantidade() > quantidadeVendida) {
                    inv.setQuantidade(inv.getQuantidade() - quantidadeVendida);  // Ajusta a quantidade
                } else {
                    investimentos.remove(inv);  // Remove se a quantidade vendida for igual ou maior
                }
                return;
            }
        }
        System.out.println("Investimento não encontrado.");
    }

    // Getters e Setters
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSaldoDisponivel() {
        return saldoDisponivel;
    }

    public void setSaldoDisponivel(double saldoDisponivel) {
        this.saldoDisponivel = saldoDisponivel;
    }

    public List<Investimento> getInvestimentos() {
        return investimentos;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    // Método para exibir informações da conta
    public void exibir() {
        System.out.println("Número da Conta: " + numero);
        System.out.println("Saldo Disponível: " + saldoDisponivel);
        System.out.println("Investimentos: " + investimentos.size());
        System.out.println("Transações: " + transacoes.size());
    }

    // Método para adicionar um investimento diretamente
    public void adicionarInvestimento(Investimento investimento) {
        investimentos.add(investimento);
        System.out.println("Investimento adicionado com sucesso.");
    }

    // Método para remover um investimento diretamente
    public void removerInvestimento(Investimento investimento) {
        if (investimentos.remove(investimento)) {
            System.out.println("Investimento removido com sucesso.");
        } else {
            System.out.println("Investimento não encontrado.");
        }
    }
}
