package com.fiosequeries.repository;

import com.fiosequeries.Model.Tecido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecidoRepository extends JpaRepository<Tecido, Long> {
}
