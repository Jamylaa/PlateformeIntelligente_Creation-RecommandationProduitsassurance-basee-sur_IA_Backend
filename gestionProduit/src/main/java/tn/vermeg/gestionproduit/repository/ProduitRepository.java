package tn.vermeg.gestionproduit.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import tn.vermeg.gestionproduit.entities.Category;
import tn.vermeg.gestionproduit.entities.Produit;

import java.util.List;

public interface ProduitRepository extends MongoRepository<Produit, String> {
    List<Produit> findByCategoryAndActiveTrue(Category category);
    // Tu peux ajouter des requêtes personnalisées si besoin
}