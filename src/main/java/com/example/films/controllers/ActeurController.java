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
@RequestMapping("/acteurs")
public class ActeurController {

    private final ActeurRepository acteurRepository;
    private final RealisateurRepository realisateurRepository;

    private final PersonneRepository personneRepository;


    public ActeurController(ActeurRepository acteurRepository, RealisateurRepository realisateurRepository, PersonneRepository personneRepository) {
        this.acteurRepository = acteurRepository;
        this.realisateurRepository = realisateurRepository;
        this.personneRepository = personneRepository;
    }

    @GetMapping("/{id}/addAsRealisateur")
    public Realisateur addRealisateur(@PathVariable Long id) {
        Personne p = personneRepository.findById(id).orElseThrow();
        Realisateur realisateur = new Realisateur();
        realisateur.setPersonne(p);
        return realisateurRepository.save(realisateur);
    }

    @GetMapping("")
    public Page<Acteur> getActeurs(Pageable pageable) {
        return acteurRepository.findAll(pageable);
    }

    @PostMapping("")
    public Acteur createActeur(@RequestBody Personne personne){
        personneRepository.save(personne);
        Acteur acteur = new Acteur();
        acteur.setPersonne(personne);
        return acteurRepository.save(acteur);
    }

//    @PostMapping("/{id}")
//    public Acteur createActeurFromId(@PathVariable Long id, @RequestBody(required = false) Acteur acteur) {
//        if (!personneRepository.existsById(id)) {
//            throw new RuntimeException("Personne not found");
//        }
//        Personne p = personneRepository.getReferenceById(id);
//        if(acteur == null) {
//            acteur = new Acteur();
//        }
//        acteur.setPersonne(p);
//
//        return acteurRepository.save(acteur);
//    }

//    @GetMapping("/{id}")
//    public Acteur getActeur(@PathVariable Long id) {
//        return acteurRepository.findById(id).orElseThrow();
//    }
//
//    @PutMapping("/{id}")
//    public Acteur updateActeur(@PathVariable Long id, @RequestBody Acteur acteur) {
//        Acteur acteurToUpdate = acteurRepository.findById(id).orElseThrow();
//        acteurToUpdate.setPersonne(acteur.getPersonne());
//        return acteurRepository.save(acteurToUpdate);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteActeur(@PathVariable Long id) {
//        acteurRepository.deleteById(id);
//    }
}
