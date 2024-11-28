package com.MangeRacing.demo.Repository;

import com.MangeRacing.demo.models.MotorIMG;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MotorRepository extends JpaRepository<MotorIMG, UUID> {

}
