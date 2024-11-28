package com.MangeRacing.demo.Service;


import com.MangeRacing.demo.Repository.CarrinhoRepository;
import com.MangeRacing.demo.models.Carrinho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CarrinhoService {
    @Autowired
    private CarrinhoRepository carrinhoRepository;

    public List<Carrinho> findAll(){return carrinhoRepository.findAll();}

    public Optional<Carrinho> findById(UUID id){return carrinhoRepository.findById(id);}

    public Carrinho save(Carrinho carrinho){return carrinhoRepository.save(carrinho);}

    public void deleteById(UUID id) {carrinhoRepository.deleteById(id);}
}
