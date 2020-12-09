package com.superdevs.HealthOMeter.repositories;

import com.superdevs.HealthOMeter.entity.BioMetricData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface BioMetricDataRepository extends JpaRepository <BioMetricData, Long> {
}
