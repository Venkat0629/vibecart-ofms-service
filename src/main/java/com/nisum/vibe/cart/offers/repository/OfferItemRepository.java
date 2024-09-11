package com.nisum.vibe.cart.offers.repository;

import com.nisum.vibe.cart.offers.dao.OfferItemDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferItemRepository extends JpaRepository<OfferItemDAO, Long> {

}
