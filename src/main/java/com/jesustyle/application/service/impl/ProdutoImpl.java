package com.jesustyle.application.service.impl;

import com.jesustyle.application.entidade.produto.Produto;
import com.jesustyle.application.service.ProdutoService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProdutoImpl implements ProdutoService {

    @Override
    public Produto cadastrarProduto(Produto produto) {
        return null;
    }

    @Override
    public Produto AtualizarEstoqueProduto(Produto produto) {
        return null;
    }

    @Override
    public String removerProduto(String idProduto) {
        return null;
    }

    @Override
    public Produto GetProduto(String idProduto) {
        return null;
    }

    @Override
    public List<Produto> listaProdutos(List<String> ids) {
        return null;
    }
}
