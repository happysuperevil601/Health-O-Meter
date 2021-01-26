package com.superdevs.HealthOMeter.repositories;

import com.superdevs.HealthOMeter.entity.MedicalData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface MedicalDataRepository extends JpaRepository<MedicalData, Long> {

    @Override
    List<MedicalData> findAll();

    @Override
    Optional<MedicalData> findById(Long id);

    boolean existsById(Long id);

    @Override
    void deleteById(Long id);
}
