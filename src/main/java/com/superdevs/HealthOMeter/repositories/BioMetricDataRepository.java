package com.superdevs.HealthOMeter.repositories;

import com.superdevs.HealthOMeter.entity.BioMetricData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface BioMetricDataRepository extends JpaRepository <BioMetricData, Long> {

    @Override
    List<BioMetricData> findAll();

    @Override
    Optional<BioMetricData> findById(Long id);

    boolean existsById(Long id);

    @Override
    void deleteById(Long id);
}
