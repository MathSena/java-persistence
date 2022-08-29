package com.mathsena.cursomc.dto;

import com.mathsena.cursomc.domain.Cliente;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClienteDTO {

    private String id;

    private String nome;

    private String email;


    public ClienteDTO(Cliente obj) {
        id = obj.getId();
        nome = obj.getNome();
        email = obj.getEmail();
    }

}
