package com.uptc.frw.electronicDevices.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "CLIENTE")
public class Client {
    @Id
    @Column(name = "ID_CLIENTE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "client_seq")
    @SequenceGenerator(name = "client_seq",sequenceName = "CLIENTE_SEQ", allocationSize = 1)
    private Long id;
    @Column(name="DOCUMENTO")
    private String document;
    @Column(name="NOMBRE")
    private String name;
    @Column(name="DIRECCION")
    private String address;
    @Column(name="TELEFONO")
    private String phone;
    @Column(name="CORREO")
    private String mail;


    public Client() {
    }

    public Client(Long id, String document, String name, String address, String phone, String mail) {
        this.id = id;
        this.document = document;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.mail = mail;
    }

    public Client(String document, String name, String address, String phone, String mail) {
        this.document = document;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.mail = mail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }



    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", document='" + document + '\'' +
                ", name='" + name + '\'' +
                ", address=" + address +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
