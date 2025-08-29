package main.java.br.com.videolocadora.services;

import java.util.ArrayList;
import java.util.List;

import main.java.br.com.videolocadora.models.Filme;

public class Catalogo {
    private static int contadorId;
    private final int id;
    private List<Filme> filmes = new ArrayList<>();

    public Catalogo(){
        this.id = contadorId++;
    }

    public int getId() {
        return id;
    }

    public void cadastrarFilme(Filme filme) {
        filmes.add(filme);
    }

    public List<Filme> consultarFilmes() {
        return filmes;
    }

    public void removerFilme(int id) {
        filmes.remove(id);
    }
}
