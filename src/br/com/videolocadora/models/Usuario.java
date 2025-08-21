package br.com.videolocadora.models;

public abstract class Usuario {
    protected int id;
    protected String cpf;
    protected String nome;
    protected Permissao permissao;
    protected String telefone;

    public Usuario(int id, String cpf, String nome, Permissao permissao, String telefone) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.permissao = permissao;
        this.telefone = telefone;
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
}