package com.p9oc.risk.service;

import com.p9oc.risk.model.NoteBean;
import com.p9oc.risk.model.PatientBean;
import com.p9oc.risk.model.RiskAssessment;
import com.p9oc.risk.model.RiskLevel;
import com.p9oc.risk.proxy.NoteProxy;
import com.p9oc.risk.proxy.PatientProxy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RiskServiceTest {

    @Mock
    private PatientProxy patientProxy;

    @Mock
    private NoteProxy noteProxy;

    @InjectMocks
    private RiskService riskService;

    @Test
    void shouldReturnEarlyOnsetForMaleUnder30WithManyTriggers() {
        // GIVEN
        PatientBean patient = new PatientBean();
        patient.setId(1);
        patient.setGender("M");
        patient.setBirthdate(LocalDate.now().minusYears(25));

        List<NoteBean> notes = List.of(
                note("Hémoglobine A1C"),
                note("Fumeur"),
                note("Poids"),
                note("Vertiges"),
                note("Cholestérol")
        );

        when(patientProxy.getPatient(1)).thenReturn(patient);
        when(noteProxy.getNotes(1)).thenReturn(notes);

        // WHEN
        RiskAssessment result = riskService.assessRisk(1);

        // THEN
        assertEquals(RiskLevel.EARLY_ONSET, result.getRiskLevel());
    }

    @Test
    void shouldReturnNoneWhenNoTriggers() {
        PatientBean patient = patient(40, "F");
        when(patientProxy.getPatient(1)).thenReturn(patient);
        when(noteProxy.getNotes(1)).thenReturn(List.of());

        RiskAssessment result = riskService.assessRisk(1);

        assertEquals(RiskLevel.NONE, result.getRiskLevel());
    }
    @Test
    void shouldReturnBorderlineWhenTwoTriggers() {
        PatientBean patient = patient(45, "M");

        when(patientProxy.getPatient(1)).thenReturn(patient);
        when(noteProxy.getNotes(1)).thenReturn(List.of(
                note("Hémoglobine A1C"),
                note("Fumeur")
        ));

        RiskAssessment result = riskService.assessRisk(1);

        assertEquals(RiskLevel.BORDERLINE, result.getRiskLevel());
    }

    @Test
    void shouldReturnInDangerForYoungMale() {
        PatientBean patient = patient(28, "M");

        when(patientProxy.getPatient(1)).thenReturn(patient);
        when(noteProxy.getNotes(1)).thenReturn(List.of(
                note("Poids"),
                note("Fumeur"),
                note("Vertiges")
        ));

        RiskAssessment result = riskService.assessRisk(1);

        assertEquals(RiskLevel.IN_DANGER, result.getRiskLevel());
    }
    @Test
    void shouldReturnInDangerForYoungFemale() {
        PatientBean patient = patient(27, "F");

        when(patientProxy.getPatient(1)).thenReturn(patient);
        when(noteProxy.getNotes(1)).thenReturn(List.of(
                note("Poids"),
                note("Vertiges"),
                note("Cholestérol"),
                note("Fumeur")
        ));

        RiskAssessment result = riskService.assessRisk(1);

        assertEquals(RiskLevel.IN_DANGER, result.getRiskLevel());
    }
    @Test
    void shouldReturnEarlyOnsetWhenManyTriggers() {
        PatientBean patient = patient(25, "M");

        when(patientProxy.getPatient(1)).thenReturn(patient);
        when(noteProxy.getNotes(1)).thenReturn(List.of(
                note("Hémoglobine A1C"),
                note("Microalbumine"),
                note("Taille"),
                note("Poids"),
                note("Fumeur"),
                note("Vertiges")
        ));

        RiskAssessment result = riskService.assessRisk(1);

        assertEquals(RiskLevel.EARLY_ONSET, result.getRiskLevel());
    }
    @Test
    void shouldReturnInDangerWhenOver30WithManyTriggers() {
        PatientBean patient = patient(55, "F");

        when(patientProxy.getPatient(1)).thenReturn(patient);
        when(noteProxy.getNotes(1)).thenReturn(List.of(
                note("Hémoglobine A1C"),
                note("Microalbumine"),
                note("Taille"),
                note("Poids"),
                note("Fumeur"),
                note("Vertiges")
        ));

        RiskAssessment result = riskService.assessRisk(1);

        assertEquals(RiskLevel.IN_DANGER, result.getRiskLevel());
    }
    @Test
    void shouldReturnBorderlineWhenOver30WithThreeTriggers() {
        PatientBean patient = patient(40, "M");

        when(patientProxy.getPatient(1)).thenReturn(patient);
        when(noteProxy.getNotes(1)).thenReturn(List.of(
                note("Poids"),
                note("Vertiges"),
                note("Fumeur")
        ));

        RiskAssessment result = riskService.assessRisk(1);

        assertEquals(RiskLevel.BORDERLINE, result.getRiskLevel());
    }
    @Test
    void shouldThrowExceptionWhenPatientNotFound() {
        when(patientProxy.getPatient(99))
                .thenThrow(new RuntimeException("Patient not found"));

        org.junit.jupiter.api.Assertions.assertThrows(
                RuntimeException.class,
                () -> riskService.assessRisk(99)
        );
    }


    private NoteBean note(String text) {
        NoteBean n = new NoteBean();
        n.setNote(text);
        return n;
    }
    private PatientBean patient(int age, String gender) {
        PatientBean p = new PatientBean();
        p.setId(1);
        p.setGender(gender);
        p.setBirthdate(LocalDate.now().minusYears(age));
        return p;
    }
}
