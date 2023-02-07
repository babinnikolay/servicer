package ru.hukola.servicer.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.hukola.servicer.exception.NotFoundException;
import ru.hukola.servicer.model.SiteUser;
import ru.hukola.servicer.model.dto.SiteUserDto;
import ru.hukola.servicer.model.mapper.SiteUserMapper;
import ru.hukola.servicer.repository.SiteUserRepository;

import java.util.List;

/**
 * @author Babin Nikolay
 */
@Service
@AllArgsConstructor
public class SiteUserService {
    private final SiteUserRepository siteUserRepository;

    private final PasswordEncoder passwordEncoder;

    public List<SiteUserDto> findAll() {
        return siteUserRepository.findAll().stream().map(SiteUserMapper::toSiteUserDto).toList();
    }

    public void save(SiteUserDto userDto) {
        SiteUser siteUser = SiteUserMapper.toSiteUser(userDto);
        siteUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
        siteUserRepository.save(siteUser);
    }

    public SiteUserDto findById(int id) throws NotFoundException {
        SiteUser siteUser = siteUserRepository.findById(id).orElseThrow(() ->
                new NotFoundException(String.format("User with id=%s not found")));
        return SiteUserMapper.toSiteUserDto(siteUser);
    }

    public void update(int id, SiteUserDto siteUser) throws NotFoundException {
        SiteUser siteUserDb = siteUserRepository.findById(id).orElseThrow(() ->
                new NotFoundException(String.format("User with id=%s not found")));
        siteUserDb.setActive(siteUser.isActive());
        siteUserDb.setPassword(siteUserDb.getPassword());
        siteUserDb.setRoles(siteUser.getRoles());
        siteUserDb.setUsername(siteUser.getUsername());
        siteUserRepository.save(siteUserDb);
    }
}
