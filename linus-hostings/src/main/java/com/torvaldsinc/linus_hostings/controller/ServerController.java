package com.torvaldsinc.linus_hostings.controller;

import java.util.List;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.torvaldsinc.linus_hostings.model.*;
import com.torvaldsinc.linus_hostings.service.ServerService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/servers")
public class ServerController {
    private ServerService serverService;

    public ServerController(ServerService serverService) {
        this.serverService = serverService;
    }

    @GetMapping
    public List<Server> getServers() {
        return serverService.getAll();
    }

    @PostMapping
    public ResponseEntity<Server> createServer(@RequestBody @Valid Server server) {
        Server savedServer = serverService.create(server);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedServer);
    }
}
