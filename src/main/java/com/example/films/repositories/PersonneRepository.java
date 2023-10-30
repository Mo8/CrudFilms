package com.example.films.repositories;

import com.example.films.models.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PersonneRepository extends JpaRepository<Personne, Long>{


}
