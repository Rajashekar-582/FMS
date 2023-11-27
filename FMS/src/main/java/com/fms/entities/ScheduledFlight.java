package com.fms.entities;


import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name="scheduled_flight")
public class ScheduledFlight {
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "schedule_flight_id")
	private int Id;

	@OneToOne(fetch = FetchType.EAGER)
	@Nonnull
	private Flight flight;

	@Column(name = "available_seats")
	@Nonnull
	private int availableSeats;

	@Nonnull
	@OneToOne(cascade = CascadeType.ALL)
	private Schedule schedule;

	public Schedule getSchedule() {
		// TODO Auto-generated method stub
		return null;
	}

}
