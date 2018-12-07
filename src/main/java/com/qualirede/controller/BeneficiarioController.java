package com.qualirede.controller;

import com.qualirede.controller.json.BeneficiarioDoencaDTO;
import com.qualirede.repositories.jpa.BeneficiarioRepository;
import com.qualirede.repositories.jpa.DoencaRepository;
import com.qualirede.repositories.jpa.entities.Beneficiario;
import com.qualirede.repositories.jpa.entities.Doenca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/v1/beneficiario")
public class BeneficiarioController {

    @Autowired
    private BeneficiarioRepository repoBene;

    @Autowired
    private DoencaRepository repoDoenca;

    /**
     * Cria um beneficiário.
     * @param b beneficiário.
     */
    @PostMapping()
    public ResponseEntity<Long> create(@RequestBody Beneficiario b) {
        try {
            repoBene.save(b);
            return ResponseEntity.ok(b.getId());
        } catch (Throwable t){
            throw t;
        }
    }

    /**
     * Retorna um Beneficiário
     * @param beneficiarioId id do Beneficiário.
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<Beneficiario> get(@PathVariable(name = "id") Long beneficiarioId) {
        try {
            final Optional<Beneficiario> found = repoBene.findById(beneficiarioId);
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

    /**
     * Retorna as doenças do beneficiário.
     * @param beneficiarioId id do Beneficiário.
     */
    @GetMapping(path = "/{id}/doencas")
    public ResponseEntity<List<Doenca>> getDoencas(@PathVariable(name = "id") Long beneficiarioId) {
        try {
            final Optional<Beneficiario> found = repoBene.findById(beneficiarioId);
            if (found.isPresent()) {
                return ResponseEntity.ok(found.get().getDoencas());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Throwable t){
            //I could customize error messages here
            throw t;
        }
    }

    /**
     * Vincula um beneficiário a uma doença.
     * @param dto objeto dto com os ids do beneficiário e da doença a ser vinculada.
     */
    @PostMapping(path = "doenca")
    public ResponseEntity<String> vinculaBeneficiarioDoenca(@RequestBody BeneficiarioDoencaDTO dto) throws Exception {
        try {
            final Optional<Beneficiario> beneOpt = repoBene.findById(dto.getIdBeneficiario());
            if (!beneOpt.isPresent()) {
                throw new Exception("Beneficiário com ID " + dto.getIdBeneficiario() + " não encontrado.");
            }
            final Optional<Doenca> doencaOpt = repoDoenca.findById(dto.getIdDoenca());
            if (!beneOpt.isPresent()) {
                throw new Exception("Doença com ID " + dto.getIdDoenca() + " não encontrada.");
            }
            final Doenca doenca = doencaOpt.get();
            final Beneficiario beneficiario = beneOpt.get();
            beneficiario.getDoencas().add(doenca);
            repoBene.save(beneficiario);
            return ResponseEntity.ok("Beneficiário " +
                    beneficiario.getNome() +
                    " vinculado à doença " +
                    doenca.getDescricao() +
                    " com sucesso.");
        } catch (Throwable t){
            throw t;
        }
    }

}
