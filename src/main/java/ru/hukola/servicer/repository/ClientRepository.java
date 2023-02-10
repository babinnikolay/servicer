package ru.hukola.servicer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.hukola.servicer.model.Client;

import java.util.List;

/**
 * @author Babin Nikolay
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
