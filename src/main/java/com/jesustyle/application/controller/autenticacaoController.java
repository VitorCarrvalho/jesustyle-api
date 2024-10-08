package com.jesustyle.application.controller;

import com.jesustyle.application.entidade.usuario.Usuario;
import com.jesustyle.application.service.AutenticacaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "https://jesustyleoficial.com.br", allowCredentials = "true")
public class autenticacaoController {

    @Autowired
    AutenticacaoService autenticacao;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestHeader String email, @RequestHeader String senha ){
        var token = autenticacao.login(email, senha);

        if(!token.get("token").isEmpty()){
            return new ResponseEntity<>(token, HttpStatus.OK);
        }
        return new ResponseEntity<>("Usuário ou senha inválidos", HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/recuperar-senha")
    public ResponseEntity<String> recuperarSenha(@RequestParam String email){

        boolean solicitacao = autenticacao.recuperarSenha(email);

        if(solicitacao){
            return new ResponseEntity<>("Consulte o email cadastro e altere a senha", HttpStatus.OK);
        }
        return new ResponseEntity<>("email inválido", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Object> cadastro(@RequestBody Usuario usuario){

       var usuarioCadastrado =  autenticacao.cadastro(usuario);

       if(Objects.nonNull(usuarioCadastrado)){
           return new ResponseEntity<>("Usuário criado com sucesso. Enviamos um email para confirmação.", HttpStatus.OK);
       }
        return new ResponseEntity<>("Houve um erro na tentativa de cadastro, por favor tente novamente mais tarde.", HttpStatus.BAD_REQUEST);

    }
}
