package com.superdevs.HealthOMeter.repositories;

import com.superdevs.HealthOMeter.entity.WHRData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface WHRDataRepository extends JpaRepository<WHRData, Long> {

    @Override
    List<WHRData> findAll();
}
