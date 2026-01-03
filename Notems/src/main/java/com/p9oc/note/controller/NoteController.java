package com.p9oc.note.controller;

import com.p9oc.note.model.Note;
import com.p9oc.note.repository.NoteRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController

@RequestMapping("/api/notes")
public class NoteController {
    private static final Logger log = LoggerFactory.getLogger(NoteController.class);
    private final NoteRepository noteRepository;

    public NoteController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @GetMapping("/patient/{patientId}")
    public List<Note> getNotesByPatient(@PathVariable Integer patientId) {
        return noteRepository.findByPatientId(patientId);
    }

    @PostMapping
    public Note addNote(@RequestBody Note note) {
        note.setCreatedAt(LocalDateTime.now());
        return noteRepository.save(note);
    }


    @DeleteMapping("/patient/{id}")
    public void deleteNotesByPatient(@PathVariable Integer id) {
        long count = noteRepository.countByPatientId(id);
        log.info("Request received to delete notes for patientId={}", id);
        if (count == 0) {
            log.info("No notes found for patientId={}", id);
        } else {
            noteRepository.deleteByPatientId(id);
            log.info("{} note(s) deleted for patientId={}", count, id);
        }
    }

}
