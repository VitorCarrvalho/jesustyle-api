package com.jesustyle.application.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "TabUsuario")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuarioEntity {

    @Id
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
