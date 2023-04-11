package com.exercicio.semana10.dtos;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProdutoAtualizarDto {
    private Long id;
    private String nome;
    private String descricao;
    private Date dataLancamento;
    private Integer valor;
}