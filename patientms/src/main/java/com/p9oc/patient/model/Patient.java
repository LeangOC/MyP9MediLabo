package com.p9oc.patient.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstname;
    private String lastname;
    private Date birthdate;
    private String gender;
    private String address;
    private String phone_number;
    @JsonManagedReference
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<RendezVous> rendezVous; //un patient possède une liste de rendez-vous
    @Transient // dit à JPA que : hors base de données, pas de colonne
    public RendezVous getNextRendezVous() {
        if (rendezVous == null) {
            return null;
        }
//prend tous les rendez-vous du patient,garde ceux dans le futur et retourne le plus proche
        return rendezVous.stream()
                .filter(rdv -> rdv.getDateHeure().isAfter(LocalDateTime.now()))
                .min(Comparator.comparing(RendezVous::getDateHeure))
                .orElse(null);
    }
}

