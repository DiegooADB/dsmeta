package me.diego.dsmeta.dto.productResponse;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProductSoldResponse extends ProductResponseDTO{
    private LocalDateTime soldAt;

    @JsonCreator
    public ProductSoldResponse(@JsonProperty("id") long id,
                              @JsonProperty("sellerName") String sellerName,
                              @JsonProperty("sellerId") long sellerId,
                              @JsonProperty("createdAt") LocalDateTime createdAt,
                              @JsonProperty("itSold") boolean itSold,
                               @JsonProperty("soldAt") LocalDateTime soldAt) {
        this.id = id;
        this.sellerName = sellerName;
        this.sellerId = sellerId;
        this.createdAt = createdAt;
        this.itSold = itSold;
        this.soldAt = soldAt;
    }
}
