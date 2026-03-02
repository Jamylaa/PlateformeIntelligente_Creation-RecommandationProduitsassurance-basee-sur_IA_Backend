package tn.vermeg.gestionproduit.service;

import org.springframework.stereotype.Service;
import tn.vermeg.gestionproduit.entities.Produit;
import tn.vermeg.gestionproduit.entities.Category;
import tn.vermeg.gestionproduit.repository.ProduitRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProduitService {

    private final ProduitRepository produitRepository;

    public ProduitService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;}

    // Créer un produit
    public Produit createProduit(Produit produit) {
        return produitRepository.save(produit);}

    // Récupérer tous les produits
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();}

    // Récupérer un produit par id
    public Produit getProduitById(String idProduit) {
        return produitRepository.findById(idProduit)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé"));}

    // Mettre à jour un produit
    public Produit updateProduit(String idProduit, Produit updatedProduit) {
        Produit produit = getProduitById(idProduit);

        produit.setNomProduit(updatedProduit.getNomProduit());
        produit.setEffectiveDate(updatedProduit.getEffectiveDate());
        produit.setVersion(updatedProduit.getVersion());
        produit.setCategory(updatedProduit.getCategory());
        produit.setMinScore(updatedProduit.getMinScore());
        produit.setBasePrice(updatedProduit.getBasePrice());
        produit.setCoverageDuration(updatedProduit.getCoverageDuration());
        produit.setCapital(updatedProduit.getCapital());
        produit.setNombreBeneficiaries(updatedProduit.getNombreBeneficiaries());
        produit.setActive(updatedProduit.getActive());

        return produitRepository.save(produit);
    }

    // Supprimer un produit
    public void deleteProduit(String idProduit) {
        Produit produit = getProduitById(idProduit);
        produitRepository.delete(produit);}
}