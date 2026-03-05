package tn.vermeg.gestionproduit.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import tn.vermeg.gestionproduit.entities.Category;
import tn.vermeg.gestionproduit.entities.NiveauRisque;
import tn.vermeg.gestionproduit.entities.Produit;
import tn.vermeg.gestionproduit.entities.StatutProduit;

import java.util.List;
public interface ProduitRepository extends MongoRepository<Produit, String> {
    //List<Produit> findByCategoryAndActiveTrue(Category category);
//    List<Produit> findByCategory(Category category);
//    List<Produit> findByStatut(StatutProduit statut);
//
//    List<Produit> findByNiveauRisque(NiveauRisque niveauRisque);

    List<Produit> findByCategoryAndStatut(Category category, StatutProduit statut);
    List<Produit> findByPrimeBetween(Double min, Double max);
    List<Produit> findByAgeMinAssureLessThanEqualAndAgeMaxAssureGreaterThanEqual(Integer age1, Integer age2);
}