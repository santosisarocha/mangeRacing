package com.MangeRacing.demo.Controller;

import com.MangeRacing.demo.Service.RodaFrenteService;
import com.MangeRacing.demo.models.RodaFrenteIMG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/rodaFrente")
public class RodaFrenteController {

    @Autowired
    private RodaFrenteService rodaFrenteService;

    @GetMapping
    public List<RodaFrenteIMG> getAllRodaFrentes(){
        return rodaFrenteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RodaFrenteIMG> getRodaFrentesById(@PathVariable UUID id) {
        Optional<RodaFrenteIMG> rodaFrenteIMG = rodaFrenteService.findById(id);
        return rodaFrenteIMG.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public RodaFrenteIMG createRodaFrente(@RequestBody RodaFrenteIMG rodaFrenteIMG) {
        return rodaFrenteService.save(rodaFrenteIMG);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RodaFrenteIMG> updateRodaFrente(@PathVariable UUID id, @RequestBody RodaFrenteIMG rodaFrenteDetails) {
        Optional<RodaFrenteIMG> existingRodaFrente = rodaFrenteService.findById(id);

        if (existingRodaFrente.isPresent()) {
            RodaFrenteIMG rodaFrenteIMG = existingRodaFrente.get();
            rodaFrenteIMG.setImagem(rodaFrenteDetails.getImagem());
            rodaFrenteIMG.setTitle(rodaFrenteDetails.getTitle());
            return ResponseEntity.ok(rodaFrenteService.save(rodaFrenteIMG));
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRodaFrente(@PathVariable UUID id) {
        Optional<RodaFrenteIMG> existingRodaFrente = rodaFrenteService.findById(id);

        if (existingRodaFrente.isPresent()) {
            rodaFrenteService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
