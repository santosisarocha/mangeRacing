package com.MangeRacing.demo.Service;

import com.MangeRacing.demo.Repository.FrenteRepository;
import com.MangeRacing.demo.models.FrenteIMG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FrenteService {
    @Autowired
    private FrenteRepository frenteRepository;

    public List<FrenteIMG> findAll(){return frenteRepository.findAll();}

    public Optional<FrenteIMG> findById(UUID id){return frenteRepository.findById(id);}

    public FrenteIMG save(FrenteIMG frenteIMG){return frenteRepository.save(frenteIMG);}

    public void deleteById(UUID id) {frenteRepository.deleteById(id);}
}
