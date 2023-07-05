package com.example.one2three3.domain.accident.repository;

import com.example.one2three3.domain.accident.entity.Accident;
import com.example.one2three3.domain.accident.entity.AccidentState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccidentRepository extends JpaRepository<Accident, Long> {

    List<Accident> findAllByState(AccidentState accidentState);
}
