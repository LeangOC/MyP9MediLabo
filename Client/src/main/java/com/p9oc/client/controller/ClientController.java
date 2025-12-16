package com.p9oc.client.controller;


import com.p9oc.client.beans.PatientBean;
import com.p9oc.client.proxies.PatientsProxy;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;
@Controller
public class ClientController {
    @Autowired
    private PatientsProxy PatientsProxy;
    @GetMapping("/api/patient")
    public String patientList(Model model, HttpServletRequest request){
        List<PatientBean> patients =  PatientsProxy.getAllPatients();
        model.addAttribute("patients", patients);
        return "patient/list";
    }
}
