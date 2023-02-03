package ru.hukola.servicer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
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

    public List<SiteUserDto> findAll() {
        return siteUserRepository.findAll().stream().map(SiteUserMapper::toSiteUserDto).toList();
    }

    public void save(SiteUserDto userDto) {
        SiteUser siteUser = SiteUserMapper.toSiteUser(userDto);
        siteUserRepository.save(siteUser);
    }
}
