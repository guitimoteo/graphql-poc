package br.com.graphqlpoc.repositories;

import br.com.graphqlpoc.models.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film,Integer> {
}