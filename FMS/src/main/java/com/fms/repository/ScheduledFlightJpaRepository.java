package com.fms.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.entities.ScheduledFlight;
public interface ScheduledFlightJpaRepository extends JpaRepository<ScheduledFlight,Integer> {

}
