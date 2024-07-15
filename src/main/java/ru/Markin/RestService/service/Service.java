package ru.Markin.RestService.service;

import ru.Markin.RestService.TDO.NewOfferParameters;
import ru.Markin.RestService.TDO.OfferStatistic;
import org.springframework.beans.factory.annotation.Autowired;
import ru.Markin.RestService.model.*;
import ru.Markin.RestService.repository.*;

import java.time.LocalDate;
import java.util.*;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private OfficeRepository officeRepository;
    @Autowired
    private PositionRepository positionRepository;
    @Autowired
    private StuffRepository stuffRepository;
    @Autowired
    private OfferRepository offerRepository;
    public List<Client> getAllClient(){
        return (List<Client>) clientRepository.findAll();
    }
    public Client getClientById(UUID id){
        return clientRepository.findById(id).get();
    }
    public List<Office> getAllOffice(){
        return (List<Office>) officeRepository.findAll();
    }
    public Office getOfficeById(UUID id){
        return officeRepository.findById(id).get();
    }
    public List<Position> getAllPosition(){
        return (List<Position>) positionRepository.findAll();
    }
    public Position getPositionById(UUID id){
        return positionRepository.findById(id).get();
    }
    public List<Stuff> getAllStuff(){
        return (List<Stuff>) stuffRepository.findAll();
    }
    public Stuff getStuffById(UUID id){
        return stuffRepository.findById(id).get();
    }
    public List<Offer> getAllOffer(){
        return (List<Offer>) offerRepository.findAll();
    }
    public Offer getOfferById(UUID id){
        return offerRepository.findById(id).get();
    }

    public Offer signNewOffer(NewOfferParameters offerParameters) {
        return new Offer(UUID.randomUUID(),
                "dfghjnj",
                LocalDate.now(),
                offerParameters.getEndingDate(),
                offerParameters.getStartDate(),
                getClientById(offerParameters.getClientId()),
                getStuffById(offerParameters.getStuffId()),
                getOfficeById(UUID.fromString("00000000-0000-0000-0000-00000000000e")));
    }
    public OfferStatistic getStatistic(){
        Map<String,Integer> stuffStatistic = new HashMap();
        Map<String,Integer> clientStatistic = new HashMap();
        Set<String> clientSurnames = new HashSet();
        for (Stuff stuff: getAllStuff()){
            String fullName = stuff.getName()+ " " +stuff.getSurname()+ " " +stuff.getPatronymic();
            if(!stuffStatistic.containsKey(fullName))
                stuffStatistic.put(fullName, 1);
            else
                stuffStatistic.put(fullName, stuffStatistic.get(fullName)+1);
        }
        for (Client client: getAllClient()){
            String fullName = client.getName()+ " " +client.getSurname()+ " " +client.getPatronymic();
            if(!clientSurnames.equals(client.getSurname()))
                clientSurnames.add(client.getSurname());

            if(!clientStatistic.containsKey(fullName))
                clientStatistic.put(fullName, 1);
            else
                clientStatistic.put(fullName, clientStatistic.get(fullName)+1);
        }
        return new OfferStatistic(stuffStatistic,clientStatistic,clientSurnames);
    }
}
