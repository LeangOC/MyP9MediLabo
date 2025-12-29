package com.p9oc.note.loader;

import com.p9oc.note.model.Note;
import com.p9oc.note.repository.NoteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadNotes(NoteRepository noteRepository) {
        return args -> {

            if (noteRepository.count() == 0) {

                noteRepository.saveAll(List.of(
                        create(1, "TestNone",
                                "Le patient déclare qu'il se sent très bien\nPoids égal ou inférieur au poids recommandé"),

                        create(2, "TestBorderline",
                                "Le patient déclare qu'il ressent beaucoup de stress au travail\nAudition anormale"),

                        create(2, "TestBorderline",
                                "Le patient déclare avoir fait une réaction aux médicaments\nAudition toujours anormale"),

                        create(3, "TestInDanger",
                                "Le patient déclare qu'il fume depuis peu"),

                        create(3, "TestInDanger",
                                "Fumeur, apnée respiratoire\nCholestérol LDL élevé"),

                        create(4, "TestEarlyOnset",
                                "Difficulté à monter les escaliers\nAnticorps élevés\nRéaction aux médicaments"),

                        create(4, "TestEarlyOnset",
                                "Commencé à fumer\nHémoglobine A1C élevée"),

                        create(4, "TestEarlyOnset",
                                "Taille, Poids, Cholestérol, Vertige et Réaction")
                ));
            }
        };
    }

    private Note create(int patientId, String lastName, String text) {
        Note note = new Note();
        note.setPatientId(patientId);
        note.setPatientLastName(lastName);
        note.setNote(text);
        note.setCreatedAt(LocalDateTime.now());
        return note;
    }
}
