package com.jesustyle.application.entidade.usuario;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;


@Data
public class Usuario {

    @JsonProperty("Codigo")
    public int codigo;
    @JsonProperty("Nome")
    public String nome;
    @JsonProperty("DataNascimento")
    @JsonIgnoreProperties(ignoreUnknown = true)
    public Date dataNascimento;
    @JsonProperty("CPF")
    @JsonIgnoreProperties(ignoreUnknown = true)
    public String cpf;
    @JsonProperty("Email")
    public String email;
    @JsonProperty("Telefone")
    @JsonIgnoreProperties(ignoreUnknown = true)
    public String telefone;
    @JsonProperty("Senha")
    public String senha;
    @JsonProperty("TipoUsuario")
    public String tipoUsuario; // ADMIN // USER
}
