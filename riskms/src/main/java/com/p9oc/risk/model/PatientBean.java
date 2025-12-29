package com.p9oc.risk.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientBean {
    private Integer id;
    private String gender;
    private LocalDate birthdate;


}
