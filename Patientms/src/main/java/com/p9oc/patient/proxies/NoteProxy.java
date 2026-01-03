package com.p9oc.patient.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "note-service", url = "http://notems:8083")
public interface NoteProxy {

    @DeleteMapping("/api/notes/patient/{id}")
    void deleteNotesByPatient(@PathVariable("id") Integer id);
}
