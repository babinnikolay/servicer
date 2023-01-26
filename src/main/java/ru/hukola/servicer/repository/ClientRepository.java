package ru.hukola.servicer.repository;

import org.springframework.stereotype.Repository;
import ru.hukola.servicer.model.Client;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Babin Nikolay
 */
@Repository
public class ClientRepository {
    private final List<Client> clients = new ArrayList<>();

    {
        clients.add(new Client(1, "name1"));
        clients.add(new Client(2, "name3"));
    }

    public List<Client> findAll() {
        return clients;
    }

    public void save(Client client) {
        clients.add(client);
    }
}
