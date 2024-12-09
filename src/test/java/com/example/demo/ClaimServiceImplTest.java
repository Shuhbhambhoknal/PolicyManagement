package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.capg.policyapp.dao.ClaimDAOImpl;
import com.capg.policyapp.exception.InvalidEntityException;
import com.capg.policyapp.model.Claim;
import com.capg.policyapp.service.ClaimServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ClaimServiceImplTest {

    @Mock
    ClaimDAOImpl claimDAO;

    @InjectMocks
    ClaimServiceImpl claimService;

    @Test
    void testAddClaim() throws InvalidEntityException {
        Claim claim = new Claim();
        long policyId = 123;

        when(claimDAO.addClaim(claim, policyId)).thenReturn(claim);

        Claim addedClaim = claimService.addClaim(claim, policyId);

        assertEquals(claim, addedClaim);
    }

    @Test
    void testUpdateClaimStatus() throws InvalidEntityException {
        long claimId = 123;
        String claimStatus = "Approved";

        Claim updatedClaim = new Claim();
        updatedClaim.setClaimId(claimId);
        updatedClaim.setClaimStatus(claimStatus);

        when(claimDAO.updateClaimStatus(claimId, claimStatus)).thenReturn(updatedClaim);

        Claim result = claimService.updateClaimStatus(claimId, claimStatus);

        assertEquals(claimId, result.getClaimId());
        assertEquals(claimStatus, result.getClaimStatus());
    }

    @Test
    void testViewAllClaims() {
        List<Claim> claims = new ArrayList<>();
        claims.add(new Claim());
        claims.add(new Claim());

        when(claimDAO.viewAllClaims()).thenReturn(claims);

        List<Claim> result = claimService.viewAllClaims();

        assertEquals(claims.size(), result.size());
    }

    @Test
    void testViewClaimById() throws InvalidEntityException {
        long claimId = 123;
        Claim claim = new Claim();
        claim.setClaimId(claimId);

        when(claimDAO.viewClaimById(claimId)).thenReturn(claim);

        Claim result = claimService.viewClaimById(claimId);

        assertEquals(claimId, result.getClaimId());
    }
}

	


