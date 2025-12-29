package com.p9oc.risk.service;

import java.util.List;

public final class RiskTriggers {

    private RiskTriggers() {}

    public static final List<String> TRIGGERS = List.of("Hémoglobine A1C",
            "Microalbumine",
            "Taille",
            "Poids",
            "Fumeur",
            "Fumeuse",
            "Anormal",
            "Cholestérol",
            "Vertiges",
            "Rechute",
            "Réaction",
            "Anticorps"
    );
}
