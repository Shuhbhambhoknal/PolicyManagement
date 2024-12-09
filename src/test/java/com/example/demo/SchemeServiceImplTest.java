package com.example.demo;

//public class SchemeServiceImplTest {

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.capg.policyapp.dao.SchemeDAO;
import com.capg.policyapp.exception.InvalidEntityException;
import com.capg.policyapp.model.Scheme;
import com.capg.policyapp.service.SchemeServiceImpl;

@ExtendWith(MockitoExtension.class)
public class SchemeServiceImplTest {

    @Mock
    SchemeDAO schemeDAO;

    @InjectMocks
    SchemeServiceImpl schemeService;

    @Test
    void testAddScheme() {
        Scheme scheme = new Scheme();

        when(schemeDAO.addScheme(scheme)).thenReturn(scheme);

        Scheme result = schemeService.addScheme(scheme);

        assertEquals(scheme, result);
    }

    @Test
    void testUpdateRateOfInterest() throws InvalidEntityException {
        long schemeId = 123;
        double rateOfInterest = 5.0;

        Scheme updatedScheme = new Scheme();
        updatedScheme.setSchemeId(schemeId);
        updatedScheme.setRateOfIntrest(rateOfInterest);

        when(schemeDAO.updateRateOfInterest(schemeId, rateOfInterest)).thenReturn(updatedScheme);

        Scheme result = schemeService.updateRateOfInterest(schemeId, rateOfInterest);

        assertEquals(updatedScheme, result);
    }

}

