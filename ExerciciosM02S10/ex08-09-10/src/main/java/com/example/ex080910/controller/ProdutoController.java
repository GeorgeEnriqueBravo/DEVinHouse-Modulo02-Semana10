package com.example.ex080910.controller;

import com.example.ex080910.model.Produto;
import com.example.ex080910.service.ProdutoService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }
    @GetMapping("/listar")
    public List<Produto> buscarProdutos() {
        return service.listarProdutos();
    }
    @GetMapping(params = "id")
    public Optional<Produto> buscaProdutoPorId(@RequestParam Long id) {
        return service.pegaProdutoPorId(id);
    }
    @PostMapping("/cadastrar")
    public boolean criarProduto(@RequestBody @Validated Produto produto) {
        return service.salvarProduto(produto);
    }
    @DeleteMapping("/deletar")
    public boolean apagarProduto(@PathVariable Long id) {
        return service.deletarProdutoPorId(id);
    }
    @PutMapping("/atualizar")
    public boolean atualizarProduto(@RequestParam Long id, @RequestBody @Validated Produto produto) {
        return service.alterarProdutoPorId(id, produto);
    }


}
