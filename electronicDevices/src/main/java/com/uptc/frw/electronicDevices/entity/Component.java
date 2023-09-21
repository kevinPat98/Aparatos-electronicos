package com.uptc.frw.electronicDevices.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "COMPONENTE")
public class Component {
    @Id
    @Column(name = "ID_COMPONENTE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "component_seq")
    @SequenceGenerator(name = "component_seq",sequenceName = "COMPONENTE_SEQ", allocationSize = 1)
    private Long id;
    @Column(name="ID_FABRICANTE",insertable = false,updatable = false)
    private Long makerId;
    @Column(name="NOMBRE")
    private String name;
    @Column(name="ESPECIFICACIONES")
    private String specifications;
    @OneToMany(mappedBy = "component")
    private List<DeviceComponent> deviceComponentList;
    @ManyToOne
    @JoinColumn(name = "ID_FABRICANTE")
    private Maker makers;

    public Component() {
    }

    public Component(Long id, Long makerId, String name, String specifications) {
        this.id = id;
        this.makerId = makerId;
        this.name = name;
        this.specifications = specifications;
    }

    public Component(Long makerId, String name, String specifications) {
        this.makerId = makerId;
        this.name = name;
        this.specifications = specifications;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMakerId() {
        return makerId;
    }

    public void setMakerId(Long makerId) {
        this.makerId = makerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public List<DeviceComponent> getDeviceComponentList() {
        return deviceComponentList;
    }

    public void setDeviceComponentList(List<DeviceComponent> deviceComponentList) {
        this.deviceComponentList = deviceComponentList;
    }

    public Maker getMakers() {
        return makers;
    }

    public void setMakers(Maker makers) {
        this.makers = makers;
    }

    @Override
    public String toString() {
        return "Component{" +
                "id=" + id +
                ", makerId=" + makerId +
                ", name='" + name + '\'' +
                ", specifications='" + specifications + '\'' +
                '}';
    }
}
