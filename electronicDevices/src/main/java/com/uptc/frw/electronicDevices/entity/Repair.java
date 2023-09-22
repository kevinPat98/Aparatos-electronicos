package com.uptc.frw.electronicDevices.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "REPARACION")
public class Repair {
    @Id
    @Column(name = "ID_REPARACION")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "reparation_seq")
    @SequenceGenerator(name = "reparation_seq",sequenceName = "REPARACION_SEQ", allocationSize = 1)
    private Long id;
    @Column(name="REFERENCIA")
    private String refence;
    @Column(name="DESCRIPCION")
    private String description;
    @Column(name="FECHA_REPARACION")
    private Date dateRepair;
    @Column(name = "ID_CLIENTE",insertable = false,updatable = false)
    private Long customerId;
    @Column(name = "ID_APARATO",insertable = false,updatable = false)
    private Long deviceId;
    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "ID_APARATO")
    private Device device;

    public Repair() {
    }

    public Repair(Long id, String refence, String description, Date dateRepair, Long customerId, Long deviceId) {
        this.id = id;
        this.refence = refence;
        this.description = description;
        this.dateRepair = dateRepair;
        this.customerId = customerId;
        this.deviceId = deviceId;
    }

    public Repair(String refence, String description, Date dateRepair, Long customerId, Long deviceId) {
        this.refence = refence;
        this.description = description;
        this.dateRepair = dateRepair;
        this.customerId = customerId;
        this.deviceId = deviceId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRefence() {
        return refence;
    }

    public void setRefence(String refence) {
        this.refence = refence;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateRepair() {
        return dateRepair;
    }

    public void setDateRepair(Date dateRepair) {
        this.dateRepair = dateRepair;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Long deviceId) {
        this.deviceId = deviceId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    @Override
    public String toString() {
        return "Repair{" +
                "id=" + id +
                ", refence='" + refence + '\'' +
                ", description='" + description + '\'' +
                ", dateRepair=" + dateRepair +
                ", customerId=" + customerId +
                ", deviceId=" + deviceId +
                '}';
    }
}
