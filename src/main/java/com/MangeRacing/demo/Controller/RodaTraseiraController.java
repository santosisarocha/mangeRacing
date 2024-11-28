package com.MangeRacing.demo.Controller;

import com.MangeRacing.demo.Service.RodaTraseiraService;
import com.MangeRacing.demo.models.RodaTraseiraIMG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/rodaTraseira")
public class RodaTraseiraController {

    @Autowired
    private RodaTraseiraService rodaTraseiraService;

    @GetMapping
    public List<RodaTraseiraIMG> getAllRodaTraseira(){
        return rodaTraseiraService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RodaTraseiraIMG> getRodaTraseiraById(@PathVariable UUID id) {
        Optional<RodaTraseiraIMG> rodaTraseiraIMG = rodaTraseiraService.findById(id);
        return rodaTraseiraIMG.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public RodaTraseiraIMG createRodaTraseira(@RequestBody RodaTraseiraIMG rodaTraseiraIMG) {
        return rodaTraseiraService.save(rodaTraseiraIMG);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RodaTraseiraIMG> updateRodaTraseira(@PathVariable UUID id, @RequestBody RodaTraseiraIMG rodaTraseiraDetails) {
        Optional<RodaTraseiraIMG> existingRodaTraseira = rodaTraseiraService.findById(id);

        if (existingRodaTraseira.isPresent()) {
            RodaTraseiraIMG rodaTraseiraIMG = existingRodaTraseira.get();
            rodaTraseiraIMG.setImagem(rodaTraseiraDetails.getImagem());
            rodaTraseiraIMG.setTitle(rodaTraseiraDetails.getTitle());
            return ResponseEntity.ok(rodaTraseiraService.save(rodaTraseiraIMG));
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRodaTraseira(@PathVariable UUID id) {
        Optional<RodaTraseiraIMG> existingRodaTraseira = rodaTraseiraService.findById(id);

        if (existingRodaTraseira.isPresent()) {
            rodaTraseiraService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
