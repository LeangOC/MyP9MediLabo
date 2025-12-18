package com.p9oc.client.proxies;

import com.p9oc.client.beans.PatientBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "patient-gateway", url = "localhost:8081")
@Component
public interface PatientsProxy {
    @GetMapping(value = "/api/patient")
    List<PatientBean> getAllPatients();

    @PostMapping(value= "/api/patient")
    PatientBean createPatient(@RequestBody PatientBean patientBean);

    @DeleteMapping( value = "/api/patient/{id}")
    PatientBean deletePatient(@PathVariable("id") String id);

}
