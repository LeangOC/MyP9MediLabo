package com.p9oc.risk.controller;

import com.p9oc.risk.model.RiskAssessment;
import com.p9oc.risk.model.RiskLevel;
import com.p9oc.risk.service.RiskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RiskController.class)
class RiskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RiskService riskService;

    @Test
    void shouldReturnRiskAssessment() throws Exception {
        RiskAssessment assessment =
                new RiskAssessment(1, RiskLevel.NONE);

        when(riskService.assessRisk(1)).thenReturn(assessment);

        mockMvc.perform(get("/api/risk/patient/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.riskLevel").value("NONE"));
    }

    @Test
    void shouldReturnRiskAssessmen2t() throws Exception {
        RiskAssessment assessment = new RiskAssessment(1, RiskLevel.NONE);

        when(riskService.assessRisk(1)).thenReturn(assessment);

        mockMvc.perform(get("/api/risk/patient/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.patientId").value(1))
                .andExpect(jsonPath("$.riskLevel").value("NONE"));
    }
}

