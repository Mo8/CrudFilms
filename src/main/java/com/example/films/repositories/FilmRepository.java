package com.example.films.repositories;

import com.example.films.models.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface FilmRepository extends JpaRepository<Film, Long> {

    @Query("select f from Film f where f.id in (select f.id from Film f join f.acteurs a where a.id in :acteurs_id) or f.id in (select f.id from Film f join f.realisateurs r where r.id in :realisateurs_id)")
    Page<Film> findAllByActeursIdInAndByRealisateursIdIn(Collection<Long> acteurs_id,Collection<Long> realisateurs_id, Pageable pageable);

    @Query("select f from Film f where f.id in (select f.id from Film f join f.acteurs a where a.id in :acteurs_id)")
    Page<Film> findAllByActeursIdIn(Collection<Long> acteurs_id, Pageable pageable);

    @Query("select f from Film f where f.id in (select f.id from Film f join f.realisateurs r where r.id in :realisateurs_id)")
    Page<Film> findAllByRealisateursIdIn(Collection<Long> realisateurs_id, Pageable pageable);
}
