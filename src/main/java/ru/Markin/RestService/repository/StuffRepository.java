package ru.Markin.RestService.repository;

import ru.Markin.RestService.model.Stuff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StuffRepository extends JpaRepository<Stuff, UUID> {
}
