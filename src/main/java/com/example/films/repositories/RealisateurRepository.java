package com.example.films.repositories;

import com.example.films.models.Realisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RealisateurRepository extends JpaRepository<Realisateur, Long> {
}
