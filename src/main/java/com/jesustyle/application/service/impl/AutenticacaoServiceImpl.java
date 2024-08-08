package com.jesustyle.application.service.impl;

import com.jesustyle.application.entidade.usuario.Usuario;
import com.jesustyle.application.service.AutenticacaoService;
import org.springframework.stereotype.Service;


@Service
public class AutenticacaoServiceImpl implements AutenticacaoService {


    @Override
    public String login(String usuario, String senha) {
        return null;
    }

    @Override
    public boolean recuperarSenha(String email) {
        return false;
    }

    @Override
    public Object cadastro(Usuario usuario) {
        return null;
    }
}
