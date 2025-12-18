package com.p9oc.client.controller;

import com.p9oc.client.beans.PatientBean;
import com.p9oc.client.proxies.PatientsProxy;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import jakarta.validation.Valid;

import java.util.List;
@Controller
public class ClientController {
    @Autowired
    private PatientsProxy PatientsProxy;
    @GetMapping("/patient")
    public String patientList(Model model, HttpServletRequest request){
        List<PatientBean> patients =  PatientsProxy.getAllPatients();
        model.addAttribute("patients", patients);
        return "patient/list";
    }



    @GetMapping("/patient/add")
    public String addPatient(Model model, HttpServletRequest request){
        PatientBean patient = new PatientBean(); //Pour bien initialiser l'objet patient sinon erreur Thymeleaf "patient.id" inconnu
        model.addAttribute("patient", patient);
        return "patient/add";
    }

    @PostMapping("/patient/validate")
    public String validateAddedPatient(
            @Valid PatientBean patientBean,
            BindingResult result,
            RedirectAttributes redirectAttributes,
            HttpServletRequest request){
        if (result.hasErrors()) {
            // Log de toutes les erreurs de validation
            result.getAllErrors().forEach(error -> {
                System.out.println("Erreur: " + error.getDefaultMessage());
            });

            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.patientBean", result);
            redirectAttributes.addFlashAttribute("patientBean", patientBean);
            redirectAttributes.addFlashAttribute("error", "Saisie incorrecte");
            return "redirect:/patient/add";
        }

        if (StringUtils.isEmpty(patientBean.getId())) {
            PatientsProxy.createPatient(patientBean);
        }
        return "redirect:/patient";
    }
    @GetMapping("/patient/delete/{id}")
    public String deletePatient(@PathVariable String id, Model model, HttpServletRequest request){
        PatientsProxy.deletePatient(id);
        List<PatientBean> patients =  PatientsProxy.getAllPatients();
        model.addAttribute("patients", patients);
        return "redirect:/patient";
    }

}
