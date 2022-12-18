package com.masai.service;

import com.masai.DTO.ReservationDTO;
import com.masai.exception.AdminException;
import com.masai.exception.ReservationException;
import com.masai.exception.UserException;
import com.masai.model.*;
import com.masai.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationDAO reservationDao;

    @Autowired
    private BusRepo busDao;

    @Autowired
    private UserSessionDao userSessionDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private AdminSessionDao adminSessionDao;

    @Override
<<<<<<< HEAD
    public Reservation addReservation(ReservationDTO reservationDTO, String key) throws ReservationException, UserException {

        CurrentUserSession loggedInUser = userSessionDao.findByUserUID(key);

        if (loggedInUser == null) {
            throw new UserException("Please Provide a valid key to reserve seats...");
        }

        Optional<User> userOptional = userDao.findById(loggedInUser.getUserId());

        if (userOptional.isPresent()) {

            Optional<Bus> opt = busDao.findById(reservationDTO.getBusDTO().getBusId());

            Bus bus = opt.orElseThrow(() -> new ReservationException("Invalid bus details!"));

            if (reservationDTO.getJourneyDate().isBefore(LocalDate.now()))
                throw new ReservationException("Please enter future date!");

            if (!bus.getBusJourneyDate().isEqual(reservationDTO.getJourneyDate()))
                throw new ReservationException("Bus is not available on " + reservationDTO.getJourneyDate());

            if (!reservationDTO.getSource().equalsIgnoreCase(bus.getRouteFrom()) || !reservationDTO.getDestination().equalsIgnoreCase(bus.getRouteTo()))
                throw new ReservationException("Bus is not available on route : " + reservationDTO.getSource() + " - " + reservationDTO.getDestination());

            int seatsAvailable = bus.getAvailableSeats();
            if (seatsAvailable < reservationDTO.getNoOfSeatsToBook())
                throw new ReservationException("Reservation Failed! Available seats: " + seatsAvailable);

            Reservation reservation = new Reservation();

            bus.setAvailableSeats(seatsAvailable - reservationDTO.getNoOfSeatsToBook());

            Bus updatedBus = busDao.save(bus);

            reservation.setBus(updatedBus);

            reservation.setReservationStatus("Success");
            reservation.setReservationDate(LocalDate.now());
            reservation.setReservationTime(LocalTime.now());
            reservation.setSource(bus.getRouteFrom());
            reservation.setDestination(bus.getRouteTo());
            reservation.setNoOfSeatsBooked(reservationDTO.getNoOfSeatsToBook());
            reservation.setFare(bus.getFarePerSeat() * (reservationDTO.getNoOfSeatsToBook()));
            reservation.setJourneyDate(reservationDTO.getJourneyDate());

            List<Reservation> userReservations = userOptional.get().getReservations();
            userReservations.add(reservation);

            userOptional.get().setReservations(userReservations);

            reservation.setUser(userOptional.get());

            Reservation savedReservation = reservationDao.save(reservation);

            if (savedReservation == null)
                throw new ReservationException("Could not reserve the seats");
            return savedReservation;
        } else {
            throw new UserException("User not found!");
        }
    }

    @Override
    public Reservation deleteReservation(Integer reservationId, String key) throws ReservationException, com.masai.exceptions.BusException, UserException {

        CurrentUserSession loggedInUser = userSessionDao.findByUserUID(key);

        if (loggedInUser == null) {
            throw new UserException("Please provide a valid key to reserve seats!");
        }

        Optional<User> userOptional = userDao.findById(loggedInUser.getUserId());

        if (userOptional.isPresent()) {

            List<Reservation> reservationList = userOptional.get().getReservations();

            boolean validReservationId = false;

            for (int i = 0; i < reservationList.size(); i++) {

                if (reservationList.get(i).getReservationId() == reservationId) {
                    validReservationId = true;

                    Optional<Reservation> Opt = reservationDao.findById(reservationId);

                    if (Opt.isPresent()) {
                        Reservation foundReservation = Opt.get();

                        Bus bus = foundReservation.getBus();

                        if (foundReservation.getJourneyDate().isBefore(LocalDate.now()))
                            throw new ReservationException("Can't Cancel Journey Completed.");

                        bus.setAvailableSeats(bus.getAvailableSeats() + foundReservation.getNoOfSeatsBooked());
                        Bus updatedBus = busDao.save(bus);

                        reservationList.remove(i);
                        reservationDao.delete(foundReservation);
                        return foundReservation;
                    } else {
                        throw new ReservationException("No Reservation found!");
                    }
                }
            }

            if (!validReservationId)
                throw new UserException("Reservation Id:" + reservationId + " does not belong to the current user!");
            return null;
        } else {
            throw new UserException("User not found!");
        }
=======
    public Reservation addReservation(ReservationDTO reservationDTO, String key) throws ReservationException, com.masai.exception.BusException, UserException {
        return null;
    }

    @Override
    public Reservation deleteReservation(Integer reservationId, String key) throws ReservationException, com.masai.exception.BusException, UserException {
        return null;
>>>>>>> 25cacb8fae3c238a2d3a2be3cec1d788b5ca473e
    }

    @Override
    public Reservation viewReservation(Integer reservationId, String key) throws ReservationException, AdminException {
        CurrentAdminSession loggedInAdmin = adminSessionDao.findByAdminUID(key);

        if (loggedInAdmin == null) {
            throw new ReservationException("Please provide a valid key to view reservation...");
        }

        Optional<Reservation> opt = reservationDao.findById(reservationId);
        if (opt.isPresent()) {
            Reservation foundReservation = opt.get();
            return foundReservation;
        } else {
            throw new ReservationException("No reservation found!");
        }
    }

    @Override
    public List<Reservation> viewAllReservation(String key) throws ReservationException {

        CurrentAdminSession loggedInAdmin = adminSessionDao.findByAdminUID(key);

        if (loggedInAdmin == null) {
            throw new ReservationException("Please provide a valid key to view all reservations...");
        }

        List<Reservation> reservationList = reservationDao.findAll();
        if (reservationList.isEmpty()) throw new ReservationException("No reservations found...");
        return reservationList;
    }

    @Override
    public List<Reservation> viewReservationByUser(String key) throws ReservationException, UserException {
        CurrentUserSession loggedInUser = userSessionDao.findByUserUID(key);

        if (loggedInUser == null) {
            throw new UserException("Please provide a valid key to view reservation!");
        }

        Optional<User> optionalUser = userDao.findById(loggedInUser.getUserId());

        if (optionalUser.isPresent()) {
            return optionalUser.get().getReservations();

        } else {
            throw new UserException("User not found!");
        }
    }
}
