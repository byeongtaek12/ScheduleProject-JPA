package com.example.schedulev2.repository;

import com.example.schedulev2.entity.Schedulev2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedulev2, Long> {

}
