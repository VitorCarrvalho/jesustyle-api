package com.jesustyle.application.service;

import com.jesustyle.application.entidade.produto.Produto;

import java.util.List;

public interface ProdutoService {

    public Produto cadastrarProduto(Produto produto);

    public Produto AtualizarEstoqueProduto(Produto produto);

    public String removerProduto(String idProduto);

    public Produto GetProduto(String idProduto);

    public List<Produto> listaProdutos(List<String> ids);



}
