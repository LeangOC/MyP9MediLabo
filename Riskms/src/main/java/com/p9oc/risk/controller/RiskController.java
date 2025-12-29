package com.p9oc.risk.controller;

import com.p9oc.risk.model.RiskAssessment;
import com.p9oc.risk.service.RiskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/risk")
public class RiskController {

    private final RiskService riskService;

    public RiskController(RiskService riskService) {
        this.riskService = riskService;
    }

    @GetMapping("/patient/{id}")
    public RiskAssessment getRisk(@PathVariable Integer id) {
        System.out.println(">>> Risk endpoint called with id=" + id);
        return riskService.assessRisk(id);
    }
}
