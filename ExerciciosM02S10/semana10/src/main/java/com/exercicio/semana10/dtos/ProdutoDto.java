package com.exercicio.semana10.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDto {
    private String nome;
    private String descricao;
    private Date dataLancamento;
    private Integer valor;
}
