package com.uptc.frw.electronicDevices.entity.key;
import com.uptc.frw.electronicDevices.entity.Component;
import com.uptc.frw.electronicDevices.entity.Device;

import java.io.Serializable;

public class DeviceComponentPk implements Serializable{

    private Component component;
    private Device device;

    public DeviceComponentPk() {
    }

    public DeviceComponentPk(Component component, Device device) {
        this.component = component;
        this.device = device;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

}
