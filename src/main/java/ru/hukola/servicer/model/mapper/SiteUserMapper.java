package ru.hukola.servicer.model.mapper;

import ru.hukola.servicer.model.SiteUser;
import ru.hukola.servicer.model.dto.SiteUserDto;

/**
 * @author Babin Nikolay
 */
public class SiteUserMapper {
    public static SiteUserDto toSiteUserDto(SiteUser siteUser) {
        return SiteUserDto.builder()
                .id(siteUser.getId())
                .username(siteUser.getUsername())
                .active(siteUser.isActive())
                .roles(siteUser.getRoles())
                .build();
    }

    public static SiteUser toSiteUser(SiteUserDto userDto) {
        return SiteUser.builder()
                .username(userDto.getUsername())
                .active(userDto.isActive())
                .roles(userDto.getRoles())
                .password(userDto.getPassword())
                .build();
    }
}
