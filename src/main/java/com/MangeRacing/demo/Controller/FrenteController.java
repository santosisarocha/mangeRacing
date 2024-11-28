package com.MangeRacing.demo.Controller;

import com.MangeRacing.demo.Service.FrenteService;
import com.MangeRacing.demo.models.FrenteIMG;
import com.MangeRacing.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/frente")
public class FrenteController {

    @Autowired
    private FrenteService frenteService;

    @GetMapping
    public List<FrenteIMG> getAllFrentes(){
        return frenteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FrenteIMG> getFrentesById(@PathVariable UUID id) {
        Optional<FrenteIMG> frenteIMG = frenteService.findById(id);
        return frenteIMG.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public FrenteIMG createFrente(@RequestBody FrenteIMG frenteIMG) {
        return frenteService.save(frenteIMG);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FrenteIMG> updateFrente(@PathVariable UUID id, @RequestBody FrenteIMG frenteDetails) {
        Optional<FrenteIMG> existingFrente = frenteService.findById(id);

        if (existingFrente.isPresent()) {
            FrenteIMG frenteIMG = existingFrente.get();
            frenteIMG.setImagem(frenteDetails.getImagem());
            frenteIMG.setTitle(frenteDetails.getTitle());
            return ResponseEntity.ok(frenteService.save(frenteIMG));
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFrente(@PathVariable UUID id) {
        Optional<FrenteIMG> existingFrente = frenteService.findById(id);

        if (existingFrente.isPresent()) {
            frenteService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
