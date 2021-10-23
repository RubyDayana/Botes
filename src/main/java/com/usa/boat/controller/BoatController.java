/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.boat.controller;

import com.usa.boat.entity.Boat;
import com.usa.boat.service.BoatService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ruby Dayana
 */
@RestController
@RequestMapping("api/Boat")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class BoatController {
    @Autowired
    private BoatService servicio;
    
    @GetMapping("/all")
    public List<Boat> getBoats(){
        return servicio.getAll();
    }
    
    @GetMapping("/{id]")
    public Optional<Boat> getBoat(@PathVariable("id") int boatId){
        return servicio.getBoat(boatId);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Boat save(@RequestBody Boat boat){
        return servicio.save(boat);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Boat update(@RequestBody Boat boat){
        return servicio.save(boat);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int boatId){
        return servicio.deleteBoat(boatId);
    }
    
}
