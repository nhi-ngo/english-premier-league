package com.epl.english_premier_league.player;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            return playerService.getPlayersByPos(position);
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

    @PostMapping
    public ResponseEntity<Player> addPlayer(@RequestBody Player player){
        Player createdPlayer = playerService.addPlayer(player);
        return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePlayer(@PathVariable Integer id){
            boolean isPlayerDeleted = playerService.deletePlayer(id);

            if (isPlayerDeleted) {
                return ResponseEntity.noContent().build(); // 204
            }

            return ResponseEntity.notFound().build(); // 404
    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(
            @PathVariable Integer id,
            @RequestBody Player updatedPlayer)
    {
        Player player = playerService.updatePlayer(id, updatedPlayer);

        if (player != null) {
            return new ResponseEntity<>(player, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
