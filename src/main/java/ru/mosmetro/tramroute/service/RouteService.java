package ru.mosmetro.tramroute.service;


import org.springframework.stereotype.Service;
import ru.mosmetro.tramroute.entity.Route;
import ru.mosmetro.tramroute.repository.RoutetRepository;

import java.util.List;

@Service
public class RouteService {
   private final RoutetRepository repository;

    public RouteService(RoutetRepository repository) {
        this.repository = repository;
    }

    public Route saveRoute(Route route) {
        return repository.save(route);
    }

    public List<Route> saveRoutes(List<Route> routes) {
        return repository.saveAll(routes);
    }

    public List<Route> getRoutes() {
        return repository.findAll();
    }

    public Route getRouteById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Route getRouteByName(String name) {
        return repository.findByName(name);
    }

    public String deleteRoute(int id) {
        repository.deleteById(id);
        return "Route removed !! " + id;
    }

    public Route updateRoute(Route route) {
        Route existingRoute = repository.findById(route.getId()).orElse(null);
        existingRoute.setCode(route.getCode());
        existingRoute.setName(route.getName());
        return repository.save(existingRoute);
    }


}
