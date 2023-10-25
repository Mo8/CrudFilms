package com.example.films.controllers;

import com.example.films.models.Acteur;
import com.example.films.models.Personne;
import com.example.films.models.Realisateur;
import com.example.films.repositories.ActeurRepository;
import com.example.films.repositories.PersonneRepository;
import com.example.films.repositories.RealisateurRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/realisateurs")
public class RealisateurController {

    private final RealisateurRepository realisateurRepository;
    private final ActeurRepository acteurRepository;

    private final PersonneRepository personneRepository;

    public RealisateurController(RealisateurRepository realisateurRepository, ActeurRepository acteurRepository, PersonneRepository personneRepository) {
        this.realisateurRepository = realisateurRepository;
        this.acteurRepository = acteurRepository;
        this.personneRepository = personneRepository;
    }

    @GetMapping("/{id}/addAsActeur")
    public Acteur addActeur(@PathVariable Long id)
    {
        Personne p = personneRepository.findById(id).orElseThrow();
        Acteur acteur = new Acteur();
        acteur.setPersonne(p);
        return acteurRepository.save(acteur);
    }
    @GetMapping("")
    public Page<Realisateur> getRealisateurs(Pageable pageable) {
        return realisateurRepository.findAll(pageable);
    }

    @PostMapping("")
    public Realisateur createRealisateur(@RequestBody Personne personne) {
        personneRepository.save(personne);
        Realisateur realisateur = new Realisateur();
        realisateur.setPersonne(personne);
        return realisateurRepository.save(realisateur);
    }

//    @PostMapping("/{id}")
//    public Realisateur createRealisateurFromId(@PathVariable Long id, @RequestBody(required = false) Realisateur realisateur) {
//
//        if (!personneRepository.existsById(id)) {
//            throw new RuntimeException("Personne not found");
//        }
//        Personne p = personneRepository.getReferenceById(id);
//        if(realisateur == null) {
//            realisateur = new Realisateur();
//        }
//        realisateur.setPersonne(p);
//
//        return realisateurRepository.save(realisateur);
//    }

//    @GetMapping("/{id}")
//    public Realisateur getRealisateur(@PathVariable Long id) {
//        return realisateurRepository.findById(id).orElseThrow();
//    }
//
//    @PutMapping("/{id}")
//    public Realisateur updateRealisateur(@PathVariable Long id, @RequestBody Realisateur realisateur) {
//        Realisateur realisateurToUpdate = realisateurRepository.findById(id).orElseThrow();
//        realisateurToUpdate.setPersonne(realisateur.getPersonne());
//        return realisateurRepository.save(realisateurToUpdate);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteRealisateur(@PathVariable Long id) {
//        realisateurRepository.deleteById(id);
//    }

}
