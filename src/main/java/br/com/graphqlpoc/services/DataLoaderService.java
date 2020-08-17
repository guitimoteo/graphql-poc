package br.com.graphqlpoc.services;

import br.com.graphqlpoc.models.Actor;
import br.com.graphqlpoc.models.Film;
import br.com.graphqlpoc.repositories.ActorRepository;
import br.com.graphqlpoc.repositories.FilmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class DataLoaderService {

    private final FilmRepository filmRepository;

    private final ActorRepository actorRepository;

    @PostConstruct
    public void loadData(){
        String [] actors = {"Autor A","Autor B","Autor C","Autor D"};
        Map<String,String> films = new HashMap<String, String>(){
            {
                put("Autor A","Filme A");
                put("Autor B","Filme B");
                put("Autor C","Filme C");
                put("Autor D","Filme D");
            }
        };
        for (String actorName :actors){
            String [] names = actorName.split(" ");

            Date dateOfBirth = DataLoaderService.between(new Date(1960,01,01),new Date(1980,01,01));
            Date dateOfLaunch = DataLoaderService.between(new Date(1990,01,01),new Date(2000,01,01));
            Film film = new Film(null, films.get(actorName),dateOfLaunch);
            filmRepository.save(film);
            Actor actor = new Actor(null, names[0],names[1],dateOfBirth,"Teste Cidade",film.getFilmId());
            actorRepository.save(actor);

        }


    }

    public static Date between(Date startInclusive, Date endExclusive) {
        long startMillis = startInclusive.getTime();
        long endMillis = endExclusive.getTime();
        long randomMillisSinceEpoch = ThreadLocalRandom
                .current()
                .nextLong(startMillis, endMillis);

        return new Date(randomMillisSinceEpoch);
    }
}