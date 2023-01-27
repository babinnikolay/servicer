package ru.hukola.servicer.repository;

import org.springframework.stereotype.Repository;
import ru.hukola.servicer.model.Client;

import java.util.*;

/**
 * @author Babin Nikolay
 */
@Repository
public class ClientRepository {
    private final Map<Integer, Client> clients = new HashMap<>();
    private int nextId = 1;

    {
        clients.put(1, new Client(nextId++, "name1"));
        clients.put(2, new Client(nextId++, "name3"));
    }

    public List<Client> findAll() {
        return clients.values().stream().toList();
    }

    public void save(Client client) {
        clients.put(nextId++, client);
    }

    public Client findById(int id) {
        return clients.get(id);
    }
}
