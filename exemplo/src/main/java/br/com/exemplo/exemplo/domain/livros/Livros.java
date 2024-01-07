package br.com.exemplo.exemplo.domain.livros;

import br.com.exemplo.exemplo.controller.DadosAlteracaoLivro;
import jakarta.persistence.*;

@Entity
@Table(name = "livros")
public class Livros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nome;
    private Integer duracaoEmMinutos;
    private Integer anoLancamento;
    private String genero;



    public Livros(DadosCadastroLivros dados){
        this.nome = dados.nome();
        this.duracaoEmMinutos = dados.duracao();
        this.anoLancamento = dados.ano();
        this.genero = dados.genero();

    }


    public Livros(){} ///alert


    @Override
    public String toString() {
        return "Livro{" +
                "nome='" + nome + '\'' +
                ", duracaoEmMinutos=" + duracaoEmMinutos +
                ", anoLancamento=" + anoLancamento +
                ", genero='" + genero + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public String getGenero() {
        return genero;
    }

   // public void add(Livros livros) {
    //}

    public void atualizaDados(DadosAlteracaoLivro dados) {
        this.nome = dados.nome();
        this.duracaoEmMinutos = dados.duracao();
        this.anoLancamento = dados.ano();
        this.genero = dados.genero();

    }
}
