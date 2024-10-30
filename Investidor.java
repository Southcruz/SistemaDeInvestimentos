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
    public Investidor(String cpf, String nome, String email, String senha, String numero, double saldoInicial) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.conta = new Conta(numero, saldoInicial);
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

    public void logout() {
        System.out.println("Logout realizado com sucesso!");
    }

    public boolean login(String email, String senha) {
        if (this.email.equals(email) && this.senha.equals(senha)) {
            System.out.println("Login realizado com sucesso!");
            return true;
        } else {
            System.out.println("Falha no login. Verifique suas credenciais.");
            return false;
        }
    }
    
    public void excluirCadastro() {
        // Limpar dados da conta associada
        if (conta != null) {
            conta.getInvestimentos().clear();
            conta.getTransacoes().clear();
        }

        // Redefinir dados do investidor
        this.cpf = null;
        this.nome = null;
        this.email = null;
        this.senha = null;
        this.conta = null;

        System.out.println("Cadastro do investidor excluído com sucesso.");
    }

}
