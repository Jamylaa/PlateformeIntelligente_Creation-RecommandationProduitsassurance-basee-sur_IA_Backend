package tn.vermeg.gestionuser.services;
 import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.vermeg.gestionproduit.entities.Produit;
import tn.vermeg.gestionuser.entities.Client;
import tn.vermeg.gestionuser.feign.ProduitFeignClient;
import tn.vermeg.gestionuser.repositories.ClientRepository;
import java.util.Date;
import java.util.List;

@Service
public class ClientService {
        private final ProduitFeignClient produitFeignClient;
        private final ClientRepository clientRepository;
        private final EmailService emailService;
        private final PasswordEncoder passwordEncoder;

    public List<Produit> getAllProduits() {
        return produitFeignClient.getAllProduits();
    }
        public ClientService(ClientRepository clientRepository,
                             EmailService emailService,
                             ProduitFeignClient produitFeignClient,
                             PasswordEncoder passwordEncoder) {
            this.clientRepository = clientRepository;
            this.emailService = emailService;
            this.produitFeignClient = produitFeignClient;
            this.passwordEncoder = passwordEncoder;
        }

        //CREATE CLIENT
        public Client createClient(Client client) {

            client.setRole("ROLE_CLIENT");
            client.setDateCreation(new Date());
            client.setActive(true);
            client.setRiskProfileScore(0.0);
            client.setNombreSinistres(0);
            client.setMontantTotalRembourse(0.0);

            // 🔐 Encodage password
            client.setPassword(passwordEncoder.encode(client.getPassword()));

            Client savedClient = clientRepository.save(client);
            emailService.sendEmail(
                    savedClient.getEmail(),
                    "Bienvenue",
                    "Votre compte a été créé avec succès."
            );

            return savedClient;
        }
        //  GET ALL
        public List<Client> getAllClients() {
            return clientRepository.findAll();
        }

        //  GET BY ID
        public Client getClientById(String idUser) {
            return clientRepository.findById(idUser)
                    .orElseThrow(() -> new RuntimeException("Client not found"));
        }
        //  UPDATE
        public Client updateClient(String idUser, Client clientDetails) {
            Client client = getClientById(idUser);
            client.setUserName(clientDetails.getUserName());
            client.setEmail(clientDetails.getEmail());
            client.setPhone(clientDetails.getPhone());
            client.setCompanyName(clientDetails.getCompanyName());
            client.setSecteurActivite(clientDetails.getSecteurActivite());
            client.setChiffreAffaires(clientDetails.getChiffreAffaires());
            client.setNombreEmployes(clientDetails.getNombreEmployes());
            client.setAdresse(clientDetails.getAdresse());
            client.setActive(clientDetails.getActive());
            // 🔐 Si password modifié
            if (clientDetails.getPassword() != null &&
                    !clientDetails.getPassword().isEmpty()) {
                client.setPassword(passwordEncoder.encode(clientDetails.getPassword()));
            }

            return clientRepository.save(client);
        }

        //  DELETE
        public void deleteClient(String idUser) {
            Client client = getClientById(idUser);
            clientRepository.delete(client);
        }
    }