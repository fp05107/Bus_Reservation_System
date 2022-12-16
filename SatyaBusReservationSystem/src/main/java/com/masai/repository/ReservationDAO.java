package com.masai.repository;

import com.masai.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ReservationDAO {

    @Repository
    public interface ReservationDAO extends JpaRepository<Reservation, Integer> {

    }
}
