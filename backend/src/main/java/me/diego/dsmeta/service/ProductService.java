package me.diego.dsmeta.service;

import lombok.RequiredArgsConstructor;
import me.diego.dsmeta.domain.Product;
import me.diego.dsmeta.dto.productResponse.ProductResponseDTO;
import me.diego.dsmeta.exceptions.BadRequestException;
import me.diego.dsmeta.repositories.ProductRepository;
import me.diego.dsmeta.utils.ProductParse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    private final ProductParse productParse;

    public Page<ProductResponseDTO> findAll(Pageable pageable) {
        List<Product> productList = productRepository.findAll();

        List<ProductResponseDTO> productResponse = new ArrayList<>();

        productList.forEach(product -> {
            productResponse.add(productParse.parseToResponseDTO(product));
        });

        return new PageImpl<>(productResponse, pageable, productResponse.size());
    }

    public ProductResponseDTO findByIdOrThrowsBadRequest(long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Product not found"));

        return productParse.parseToResponseDTO(product);
    }
}
