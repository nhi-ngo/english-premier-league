package com.epl.english_premier_league.player;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers(){
        return playerRepository.findAll();
    }

    public List<Player> getPlayersByName(String searchText){
        return playerRepository.findByNameContainingIgnoreCase(searchText);
    }

    public List<Player> getPlayersFromTeam(String teamName){
        return playerRepository.findByTeamIgnoreCase(teamName);
    }

    public List<Player> getPlayerByPos(String searchText){
        return playerRepository.findByPosIgnoreCase(searchText);
    }

    public List<Player> getPlayersByNation(String searchText){
        return playerRepository.findByNationIgnoreCase(searchText);
    }

    public List<Player> getPlayersByTeamAndPosition(String team, String position){
        return playerRepository.findByTeamAndPos(team, position);
    }

}
