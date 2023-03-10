package ru.hukola.servicer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author Babin Nikolay
 */
@AllArgsConstructor
public class SiteUserDetails implements UserDetails {
    @Getter
    private final SiteUser siteUser;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return siteUser.getRoles()
                .stream()
                .map(r -> new SimpleGrantedAuthority(r.name())).toList();
    }

    @Override
    public String getPassword() {
        return siteUser.getPassword();
    }

    @Override
    public String getUsername() {
        return siteUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
