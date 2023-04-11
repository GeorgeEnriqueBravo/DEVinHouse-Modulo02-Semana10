package com.exercicio.semana10.model;


import lombok.*;

import javax.persistence.*;
import java.util.Date;
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Column
    private String nome;
//    @Column
    private String descricao;
//    @Column
    private Date dataLancamento;
//    @Column
    private Integer valor;
    @ManyToOne
    private Usuario usuario;
}
