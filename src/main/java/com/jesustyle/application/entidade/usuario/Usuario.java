package com.jesustyle.application.entidade.usuario;

import lombok.Data;

import java.util.Date;


@Data
public class Usuario {

    public String nome;
    public Date dataNascimento;
    public String email;
    public String senha;
}
