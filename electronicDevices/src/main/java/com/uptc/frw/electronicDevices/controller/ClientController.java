package com.uptc.frw.electronicDevices.controller;

import com.uptc.frw.electronicDevices.entity.Client;
import com.uptc.frw.electronicDevices.services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ClientController {

    @Autowired
    private ClientServices clientServices;

    @QueryMapping
    public List<Client> getClients() {
        return clientServices.getClients();
    }
    @QueryMapping
    public Optional<Client> getClient(@Argument("id") Long id) {
        return clientServices.getClient(id);
    }
    @MutationMapping
    public Client saveClient(@Argument Client clientRequest) {
        return clientServices.saveClient(clientRequest);
    }
    @MutationMapping
    public Client updateClient(@Argument Long id, @Argument Client clientRequest) {
        return clientServices.updateClient(id, clientRequest);
    }
    @MutationMapping
    public void deleteClient(@Argument Long id) {
        clientServices.deleteClient(id);
    }
}
