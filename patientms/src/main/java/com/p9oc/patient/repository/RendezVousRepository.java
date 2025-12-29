package com.p9oc.patient.repository;

import com.p9oc.patient.model.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RendezVousRepository
        extends JpaRepository<RendezVous, Integer> {
}
