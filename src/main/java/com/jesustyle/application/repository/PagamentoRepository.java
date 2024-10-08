package com.jesustyle.application.repository;


import com.jesustyle.application.repository.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagamentoRepository extends JpaRepository<PedidoEntity, Long> {

    List<PedidoEntity> findAllByIdCliente(String idCliente);
}