package com.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.entities.Flight;

public interface FlightJpaRepository extends JpaRepository<Flight,Integer>{

}
