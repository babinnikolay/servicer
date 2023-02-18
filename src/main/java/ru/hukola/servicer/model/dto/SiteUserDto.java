package ru.hukola.servicer.model.dto;

import lombok.*;
import ru.hukola.servicer.model.SiteRole;

import java.util.Set;

/**
 * @author Babin Nikolay
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SiteUserDto {
    private int id;
    private String username;
    private String password;
    private boolean active;
    private Set<SiteRole> roles;

}
