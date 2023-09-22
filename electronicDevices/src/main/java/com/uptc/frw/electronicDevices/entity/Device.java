package com.uptc.frw.electronicDevices.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "APARATO")
public class Device {
    @Id
    @Column(name = "ID_APARATO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "device_seq")
    @SequenceGenerator(name = "device_seq",sequenceName = "APARATO_SEQ", allocationSize = 1)
    private Long id;
    @Column(name = "ID_TIPO",insertable = false,updatable = false)
    private Long typeId;
    @Column(name="CODIGO")
    private Long code;
    @Column(name="NOMBRE")
    private String name;
    @Column(name="DESCRIPCION")
    private String decription;
    @OneToMany(mappedBy = "device")
    private List<Repair> reparations;
    @ManyToOne
    @JoinColumn(name = "ID_TIPO")
    private TypeDevice device;
    @OneToMany(mappedBy = "device")
    private List<DeviceComponent> deviceComponentList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public List<Repair> getReparations() {
        return reparations;
    }

    public void setReparations(List<Repair> reparations) {
        this.reparations = reparations;
    }

    public TypeDevice getDevice() {
        return device;
    }

    public void setDevice(TypeDevice device) {
        this.device = device;
    }

    public List<DeviceComponent> getDeviceComponentList() {
        return deviceComponentList;
    }

    public void setDeviceComponentList(List<DeviceComponent> deviceComponentList) {
        this.deviceComponentList = deviceComponentList;
    }

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", typeId=" + typeId +
                ", code=" + code +
                ", name='" + name + '\'' +
                ", decription='" + decription + '\'' +
                '}';
    }
}
