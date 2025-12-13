package com.p9oc.client.proxies;

import com.p9oc.client.beans.PatientBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "patient-gateway", url = "localhost:8081")
@Component
public interface PatientsProxy {
    @GetMapping(value = "/api/patients")
    List<PatientBean> getAllPatients();
}
