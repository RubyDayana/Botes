/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usa.boat.service;

import com.usa.boat.entity.Reservation;
import com.usa.boat.repository.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ruby Dayana
 */
@Service
public class ReservationService {
    @Autowired
    private ReservationRepository metodosCrud;

    public List<Reservation> getAll() {
        return metodosCrud.getAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return metodosCrud.getReservation(id);
    }
    
    public Reservation save(Reservation reservation) {
        if (reservation.getIdReservation() == null) {
            return metodosCrud.save(reservation);
        } else {
            Optional<Reservation> evtReservation = metodosCrud.getReservation(reservation.getIdReservation());
            if (evtReservation.isEmpty()) {
                return metodosCrud.save(reservation);
            } else {
                return reservation;
            }
        }
    }
    
    public Reservation update(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> evtReservation = metodosCrud.getReservation(reservation.getIdReservation());
            if (!evtReservation.isEmpty()) {

                if (reservation.getStartDate()!= null) {
                    evtReservation.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate()!= null) {
                    evtReservation.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus()!= null) {
                    evtReservation.get().setStatus(reservation.getStatus());
                }
                metodosCrud.save(evtReservation.get());
                return evtReservation.get();
            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
    }
    
    public boolean deleteReservation(int reservationId) {
        Boolean booleanDelete = getReservation(reservationId).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return booleanDelete;
    }
    
}
