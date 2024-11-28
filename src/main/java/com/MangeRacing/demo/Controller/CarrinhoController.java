package com.MangeRacing.demo.Controller;

import com.MangeRacing.demo.Repository.*;
import com.MangeRacing.demo.Service.CarrinhoService;
import com.MangeRacing.demo.models.*;
import com.MangeRacing.demo.models.DTO.CarrinhoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/carrinho")
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;

    @Autowired
    private FrenteRepository frenteRepository;

    @Autowired
    private MotorRepository motorRepository;

    @Autowired
    private RodaFrenteRepository rodaFrenteRepository;

    @Autowired
    private RodaTraseiroRepository rodaTraseiroRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CarrinhoRepository carrinhoRepository;


    @GetMapping
    public List<Carrinho> getAllcarrinhos(){
        return carrinhoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrinho> getCarrinhoById(@PathVariable UUID id) {
        Optional<Carrinho> carrinho = carrinhoService.findById(id);
        return carrinho.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Carrinho> createCarrinho(@RequestBody CarrinhoDTO carrinhoDTO) {
        try {
            Carrinho carrinho = Carrinho.builder()
                    .frente(frenteRepository.findById(carrinhoDTO.getFrente())
                            .orElseThrow(() -> new IllegalArgumentException("FrenteIMG inválido!")))
                    .motor(motorRepository.findById(carrinhoDTO.getMotor())
                            .orElseThrow(() -> new IllegalArgumentException("MotorIMG inválido!")))
                    .rodaFrente(rodaFrenteRepository.findById(carrinhoDTO.getRodaFrente())
                            .orElseThrow(() -> new IllegalArgumentException("RodaFrenteIMG inválido!")))
                    .rodaTraseira(rodaTraseiroRepository.findById(carrinhoDTO.getRodaTraseira())
                            .orElseThrow(() -> new IllegalArgumentException("RodaTraseiraIMG inválido!")))
                    .user(userRepository.findById(carrinhoDTO.getUser())
                            .orElseThrow(() -> new IllegalArgumentException("Usuário inválido!")))
                    .build();

            Carrinho savedCarrinho = carrinhoRepository.save(carrinho);
            return ResponseEntity.ok(savedCarrinho);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carrinho> updateCarrinho(@PathVariable UUID id, @RequestBody Carrinho carrinhoDetails, FrenteIMG frenteIMGDetails, MotorIMG motorIMGDetails, RodaFrenteIMG rodaFrenteIMGDetails, RodaTraseiraIMG rodaTraseiraIMGDetails, User userDetails) {
        Optional<Carrinho> existingCarrinho = carrinhoService.findById(id);

        if (existingCarrinho.isPresent()) {
            Carrinho carrinho = existingCarrinho.get();
            carrinho.setFrente(frenteIMGDetails.getId());
            carrinho.setMotor(motorIMGDetails.getId());
            carrinho.setRodaFrente(rodaFrenteIMGDetails.getId());
            carrinho.setRodaTraseira(rodaTraseiraIMGDetails.getId());
            carrinho.setUser(userDetails.getId());
            return ResponseEntity.ok(carrinhoService.save(carrinho));
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarrinho(@PathVariable UUID id) {
        Optional<Carrinho> existingCarrinho = carrinhoService.findById(id);

        if (existingCarrinho.isPresent()) {
            carrinhoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
