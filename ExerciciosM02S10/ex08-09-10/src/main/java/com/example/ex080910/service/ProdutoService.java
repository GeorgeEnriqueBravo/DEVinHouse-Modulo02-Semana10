package com.example.ex080910.service;

import com.example.ex080910.model.Produto;
import com.example.ex080910.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<Produto> listarProdutos(){
        return repository.findAll();
    }

    public Optional<Produto> pegaProdutoPorId(Long id) {
        return repository.findById(id);
    }

    public boolean salvarProduto(Produto produto){
        repository.save(produto);
        return true;
    }

    public boolean deletarProdutoPorId(Long id){
        repository.deleteById(id);
        return true;
    }

    public boolean alterarProdutoPorId(Long id, Produto produto){

        Produto produtoEscolhido = repository.getById(id);
        produtoEscolhido.setNome(produto.getNome());
        produtoEscolhido.setDescricao(produto.getDescricao());
        produtoEscolhido.setValor(produto.getValor());

        return true;
    }
}
