package com.MangeRacing.demo.Service;
import com.MangeRacing.demo.Repository.MotorRepository;
import com.MangeRacing.demo.models.MotorIMG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MotorService {
    @Autowired
    private MotorRepository motorRepository;

    public List<MotorIMG> findAll(){return motorRepository.findAll();}

    public Optional<MotorIMG> findById(UUID id){return motorRepository.findById(id);}

    public MotorIMG save(MotorIMG motorIMG){return motorRepository.save(motorIMG);}

    public void deleteById(UUID id) {motorRepository.deleteById(id);}
}
