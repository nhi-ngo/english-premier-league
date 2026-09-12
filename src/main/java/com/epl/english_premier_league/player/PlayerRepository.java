package com.epl.english_premier_league.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

    void deleteByName(String name);

    Optional<Player> findByName(String name);

    List<Player> findByNameContainingIgnoreCase(String name);

    List<Player> findByTeamIgnoreCase(String team);

    List<Player> findByPosIgnoreCase(String pos);

    List<Player> findByNationIgnoreCase(String nation);

    List<Player> findByTeamAndPos(String team, String pos);
}
