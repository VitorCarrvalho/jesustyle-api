package com.jesustyle.application.service.impl;

import com.jesustyle.application.entidade.usuario.Usuario;
import com.jesustyle.application.service.AutenticacaoService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class AutenticacaoServiceImpl implements AutenticacaoService {


    @Override
    public Map<String, String> login(String usuario, String senha) {
        Map<String, String> token = new HashMap<>();
        token.put("token", "k2al0hJIazt4m4RmBjLCpu5vhHDHx5rJw6oMBtzZkKRkvZ0IUKugdcDucedza5CFkjMsfBQmGMv9OwBXFFwiZsrQfTKz2AuTFJG6hLC16OCt");

        return token;
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
