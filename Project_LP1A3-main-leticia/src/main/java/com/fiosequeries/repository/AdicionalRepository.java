package com.fiosequeries.repository;

import com.fiosequeries.Model.Adicional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdicionalRepository extends JpaRepository<Adicional, Long> {
}
