package br.org.drogaria.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RemedioDTO {
    private Long id;
    private String nome;
    private String ativo;
    private double preco;
    private int quantidade;
}
