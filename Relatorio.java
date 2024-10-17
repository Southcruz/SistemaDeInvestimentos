import java.time.LocalDateTime;
import java.util.List;


public class Relatorio {
    private String tipo;
    private List<Investimento> dados;
    private LocalDateTime dataGeracao;
    private Conta conta;

    public Relatorio(String tipo, Conta conta ){
        this.tipo = tipo;
        this.conta = conta;
        this.dataGeracao = LocalDateTime.now();
    }
    public void gerarRelatorio(){
        System.out.println("Gerando relatório do tipo: " + tipo);
        this.dados = conta.getInvestimentos();

        if (dados.isEmpty()){
            System.out.println("Nenhum investimento disponível para gerar o relatório.");
        } else {
            exibirRelatorio();
        }
    }

    public void exibirRelatorio(){
        System.out.println("Relatório gerado em: " + dataGeracao);
        System.out.println("Tipo de relatório: " + tipo);
        System.out.println("Investimentos: ");

        for (Investimento investimento : dados){
            System.out.println("Investimento: " + investimento.getInstituicao() + 
            ", Quantidade: " + investimento.getQuantidade() +
            ", Preço Atual: " + investimento.getPrecoAtual() +
            ", Valor Atual: " + investimento.calcularValorAtual());
        }
    }

    public void exportarPDF(){
        System.out.println("Exportando relatório para PDF...");
        //aqui será implementado a lógica de exportar o relatório para PDF utilizando ferramentas externas
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getDataGeracao() {
        return dataGeracao;
    }

    public List<Investimento> getDados() {
        return dados;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}
