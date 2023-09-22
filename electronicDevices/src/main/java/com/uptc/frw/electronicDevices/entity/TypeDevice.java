package com.uptc.frw.electronicDevices.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "TIPO")
public class TypeDevice {
    @Id
    @Column(name = "ID_TIPO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "tipo_seq")
    @SequenceGenerator(name = "tipo_seq",sequenceName = "TIPO_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "NOMBRE")
    private String name;
    @Column(name = "ID_SUPER_TIPO",insertable = false,updatable = false)
    private Long superTypeDevice;
    @Column(name = "CARACTERISTICA")
    private String characteristic;

    @OneToMany(mappedBy = "typeDevice")
    private List<TypeDevice> typeDevices;
    @ManyToOne
    @JoinColumn(name = "ID_SUPER_TIPO")
    private TypeDevice typeDevice;
    @OneToMany(mappedBy = "device")
    private List<Device> devices;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSuperTypeDevice() {
        return superTypeDevice;
    }

    public void setSuperTypeDevice(Long superTypeDevice) {
        this.superTypeDevice = superTypeDevice;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    public List<TypeDevice> getTypeDevices() {
        return typeDevices;
    }

    public void setTypeDevices(List<TypeDevice> typeDevices) {
        this.typeDevices = typeDevices;
    }

    public TypeDevice getTypeDevice() {
        return typeDevice;
    }

    public void setTypeDevice(TypeDevice typeDevice) {
        this.typeDevice = typeDevice;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    @Override
    public String toString() {
        return "TypeDevice{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", superTypeDevice=" + superTypeDevice +
                ", characteristic='" + characteristic + '\'' +
                '}';
    }
}
