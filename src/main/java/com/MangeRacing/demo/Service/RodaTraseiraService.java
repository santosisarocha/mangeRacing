package com.MangeRacing.demo.Service;

import com.MangeRacing.demo.Repository.RodaTraseiroRepository;
import com.MangeRacing.demo.models.RodaTraseiraIMG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RodaTraseiraService {
    @Autowired
    private RodaTraseiroRepository rodaTraseiroRepository;

    public List<RodaTraseiraIMG> findAll(){return rodaTraseiroRepository.findAll();}

    public Optional<RodaTraseiraIMG> findById(UUID id){return rodaTraseiroRepository.findById(id);}

    public RodaTraseiraIMG save(RodaTraseiraIMG rodaTraseiraIMG){return rodaTraseiroRepository.save(rodaTraseiraIMG);}

    public void deleteById(UUID id) {rodaTraseiroRepository.deleteById(id);}
}
