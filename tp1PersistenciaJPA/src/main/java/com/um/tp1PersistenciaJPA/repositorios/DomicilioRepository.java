package com.um.tp1PersistenciaJPA.repositorios;

import com.um.tp1PersistenciaJPA.entidades.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends JpaRepository<Domicilio, Long> {
}
