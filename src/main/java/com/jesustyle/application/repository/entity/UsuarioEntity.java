package com.jesustyle.application.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Data
@Entity
@Table(name = "tab_usuario")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int codigo;
    @Column(name = "nome")
    public String nome;
    @Column(name = "data_nascimento")
    public Date dataNascimento;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Column(name = "cpf")
    public String cpf;
    @JsonProperty("email")
    public String email;
    @Column(name = "telefone")
    public String telefone;
    @Column(name = "senha")
    public String senha;
    @Column(name = "tipo_usuario")
    public String tipoUsuario; // ADMIN // USER
}
