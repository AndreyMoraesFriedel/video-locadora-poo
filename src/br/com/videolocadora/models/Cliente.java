package br.com.videolocadora.models;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {

    private List<Locacao> locacoes = new ArrayList<>();

    public Cliente(int id, String cpf, String nome, String telefone) {
        super(id, cpf, nome, Permissao.CLIENTE, telefone);
    }

    public void adicionarLocacao(Locacao locacao){
        locacoes.add(locacao);
    }

    public List<Locacao> minhasLocacoes(){
        return locacoes;
    }
}
