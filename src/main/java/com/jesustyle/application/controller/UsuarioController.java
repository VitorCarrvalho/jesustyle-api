package com.jesustyle.application.controller;


import com.jesustyle.application.entidade.usuario.Usuario;
import com.jesustyle.application.service.AutenticacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private AutenticacaoService autenticacaoService;

    @PostMapping("/cadastro")
    public ResponseEntity<String> detalheUsuario(@RequestBody Usuario usuario){

        Object solicitacao = autenticacaoService.cadastro(usuario);

        if(Objects.nonNull(solicitacao)){
            return new ResponseEntity<>("Usuário cadastrado com sucesso! ", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Erro ao tentar efetuar o cadastro, por favor tenta novamente mais tarde.", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/buscar/{idUsuario}")
    public ResponseEntity<Object> get(@PathVariable int idUsuario){

        Object solicitacao = autenticacaoService.buscarUsuario(idUsuario);

        if(Objects.nonNull(solicitacao)){
            return new ResponseEntity<>(solicitacao, HttpStatus.OK);
        }
        return new ResponseEntity<>("Erro ao tentar buscar o usuário, por favor tenta novamente mais tarde.", HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/update")
    public ResponseEntity<Object> get(@RequestBody Usuario usuario){

        Object solicitacao = autenticacaoService.atualizarUsuario(usuario);

        if(Objects.nonNull(solicitacao)){
            return new ResponseEntity<>(solicitacao, HttpStatus.OK);
        }
        return new ResponseEntity<>("Erro ao tentar buscar o usuário, por favor tenta novamente mais tarde.", HttpStatus.BAD_REQUEST);
    }
}
