package com.qualirede.controller;

import com.qualirede.repositories.jpa.DoencaRepository;
import com.qualirede.repositories.jpa.entities.Doenca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/rest/v1/doenca")
public class DoencaController {

    @Autowired
    private DoencaRepository repoDoenca;

    /**
     * Cria uma nova doença.
     */
    @PostMapping()
    public ResponseEntity<Long> create(@RequestBody Doenca doenca) {
        try {
            repoDoenca.save(doenca);
            return ResponseEntity.ok(doenca.getId());
        } catch (Throwable t){
            throw t;
        }
    }

    /**
     * Retorna a Doenca.
     * @param doencaId id da doença a ser retornada.
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<Doenca> get(@PathVariable(name = "id") Long doencaId) {
        try {
            final Optional<Doenca> found = repoDoenca.findById(doencaId);
            if (found.isPresent()) {
                return ResponseEntity.ok(found.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Throwable t){
            //I could customize error messages here
            throw t;
        }
    }
}
