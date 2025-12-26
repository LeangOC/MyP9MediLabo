package com.p9oc.client.controller;

import com.p9oc.client.proxies.PatientsProxy;
import com.p9oc.client.proxies.NoteProxy;
import com.p9oc.client.beans.NoteBean;
import com.p9oc.client.beans.PatientBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class NoteController {
    @Autowired
    private NoteProxy noteProxy;

    @Autowired
    private PatientsProxy patientsProxy;


    public NoteController(PatientsProxy patientsProxy, NoteProxy noteProxy) {
        this.patientsProxy = patientsProxy;
        this.noteProxy = noteProxy;
    }

    @GetMapping("/patient/{id}/details")
    public String patientDetail(@PathVariable Integer id, Model model) {

        PatientBean patient = patientsProxy.getPatient(id);
        List<NoteBean> notes = noteProxy.getNotes(id);

        model.addAttribute("patient", patient);
        model.addAttribute("notes", notes);

        return "patient";
    }

    @PostMapping("/notes/add")
    public String addNote(NoteBean note) {
        noteProxy.addNote(note);
        return "redirect:/patient/" + note.getPatientId();
    }

}
