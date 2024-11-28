package com.MangeRacing.demo.Controller;

import com.MangeRacing.demo.Service.MotorService;
import com.MangeRacing.demo.models.MotorIMG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/motor")
public class MotorController {

    @Autowired
    private MotorService motorService;

    @GetMapping
    public List<MotorIMG> getAllMotor(){
        return motorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MotorIMG> getMotorById(@PathVariable UUID id) {
        Optional<MotorIMG> motorIMG = motorService.findById(id);
        return motorIMG.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public MotorIMG createMotor(@RequestBody MotorIMG motorIMG) {
        return motorService.save(motorIMG);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MotorIMG> updateMotor(@PathVariable UUID id, @RequestBody MotorIMG motorDetails) {
        Optional<MotorIMG> existingMotor = motorService.findById(id);

        if (existingMotor.isPresent()) {
            MotorIMG motorIMG = existingMotor.get();
            motorIMG.setImagem(motorDetails.getImagem());
            motorIMG.setTitle(motorDetails.getTitle());
            return ResponseEntity.ok(motorService.save(motorIMG));
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMotor(@PathVariable UUID id) {
        Optional<MotorIMG> existingMotor = motorService.findById(id);

        if (existingMotor.isPresent()) {
            motorService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
