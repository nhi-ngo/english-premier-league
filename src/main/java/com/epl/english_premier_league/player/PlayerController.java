package com.epl.english_premier_league.player;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> getPlayers(
            @RequestParam(required = false) String team,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String position,
            @RequestParam(required = false) String nation
    ){
        if(team != null && position != null){
            return playerService.getPlayersByTeamAndPosition(team, position);
        }
        else if(team != null){
            return playerService.getPlayersFromTeam(team);
        }
        else if(position != null){
            return playerService.getPlayerByPos(position);
        }
        else if(name != null){
            return playerService.getPlayersByName(name);
        }
        else if(nation != null){
            return playerService.getPlayersByNation(nation);
        }
        else{
            return playerService.getPlayers();
        }
    }
}
