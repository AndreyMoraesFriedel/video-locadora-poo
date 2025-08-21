package br.com.videolocadora.models;

public class Administrador extends Usuario {

    public Administrador(int id, String cpf, String nome, String telefone) {
        super(id, cpf, nome, Permissao.ADMINISTRADOR, telefone);
    }
    
}
