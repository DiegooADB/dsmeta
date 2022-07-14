package me.diego.dsmeta.controllers;

import lombok.RequiredArgsConstructor;
import me.diego.dsmeta.entities.Sale;
import me.diego.dsmeta.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/sales")
@RequiredArgsConstructor
public class SaleController {
    @Autowired
    private final SaleService saleService;

    @GetMapping
    public ResponseEntity<List<Sale>> findAll() {
        return ResponseEntity.status(HttpStatus.FOUND).body(saleService.findAll());
    }
}
