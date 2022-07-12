package me.diego.dsmeta.service;

import me.diego.dsmeta.domain.Seller;
import me.diego.dsmeta.exceptions.BadRequestException;
import me.diego.dsmeta.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService {
    @Autowired
    private final SellerRepository sellerRepository;

    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    private List<Seller> findAll() {
        return sellerRepository.findAll();
    }

    public Seller createSeller(Seller seller) {
        return sellerRepository.save(seller);
    }

    public Seller findByIdOrThrowsBadRequestException(long id) {
        return sellerRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Seller not found"));
    }

    public void delete(long id) {
        Seller seller = findByIdOrThrowsBadRequestException(id);
        sellerRepository.delete(seller);
    }

    public Page<Seller> findAllPageable(Pageable pageable) {
        return sellerRepository.findAll(pageable);
    }
}
