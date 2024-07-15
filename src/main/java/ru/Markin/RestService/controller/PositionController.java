package ru.Markin.RestService.controller;

import ru.Markin.RestService.model.Position;
import ru.Markin.RestService.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/position")
public class PositionController {
    @Autowired
    private Service service;

    @GetMapping("")
    public List<Position> getPositions(){
        return service.getAllPosition();
    }

    @GetMapping("/{id}")
    public Position getPosition(@PathVariable("id") UUID id) {
        return service.getPositionById(id);
    }
}
