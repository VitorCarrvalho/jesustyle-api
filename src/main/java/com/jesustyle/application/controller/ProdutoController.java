package com.jesustyle.application.controller;


import com.jesustyle.application.entidade.produto.Produto;
import com.jesustyle.application.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/produto")
@CrossOrigin("*")
public class ProdutoController {

    @Autowired
    ProdutoService produtoSerice;

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastro(@RequestBody Produto produto){
        var produtoCadastrado = produtoSerice.cadastrarProduto(produto);

        if(Objects.nonNull(produtoCadastrado)){
            return new ResponseEntity<>("Produto cadastrado com sucesso", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Erro ao criar novo produto", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<String> atualizarProduto(@RequestBody Produto produto){
        var produtoCadastrado = produtoSerice.AtualizarEstoqueProduto(produto);

        if(Objects.nonNull(produtoCadastrado)){
            return new ResponseEntity<>("Produto atualizado com sucesso", HttpStatus.OK);
        }
        return new ResponseEntity<>("Erro ao atualizar o produto", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/deletar")
    public ResponseEntity<String> deletarProduto(@PathVariable String idProduto){
        var produtoRemovido = produtoSerice.removerProduto(idProduto);

        if(!produtoRemovido.isBlank()){
            return new ResponseEntity<>("Produto deletado com sucesso", HttpStatus.OK);
        }
        return new ResponseEntity<>("Erro ao deletar o produto", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/{produto}")
    public ResponseEntity<Produto> buscarProduto(@PathVariable String idProduto){
        var produtoConsultado = produtoSerice.GetProduto(idProduto);

        if(Objects.nonNull(produtoConsultado)){
            return new ResponseEntity<>(produtoConsultado, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/produtos")
    public ResponseEntity<String> listaProduto(@RequestBody List<String> listaProduto){
        var listaProdutosRetornados = produtoSerice.listaProdutos(listaProduto);

        if(Objects.nonNull(listaProdutosRetornados)){
            return new ResponseEntity<>("Lista de produtos consultado com sucesso", HttpStatus.OK);
        }
        return new ResponseEntity<>("Erro ao consultar lista de produtos.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
