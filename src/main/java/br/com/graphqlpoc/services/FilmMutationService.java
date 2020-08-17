package br.com.graphqlpoc.services;

import br.com.graphqlpoc.models.Film;
import br.com.graphqlpoc.repositories.FilmRepository;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLSubscriptionResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.FluxSink;

import javax.transaction.Transactional;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class FilmMutationService implements GraphQLMutationResolver, GraphQLSubscriptionResolver {
    private final FilmRepository repository;
    private ConcurrentHashMap<Integer, FluxSink<Film>> subscribers = new ConcurrentHashMap<>();
    @Transactional
    public Film updateFilmName(Integer id,String name) {
        Film film = repository.getOne(id);
        film.setName(name);
        repository.save(film);
        if (subscribers.get(id) != null)
            subscribers.get(id).next(film);
        return film;
    }

}