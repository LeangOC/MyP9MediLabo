package com.p9oc.patient.controller;

import com.p9oc.patient.model.Patient;
import com.p9oc.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/api/patient")
@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;
    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = patientService.getAllPatients();
        return ResponseEntity.ok(patients);
    }

    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
           Patient createdPatient = patientService.createPatient(patient);
            return ResponseEntity.ok(createdPatient);
    }

}

