package com.example.one2three3.domain.support.repository;

import com.example.one2three3.domain.support.entity.Support;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SupportRepository extends JpaRepository<Support, Long> {

    List<Support> findAllByAccident_Id(Long accidentId);
}
