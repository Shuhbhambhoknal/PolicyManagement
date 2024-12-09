package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.capg.policyapp.dao.PolicyDAO;
import com.capg.policyapp.exception.InvalidEntityException;
import com.capg.policyapp.model.Policy;
import com.capg.policyapp.service.PolicyServiceImpl;


@ExtendWith(MockitoExtension.class)
public class PolicyServiceImplTest {

    @Mock
    PolicyDAO policyDAO;

    @InjectMocks
    PolicyServiceImpl policyService;

    @Test
    void testAddPolicy() throws InvalidEntityException {
        Policy policy = new Policy();
        long customerId = 123;
        long schemeId = 123;

        when(policyDAO.addPolicy(policy, customerId, schemeId)).thenReturn(policy);

        Policy result = policyService.addPolicy(policy, customerId, schemeId);

        assertEquals(policy, result);
    }

    @Test
    void testUpdatePolicyStatus() throws InvalidEntityException {
        long policyId = 123;
        String policyStatus = "Active";

        Policy updatedPolicy = new Policy();
        updatedPolicy.setPolicyId(policyId);
        updatedPolicy.setPolicyStatus(policyStatus);

        when(policyDAO.updatePolicyStatus(policyId, policyStatus)).thenReturn(updatedPolicy);

        Policy result = policyService.updatePolicyStatus(policyId, policyStatus);

        assertEquals(updatedPolicy, result);
    }
}
