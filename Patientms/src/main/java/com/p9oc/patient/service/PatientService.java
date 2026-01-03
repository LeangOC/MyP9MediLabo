package com.p9oc.patient.service;
import com.p9oc.patient.model.Patient;
import com.p9oc.patient.proxies.NoteProxy;
import com.p9oc.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class PatientService {

    private final PatientRepository patientRepository;
    private final NoteProxy noteProxy;

    public PatientService(PatientRepository patientRepository,
                          NoteProxy noteProxy) {
        this.patientRepository = patientRepository;
        this.noteProxy = noteProxy;
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
        if (!patientRepository.existsById(id)) {
            throw new IllegalArgumentException("Patient not found.");
        }

        // Suppression des notes AVANT suppression du patient
        noteProxy.deleteNotesByPatient(id);

        patientRepository.deleteById(id);
    }

    public Patient updatePatient(Patient updatedPatient) {
        if (!patientRepository.existsById(updatedPatient.getId())) {
            throw new IllegalArgumentException("Patient not found.");
        }
        return patientRepository.save(updatedPatient);
    }
}

