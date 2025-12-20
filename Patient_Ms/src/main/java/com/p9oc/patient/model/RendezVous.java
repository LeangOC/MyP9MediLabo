package com.p9oc.patient.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity //Cette classe est une entité persistante (une table en base de données)
@Table(name = "rdv") //Associe la classe à la table SQL rdv
@Data //Lombok : génération automatique getters/setters, toString,....
@NoArgsConstructor //Lombak : public RendezVous() {}
@AllArgsConstructor //Lombak : public RendezVous(Integer id, LocalDateTime dateHeure, Patient patient)
public class RendezVous {

    @Id // clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY) //bdd génère l’ID automatiquement (auto-increment)
    private Integer id;

    @Column(nullable = false) //Colonne obligatoire en base (NOT NULL)
    private LocalDateTime dateHeure; // date + heure sans fuseau horaire

    // Relation avec Patient
    @JsonBackReference
    @ManyToOne //Plusieurs rendez-vous peuvent appartenir à un seul patient
    @JoinColumn(name = "patient_id", nullable = false)
    //crée une colonne appelée patient_id qui référence la clé primaire id de la table patient
    //sql : FOREIGN KEY (patient_id) REFERENCES patient(id)
    private Patient patient; //un rendez-vous est associé à UN patient
}
