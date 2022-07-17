package me.diego.dsmeta.controllers;

import lombok.RequiredArgsConstructor;
import me.diego.dsmeta.entities.Sale;
import me.diego.dsmeta.services.SaleService;
import me.diego.dsmeta.services.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/sales", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class SaleController {
    @Autowired
    private final SaleService saleService;

    @Autowired
    private final SmsService smsService;

    @GetMapping
    public ResponseEntity<Page<Sale>> findAll(@RequestParam(value = "minDate", defaultValue = "") String minDate,
                                              @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
                                              @PageableDefault Pageable pageable) {
        return ResponseEntity.status(HttpStatus.FOUND).body(saleService.findAll(minDate, maxDate, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sale> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.FOUND).body(saleService.findByIdOrThrowsBadRequest(id));
    }

    @GetMapping("/{id}/notification")
    public void notifySms(@PathVariable Long id) {
        smsService.sendSms(id);
    }

}
