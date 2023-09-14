package com.um.tp1PersistenciaJPA.repositorios;

import com.um.tp1PersistenciaJPA.entidades.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
