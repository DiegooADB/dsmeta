package me.diego.dsmeta.controller;

import lombok.RequiredArgsConstructor;
import me.diego.dsmeta.domain.Seller;
import me.diego.dsmeta.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/seller")
@RequiredArgsConstructor
public class SellerController {
    @Autowired
    private final SellerService sellerService;

    @GetMapping
    public ResponseEntity<Page<Seller>> findAll(@PageableDefault Pageable pageable) {
        return ResponseEntity.status(HttpStatus.FOUND).body(sellerService.findAllPageable(pageable));
    }

    @PostMapping
    public ResponseEntity<Seller> createSeller(@RequestBody Seller seller) {
        return ResponseEntity.status(HttpStatus.CREATED).body(sellerService.createSeller(seller));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Seller> findById(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.FOUND).body(sellerService.findByIdOrThrowsBadRequestException(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        sellerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
