package com.nisum.vibe.cart.offers.repository;

import com.nisum.vibe.cart.offers.dao.OfferDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OfferRepository extends JpaRepository<OfferDAO, Long> {
    Optional<OfferDAO> findByOfferName(String offerName);

}
