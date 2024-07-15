package ru.Markin.RestService.controller;

import ru.Markin.RestService.model.Office;
import ru.Markin.RestService.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/office")
public class OfficeController {
    @Autowired
    private Service service;

    @GetMapping("")
    public List<Office> getOffice() {
        return service.getAllOffice();
    }

    @GetMapping("/{id}")
    public Office getOfficeById(@PathVariable("id") UUID id) {
        return service.getOfficeById(id);
    }
}
