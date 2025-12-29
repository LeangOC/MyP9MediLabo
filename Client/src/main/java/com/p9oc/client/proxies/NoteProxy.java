package com.p9oc.client.proxies;

import com.p9oc.client.beans.NoteBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

    @FeignClient(name = "note-service", url = "http://gateway:8081")
    public interface NoteProxy {

        @GetMapping("/api/notes/patient/{patientId}")
        List<NoteBean> getNotes(@PathVariable Integer patientId);

        @PostMapping("/api/notes")
        NoteBean addNote(@RequestBody NoteBean note);
    }


