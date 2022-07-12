package me.diego.dsmeta.dto.productResponse;

import lombok.Getter;
import lombok.Setter;
import me.diego.dsmeta.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ProductResponseDTO {
    protected long id;
    protected String sellerName;
    protected long sellerId;
    protected LocalDateTime createdAt;
    protected boolean itSold;

    public static Page<ProductResponseDTO> parseToResponseDTO(List<Product> productList, Pageable pageable) {
        List<ProductResponseDTO> productResponseDTOList = new ArrayList<>();

        productList.forEach(product -> {
            if(product.isItSold()) {
                productResponseDTOList.add(
                        new ProductSoldResponse(
                                product.getId(),
                                product.getSeller().getName(),
                                product.getSeller().getId(),
                                product.getCreatedAt(),
                                product.isItSold(),
                                product.getSoldAt()
                        ));
            } else {
                productResponseDTOList.add(
                        new ProductNotSoldResponse(
                                product.getId(),
                                product.getSeller().getName(),
                                product.getSeller().getId(),
                                product.getCreatedAt(),
                                product.isItSold()
                        ));
            }
        });

        return new PageImpl<>(productResponseDTOList, pageable, productResponseDTOList.size());
    }
}
