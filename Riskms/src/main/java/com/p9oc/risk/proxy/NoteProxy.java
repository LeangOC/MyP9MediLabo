package com.p9oc.risk.proxy;

import com.p9oc.risk.model.NoteBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "note-service", url = "http://gateway:8081")
public interface NoteProxy {

    @GetMapping("/api/notes/patient/{id}")
    List<NoteBean> getNotes(@PathVariable("id") Integer id);
}
