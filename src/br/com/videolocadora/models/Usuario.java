package br.com.videolocadora.models;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class Usuario {
    private static int contadorId;
    private final int id;
    private String cpf;
    private String nome;
    private Permissao permissao;
    private String telefone;
    private String email;
    private String password;
    private boolean logado;

    public Usuario(String cpf, String nome, Permissao permissao, String telefone, String email, String password) {     
        this.id = contadorId++;
        this.cpf = cpf;
        this.nome = nome;
        this.permissao = permissao;
        this.telefone = telefone;
        this.email = email;
        this.password = gerarHash(password);
        this.logado = false;
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

    public boolean isLogado() {
        return logado;
    }

    public void setLogado(boolean logado) {
        this.logado = logado;
    }

    private String gerarHash(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(senha.getBytes());
            StringBuilder hexString = new StringBuilder();
            for(byte b : hash){
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao gerar hash", e);
        }
    }

    public void login(String emailDigitado, String senhaDigitada) throws Exception{
        if(validarEmail(emailDigitado) && validarSenha(senhaDigitada)){
            setLogado(true);
        }else { throw new Exception("Email ou Senha Incorreto!"); }
    }

    public boolean validarEmail(String emailDigitado) {
        return this.email.equals(emailDigitado);
    }

    public boolean validarSenha(String senhaDigitada) {
        return this.password.equals(gerarHash(senhaDigitada));
    }

    public void logout() {
        setLogado(false);
    }
}