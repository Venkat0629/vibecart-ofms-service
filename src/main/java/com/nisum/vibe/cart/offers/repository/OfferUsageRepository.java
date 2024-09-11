package com.nisum.vibe.cart.offers.repository;

import com.nisum.vibe.cart.offers.dao.OfferUsageDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferUsageRepository extends JpaRepository<OfferUsageDAO, Long> {
}
