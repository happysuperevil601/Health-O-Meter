package com.superdevs.HealthOMeter.repositories;

import com.superdevs.HealthOMeter.entity.RFMData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface RFMDataRepository extends JpaRepository <RFMData, Long> {

    @Override
    List<RFMData> findAll();
}
