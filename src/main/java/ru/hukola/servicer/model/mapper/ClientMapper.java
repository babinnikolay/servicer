package ru.hukola.servicer.model.mapper;

import ru.hukola.servicer.model.Client;
import ru.hukola.servicer.model.dto.ClientDto;

/**
 * @author Babin Nikolay
 */
public class ClientMapper {
    public static ClientDto toClientDto(Client client) {
        return ClientDto.builder()
                .id(client.getId())
                .name(client.getName()).build();
    }
}
