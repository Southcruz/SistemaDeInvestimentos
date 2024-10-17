import java.time.LocalDateTime;

public class Transacao {
    private String tipo; // Pode ser "Depósito", "Saque", "Compra de Investimento", etc.
    private float valor;
    private LocalDateTime dataHora;
    private String descricao;

    // Construtor
    public Transacao(String tipo, float valor, String descricao) throws IllegalArgumentException {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor da transação deve ser positivo.");
        }
        this.tipo = tipo;
        this.valor = valor;
        this.dataHora = LocalDateTime.now(); // Pega a data e hora atual
        this.descricao = descricao;
    }

    // Getters e Setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) throws IllegalArgumentException {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor da transação deve ser positivo.");
        }
        this.valor = valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // Método para exibir detalhes da transação
    public void exibirDetalhes() {
        System.out.println("Tipo de Transação: " + tipo);
        System.out.println("Valor: R$ " + valor);
        System.out.println("Data e Hora: " + dataHora);
        System.out.println("Descrição: " + descricao);
    }

    // Método para verificar se a transação é um tipo específico
    public boolean isTipo(String tipo) {
        return this.tipo.equalsIgnoreCase(tipo);
    }
}
