package br.com.videolocadora.models;

public abstract class Usuario {
    private static int contadorId;
    private final int id;
    private String cpf;
    private String nome;
    private Permissao permissao;
    private String telefone;
    private String email;
    private String password;
    //private boolean logado;

    public Usuario(String cpf, String nome, Permissao permissao, String telefone, String email, String password) {     
        this.id = contadorId++;
        this.cpf = cpf;
        this.nome = nome;
        this.permissao = permissao;
        this.telefone = telefone;
        this.email = email;
        this.password = password;
    }  

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Permissao getPermissao() {
        return permissao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // private String gerarHash(String senha) {}

    // public boolean login(String emailDigitado, String senhaDigitada) {}

    // public boolean validarEmail(String emailDigitado) {}

    // public boolean validarSenha(String senhaDigitada) {}

    // public void logout() {}
}