package com.mathsena.cursomc.dto;

import java.util.ArrayList;
import java.util.List;

import com.mathsena.cursomc.domain.Categoria;
import com.mathsena.cursomc.domain.Produto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoriaDTO  {

    private String id;

//    @NotEmpty(message = "Preenchimento obrigatório")
//    @Length(min=5, max=80, message = "O tamanho deve ser entre 5 e 80 caracteres")
    private String nome;
    
    private List<Produto> produtos = new ArrayList<>();

    public CategoriaDTO(Categoria obj){
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.produtos = obj.getProdutos();
    }

}
