/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.boat.service;

import com.usa.boat.entity.Boat;
import com.usa.boat.repository.BoatRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ruby Dayana
 */
@Service
public class BoatService {

    @Autowired
    private BoatRepository metodosCrud;

    public List<Boat> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Boat> getBoat(int id) {
        return metodosCrud.getBoat(id);
    }

    public Boat save(Boat boat) {
        if (boat.getId() == null) {
            return metodosCrud.save(boat);
        } else {
            Optional<Boat> evtBoat = metodosCrud.getBoat(boat.getId());
            if(evtBoat.isEmpty()){
                return metodosCrud.save(boat);
            } else {
                return boat;
            }
        }
    }

    public Boat update(Boat boat) {
        if (boat.getId() != null) {
            Optional<Boat> evtBoat = metodosCrud.getBoat(boat.getId());
            if (!evtBoat.isEmpty()) {
                if (boat.getName() != null) {
                    evtBoat.get().setName(boat.getName());
                }
                if (boat.getBrand() != null) {
                    evtBoat.get().setBrand(boat.getBrand());
                }
                if (boat.getYear() != null) {
                    evtBoat.get().setYear(boat.getYear());
                }
                if (boat.getDescription() != null) {
                    evtBoat.get().setDescription(boat.getDescription());
                }
                if (boat.getCategory() != null) {
                    evtBoat.get().setCategory(boat.getCategory());
                }
                metodosCrud.save(evtBoat.get());
                return evtBoat.get();
            } else {
                return boat;
            }
        } else {
            return boat;
        }
    }

    public boolean deleteBoat(int boatId) {
        Boolean booleanDelete = getBoat(boatId).map(boat -> {
            metodosCrud.delete(boat);
            return true;
        }).orElse(false);
        return booleanDelete;
    }
}
