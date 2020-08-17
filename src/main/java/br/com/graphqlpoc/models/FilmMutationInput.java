package br.com.graphqlpoc.models;

import graphql.schema.GraphQLInputType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmMutationInput implements GraphQLInputType {
    private String filmName;
    private Integer id;
    @Override
    public String getName() {
        return "filmMutationInput";
    }
}