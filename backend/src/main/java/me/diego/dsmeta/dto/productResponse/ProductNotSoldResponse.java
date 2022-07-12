package me.diego.dsmeta.dto.productResponse;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ProductNotSoldResponse extends ProductResponseDTO {
    @JsonCreator
    public ProductNotSoldResponse(@JsonProperty("id") long id,
                               @JsonProperty("sellerName") String sellerName,
                               @JsonProperty("sellerId") long sellerId,
                               @JsonProperty("createdAt") LocalDateTime createdAt,
                               @JsonProperty("itSold") boolean itSold) {
        this.id = id;
        this.sellerName = sellerName;
        this.sellerId = sellerId;
        this.createdAt = createdAt;
        this.itSold = itSold;
    }
}
