package com.exercicio.semana10.controller;

import com.exercicio.semana10.dtos.ProdutoAtualizarDto;
import com.exercicio.semana10.dtos.ProdutoDto;
import com.exercicio.semana10.model.Produto;
import com.exercicio.semana10.repository.ProdutoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

//    ProdutoService produtoService = new ProdutoService();

    private final ProdutoRepository repository;

    public ProdutoController(ProdutoRepository repository) {
        this.repository = repository;
    }


    @GetMapping
    public String chamaFormulario(ProdutoDto produtoDto, Model model){
        return "produto";
    }

//    @GetMapping
//    public String getProduto(Model model) {
//        model.addAttribute("nome", "Tênis");
//        model.addAttribute("descricao", "Tênis de corrida");
//        model.addAttribute("dataLancamento", "04/04/2023");
//        model.addAttribute("valor", "R$400,00");

//        Produto produto = repository.findById(1).get();
//        model.addAttribute("produto", produto);
//
//        produtoService.pegaProduto(model);
//        return "produto"; // isso retorna as coisas feitas aqui para a página produto.HTML
//    }

    @PostMapping
    public String postFormulario(
            @Validated ProdutoDto produtoDto,
            Model model
    ){
        repository.save(
                Produto.builder()
                        .nome(produtoDto.getNome())
                        .descricao(produtoDto.getDescricao())
                        .dataLancamento(produtoDto.getDataLancamento())
                        .valor(produtoDto.getValor())
                        .build()
        );
        return "redirect:produto/lista";
    }

    @GetMapping("/lista")
    public String listarPessoas(
            Model model
    ){
        List<ProdutoDto> produtosDto =
                repository.findAll()
                        .stream()
                        .map(produto -> new ProdutoDto(
                                produto.getNome(),
                                produto.getDescricao(),
                                produto.getDataLancamento(),
                                produto.getValor())
                        ).collect(Collectors.toList());

        model.addAttribute("produtosDto", produtosDto);
        return "lista_produtos";
    }


    @GetMapping("/atualizar")
    public String chamaAtualizarPessoa(ProdutoAtualizarDto produtoAtualizarDto, Model model){
        return "produto_atualizar";
    }
    @PostMapping("/atualizar")
    public String atualizarPessoa(
            ProdutoAtualizarDto produtoAtualizarDto,
            Model model
    ){
        Produto entity = repository
                .findById(produtoAtualizarDto.getId())
                .orElse(null);

        entity.setNome(produtoAtualizarDto.getNome());
        entity.setDescricao(produtoAtualizarDto.getDescricao());
        entity.setDataLancamento(produtoAtualizarDto.getDataLancamento());
        entity.setValor(produtoAtualizarDto.getValor());

        repository.save(entity);

        List<ProdutoDto> produtosDto =
                repository.findAll()
                        .stream()
                        .map(produtoAtualizado -> new ProdutoDto(
                                produtoAtualizado.getNome(),
                                produtoAtualizado.getDescricao(),
                                produtoAtualizado.getDataLancamento(),
                                produtoAtualizado.getValor())
                        ).collect(Collectors.toList());

        model.addAttribute("produtosDto", produtosDto);
        return "lista_produtos";
    }

    @GetMapping("/deletar/{id}")
    public String deletarProduto(
            @PathVariable("id") Long id,
            Model model
    ){
        repository.deleteById(id);

        List<ProdutoDto> produtosDto =
                repository.findAll()
                        .stream()
                        .map(produto -> new ProdutoDto(
                                produto.getNome(),
                                produto.getDescricao(),
                                produto.getDataLancamento(),
                                produto.getValor())
                        ).collect(Collectors.toList());

        model.addAttribute("produtosDto", produtosDto);
        return "lista_produtos";
    }

}
