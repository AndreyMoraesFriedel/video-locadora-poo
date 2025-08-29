package main.java.br.com.videolocadora.models;

public class Produtora {
    private static int contadorId;
    private final int id;
    private String nome;
    private String endereco;
    private String telefone;

    public Produtora(String nome, String endereco, String telefone) throws Exception {
        this.id = contadorId++;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = formatarTelefone(telefone);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    private String formatarTelefone(String telefoneDigitado) throws Exception{
        if(!telefoneDigitado.matches("\\d{2}-\\d{5}-\\d{4}")){
            throw new IllegalArgumentException("Telefone inválido. Use o formato DD-XXXXX-XXXX");
        }else{ return telefoneDigitado; }
    }
    
}
