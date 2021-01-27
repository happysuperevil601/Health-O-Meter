package com.superdevs.HealthOMeter.repositories;

import com.superdevs.HealthOMeter.entity.BioMetricHistoricalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface BioMetricHistoricalDataRepository extends JpaRepository<BioMetricHistoricalData, Long> {

    @Override
    List<BioMetricHistoricalData> findAll();

    @Override
    Optional<BioMetricHistoricalData> findById(Long id);

    boolean existsById(Long id);

    @Override
    void deleteById(Long id);
}
