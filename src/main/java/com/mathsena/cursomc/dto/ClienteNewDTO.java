package com.mathsena.cursomc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteNewDTO {
	
    private String nome;
    private String email;
    private String cpfOuCnpj;
    private Integer tipo;
    private String longradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cep;
    private String telefone1;
    private String telefone2;
    private String telefone3;
    private Integer cidadeId;
    
}
