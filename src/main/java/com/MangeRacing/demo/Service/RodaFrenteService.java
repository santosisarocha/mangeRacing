package com.MangeRacing.demo.Service;


import com.MangeRacing.demo.Repository.RodaFrenteRepository;
import com.MangeRacing.demo.models.RodaFrenteIMG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RodaFrenteService {
    @Autowired
    private RodaFrenteRepository rodaFrenteRepository;

    public List<RodaFrenteIMG> findAll(){return rodaFrenteRepository.findAll();}

    public Optional<RodaFrenteIMG> findById(UUID id){return rodaFrenteRepository.findById(id);}

    public RodaFrenteIMG save(RodaFrenteIMG rodaFrenteIMG){return rodaFrenteRepository.save(rodaFrenteIMG);}

    public void deleteById(UUID id) {rodaFrenteRepository.deleteById(id);}
}
