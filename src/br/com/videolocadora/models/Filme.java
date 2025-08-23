package br.com.videolocadora.models;

import java.util.Date;

public class Filme {
    private static int contadorId;
    private final int id;
    private String titulo;
    private Genero genero;
    private Date dataLancamento;
    private Produtora produtora;
    private Boolean disponibilidade;

    public Filme(String titulo, Genero genero, Date dataLancamento, Produtora produtora) {
        this.id = contadorId++;
        this.titulo = titulo;
        this.genero = genero;
        this.dataLancamento = dataLancamento;
        this.produtora = produtora;
        this.disponibilidade = true;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Produtora getProdutora() {
        return produtora;
    }

    public void setProdutora(Produtora produtora) {
        this.produtora = produtora;
    }

    public Boolean getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public void alterarDisponibilidade(){
        if (getDisponibilidade()){
            setDisponibilidade(false);
        }else { setDisponibilidade(true); }
    }

    
}
