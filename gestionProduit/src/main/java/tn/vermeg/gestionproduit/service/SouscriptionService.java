package tn.vermeg.gestionproduit.service;

import org.springframework.stereotype.Service;
import tn.vermeg.gestionproduit.entities.Produit;
import tn.vermeg.gestionproduit.entities.Souscription;
import tn.vermeg.gestionproduit.entities.StatutProduit;
import tn.vermeg.gestionproduit.exception.ResourceNotFoundException;
import tn.vermeg.gestionproduit.feign.ClientFeign;
import tn.vermeg.gestionproduit.repository.ProduitRepository;
import tn.vermeg.gestionproduit.repository.SouscriptionRepository;

import java.util.Date;
import java.util.List;

@Service
public class SouscriptionService {

    private final SouscriptionRepository souscriptionRepository;
    private final ProduitRepository produitRepository;
    private final ClientFeign clientFeign;

    public SouscriptionService(SouscriptionRepository souscriptionRepository,
                               ProduitRepository produitRepository,
                               ClientFeign clientFeign) {
        this.souscriptionRepository = souscriptionRepository;
        this.produitRepository = produitRepository;
        this.clientFeign = clientFeign;
    }

    private void verifierClientExiste(String idClient) {
        try {
            clientFeign.getClientById(idClient);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Client introuvable dans gestion-user");
        }
    }

    public Souscription souscrire(String idProduit, String idClient) {

        verifierClientExiste(idClient);

        Produit produit = produitRepository.findById(idProduit)
                .orElseThrow(() -> new ResourceNotFoundException("Produit introuvable"));

        if (produit.getStatut() != StatutProduit.ACTIF) {
            throw new RuntimeException("Produit non actif");
        }

        Souscription souscription = new Souscription();
        souscription.setIdProduit(idProduit);
        souscription.setIdClient(idClient);
        souscription.setDateSouscription(new Date());
        souscription.setDateFin(produit.getDateExpiration());
        souscription.setStatut(StatutProduit.ACTIF);

        produit.setNombreSouscriptions(produit.getNombreSouscriptions() + 1);
        produitRepository.save(produit);

        return souscriptionRepository.save(souscription);
    }

    public List<Souscription> getSouscriptionsByClient(String idClient) {
        return souscriptionRepository.findByIdClient(idClient);
    }

    public List<Souscription> getSouscriptionsByProduit(String idProduit) {
        return souscriptionRepository.findByIdProduit(idProduit);
    }
}