package com.example.films.repositories;

import com.example.films.models.Film;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface FilmRepository extends JpaRepository<Film, Long> {

@Query("select f from Film f join f.acteurs a join f.realisateurs r where " +
        "(:acteurs_id is null or a.id in :acteurs_id) and " +
        "(:realisateurs_id is null or r.id in :realisateurs_id)")
Page<Film> findAllByActeursInAndByRealisateursIn(@Param("acteurs_id") Collection<Long> acteurs_id,
                                                 @Param("realisateurs_id") Collection<Long> realisateurs_id,
                                                 Pageable pageable);


}
