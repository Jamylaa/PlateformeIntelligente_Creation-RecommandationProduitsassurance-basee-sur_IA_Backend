package tn.vermeg.gestionproduit.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.vermeg.gestionproduit.entities.Souscription;
import tn.vermeg.gestionproduit.service.SouscriptionService;

import java.util.List;

@RestController
@RequestMapping("/api/souscriptions")
@CrossOrigin("*")
public class SouscriptionController {

    private final SouscriptionService souscriptionService;

    public SouscriptionController(SouscriptionService souscriptionService) {
        this.souscriptionService = souscriptionService;
    }

    @PostMapping("/{idProduit}/{idClient}")
    public ResponseEntity<Souscription> souscrire(
            @PathVariable String idProduit,
            @PathVariable String idClient) {

        return ResponseEntity.status(201)
                .body(souscriptionService.souscrire(idProduit, idClient));
    }

    @GetMapping("/client/{idClient}")
    public ResponseEntity<List<Souscription>> getByClient(@PathVariable String idClient) {
        return ResponseEntity.ok(souscriptionService.getSouscriptionsByClient(idClient));
    }

    @GetMapping("/produit/{idProduit}")
    public ResponseEntity<List<Souscription>> getByProduit(@PathVariable String idProduit) {
        return ResponseEntity.ok(souscriptionService.getSouscriptionsByProduit(idProduit));
    }
}