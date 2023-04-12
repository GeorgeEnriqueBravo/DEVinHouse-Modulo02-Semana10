package com.example.ex080910.repository;

import com.example.ex080910.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
//    boolean delete(Long id);

//    ProdutoRepository repository = null;
//
//    static List<Produto> listaProdutos = new ArrayList<>();
//
//    public default boolean removerProdutoId(Integer id){
//        return listaProdutos.remove(listaProdutos.get(id));
//    }
}
