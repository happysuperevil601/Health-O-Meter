package com.superdevs.HealthOMeter.repositories;

import com.superdevs.HealthOMeter.entity.WHRData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface WHRDataRepository extends JpaRepository<WHRData, Long> {

    @Override
    List<WHRData> findAll();

    @Override
    Optional<WHRData> findById(Long id);

    boolean existsById(Long id);

    @Override
    void deleteById(Long id);
}
