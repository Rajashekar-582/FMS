package com.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.entities.Schedule;
public interface ScheduleJpaRepository extends JpaRepository<Schedule,Integer> {

}
