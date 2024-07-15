package ru.Markin.RestService.controller;

import ru.Markin.RestService.model.Stuff;
import ru.Markin.RestService.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/stuff")
public class StuffController {
    @Autowired
    private Service service;

    @GetMapping("")
    public List<Stuff> getStuffs(){
        return service.getAllStuff();
    }

    @GetMapping("/{id}")
    public Stuff getStuff(@PathVariable("id") UUID id){
        return service.getStuffById(id);
    }
}
