package com.jesustyle.application.entidade.transporte.solicitar.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Destinatario {
    private String nome;
    private String cnpjCpf;
    private Endereco endereco;
    private String contato;
    private String email;
    private String telefone;
    private String celular;
}

