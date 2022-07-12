package me.diego.dsmeta.service;

import lombok.RequiredArgsConstructor;
import me.diego.dsmeta.domain.Product;
import me.diego.dsmeta.dto.productResponse.ProductResponseDTO;
import me.diego.dsmeta.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    @Autowired
    private final ProductRepository productRepository;

    public Page<ProductResponseDTO> findAll(Pageable pageable) {
        List<Product> productList = productRepository.findAll();

        return ProductResponseDTO.parseToResponseDTO(productList, pageable);
    }
}
