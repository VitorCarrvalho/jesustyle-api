package com.jesustyle.application.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jesustyle.application.entidade.usuario.Usuario;
import com.jesustyle.application.repository.UsuarioRepository;
import com.jesustyle.application.repository.entity.UsuarioEntity;
import com.jesustyle.application.service.AutenticacaoService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Slf4j
@Service
public class AutenticacaoServiceImpl implements AutenticacaoService {


    private final String secretKey = "75319461dba2144e18b69fc2e4f4553ffbda687f2b10cadc64a15cad245aa7bc";
    private final long validityInMilliseconds = 86400;
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public Map<String, String> login(String email, String senha) {
        UsuarioEntity response = usuarioRepository.findByEmail(email);
        Map<String, String> tokenGerado = new HashMap<>();

        if (response.getEmail().equalsIgnoreCase(email) && response.getSenha().equals(senha)) {
            String token = generateToken(response);
            tokenGerado.put("token", token);
        }

        tokenGerado.put("TipoUsuario", response.getTipoUsuario());
        tokenGerado.put("codigo", String.valueOf(response.getCodigo()));
        tokenGerado.put("nome", response.getNome());
        tokenGerado.put("email", response.getEmail());
        tokenGerado.put("telefone", response.getTelefone());
        tokenGerado.put("dataNascimento", String.valueOf(response.getDataNascimento()));
        return tokenGerado;
    }

    private String generateToken(UsuarioEntity response) {

        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);


        Map<String, Object> claims = new HashMap<>();

        if (response.getTipoUsuario().equals("Admin")) {
            claims.put("tipoUsuario", "Admin");
        } else {
            claims.put("tipoUsuario", "user");
        }

        return Jwts.builder()
                .setSubject(String.valueOf(response.getCodigo()))
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    @Override
    public boolean recuperarSenha(String email) {
        return false;
    }

    @Override
    public Object cadastro(Usuario usuario) {

        var usuarioEntity = UsuarioEntity.builder()
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .dataNascimento(usuario.getDataNascimento())
                .senha(usuario.getSenha())
                .tipoUsuario("USER")
                .build();
        var retorno = usuarioRepository.save(usuarioEntity);
        log.info("Usuário atualizado com sucesso: " + retorno.getCodigo());
        return retorno;
    }

    public Object buscarUsuario(int idUsuario) {
        return usuarioRepository.findById(idUsuario);
    }

    public Object atualizarUsuario(Usuario usuario) {
        ObjectMapper mapper = new ObjectMapper();
        var usuarioEntity = mapper.convertValue(usuario, UsuarioEntity.class);

        var retorno = usuarioRepository.findById(usuario.getCodigo());

        if (retorno.isPresent()) {
            var rr = usuarioRepository.save(usuarioEntity);
            log.info("Usuário atualizado com sucesso: " + rr.getCodigo());
            return rr;
        }
        log.error("Usuário inválido.");

        return null;
    }
}
