import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Investidor investidor = null;  // Inicialmente, não há investidor logado
        boolean loggedIn = false;

        while (true) {
            System.out.println("\n----- SISTEMA DE INVESTIMENTOS FINANCEIROS -----");
            System.out.println("1. Criar conta");
            System.out.println("2. Login");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                // Cadastro do Investidor e sua Conta
                case 1:
                    System.out.println("\n----- CADASTRO DE CONTA -----");
                    System.out.print("Informe seu CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Informe seu nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Informe seu email: ");
                    String email = scanner.nextLine();
                    System.out.print("Informe sua senha: ");
                    String senha = scanner.nextLine();
                    System.out.print("Informe o número da conta: ");
                    String numeroConta = scanner.nextLine();
                    System.out.print("Informe o saldo inicial da conta: ");
                    float saldoInicial = scanner.nextFloat();
                    scanner.nextLine();

                    Conta conta = new Conta(numeroConta, saldoInicial);
                    investidor = new Investidor(cpf, nome, email, senha, conta);
                    System.out.println("Conta criada com sucesso!");
                    break;
                
                // Login do Investidor
                case 2:
                    if (investidor == null) {
                        System.out.println("Você ainda não criou uma conta. Crie uma conta antes de fazer login.");
                        continue;
                    }
                    System.out.print("Informe seu email: ");
                    String emailLogin = scanner.nextLine();
                    System.out.print("Informe sua senha: ");
                    String senhaLogin = scanner.nextLine();
                    if (investidor.login(emailLogin, senhaLogin)) {
                        loggedIn = true;
                    } else {
                        System.out.println("Falha no login. Tente novamente.");
                        continue;
                    }

                    // APÓS LOGAR NA CONTA
                    while (loggedIn) {
                        System.out.println("\n----- SISTEMA DE INVESTIMENTOS FINANCEIROS -----");
                        System.out.println("Bem vindo(a), " + investidor.getNome() + "!");
                        System.out.println("Saldo Disponível: " + investidor.getConta().getSaldoDisponivel());

                        // Exibir opções do menu
                        System.out.println("1. Consultar Relatório de Investimentos");
                        System.out.println("2. Realizar Novo Investimento");
                        System.out.println("3. Resgatar Investimentos");
                        System.out.println("4. Realizar Transação");
                        System.out.println("5. Simulação de Investimentos");
                        System.out.println("6. Logout");
                        System.out.print("Escolha uma opção: ");
                        int opcaoMenu2 = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcaoMenu2) {
                            case 1:
                                // Consultar Relatório de Investimentos
                                System.out.println(investidor.getConta().getInvestimentos());
                                break;

                            case 2:
                                // Realizar Novo Investimento
                                System.out.println("\nSelecione o tipo de investimento:");
                                System.out.println("1. Renda Fixa");
                                System.out.println("2. Renda Variável");
                                int tipoInvestimento = scanner.nextInt();
                                scanner.nextLine();

                                Investimento investimento = null;

                                switch (tipoInvestimento) {
                                    case 1:
                                        // Investimento em Renda Fixa
                                        System.out.print("Informe a data de vencimento (dd-mm-yyyy): ");
                                        String dataVencimento = scanner.nextLine();
                                        System.out.print("Informe a taxa de juros (%): ");
                                        float taxaJuros = scanner.nextFloat();
                                        System.out.print("Informe o valor inicial do investimento: ");
                                        float valorInicial = scanner.nextFloat();
                                        scanner.nextLine();

                                        investimento = new RendaFixa(dataVencimento, taxaJuros, valorInicial);
                                        investidor.getConta().adicionarInvestimento(investimento);
                                        System.out.println("Investimento em Renda Fixa adicionado com sucesso!");
                                        break;

                                    case 2:
                                        // Investimento em Renda Variável
                                        System.out.print("Informe a volatilidade (%): ");
                                        float volatilidade = scanner.nextFloat();
                                        System.out.print("Informe os dividendos: ");
                                        float dividendos = scanner.nextFloat();
                                        scanner.nextLine();

                                        investimento = new RendaVariavel(volatilidade, dividendos);
                                        investidor.getConta().adicionarInvestimento(investimento);
                                        System.out.println("Investimento em Renda Variável adicionado com sucesso!");
                                        break;

                                    default:
                                        System.out.println("Opção inválida para tipo de investimento.");
                                }
                                break;

                            case 3:
                                // Resgatar Investimentos
                                // Lógica para resgatar investimentos
                                System.out.println("Funcionalidade de resgatar investimentos ainda não implementada.");
                                break;

                            case 4:
                                // Realizar Transação
                                System.out.print("Informe o tipo de transação (Deposito, Saque, Compra de Investimento, etc.): ");
                                String tipoTransacao = scanner.nextLine();
                                System.out.print("Informe o valor da transação: ");
                                float valorTransacao = scanner.nextFloat();
                                scanner.nextLine();

                                System.out.print("Informe uma descrição para a transação: ");
                                String descricaoTransacao = scanner.nextLine();

                                Transacao transacao = new Transacao(tipoTransacao, valorTransacao, descricaoTransacao);
                                investidor.getConta().getTransacoes().add(transacao);
                                transacao.exibirDetalhes();
                                break;

                            case 5:
                                // Simulação de Investimentos
                                if (investidor.getConta().getInvestimentos().isEmpty()) {
                                    System.out.println("Você ainda não possui investimentos para simular.");
                                    continue;
                                }

                                System.out.print("Informe a data de início da simulação (dd-mm-yyyy): ");
                                String dataInicio = scanner.nextLine();
                                System.out.print("Informe a data de fim da simulação (dd-mm-yyyy): ");
                                String dataFim = scanner.nextLine();

                                // Converter as datas de entrada
                                LocalDate inicio = LocalDate.parse(dataInicio, java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy"));
                                LocalDate fim = LocalDate.parse(dataFim, java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy"));

                                // Usar o primeiro investimento da conta para simulação (exemplo)
                                Investimento investimentoSimulacao = investidor.getConta().getInvestimentos().get(0);
                                Simulacao simulacao = new Simulacao(investimentoSimulacao, inicio, fim);
                                simulacao.exibirRelatorioSimulacao();
                                break;

                            case 6:
                                // Logout
                                investidor.logout();
                                loggedIn = false;
                                break;

                            default:
                                System.out.println("Opção inválida. Tente novamente.");
                        }
                    }
                    break;

                case 3:
                    // Sair do programa
                    System.out.println("Obrigado por utilizar o sistema de investimentos. Até logo!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
