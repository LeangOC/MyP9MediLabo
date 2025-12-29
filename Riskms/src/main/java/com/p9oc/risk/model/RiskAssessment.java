package com.p9oc.risk.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RiskAssessment {

    private Integer patientId;
    private RiskLevel riskLevel;
}
