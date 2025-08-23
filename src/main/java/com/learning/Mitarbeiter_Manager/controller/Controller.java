package com.learning.Mitarbeiter_Manager.controller;


import com.learning.Mitarbeiter_Manager.model.Mitarbeiter;
import com.learning.Mitarbeiter_Manager.repos.MitarbeiterRepo;
import com.learning.Mitarbeiter_Manager.services.MitarbeiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")

public class Controller {
    @Autowired
    MitarbeiterService mitarbeiterService;
    @Autowired
    private MitarbeiterRepo mitarbeiterRepo;

    // hole mir alle Mitarbeiter in DB
    @GetMapping("/alleMitarbeiter")
    public List<Mitarbeiter> getAllMitarbeiter (){

        return mitarbeiterService.getAllMitarbeiter();

    }

    // hole mir die Mitarbeiter mit der Id = id die Form (http://localhost:8081/api/id/1) wegen PathVariable
    @GetMapping("/id/{id}")
    public Mitarbeiter getMitarbeiterById(@PathVariable Long id)
    {
        return mitarbeiterService.getMitarbeiterById(id);
    }

    // hole mir die Mitarbeiter mit der Id = id die Form (http://localhost:8081/api/id?id=1) wegen RequestParam
    @GetMapping("/id")
    public Mitarbeiter getMitarbeiterByIdWithRequest(@RequestParam Long id)
    {
        return mitarbeiterService.getMitarbeiterById(id);
    }

    @GetMapping("/vorname")
    public Mitarbeiter getMitarbeiterByVorname(@RequestParam String vorname)
    {
        return mitarbeiterService.getMitarbeiterVorname(vorname);
    }


    @GetMapping("/vorname/{vorname}")
    public Mitarbeiter getMitarbeiterByVornameWithPath(@PathVariable String vorname)
    {
        return mitarbeiterService.getMitarbeiterVorname(vorname);
    }

    @GetMapping("/nachname")
    public Mitarbeiter getMitarbeiterByNachname(@RequestParam String nachname)
    {
        return mitarbeiterService.getMitarbeiterNachname(nachname);
    }

    @GetMapping("/nachname/{nachname}")
    public Mitarbeiter getMitarbeiterByNachnameWithPath(@PathVariable String nachname)
    {
        return mitarbeiterService.getMitarbeiterNachname(nachname);
    }

    @GetMapping("/sucheMitarbeiter")
    public List<Mitarbeiter> sucheMitarbeiter(@RequestParam(required = false) String vorname, @RequestParam(required = false) String nachname){
        return mitarbeiterService.sucheMitarbeiter(vorname, nachname);
    }


    @PostMapping("/neuMitarbeiter")
    public String addMitarbeiterToDb(@RequestBody  Mitarbeiter neuMitarbeiter)
    {
        mitarbeiterService.addMitarbeiter(neuMitarbeiter);
        return "Mitarbeiter wurde erfolgreich hinzugefügt";
    }

    @PutMapping("/updateMitarbeiter")
    public String updateMitarbeiter(@RequestBody  Mitarbeiter neuMitarbeiter)
    {
        mitarbeiterService.updateMitarbeiter(neuMitarbeiter);
        return "Mitarbeiter wurde erfolgreich geändert";
    }

    @DeleteMapping("/deleteMitarbeiter")
    public String  deleteMitarbeiter(long id)
    {
        mitarbeiterService.deleteMitarbeiter(id);
        return "Mitarbeiter mit der Id : "+ id + " wurde erfolgreich gelöscht";
    }






}
