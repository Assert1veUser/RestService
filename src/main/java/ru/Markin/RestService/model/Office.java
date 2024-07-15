package ru.Markin.RestService.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Restoffice")
public class Office {
    @Id
    @Column
    private UUID id;
    @Column(name = "address")
    private String address;
    @JsonProperty("law_address")
    @Column(name = "law_address")
    private String lawAddress;
    @JsonProperty("cabinets_count")
    @Column(name = "cabinets_count")
    private Integer cabinetsCount;

    public Office() {
    }

    public Office(UUID id, String addres, String lawAddress, Integer cabinetsCount) {
        this.id = id;
        this.address = addres;
        this.lawAddress = lawAddress;
        this.cabinetsCount = cabinetsCount;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLawAddress() {
        return lawAddress;
    }

    public void setLawAddress(String lawAddress) {
        this.lawAddress = lawAddress;
    }

    public Integer getCabinetsCount() {
        return cabinetsCount;
    }

    public void setCabinetsCount(Integer cabinetsCount) {
        this.cabinetsCount = cabinetsCount;
    }
    @Override
    public String toString() {
        return "Office{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", lawAddress='" + lawAddress + '\'' +
                ", cabinetsCounts=" + cabinetsCount +
                '}';
    }
}

