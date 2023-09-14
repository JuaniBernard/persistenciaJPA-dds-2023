package com.um.tp1PersistenciaJPA.repositorios;

import com.um.tp1PersistenciaJPA.entidades.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Long> {
}
