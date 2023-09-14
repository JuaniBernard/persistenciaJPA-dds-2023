package com.um.tp1PersistenciaJPA.repositorios;

import com.um.tp1PersistenciaJPA.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
