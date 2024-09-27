package com.jesustyle.application.repository;


import com.jesustyle.application.repository.entity.PedidoEntity;
import com.jesustyle.application.repository.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, Integer> {

    UsuarioEntity findByEmail(String email);

}

