package me.diego.dsmeta.controllers;

import lombok.RequiredArgsConstructor;
import me.diego.dsmeta.entities.Sale;
import me.diego.dsmeta.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/sales")
@RequiredArgsConstructor
public class SaleController {
    @Autowired
    private final SaleService saleService;

    @GetMapping
    public ResponseEntity<Page<Sale>> findAll(@RequestParam(value = "minDate", defaultValue = "") String minDate,
                                              @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
                                              @PageableDefault Pageable pageable) {
        return ResponseEntity.status(HttpStatus.FOUND).body(saleService.findAll(minDate, maxDate, pageable));
    }
}
