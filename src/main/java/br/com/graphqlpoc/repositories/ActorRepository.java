package br.com.graphqlpoc.repositories;


import br.com.graphqlpoc.models.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Integer> {

    public Actor findActorByFirstNameLike(String name);
}