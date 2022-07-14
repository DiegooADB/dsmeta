package me.diego.dsmeta.repositories;

import me.diego.dsmeta.entities.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepository extends JpaRepository<Sales, Long> {
}
