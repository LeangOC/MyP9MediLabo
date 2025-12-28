package com.p9oc.patient.service;
import com.p9oc.patient.model.Patient;
import com.p9oc.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Optional<Patient> getPatientById(Integer id) {
        return patientRepository.findById(id);
    }

    public void deletePatient(Integer id) {
        if (patientRepository.existsById(id)) {
            patientRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Patient not found.");
        }
    }
    public Patient updatePatient(Patient updatedPatient) {
        if (patientRepository.existsById(updatedPatient.getId())) {
            updatedPatient.setId(updatedPatient.getId());
            return patientRepository.save(updatedPatient);
        } else {
            throw new IllegalArgumentException("Patient not found.");
        }
    }
}

