package me.diego.dsmeta.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@RequiredArgsConstructor
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    private LocalDateTime createdAt;

    private boolean itSold;

    private LocalDateTime soldAt;
}
