package com.jesustyle.application.entidade.transporte.request;

public enum ServicoTipo {
    E("Entrega Normal"),
    X("Entrega Expressa"),
    M("Mini Envios"),
    R("Retira");

    private final String descricao;

    ServicoTipo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

