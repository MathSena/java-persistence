package com.mathsena.cursomc.dto;

import com.mathsena.cursomc.domain.Cliente;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class ClienteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotEmpty(message = "Prenchimento obrigatório")
    @Length(min=5,max=120, message = "O tamanho deve ser entre 5 e 120 caracteres")
    private Integer id;
    @NotEmpty(message = "Prenchimento obrigatório")
    @Length(min=5,max=120, message = "Email inválido")
    private String nome;
    private String email;

    public ClienteDTO() {

    }

    public ClienteDTO(Cliente obj) {
        id = obj.getId();
        nome = obj.getNome();
        email = obj.getEmail();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
