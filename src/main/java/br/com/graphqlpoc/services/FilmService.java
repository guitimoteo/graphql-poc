package br.com.graphqlpoc.services;

import br.com.graphqlpoc.models.Actor;
import br.com.graphqlpoc.models.Film;
import br.com.graphqlpoc.repositories.FilmRepository;
import com.coxautodev.graphql.tools.GraphQLResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FilmService implements GraphQLResolver<Actor> {
    private final FilmRepository repository;

    public Film getFilm(Actor actor){
        return repository.findById(actor.getFilmId()).
                orElse(new Film(null, "No movie found", null));
    }
}