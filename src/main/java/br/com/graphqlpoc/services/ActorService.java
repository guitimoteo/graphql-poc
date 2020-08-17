package br.com.graphqlpoc.services;

import br.com.graphqlpoc.models.Actor;
import br.com.graphqlpoc.models.Film;
import br.com.graphqlpoc.repositories.ActorRepository;
import br.com.graphqlpoc.repositories.FilmRepository;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActorService implements GraphQLQueryResolver {
    private final ActorRepository actorRepository;
    private final FilmRepository filmRepository;
    public Actor getActorById(Integer id) {
        return actorRepository.findById(id).orElse(new Actor(null, "Ator nao encontrado", null, null, null, null));
    }
    public List<Actor> getAllActors(){
        return actorRepository.findAll();
    }

    public List<Film> getAllFilms(){
        return filmRepository.findAll();
    }
}