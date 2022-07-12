package me.diego.dsmeta.utils;

import me.diego.dsmeta.domain.Product;
import me.diego.dsmeta.dto.productResponse.ProductNotSoldResponse;
import me.diego.dsmeta.dto.productResponse.ProductResponseDTO;
import me.diego.dsmeta.dto.productResponse.ProductSoldResponse;
import org.springframework.stereotype.Component;

@Component
public class ProductParse {
    public ProductResponseDTO parseToResponseDTO(Product product) {
        ProductResponseDTO productResponseDTO;

        if (product.isItSold()) {
            productResponseDTO = new ProductSoldResponse(
                    product.getId(),
                    product.getSeller().getName(),
                    product.getSeller().getId(),
                    product.getCreatedAt(),
                    product.isItSold(),
                    product.getSoldAt()
            );
        } else {
            productResponseDTO = new ProductNotSoldResponse(
                    product.getId(),
                    product.getSeller().getName(),
                    product.getSeller().getId(),
                    product.getCreatedAt(),
                    product.isItSold());
        }

        return productResponseDTO;
    }
}
