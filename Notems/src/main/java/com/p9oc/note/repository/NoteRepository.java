package com.p9oc.note.repository;

import com.p9oc.note.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NoteRepository extends MongoRepository<Note, String> {

    List<Note> findByPatientId(Integer patientId);
    long countByPatientId(Integer patientId);
    void deleteByPatientId(Integer patientId);
}
