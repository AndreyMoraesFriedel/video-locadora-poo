package main.java.br.com.videolocadora.models;

public class Administrador extends Usuario {

    public Administrador(String cpf, String nome, String telefone, String email, String password) throws Exception {
        super(cpf, nome, Permissao.ADMINISTRADOR, telefone, email, password);
    }
    
}
