package com.p9oc.risk.proxy;

import com.p9oc.risk.model.PatientBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "patient-service", url = "http://gateway:8081")
public interface PatientProxy {

    @GetMapping("/api/patient/{id}")
    PatientBean getPatient(@PathVariable("id") Integer id);
}
