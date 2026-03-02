package tn.vermeg.gestionuser.controllers;
 import com.mongodb.client.internal.ClientSessionClock;
 import org.springframework.http.ResponseEntity;
 import org.springframework.security.access.prepost.PreAuthorize;
 import tn.vermeg.gestionuser.entities.Admin;
import tn.vermeg.gestionuser.entities.Client;
import tn.vermeg.gestionuser.entities.Department;
import tn.vermeg.gestionuser.services.ClientService;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    // 🔒 Seul ADMIN peut créer
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/createClient")
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    @GetMapping("/getAllClients")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/getClientById/{idUser}")
    public Client getClientById(@PathVariable String idUser) {
        return clientService.getClientById(idUser);
    }

    //updateclient
    @PutMapping("/updateClient/{idUser}")
    public ResponseEntity<Client> updateClient(
            @PathVariable String idUser,
            @RequestBody Client client) {
        Client updatedClient = clientService.updateClient(idUser, client);
        return ResponseEntity.ok(updatedClient); }

    //delete
    @DeleteMapping("/deleteClient/{idUser}")
    public ResponseEntity<String> deleteClient(@PathVariable String idUser) {
        clientService.deleteClient(idUser);
        return ResponseEntity.ok("Client supprimé avec succès !");
    }
}

//    //update
//    @PutMapping("/updateClient/{idUser}")
//    public Client updateClient(@PathVariable String idUser,
//            @RequestParam String userName, @RequestParam String email,
//            @RequestParam String password,
//            @RequestParam int phone, @RequestParam String companyName) {
//        return clientService.updateClient(idUser, userName, email, password, phone, companyName);
//    }