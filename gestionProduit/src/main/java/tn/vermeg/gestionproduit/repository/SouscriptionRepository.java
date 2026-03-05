package tn.vermeg.gestionproduit.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tn.vermeg.gestionproduit.entities.Souscription;

import java.util.List;

@Repository
public interface SouscriptionRepository extends MongoRepository<Souscription, String> {
    List<Souscription> findByIdClient(String idClient);
    List<Souscription> findByIdProduit(String idPoduit);
}