package ru.hukola.servicer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.hukola.servicer.model.Client;
import ru.hukola.servicer.model.dto.ClientDto;
import ru.hukola.servicer.model.mapper.ClientMapper;
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

    public List<ClientDto> findAll() {
        return clientRepository.findAll().stream().map(ClientMapper::toClientDto).toList();
    }

    public void save(Client client) {
        clientRepository.save(client);
    }
}
