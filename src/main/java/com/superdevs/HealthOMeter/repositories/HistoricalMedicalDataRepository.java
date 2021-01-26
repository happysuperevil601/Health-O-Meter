package com.superdevs.HealthOMeter.repositories;

import com.superdevs.HealthOMeter.entity.HistoricalMedicalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface HistoricalMedicalDataRepository extends JpaRepository <HistoricalMedicalData, Long> {

    @Override
    List<HistoricalMedicalData> findAll();

    @Override
    Optional<HistoricalMedicalData> findById(Long id);

    boolean existsById(Long id);

    @Override
    void deleteById(Long id);
}
