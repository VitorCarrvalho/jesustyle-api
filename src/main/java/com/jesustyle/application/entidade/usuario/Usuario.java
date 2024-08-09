package com.jesustyle.application.entidade.usuario;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Usuario {

    public String nome;
    public Date dataNascimento;
    public String email;
    public String senha;
    public String nivelPermissao; // ADMIN // USER
}
