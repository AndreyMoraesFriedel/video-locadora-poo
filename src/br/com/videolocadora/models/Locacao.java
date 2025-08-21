package br.com.videolocadora.models;

import java.util.Date;

public class Locacao {
    private int id;
    private Cliente cliente;
    private Filme filme;
    private Date dataAlocacao;
    private Date dataDevolucao;

    public Locacao(int id, Cliente cliente, Filme filme, Date dataAlocacao, Date dataDevolucao) {
        this.id = id;
        this.cliente = cliente;
        this.filme = filme;
        this.dataAlocacao = dataAlocacao;
        this.dataDevolucao = dataDevolucao;
        registrarLocacao();
    }

    public void registrarLocacao() {
        cliente.adicionarLocacao(this);
    }

    public void registrarDevolucao() {}
    
}
