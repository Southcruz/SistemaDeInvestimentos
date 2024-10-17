import java.util.InputMismatchException;
import java.util.Scanner;

public class Investidor {
    private String cpf;
    private String nome;
    private String email;
    private String senha;
    private Conta conta;

    // Construtor padrão
    public Investidor() {
    }

    // Construtor com parâmetros
    public Investidor(String cpf, String nome, String email, String senha, Conta conta) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.conta = conta;
    }

    // Getters e Setters
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    // Método para cadastrar o investidor
    public void cadastrar() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Digite o CPF: ");
            this.cpf = scanner.nextLine();

            System.out.print("Digite o nome: ");
            this.nome = scanner.nextLine();

            System.out.print("Digite o email: ");
            this.email = scanner.nextLine();

            System.out.print("Digite a senha: ");
            this.senha = scanner.nextLine();

            System.out.print("Digite o número da conta: ");
            String numeroConta = scanner.nextLine();
            this.conta = new Conta(numeroConta, 0);

            System.out.println("Investidor cadastrado com sucesso!");
        } catch (InputMismatchException e) {
            System.out.println("Erro de entrada: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    // Método para o investidor realizar o login
    public boolean login(String email, String senha) {
        if (this.email.equals(email) && this.senha.equals(senha)) {
            System.out.println("Login realizado com sucesso!");
            return true;
        } else {
            System.out.println("Falha no login. Verifique suas credenciais.");
            return false;
        }
    }

    // Método para o investidor realizar o logout
    public void logout() {
        System.out.println("Logout realizado com sucesso!");
    }
}
