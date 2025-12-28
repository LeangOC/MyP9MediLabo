package com.p9oc.note.controller;

import com.p9oc.note.model.Note;
import com.p9oc.note.repository.NoteRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

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
}
