package main.java.br.com.videolocadora.services;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import main.java.br.com.videolocadora.models.Cliente;
import main.java.br.com.videolocadora.models.Filme;

public class Locacao {
    private static int contadorId;
    private final int id;
    private Cliente cliente;
    private Filme filme;
    private LocalDateTime dataAlocacao;
    private LocalDateTime dataDevolucao;

    public Locacao(Cliente cliente, Filme filme) throws Exception{
        if(!verificarDisponibilidade(filme)){
            throw new Exception("Filme Indisponivel");
        }
        if(!verificarClienteLogado(cliente)){
            throw new Exception("Cliente não esta logado");
        }
        this.id = contadorId++;
        this.cliente = cliente;
        this.filme = filme;
        this.dataAlocacao = LocalDateTime.now();
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

    public LocalDateTime getDataAlocacao() {
        return dataAlocacao;
    }

    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }

    public boolean verificarDisponibilidade(Filme filme){
        return filme.getDisponibilidade();
    }

    public boolean verificarClienteLogado(Cliente cliente){
        return cliente.isLogado();
    }

    private void registrarLocacao() {
        cliente.adicionarLocacao(this);
        filme.alterarDisponibilidade();
    }

    public void registrarDevolucao() throws Exception{
        if(!cliente.isLogado()){
            throw new SecurityException("Cliente precisa estar logado");
        }
        if(getDataDevolucao() != null){
            throw new IllegalStateException("Filme ja esta devolvido");
        }
        this.dataDevolucao = LocalDateTime.now();
        filme.alterarDisponibilidade();
    }

    public int calcularMulta(){
        long dias = calcularTempoUtilizado(dataDevolucao);
        int pagamentoBase = 20;
        if(dias <= 7){
            return pagamentoBase;
        }else{
            int diasExtras = (int) dias - 7;
            return pagamentoBase + diasExtras;
        }
    }

    public long calcularTempoUtilizado(LocalDateTime dataDevolucao){
        return Math.max(0, ChronoUnit.DAYS.between(dataAlocacao, dataDevolucao));
    }

    @Override
    public String toString() {
        return String.format("""
                id: %d
                Nome Do Cliente: %s
                Titulo Do Filme: %s
                Data da Alocacao: %s
                Data da Devolucao: %s
                """,
                getId(),
                getCliente().getNome(),
                getFilme().getTitulo(),
                getDataAlocacao().toString(),
                (getDataDevolucao() != null  ? getDataDevolucao().toString():"Filme nao devolvido")
        );
    }
}
