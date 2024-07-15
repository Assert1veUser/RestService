package ru.Markin.RestService.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "Restoffer")
public class Offer {
    @Id
    @Column
    private UUID id;
    @JsonProperty("serial_number")
    @Column(name = "serial_numbers")
    private String serialNumber;
    @JsonProperty("sign_date")
    @Column(name = "sign_date")
    private LocalDate signDate;
    @JsonProperty("ending_date")
    @Column(name = "ending_date")
    private LocalDate endingDate;
    @JsonProperty("start_date")
    @Column(name = "start_date")
    private LocalDate startDate;
    @ManyToOne(targetEntity = Client.class, optional = false)
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToOne(targetEntity = Stuff.class, optional = false)
    @JoinColumn(name = "stuff_id")
    private Stuff stuff;
    @ManyToOne(targetEntity = Office.class, optional = false)
    @JoinColumn(name = "office_id")
    private Office office;

    public Offer(UUID id, String serielNumber, LocalDate signDate, LocalDate endingDate, LocalDate startDate, Client client, Stuff stuff, Office office) {
        this.id = id;
        this.serialNumber = serielNumber;
        this.signDate = signDate;
        this.endingDate = endingDate;
        this.startDate = startDate;
        this.client = client;
        this.stuff = stuff;
        this.office = office;
    }

    public Offer() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public LocalDate getSignDate() {
        return signDate;
    }

    public void setSignDate(LocalDate signDate) {
        this.signDate = signDate;
    }

    public LocalDate getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(LocalDate endingDate) {
        this.endingDate = endingDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Stuff getStuff() {
        return stuff;
    }

    public void setStuff(Stuff stuff) {
        this.stuff = stuff;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }
    @Override
    public String toString() {
        return "Offer{" +
                "id=" + id +
                ", serialNumber='" + serialNumber + '\'' +
                ", signDate=" + signDate +
                ", endingDate=" + endingDate +
                ", startDate=" + startDate +
                ", Restclient=" + client +
                ", office=" + office +
                ", RestService_stuff=" + stuff +
                '}';
    }
}
