package tn.vermeg.gestionuser.repositories;

 import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tn.vermeg.gestionuser.entities.Client;

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {
 Client findByUserName(String userName);
}