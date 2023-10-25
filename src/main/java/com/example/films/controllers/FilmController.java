package com.example.films.controllers;

import com.example.films.models.Film;
import com.example.films.repositories.FilmRepository;
import jakarta.annotation.Nullable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/films")
public class FilmController {

    private final FilmRepository filmRepository;

    public FilmController(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @GetMapping("")
    public Page<Film> getFilms(Pageable pageable, @Nullable @RequestParam(required = false) List<Long> acteursIds, @Nullable @RequestParam(required = false) List<Long> realisateursIds) {

        if (acteursIds != null && realisateursIds != null)
            return filmRepository.findAllByActeursIdInAndByRealisateursIdIn(acteursIds, realisateursIds, pageable);

        if (realisateursIds != null)
            return filmRepository.findAllByRealisateursIdIn(realisateursIds, pageable);

        if (acteursIds != null)
            return filmRepository.findAllByActeursIdIn(acteursIds, pageable);

        return filmRepository.findAll(pageable);
    }

    @PostMapping("")
    public Film createFilm(@RequestBody Film film) {
        return filmRepository.save(film);
    }
//
//    @GetMapping("/{id}")
//    public Film getFilm(@PathVariable Long id) {
//        return filmRepository.findById(id).orElseThrow();
//    }
//
//    @PutMapping("/{id}")
//    public Film updateFilm(@PathVariable Long id, @RequestBody Film film) {
//        Film filmToUpdate = filmRepository.findById(id).orElseThrow();
//        filmToUpdate.setNom(film.getNom());
//        filmToUpdate.setDescription(film.getDescription());
//        filmToUpdate.setDateParution(film.getDateParution());
//        return filmRepository.save(filmToUpdate);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteFilm(@PathVariable Long id) {
//        filmRepository.deleteById(id);
//    }
}
