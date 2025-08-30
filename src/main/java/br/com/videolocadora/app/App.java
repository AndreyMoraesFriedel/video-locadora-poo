package main.java.br.com.videolocadora.app;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import main.java.br.com.videolocadora.models.Administrador;
import main.java.br.com.videolocadora.models.Cliente;
import main.java.br.com.videolocadora.models.Filme;
import main.java.br.com.videolocadora.models.Genero;
import main.java.br.com.videolocadora.models.Produtora;
import main.java.br.com.videolocadora.services.Catalogo;
import main.java.br.com.videolocadora.services.Locacao;

public class App {
    public static void main(String[] args) throws Exception{
        try{
            Cliente cliente = new Cliente(
                "111.222.333-44", 
                "Robson Almeida Junior", 
                "47-99988-7755", 
                "robson@gmail.com", 
                "1234"
            );
            System.out.println("Cliente cadastrado com sucesso");

            Administrador adm = new Administrador(
                "222.333.444-55",
                "Aldemir De Santos", 
                "47-99940-7090", 
                "aldemir@gmail.com", 
                "admin"
            );

            System.out.println("Administrador cadastrado com sucesso");

            Produtora produtora = new Produtora(
                "Mazel Brasil", 
                "Avenida Ipiranga", 
                "11-99950-7028"
            );
            System.out.println("Produtora cadastrado com sucesso");

            Calendar calendar = Calendar.getInstance();
            calendar.set(1980, Calendar.AUGUST, 14);
            Date dataLancamento = calendar.getTime();

            Filme filme = new Filme(
                "Um dia de cada vez", 
                Genero.COMEDIA, 
                dataLancamento, 
                produtora
            );

            Filme filme2 = new Filme(
                "O sol nascer", 
                Genero.ROMANCE, 
                dataLancamento, 
                produtora
            );

            Filme filme3 = new Filme(
                "As pedras que caminham", 
                Genero.DOCUMENTARIO, 
                dataLancamento, 
                produtora
            );

            System.out.println("Filmes cadastrados com sucesso");

            Catalogo catalogo = new Catalogo();
            System.out.println("Catalogo construido com sucesso");

            catalogo.cadastrarFilme(filme);
            catalogo.cadastrarFilme(filme2);
            catalogo.cadastrarFilme(filme3);
            System.out.println("Filmes adicionados ao catalogo");

            catalogo.removerFilme(2);
            System.out.println("Filme de id 2 removido!");

            System.out.println("Filmes do Catalogo");
            List<Filme> filmesDoCat = catalogo.consultarFilmes();
            for (Filme fil : filmesDoCat) {
                System.out.println(fil);
            }

            cliente.login("robson@gmail.com", "1234");
            Locacao loc = new Locacao(cliente, filme);
            Locacao loc2 = new Locacao(cliente, filme2);
            System.out.println("Locacoes Construidas");

            loc.registrarDevolucao();

            List<Locacao> locDoCliente = cliente.minhasLocacoes();
            System.out.println("Locacoes do Cliente: ");
            for (Locacao locacao : locDoCliente) {
                System.out.println(locacao);
            }

            cliente.logout();

        }catch(IllegalArgumentException e){
            System.out.println("Erro De Formatacao: " + e.getMessage());
        }catch(SecurityException e){
            System.out.println("Erro de seguranca: " + e.getMessage());
        }catch(Exception e){
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }
}
