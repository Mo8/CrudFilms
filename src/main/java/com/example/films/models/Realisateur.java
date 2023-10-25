package com.example.films.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "realisateur")
public class Realisateur  {

    @ManyToMany
    private List<Film> films;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personne_id")
    private Personne personne;

    @Id @Column(name = "personne_id")
    private Long id;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }
}
