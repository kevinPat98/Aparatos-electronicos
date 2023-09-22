package com.uptc.frw.electronicDevices.services;

import com.uptc.frw.electronicDevices.entity.Client;
import com.uptc.frw.electronicDevices.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServices {
    @Autowired
    ClientRepository clientRepository;

    public List<Client> getClients(){return clientRepository.findAll();}

    public Optional<Client> getClient(Long id){
        return Optional.ofNullable(clientRepository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Cliente %s no encontrado", id))
        ));
    }
    public Client saveClient(Client clientRequest) {
        Client client = new Client();
        client.setDocument(clientRequest.getDocument());
        client.setName(clientRequest.getName());
        client.setAddress(clientRequest.getAddress());
        client.setPhone(clientRequest.getPhone());
        client.setMail(clientRequest.getMail());
        return clientRepository.save(client);
    }

    public void deleteClient(long id){
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            clientRepository.deleteById(id);
        } else {
            throw new RuntimeException(String.format("Cliente %s no encontrado", id));
        }
    }

    public Client updateClient(Long id, Client clientRequest) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            Client existingClient = optionalClient.get();
            existingClient.setId(id);
            if (clientRequest.getDocument() != null) {
                existingClient.setDocument(clientRequest.getDocument());
            }
            if (clientRequest.getName() != null) {
                existingClient.setName(clientRequest.getName());
            }
            if (clientRequest.getAddress() != null) {
                existingClient.setAddress(clientRequest.getAddress());
            }
            if (clientRequest.getPhone() != null) {
                existingClient.setPhone(clientRequest.getPhone());
            }
            if (clientRequest.getMail() != null) {
                existingClient.setMail(clientRequest.getMail());
            }
            return clientRepository.save(existingClient);
        } else {
            throw new RuntimeException(String.format("Cliente %s no encontrado", id));
        }
    }
}
