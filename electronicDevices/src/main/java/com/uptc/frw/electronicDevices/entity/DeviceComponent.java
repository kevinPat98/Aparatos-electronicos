package com.uptc.frw.electronicDevices.entity;

import com.uptc.frw.electronicDevices.entity.key.DeviceComponentPk;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "REGISTRO_UNIDADES")
@IdClass(DeviceComponentPk.class)
public class DeviceComponent {
    @Id
    @ManyToOne
    @JoinColumn(name = "ID_COMPONENTE")
    private Component component;
    @Id
    @ManyToOne
    @JoinColumn(name = "ID_APARATO")
    private Device device;

    @Column(name = "UNIDADES")
    private Integer units;

    public DeviceComponent() {
    }

    public DeviceComponent(Component component, Device device, Integer units) {
        this.component = component;
        this.device = device;
        this.units = units;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public Device getDevices() {
        return device;
    }

    public void setDevices(Device devices) {
        this.device = devices;
    }

    public Integer getUnits() {
        return units;
    }

    public void setUnits(Integer units) {
        this.units = units;
    }

    @Override
    public String toString() {
        return "DeviceComponent{" +
                "units=" + units +
                '}';
    }
}
