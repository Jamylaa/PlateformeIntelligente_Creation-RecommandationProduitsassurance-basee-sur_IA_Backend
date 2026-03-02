package tn.vermeg.gestionproduit.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.vermeg.gestionproduit.entities.Produit;
import tn.vermeg.gestionproduit.service.ProduitService;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/produits")
public class ProduitController {

    private final ProduitService produitService;

    public ProduitController(ProduitService produitService) {
        this.produitService = produitService;
    }

    @PostMapping
    public Produit createProduit(@RequestBody Produit produit) {
        return produitService.createProduit(produit);
    }

    @GetMapping("/getAllProduits")
    public List<Produit> getAllProduits() {
        return produitService.getAllProduits();
    }

    @GetMapping("/getProduitById/{idProduit}")
    public Produit getProduitById(@PathVariable String idProduit) {
        return produitService.getProduitById(idProduit);
    }

    @PutMapping("/updateProduit/{idProduit}")
    public Produit updateProduit(@PathVariable String idProduit, @RequestBody Produit produit) {
        return produitService.updateProduit(idProduit, produit);
    }

    @DeleteMapping("/deleteProduit/{idProduit}")
    public ResponseEntity<String> deleteProduit(@PathVariable String idProduit) {
        produitService.deleteProduit(idProduit);
        return ResponseEntity.ok("Produit supprimé avec succès !");
    }
}