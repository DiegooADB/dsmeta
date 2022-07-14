package me.diego.dsmeta.services;

import lombok.RequiredArgsConstructor;
import me.diego.dsmeta.entities.Sale;
import me.diego.dsmeta.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleService {
    @Autowired
    private final SaleRepository saleRepository;

    public List<Sale> findAll() {
        return saleRepository.findAll();
    }
}
