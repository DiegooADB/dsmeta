package me.diego.dsmeta.controller;

import lombok.RequiredArgsConstructor;
import me.diego.dsmeta.dto.productResponse.ProductResponseDTO;
import me.diego.dsmeta.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/product")
@RequiredArgsConstructor
public class ProductController {
    @Autowired
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<Page<ProductResponseDTO>> findAll(@PageableDefault Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findAll(pageable));
    }
}
