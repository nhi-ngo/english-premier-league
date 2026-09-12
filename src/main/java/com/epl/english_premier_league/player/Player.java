package com.epl.english_premier_league.player;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "player_stats")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String name;

    @NotBlank
    private String nation;

    @NotBlank
    private String pos;

    @NotNull
    private Integer age;

    @NotBlank
    private String team;

    private Integer mp;

    private Integer starts;

    private Double min;

    private Double gls;

    private Double ast;

    private Double pk;

    private Double crdy;

    private Double crdr;

    private Double xg;

    private Double xag;

}
