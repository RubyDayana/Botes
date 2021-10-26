/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.boat.repository;

import com.usa.boat.entity.Boat;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.usa.boat.repository.crud.IBoat;

/**
 *
 * @author Ruby Dayana
 */
@Repository
public class BoatRepository {

    @Autowired
    private IBoat crud;

    public List<Boat> getAll() {
        return (List< Boat>) crud.findAll();
    }

    public Optional<Boat> getBoat(int id) {
        return crud.findById(id);
    }

    public Boat save(Boat boat) {
        return crud.save(boat);
    }

    public void delete(Boat boat) {
        crud.delete(boat);
    }

}
