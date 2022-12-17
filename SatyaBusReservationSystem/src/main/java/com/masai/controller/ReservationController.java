package com.masai.controller;

import com.masai.DTO.ReservationDTO;
import com.masai.exception.AdminException;
import com.masai.exception.ReservationException;
import com.masai.exception.UserException;
import com.masai.model.Reservation;
import com.masai.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/reservation/user")
    public ResponseEntity<Reservation> addReservation(@Valid @RequestBody ReservationDTO reservationDTO, @RequestParam(required = false) String key) throws ReservationException, UserException, com.masai.exceptions.BusException {
        Reservation addReservation = reservationService.addReservation(reservationDTO, key);
        return new ResponseEntity<>(addReservation, HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/reservation/user/{id}")
    public ResponseEntity<Reservation> deleteReservation(@PathVariable("id") Integer reservationId, @RequestParam(required = false) String key) throws ReservationException, UserException, com.masai.exceptions.BusException {
        Reservation deletReservation = reservationService.deleteReservation(reservationId, key);
        return new ResponseEntity<>(deletReservation, HttpStatus.OK);
    }

    @GetMapping("/reservation/admin/{id}")
    public ResponseEntity<Reservation> viewReservation(@PathVariable("id") Integer reservationId, @RequestParam(required = false) String key) throws ReservationException, AdminException {
        Reservation viewReservation = reservationService.viewReservation(reservationId, key);
        return new ResponseEntity<>(viewReservation, HttpStatus.OK);
    }

    @GetMapping("/reservation/admin")
    public ResponseEntity<List<Reservation>> viewAllReservation(@RequestParam(required = false) String key) throws ReservationException {
        List<Reservation> viewAllReservation = reservationService.viewAllReservation(key);
        return new ResponseEntity<>(viewAllReservation, HttpStatus.OK);
    }

    @GetMapping("/reservation/user")
    public ResponseEntity<List<Reservation>> viewReservationByUser(@RequestParam(required = false) String key) throws ReservationException, UserException {

        List<Reservation> viewReservationByUser = reservationService.viewReservationByUser(key);
        return new ResponseEntity<>(viewReservationByUser, HttpStatus.OK);
    }
}
