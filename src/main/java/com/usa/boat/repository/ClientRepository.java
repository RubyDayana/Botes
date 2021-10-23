/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.boat.repository;

import com.usa.boat.entity.Client;
import com.usa.boat.interfaces.IClient;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ruby Dayana
 */
@Repository
public class ClientRepository {

    @Autowired
    private IClient crud;

    public List<Client> getAll() {
        return (List<Client>) crud.findAll();
    }

    public Optional<Client> getClient(int id) {
        return crud.findById(id);
    }

    public Client save(Client client) {
        return crud.save(client);
    }

    public void delete(Client client) {
        crud.delete(client);
    }
}
