package br.com.videolocadora.services;

import java.util.Date;

import br.com.videolocadora.models.Cliente;
import br.com.videolocadora.models.Filme;

public class Locacao {
    private static int contadorId;
    private final int id;
    private Cliente cliente;
    private Filme filme;
    private Date dataAlocacao;
    private Date dataDevolucao;

    public Locacao(Cliente cliente, Filme filme, Date dataAlocacao) throws Exception{
        if(!verificarDisponibilidade()){
            throw new Exception("Filme Indisponivel");
        }   
        this.id = contadorId++;
        this.cliente = cliente;
        this.filme = filme;
        this.dataAlocacao = dataAlocacao;
        this.dataDevolucao = null;
        registrarLocacao();        
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Date getDataAlocacao() {
        return dataAlocacao;
    }

    public void setDataAlocacao(Date dataAlocacao) {
        this.dataAlocacao = dataAlocacao;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public boolean verificarDisponibilidade(){
        return filme.getDisponibilidade();
    }

    private void registrarLocacao() {
        cliente.adicionarLocacao(this);
        filme.alterarDisponibilidade();
    }

    public void registrarDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
        filme.alterarDisponibilidade();
    }
    
}
