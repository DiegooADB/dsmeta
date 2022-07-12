package me.diego.dsmeta.dto.productResponse;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ProductResponseDTO {
    protected long id;
    protected String sellerName;
    protected long sellerId;
    protected LocalDateTime createdAt;
    protected boolean itSold;
}
