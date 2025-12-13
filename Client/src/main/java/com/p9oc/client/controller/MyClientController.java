package com.p9oc.client.controller;

import com.p9oc.client.beans.PatientBean;
import com.p9oc.client.proxies.PatientsProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class MyClientController {


    @Autowired
    private PatientsProxy PatientsProxy;
    @GetMapping("/api/patients")
    public ResponseEntity<List<PatientBean>> getAllPatients() {
        List<PatientBean> patients =  PatientsProxy.getAllPatients();
        return ResponseEntity.ok(patients);
    }

}


