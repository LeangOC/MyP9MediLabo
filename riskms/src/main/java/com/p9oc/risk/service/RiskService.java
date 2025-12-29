package com.p9oc.risk.service;

import com.p9oc.risk.model.NoteBean;
import com.p9oc.risk.model.PatientBean;
import com.p9oc.risk.model.RiskAssessment;
import com.p9oc.risk.model.RiskLevel;
import com.p9oc.risk.proxy.NoteProxy;
import com.p9oc.risk.proxy.PatientProxy;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import static com.p9oc.risk.service.RiskTriggers.TRIGGERS;

@Service
public class RiskService {

    private final PatientProxy patientProxy;
    private final NoteProxy noteProxy;

    public RiskService(PatientProxy patientProxy, NoteProxy noteProxy) {
        this.patientProxy = patientProxy;
        this.noteProxy = noteProxy;
    }

    public RiskAssessment assessRisk(Integer patientId) {

        PatientBean patient = patientProxy.getPatient(patientId);
        List<NoteBean> note = noteProxy.getNotes(patientId);

        int age = Period.between(patient.getBirthdate(), LocalDate.now()).getYears();
        boolean isMale = "M".equalsIgnoreCase(patient.getGender());

        int triggerCount = countTriggers(note);

        RiskLevel level = calculateRisk(age, isMale, triggerCount);

        return new RiskAssessment(patientId, level);
    }

    private int countTriggers(List<NoteBean> notes) {
        return notes.stream()
                .map(NoteBean::getNote)
                .map(String::toLowerCase)
                .mapToInt(note ->
                        (int) TRIGGERS.stream()
                                .filter(t -> note.contains(t.toLowerCase()))
                                .count()
                ).sum();
    }

    private RiskLevel calculateRisk(int age, boolean isMale, int triggers) {

        if (triggers == 0) return RiskLevel.NONE;

        if (age > 30) {
            if (triggers >= 8) return RiskLevel.EARLY_ONSET;
            if (triggers >= 6) return RiskLevel.IN_DANGER;
            if (triggers >= 2) return RiskLevel.BORDERLINE;
        } else {
            if (isMale) {
                if (triggers >= 5) return RiskLevel.EARLY_ONSET;
                if (triggers >= 3) return RiskLevel.IN_DANGER;
            } else {
                if (triggers >= 7) return RiskLevel.EARLY_ONSET;
                if (triggers >= 4) return RiskLevel.IN_DANGER;
            }
        }

        return RiskLevel.NONE;
    }
}
