package tn.vermeg.gestionuser.services;
import org.springframework.stereotype.Service;
import tn.vermeg.gestionuser.entities.Admin;
import tn.vermeg.gestionuser.entities.Client;
import tn.vermeg.gestionuser.repositories.ClientRepository;
import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final EmailService emailService;

    public ClientService(ClientRepository clientRepository, EmailService emailService) {
        this.clientRepository = clientRepository;
        this.emailService = emailService;
    }
    public List<Client> getAllClients() {return clientRepository.findAll();}

    public Client getClientById(String idUser) {
        return clientRepository.findById(idUser)
                .orElseThrow(() -> new RuntimeException("Client not found"));}

    public Client findByUserName(String userName) {return clientRepository.findByUserName(userName);}

    // Création d'un client + envoi d'email
    public Client createClient(Client client) {
        // Sauvegarde du client dans la BDD
        Client savedClient = clientRepository.save(client);

        // Préparer le contenu du mail
        String subject = "Bienvenue sur notre plateforme";
        String body = "Bonjour " + client.getUserName() + ",\n\n" +
                "Votre compte client a été créé avec succès.\n" +
                "Email: " + client.getEmail() + "\n" +
                "Mot de passe: " + client.getPassword() + "\n\n" +
                "Cordialement,\nL'équipe.";

        // Envoi du mail
        emailService.sendEmail(client.getEmail(), subject, body);
        return savedClient;
    }

    // Mise à jour d'un client + envoi par mail

    public Client updateClient(String idUser, Client clientDetails) {

        Client existingClient = clientRepository.findById(idUser)
                .orElseThrow(() -> new RuntimeException("Client non trouvé"));

        existingClient.setUserName(clientDetails.getUserName());
        existingClient.setEmail(clientDetails.getEmail());
        existingClient.setPassword(clientDetails.getPassword());
        existingClient.setPhone(clientDetails.getPhone());
        existingClient.setCompanyName(clientDetails.getCompanyName());
        existingClient.setActive(clientDetails.getActive());
        Client savedClient = clientRepository.save(existingClient);

        // Envoi du mail après modification
        String subject = "Mise à jour de votre compte Client";
        String body = "Bonjour " + savedClient.getUserName() + ",\n\n" +
                "Votre compte a été mis à jour avec succès.\n\n" +
                "Informations actuelles :\n" +
                "Email: " + savedClient.getEmail() + "\n" +
                "Téléphone: " + savedClient.getPhone() + "\n" +
                "Société: " + savedClient.getCompanyName() + "\n\n" +
                "Si vous n'êtes pas à l'origine de cette modification, contactez-nous.\n\n" +
                "Cordialement,\nL'équipe.";

        emailService.sendEmail(savedClient.getEmail(), subject, body);

        return savedClient;
    }

     public void deleteClient(String idUser) {
        Client client = getClientById(idUser);
        clientRepository.delete(client);}

    public Client save(Client client) {return clientRepository.save(client);}

}