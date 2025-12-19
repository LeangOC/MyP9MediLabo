package com.p9oc.patient.controller;

import com.p9oc.patient.model.Patient;
import com.p9oc.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Patient>> deletePatient(@PathVariable String id) {
        int intId = Integer.parseInt(id);
        Optional<Patient> patient = patientService.getPatientById(intId);
        if (patient.isPresent()) {
            patientService.deletePatient(intId);
            return ResponseEntity.ok(patient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable String id) {
        Optional<Patient> patient = patientService.getPatientById(Integer.parseInt(id));
        return patient.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<Patient> updatePatient(@RequestBody Patient updatedPatient) {
            try {
            Patient updated = patientService.updatePatient(updatedPatient);
            return ResponseEntity.ok(updated);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

