package ru.mosmetro.tramroute.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.mosmetro.tramroute.entity.Route;
import ru.mosmetro.tramroute.service.RouteService;

import java.util.List;

@Tag(name="Маршрут",description = "API для получения/сохранения всех трамвайных маршрутов")
@RestController
@RequestMapping
@RequiredArgsConstructor
public class RouteController {

    private final RouteService service;

    @GetMapping(value = "/trams")
    public List<Route> findAllProducts() {
        return service.getRoutes();
    }

    @GetMapping(value ="/trams/{id}")
    public Route findRouteById(@PathVariable int id) {
        return service.getRouteById(id);
    }

    @PostMapping(value ="/trams")
    public Route addProduct(@RequestBody Route route) {
        return service.saveRoute(route);
    }

    @PostMapping(value ="/addTrams")
    public List<Route> addProducts(@RequestBody List<Route> routes) {
        return service.saveRoutes(routes);
    }

    @DeleteMapping(value ="/trams/{id}")
    public String deleteRoute(@PathVariable int id) {
        return service.deleteRoute(id);
    }

    @PutMapping(value ="/trams/{id}")
    public Route updateRoute(@RequestBody Route route) {
        return service.updateRoute(route);
    }


}
