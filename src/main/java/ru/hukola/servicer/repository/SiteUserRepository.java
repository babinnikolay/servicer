package ru.hukola.servicer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hukola.servicer.model.SiteUser;

/**
 * @author Babin Nikolay
 */
public interface SiteUserRepository extends JpaRepository<SiteUser, Integer> {
    SiteUser findSiteUserByUsername(String name);
}
