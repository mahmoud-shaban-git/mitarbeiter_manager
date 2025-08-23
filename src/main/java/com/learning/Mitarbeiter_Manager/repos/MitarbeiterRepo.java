package com.learning.Mitarbeiter_Manager.repos;


import com.learning.Mitarbeiter_Manager.model.Mitarbeiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MitarbeiterRepo extends JpaRepository<Mitarbeiter, Long> {

    Optional<Mitarbeiter> findByVorname(String vorname);

    Optional<Mitarbeiter> findByNachname(String nachname);

    @Query("SELECT m FROM Mitarbeiter m WHERE m.vorname = :vorname OR m.nachname = :nachname")
    List<Mitarbeiter> sucheMitarbeiter(@Param("vorname") String vorname,
                                       @Param("nachname") String nachname);
}
