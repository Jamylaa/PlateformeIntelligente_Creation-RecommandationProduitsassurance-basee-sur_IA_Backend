package tn.vermeg.gestionuser.controllers;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import tn.vermeg.gestionproduit.entities.Produit;
import tn.vermeg.gestionuser.entities.Client;
import tn.vermeg.gestionuser.services.ClientService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
@CrossOrigin(origins = "http://localhost:4200")
public class ClientController {

        private final ClientService clientService;
        public ClientController(ClientService clientService) {
            this.clientService = clientService;}

         @GetMapping("/produits")
         public List<Produit> listeProduits() {
        return clientService.getAllProduits();}

        //  ADMIN only
        @PreAuthorize("hasRole('ADMIN')")
        @PostMapping
        public ResponseEntity<Client> createClient(@RequestBody Client client) {
            return ResponseEntity.ok(clientService.createClient(client));}

        @PreAuthorize("hasRole('ADMIN')")
        @GetMapping
        public ResponseEntity<List<Client>> getAllClients() {
            return ResponseEntity.ok(clientService.getAllClients());}

        @PreAuthorize("hasAnyRole('ADMIN','CLIENT')")
        @GetMapping("/{idUser}")
        public ResponseEntity<Client> getClientById(@PathVariable String idUser) {
            return ResponseEntity.ok(clientService.getClientById(idUser));}

        @PreAuthorize("hasRole('ADMIN')")
        @PutMapping("/{idUser}")
        public ResponseEntity<Client> updateClient(
                @PathVariable String idUser,
                @RequestBody Client client) {
            return ResponseEntity.ok(clientService.updateClient(idUser, client));}

        @PreAuthorize("hasRole('ADMIN')")
        @DeleteMapping("/{idUser}")
        public ResponseEntity<String> deleteClient(@PathVariable String idUser) {
            clientService.deleteClient(idUser);
            return ResponseEntity.ok("Client supprimé avec succès !");
        }
    }