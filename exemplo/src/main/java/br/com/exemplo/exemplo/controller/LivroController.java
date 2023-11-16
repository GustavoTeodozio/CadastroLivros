package br.com.exemplo.exemplo.controller;

import br.com.exemplo.exemplo.domain.livros.DadosCadastroLivros;
import br.com.exemplo.exemplo.domain.livros.LivroRepository;
import br.com.exemplo.exemplo.domain.livros.Livros;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroRepository repository;

    @GetMapping("/formulario")
    public String carregaPaginaFormulario(Long id, Model model) {
        if (id != null){
            var livro = repository.getReferenceById(id);
            model.addAttribute("livro", livro);
        }
        return "livros/formulario";
    }

    @GetMapping
    public String carregaPaginaListagem(Model model) {
        model.addAttribute("lista", repository.findAll());
        return "livros/listagem";
    }



    @PostMapping
    @Transactional
    public String cadastraLivro(DadosCadastroLivros dados){
        var livros = new Livros(dados);

        repository.save(livros);

        return "redirect:/livros";
    }

    @PutMapping
    @Transactional
    public String alteraLivro(DadosAlteracaoLivro dados){
        var livro = repository.getReferenceById(dados.id());
        livro.atualizaDados(dados);

        return "redirect:/livros";
    }

    @DeleteMapping
    @Transactional
    public  String removeLivro(Long id){

        repository.deleteById(id);

        return "redirect:/livros";
    }
}
