package com.jesustyle.application.entidade.usuario;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;


@Data
public class Usuario {

    public int codigo;
    public String nome;
    @JsonIgnoreProperties(ignoreUnknown = true)
    public Date dataNascimento;
    @JsonIgnoreProperties(ignoreUnknown = true)
    public String cpf;
    public String email;
    @JsonIgnoreProperties(ignoreUnknown = true)
    public String telefone;
    public String senha;
    public String tipoUsuario; // ADMIN // USER
}
