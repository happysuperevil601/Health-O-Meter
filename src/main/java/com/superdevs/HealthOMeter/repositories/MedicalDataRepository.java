package com.superdevs.HealthOMeter.repositories;

import com.superdevs.HealthOMeter.entity.MedicalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface MedicalDataRepository extends JpaRepository<MedicalData, Long> {
}
