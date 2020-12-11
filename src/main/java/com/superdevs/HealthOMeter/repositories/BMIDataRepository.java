package com.superdevs.HealthOMeter.repositories;

import com.superdevs.HealthOMeter.entity.BMIData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface BMIDataRepository extends JpaRepository<BMIData, Long> {

    @Override
    List<BMIData> findAll();
}
