package ru.Markin.RestService.repository;

import ru.Markin.RestService.model.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OfficeRepository extends JpaRepository <Office, UUID>{
}
