/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.boat.service;

import com.usa.boat.entity.Client;
import com.usa.boat.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ruby Dayana
 */
@Service
public class ClientService {
    @Autowired
    private ClientRepository metodosCrud;

    public List<Client> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Client> getClient(int id) {
        return metodosCrud.getClient(id);
    }
    
    public Client save(Client client) {
        if (client.getIdClient() == null) {
            return metodosCrud.save(client);
        } else {
            Optional<Client> evtClient = metodosCrud.getClient(client.getIdClient());
            if(evtClient.isEmpty()){
                return metodosCrud.save(client);
            } else {
                return client;
            }
        }
    }
    
    public Client update(Client client) {
        if (client.getIdClient()!= null) {
            Optional<Client> evtClient = metodosCrud.getClient(client.getIdClient());
            if (!evtClient.isEmpty()) {
                
                if (client.getName() != null) {
                    evtClient.get().setName(client.getName());
                }
                if (client.getAge()!= null) {
                    evtClient.get().setAge(client.getAge());
                }
                if (client.getPassword()!= null) {
                    evtClient.get().setPassword(client.getPassword());
                }
                metodosCrud.save(evtClient.get());
                return evtClient.get();
            } else {
                return client;
            }
        } else {
            return client;
        }
    }

    public boolean deleteClient(int clientId) {
        Boolean booleanDelete = getClient(clientId).map(client -> {
            metodosCrud.delete(client);
            return true;
        }).orElse(false);
        return booleanDelete;
    }
}
