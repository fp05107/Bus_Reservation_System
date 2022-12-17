package com.masai.service;

import com.masai.DTO.ReservationDTO;
import com.masai.exception.AdminException;
import com.masai.exception.ReservationException;
import com.masai.exception.UserException;
import com.masai.model.Reservation;
import java.util.List;

public interface ReservationService {

    public Reservation addReservation(ReservationDTO reservationDTO, String key) throws ReservationException, com.masai.exceptions.BusException, UserException;

    public Reservation deleteReservation(Integer reservationId, String key) throws ReservationException, com.masai.exceptions.BusException, UserException;

    public Reservation viewReservation(Integer reservationId, String key) throws ReservationException, AdminException;

    public List<Reservation> viewAllReservation(String key) throws ReservationException;

    public List<Reservation> viewReservationByUser(String key) throws ReservationException, UserException;
}
