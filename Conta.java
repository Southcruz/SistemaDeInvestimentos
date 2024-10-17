import java.util.ArrayList;
import java.util.List;

public class Conta {
    private String numero;
    private float saldoDisponivel;
    private List<Investimento> investimentos;
    private List<Transacao> transacoes;

    // Construtor padrão
    public Conta() {
        this.investimentos = new ArrayList<>();
        this.transacoes = new ArrayList<>();
    }

    // Construtor com parâmetros
    public Conta(String numero, float saldoInicial) throws IllegalArgumentException {
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("O saldo inicial não pode ser negativo.");
        }
        this.numero = numero;
        this.saldoDisponivel = saldoInicial;
        this.investimentos = new ArrayList<>();
        this.transacoes = new ArrayList<>();
    }

    // Getters e Setters
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public float getSaldoDisponivel() {
        return saldoDisponivel;
    }

    public void setSaldoDisponivel(float saldoDisponivel) throws IllegalArgumentException {
        if (saldoDisponivel < 0) {
            throw new IllegalArgumentException("O saldo não pode ser negativo.");
        }
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

    // Método para adicionar um investimento à conta
    public void adicionarInvestimento(Investimento investimento) {
        if (investimento != null) {
            investimentos.add(investimento);
            System.out.println("Investimento adicionado com sucesso.");
        } else {
            throw new NullPointerException("Investimento não pode ser nulo.");
        }
    }

    // Método para remover um investimento da conta
    public void removerInvestimento(Investimento investimento) {
        if (investimentos.remove(investimento)) {
            System.out.println("Investimento removido com sucesso.");
        } else {
            System.out.println("Investimento não encontrado.");
        }
    }
}
