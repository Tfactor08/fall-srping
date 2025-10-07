package com.torvaldsinc.linus_hostings.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.torvaldsinc.linus_hostings.model.Server;
import com.torvaldsinc.linus_hostings.repository.ServerRepository;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class ServerService {
    ServerRepository serverRepo;

    public ServerService(ServerRepository serverRepo) {
        this.serverRepo = serverRepo;
    }

    public List<Server> getAll() {
        return serverRepo.findAll();
    }

    @Transactional
    public Server create(Server server) {
        return serverRepo.save(server);
    }
}
