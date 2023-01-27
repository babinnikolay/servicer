package ru.hukola.servicer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hukola.servicer.model.Client;
import ru.hukola.servicer.repository.ClientRepository;

import java.util.List;
import java.util.Set;

/**
 * @author Babin Nikolay
 */
@Service
@AllArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public void save(Client client) {
        clientRepository.save(client);
    }
}
