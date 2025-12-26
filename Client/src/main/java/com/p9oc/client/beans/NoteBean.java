package com.p9oc.client.beans;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NoteBean {

    private String id;
    private Integer patientId;
    private String patientLastName;
    private String note;
    private LocalDateTime createdAt;
}
