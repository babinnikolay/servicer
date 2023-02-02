package ru.hukola.servicer.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.hukola.servicer.model.SiteUser;
import ru.hukola.servicer.model.SiteUserDetails;
import ru.hukola.servicer.repository.SiteUserRepository;

/**
 * @author Babin Nikolay
 */
@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final SiteUserRepository siteUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SiteUser user = siteUserRepository.findSiteUserByUsername(username);
        return new SiteUserDetails(user);
    }
}
