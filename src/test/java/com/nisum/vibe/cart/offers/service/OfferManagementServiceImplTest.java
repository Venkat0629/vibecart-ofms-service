package com.nisum.vibe.cart.offers.service;

import com.nisum.vibe.cart.offers.dto.OfferDTO;
import com.nisum.vibe.cart.offers.repository.OfferRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OfferManagementServiceImplTest {

    private final OfferRepository offerRepository = Mockito.mock(OfferRepository.class);

    @InjectMocks
    private OfferManagementServiceImpl offerManagementService;

    @Test
    public void testGetAllOffers() {
        when(offerRepository.findAll()).thenReturn(Collections.emptyList());
        List<OfferDTO> result = offerManagementService.getAllOffers();
        assertEquals(Collections.emptyList(), result);
    }

}