package com.p9oc.note.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "notes")
public class Note {

    @Id
    private String id;

    private Integer patientId;

    private String patientLastName;

    private String note;

    private LocalDateTime createdAt;
}
