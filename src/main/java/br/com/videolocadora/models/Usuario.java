package main.java.br.com.videolocadora.models;

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

    public Usuario(String cpf, String nome, Permissao permissao, String telefone, String email, String password) throws Exception {     
        this.id = contadorId++;
        this.cpf = formatarCpf(cpf);
        this.nome = nome;
        this.permissao = permissao;
        this.telefone = formatarTelefone(telefone);
        this.email = formatarEmail(email);
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
        }else { throw new SecurityException("Email ou Senha Incorreto!"); }
    }

    private boolean validarEmail(String emailDigitado) {
        return this.email.equals(emailDigitado);
    }

    private boolean validarSenha(String senhaDigitada) {
        return this.password.equals(gerarHash(senhaDigitada));
    }

    private String formatarEmail(String emailDigitado) throws Exception{
        if(!emailDigitado.matches("^[A-Za-z0-9+_.-]+@(.+)$")){
            throw new IllegalArgumentException("Email Invalido");
        }else{ return emailDigitado; }
    }

    private String formatarCpf(String cpfDigitado) throws Exception{
        if(!cpfDigitado.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")){
            throw new IllegalArgumentException("CPF inválido. Use o formato XXX.XXX.XXX-XX");
        }else{ return cpfDigitado; }
    }

    private String formatarTelefone(String telefoneDigitado) throws Exception{
        if(!telefoneDigitado.matches("\\d{2}-\\d{5}-\\d{4}")){
            throw new IllegalArgumentException("Telefone inválido. Use o formato DD-XXXXX-XXXX");
        }else{ return telefoneDigitado; }
    }

    public void logout() {
        setLogado(false);
    }
}