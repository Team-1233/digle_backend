package com.example.one2three3.domain.accident.repository;

import com.example.one2three3.domain.accident.entity.Accident;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccidentRepository extends JpaRepository<Accident, Long> {
}
