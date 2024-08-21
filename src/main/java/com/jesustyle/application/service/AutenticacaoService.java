package com.jesustyle.application.service;

import com.jesustyle.application.entidade.usuario.Usuario;

import java.util.Map;

public interface AutenticacaoService {

    Map<String, String> login(String email, String senha);

    boolean recuperarSenha(String email);

    Object cadastro(Usuario usuario);

    Object buscarUsuario(int idUsuario);

    Object atualizarUsuario(Usuario usuario);
}
