package com.harsha.demo.controller;

import com.harsha.demo.model.Player;
import com.harsha.demo.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    public ResponseEntity<Player> createPlayer(@RequestParam Long teamId, @RequestBody Player player) {
        return ResponseEntity.status(HttpStatus.CREATED).body(playerService.createPlayer(teamId, player));
    }

    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers() {
        return ResponseEntity.ok(playerService.getAllPlayers());
    }

    @GetMapping("/{playerId}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Long playerId) {
        return ResponseEntity.ok(playerService.getPlayerById(playerId));
    }

    @PutMapping("/{playerId}")
    public ResponseEntity<Player> updatePlayer(@PathVariable Long playerId, @RequestBody Player player) {
        return ResponseEntity.ok(playerService.updatePlayer(playerId, player));
    }

    @DeleteMapping("/{playerId}")
    public ResponseEntity<Player> deletePlayer(@PathVariable Long playerId) {
        playerService.deletePlayer(playerId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("team")
    public ResponseEntity<List<Player>> getPlayersByTeam(@RequestParam String teamName) {
        return ResponseEntity.ok(playerService.getPlayersByTeam(teamName));
    }
}
