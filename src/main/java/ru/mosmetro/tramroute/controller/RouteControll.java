package ru.mosmetro.tramroute.controller;

import org.springframework.web.bind.annotation.*;
import ru.mosmetro.tramroute.entity.Route;
import ru.mosmetro.tramroute.service.RouteService;

import java.util.List;

@RestController
public class RouteControll {

    private final RouteService service;

    public RouteControll(RouteService service) {
        this.service = service;
    }

    @GetMapping("/trams")
    public List<Route> findAllProducts() {
        return service.getRoutes();
    }

    @GetMapping("/trams/{id}")
    public Route findRouteById(@PathVariable int id) {
        return service.getRouteById(id);
    }

    @PostMapping("/trams")
    public Route addProduct(@RequestBody Route route) {
        return service.saveRoute(route);
    }

    @PostMapping("/addTrams")
    public List<Route> addProducts(@RequestBody List<Route> routes) {
        return service.saveRoutes(routes);
    }

    @DeleteMapping("/trams/{id}")
    public String deleteRoute(@PathVariable int id) {
        return service.deleteRoute(id);
    }

    @PutMapping("/trams/{id}")
    public Route updateRoute(@RequestBody Route route) {
        return service.updateRoute(route);
    }


}
