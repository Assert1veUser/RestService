package ru.Markin.RestService.controller;

import ru.Markin.RestService.model.Client;
import ru.Markin.RestService.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController {
    @Autowired
    private Service service;

    @GetMapping("")
    public List<Client> getAllclients(){
        return service.getAllClient();
    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable("id") UUID id){
        return service.getClientById(id);
    }
}
