package br.com.graphqlpoc.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "FILM")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Film {
    @Id
    @Column(name = "FILM_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer filmId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DATE_OF_LAUNCH")
    private Date dateOfLaunch;


}