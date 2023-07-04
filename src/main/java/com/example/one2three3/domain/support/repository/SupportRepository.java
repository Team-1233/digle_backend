package com.example.one2three3.domain.support.repository;

import com.example.one2three3.domain.support.entity.Support;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SupportRepository extends JpaRepository<Support, Long> {

    @Query(value = "SELECT COALESCE(SUM(S.supportAmount), 0) FROM Support as S WHERE S.accident.id = :accidentId")
    Long sumByAccidentIdWithSupportMoney(Long accidentId);
}
