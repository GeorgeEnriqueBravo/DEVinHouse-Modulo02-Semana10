package com.exercicio.semana10.repository;

import com.exercicio.semana10.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}

// Parâmeros do Repository (passar ou mouse em cima do CrudRepository)
// T sempre será um entity (tabela)
// Integer sempre será um id
