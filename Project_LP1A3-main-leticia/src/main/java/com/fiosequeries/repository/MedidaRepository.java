package com.fiosequeries.repository;

import com.fiosequeries.Model.Medida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedidaRepository extends JpaRepository<Medida, Long> {
}
