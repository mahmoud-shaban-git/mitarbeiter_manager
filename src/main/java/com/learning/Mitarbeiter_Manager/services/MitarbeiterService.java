package com.learning.Mitarbeiter_Manager.services;

import com.learning.Mitarbeiter_Manager.model.Mitarbeiter;
import com.learning.Mitarbeiter_Manager.repos.MitarbeiterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class MitarbeiterService {
    @Autowired
    private MitarbeiterRepo mitarbeiterRepo ;

    public List<Mitarbeiter> getAllMitarbeiter(){
        return mitarbeiterRepo.findAll();
    }

    public Mitarbeiter getMitarbeiterById(Long id){
        return mitarbeiterRepo.findById(id).orElse(null);
    }

    public Mitarbeiter getMitarbeiterVorname(String vorname){
        return mitarbeiterRepo.findByVorname(vorname).orElse(null);
    }

    public Mitarbeiter getMitarbeiterNachname(String nachname){
        return mitarbeiterRepo.findByNachname(nachname).orElse(null);
    }

    public List<Mitarbeiter> sucheMitarbeiter (String vorname, String nachname){
        return mitarbeiterRepo.sucheMitarbeiter(vorname, nachname);

    }

    public void addMitarbeiter(Mitarbeiter mitarbeiter)
    {
        mitarbeiterRepo.save(mitarbeiter);
    }

    public void updateMitarbeiter(Mitarbeiter mitarbeiter)
    {
        mitarbeiterRepo.save(mitarbeiter);
    }

    public void deleteMitarbeiter(long id)
    {
        mitarbeiterRepo.deleteById(id);
    }






}
