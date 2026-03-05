package tn.vermeg.gestionproduit.service;

import org.springframework.stereotype.Service;
import tn.vermeg.gestionproduit.entities.Produit;
import tn.vermeg.gestionproduit.entities.StatutProduit;
import tn.vermeg.gestionproduit.repository.ProduitRepository;
import java.util.Date;
import java.util.List;

@Service
public class ProduitService {

        private final ProduitRepository produitRepository;

        public ProduitService(ProduitRepository produitRepository) {
            this.produitRepository = produitRepository;}

    public double calculRiskScore(Produit produit) {
        double score = 0;

        if (produit.getTauxSinistralite() != null)
            score += produit.getTauxSinistralite() * 50;

        if (produit.getFranchise() != null && produit.getFranchise() > 1000)
            score += 10;

        if (produit.getPrime() != null && produit.getPrime() > 2000)
            score += 20;

        return score;
    }
        //  Créer un produit
        public Produit createProduit(Produit produit) {

            produit.setDateCreation(new Date());
            produit.setStatut(StatutProduit.ACTIF);
            produit.setNombreSouscriptions(0);
            produit.setTauxSinistralite(0.0);
            produit.setRiskScore(0.0);
            produit.setScoreRecommandation(0.0);
            return produitRepository.save(produit);
        }

        //  Récupérer tous les produits
        public List<Produit> getAllProduits() {return produitRepository.findAll();}

        //  Récupérer un produit par ID
        public Produit getProduitById(String idProduit) {
            return produitRepository.findById(idProduit)
                    .orElseThrow(() -> new RuntimeException("Produit non trouvé")); }

        //  Mettre à jour produit (version propre)
        public Produit updateProduit(String idProduit, Produit updatedProduit) {

            Produit produit = getProduitById(idProduit);

            produit.setNomProduit(updatedProduit.getNomProduit());
            produit.setDescription(updatedProduit.getDescription());
            produit.setCategory(updatedProduit.getCategory());
            produit.setStatut(updatedProduit.getStatut());
            produit.setDateExpiration(updatedProduit.getDateExpiration());
            produit.setDevise(updatedProduit.getDevise());

            produit.setPrime(updatedProduit.getPrime());
            produit.setFranchise(updatedProduit.getFranchise());
            produit.setTauxRemboursement(updatedProduit.getTauxRemboursement());
            produit.setMontantMaxRemboursement(updatedProduit.getMontantMaxRemboursement());

            produit.setAgeMinAssure(updatedProduit.getAgeMinAssure());
            produit.setAgeMaxAssure(updatedProduit.getAgeMaxAssure());
            produit.setDureeContrat(updatedProduit.getDureeContrat());
            produit.setRenouvelable(updatedProduit.getRenouvelable());
            produit.setPeriodeAttente(updatedProduit.getPeriodeAttente());

            produit.setModePaiement(updatedProduit.getModePaiement());
            produit.setBonusMalus(updatedProduit.getBonusMalus());

            produit.setGarantiesIds(updatedProduit.getGarantiesIds());
            produit.setCompanyId(updatedProduit.getCompanyId());

            produit.setVersion(produit.getVersion() + 1);
            produit.setRiskScore(calculRiskScore(produit));
            return produitRepository.save(produit);
        }

        //  Suppression
        public void deleteProduit(String idProduit) {
            Produit produit = getProduitById(idProduit);
            produitRepository.delete(produit);}
    }

// Méthode pour souscrire un produit
// public Produit souscrireProduit(String idProduit, String idClient) {
//   Produit produit = produitRepository.findById(idProduit)
//                .orElseThrow(() -> new RuntimeException("Produit non trouvé"));
//
//        Client client = clientRepository.findById(idClient)
//                .orElseThrow(() -> new RuntimeException("Client non trouvé"));
//
//        // Vérification âge et conditions (exemple pour âge)
//        if (produit.getAgeMinAssure() != null && produit.getAgeMaxAssure() != null) {
//            // Supposons que le client a un champ 'age' (à ajouter si nécessaire)
//            // if (client.getAge() < produit.getAgeMinAssure() || client.getAge() > produit.getAgeMaxAssure()) {
//            //    throw new RuntimeException("Client hors tranche d'âge autorisée pour ce produit");
//            //}
//        }

// Ajouter le client à la liste des clients du produit
//        if (!produit.getClientIds().contains(idClient)) {
//            produit.getClientIds().add(idClient);
//            produit.setNombreSouscriptions(
//                    produit.getNombreSouscriptions() != null ? produit.getNombreSouscriptions() + 1 : 1
//            );
//        }






    // Créer un produit
//    public Produit createProduit(Produit produit) {
//        return produitRepository.save(produit);}

    // Récupérer tous les produits
//    public List<Produit> getAllProduits() {
//        return produitRepository.findAll();}

    // Récupérer un produit par id
//    public Produit getProduitById(String idProduit) {
//        return produitRepository.findById(idProduit)
//                .orElseThrow(() -> new RuntimeException("Produit non trouvé"));}

    // Mettre à jour un produit
//    public Produit updateProduit(String idProduit, Produit updatedProduit) {
//        Produit produit = getProduitById(idProduit);
//
//        produit.setNomProduit(updatedProduit.getNomProduit());
//        produit.setEffectiveDate(updatedProduit.getEffectiveDate());
//        produit.setVersion(updatedProduit.getVersion());
//        produit.setCategory(updatedProduit.getCategory());
//        produit.setMinScore(updatedProduit.getMinScore());
//        produit.setBasePrice(updatedProduit.getBasePrice());
//        produit.setCoverageDuration(updatedProduit.getCoverageDuration());
//        produit.setCapital(updatedProduit.getCapital());
//        produit.setNombreBeneficiaries(updatedProduit.getNombreBeneficiaries());
//        produit.setActive(updatedProduit.getActive());
//
//        return produitRepository.save(produit);
//    }

    // Supprimer un produit
//    public void deleteProduit(String idProduit) {
//        Produit produit = getProduitById(idProduit);
//        produitRepository.delete(produit);}
