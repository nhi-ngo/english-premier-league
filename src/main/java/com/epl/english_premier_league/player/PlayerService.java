package com.epl.english_premier_league.player;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<Player> getPlayersByPos(String searchText){
        return playerRepository.findByPosIgnoreCase(searchText);
    }

    public List<Player> getPlayersByNation(String searchText){
        return playerRepository.findByNationIgnoreCase(searchText);
    }

    public List<Player> getPlayersByTeamAndPosition(String team, String position){
        return playerRepository.findByTeamAndPos(team, position);
    }

    public boolean deletePlayer(Integer id){
        if(!playerRepository.existsById(id)){
            return false;
        }
        playerRepository.deleteById(id);
        return true;
    }

    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }
}
