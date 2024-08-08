package com.jesustyle.application.service;

import com.jesustyle.application.entidade.usuario.Usuario;

public interface AutenticacaoService {

    String login(String usuario, String senha);

    boolean recuperarSenha(String email);

    Object cadastro(Usuario usuario);
}
