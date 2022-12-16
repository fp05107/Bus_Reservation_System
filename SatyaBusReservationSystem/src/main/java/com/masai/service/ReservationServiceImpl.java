package com.masai.service;

import com.masai.DTO.ReservationDTO;
import com.masai.exception.AdminException;
import com.masai.exception.ReservationException;
import com.masai.exception.UserException;
import com.masai.model.Reservation;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService{

    @Override
    public Reservation addReservation(ReservationDTO reservationDTO, String key) throws ReservationException, com.masai.exceptions.BusException, UserException {
        return null;
    }

    @Override
    public Reservation deleteReservation(Integer reservationId, String key) throws ReservationException, com.masai.exceptions.BusException, UserException {
        return null;
    }

    @Override
    public Reservation viewReservation(Integer reservationId, String key) throws ReservationException, AdminException {
        return null;
    }

    @Override
    public List<Reservation> viewAllReservation(String key) throws ReservationException {
        return null;
    }

    @Override
    public List<Reservation> viewReservationByUser(String key) throws ReservationException, UserException {
        return null;
    }
}
