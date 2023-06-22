package ru.mosmetro.tramroute.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mosmetro.tramroute.entity.Route;

public interface RoutetRepository extends JpaRepository<Route,Integer> {
    Route findByName(String name);
}