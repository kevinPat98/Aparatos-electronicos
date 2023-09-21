package com.uptc.frw.electronicDevices.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "FABRICANTE")
public class Maker {
    @Id
    @Column(name = "ID_FABRICANTE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "maker_seq")
    @SequenceGenerator(name = "maker_seq",sequenceName = "FABRICANTE_SEQ", allocationSize = 1)
    private Long id;
    @Column(name="RIF")
    private Double rif;
    @Column(name="NOMBRE")
    private String name;
    @Column(name="DOMICILIO")
    private String address;
    @OneToMany(mappedBy = "makers")
    private List<Component> componentList;

    public Maker() {
    }

    public Maker(Long id, Double rif, String name, String address) {
        this.id = id;
        this.rif = rif;
        this.name = name;
        this.address = address;
    }

    public Maker(Double rif, String name, String address) {
        this.rif = rif;
        this.name = name;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getRif() {
        return rif;
    }

    public void setRif(Double rif) {
        this.rif = rif;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Component> getComponentList() {
        return componentList;
    }

    public void setComponentList(List<Component> componentList) {
        this.componentList = componentList;
    }


    @Override
    public String toString() {
        return "Maker{" +
                "id=" + id +
                ", rif=" + rif +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
