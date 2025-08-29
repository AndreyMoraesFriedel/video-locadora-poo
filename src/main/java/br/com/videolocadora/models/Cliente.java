package main.java.br.com.videolocadora.models;

import java.util.ArrayList;
import java.util.List;

import main.java.br.com.videolocadora.services.Locacao;

public class Cliente extends Usuario {

    private List<Locacao> locacoes = new ArrayList<>();

    public Cliente(String cpf, String nome, String telefone, String email, String password) throws Exception {
        super(cpf, nome, Permissao.CLIENTE, telefone, email, password);
    }

    public void adicionarLocacao(Locacao locacao){
        locacoes.add(locacao);
    }

    public List<Locacao> minhasLocacoes(){
        return locacoes;
    }
}
