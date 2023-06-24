package com.fiosequeries.repository;

import com.fiosequeries.Model.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface itemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}
