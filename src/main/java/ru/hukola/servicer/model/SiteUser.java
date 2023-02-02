package ru.hukola.servicer.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

/**
 * @author Babin Nikolay
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SiteUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String username;
    private String password;
    private boolean active;
    @ElementCollection(targetClass = SiteRole.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "site_user_id"))
    @Enumerated(EnumType.STRING)
    private Set<SiteRole> roles;
}
