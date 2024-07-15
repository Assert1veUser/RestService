package ru.Markin.RestService.controller;

import ru.Markin.RestService.TDO.NewOfferParameters;
import ru.Markin.RestService.TDO.OfferStatistic;
import ru.Markin.RestService.model.Offer;
import ru.Markin.RestService.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import java.util.UUID;

@RestController
@RequestMapping("/api/v1/offer")
public class OfferController {
    @Autowired
    private Service service;

    @GetMapping("")
    public List<Offer> getAllclients(){
        return service.getAllOffer();
    }

    @GetMapping("/{id}")
    public Offer getOfferById(@PathVariable("id") UUID id){
        return service.getOfferById(id);
    }
    @GetMapping("/statistic")
    private OfferStatistic getStatistic(){
        return service.getStatistic();
    }
    @PutMapping("")
    private Offer signNewOffer(@RequestBody NewOfferParameters offerParameters){
        return service.signNewOffer(offerParameters);
    }
}


