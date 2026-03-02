package tn.vermeg.gestionuser.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import tn.vermeg.gestionuser.config.JwtUtil;
import tn.vermeg.gestionuser.dto.AuthRequest;
import tn.vermeg.gestionuser.dto.RegisterRequest;
import tn.vermeg.gestionuser.entities.Admin;
import tn.vermeg.gestionuser.entities.Client;
import tn.vermeg.gestionuser.services.AdminService;
import tn.vermeg.gestionuser.services.ClientService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AdminService adminService;
    private final ClientService clientService;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthController(AdminService adminService, ClientService clientService) {
        this.adminService = adminService;
        this.clientService = clientService;
    }

    // ---------------- LOGIN ----------------
    @PostMapping("/registerAdmin")
    public ResponseEntity<?> registerAdmin(@RequestBody RegisterRequest request) {

        if (adminService.findByUserName(request.getUserName()) != null) {
            return ResponseEntity.badRequest().body("Username already exists");
        }

        Admin admin = new Admin();
        admin.setUserName(request.getUserName());
        admin.setPassword(passwordEncoder.encode(request.getPassword()));
        admin.setEmail(request.getEmail());
        admin.setPhone(request.getPhone());
        admin.setDepartment(request.getDepartment());

        adminService.save(admin);

        // 🔹 rôle simple
        String token = JwtUtil.generateToken(admin.getUserName(), "admin");
        return ResponseEntity.ok(token);
    }
//    @PostMapping("/registerAdmin")
//    public ResponseEntity<?> registerAdmin(@RequestBody RegisterRequest request) {
//
//        if (adminService.findByUserName(request.getUserName()) != null) {
//            return ResponseEntity.badRequest().body("Username already exists");
//        }
//
//        Admin admin = new Admin();
//        admin.setUserName(request.getUserName());
//        admin.setPassword(passwordEncoder.encode(request.getPassword()));
//        admin.setEmail(request.getEmail());
//        admin.setPhone(request.getPhone());
//        //  admin.setRole(Role.admin);
//        admin.setDepartment(request.getDepartment()); // si tu passes le département
//        adminService.save(admin);
//        String token = JwtUtil.generateToken(admin.getUserName(), "admin");
//        return ResponseEntity.ok(token);
//    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {

        // Vérification admin
        Admin admin = adminService.findByUserName(request.getUserName());
        if (admin != null && passwordEncoder.matches(request.getPassword(), admin.getPassword())) {
            // 🔹 Ne pas mettre ROLE_ dans le token, juste "admin"
            String token = JwtUtil.generateToken(admin.getUserName(), "admin");
            return ResponseEntity.ok(token);
        }

        // Vérification client
        Client client = clientService.findByUserName(request.getUserName());
        if (client != null && passwordEncoder.matches(request.getPassword(), client.getPassword())) {
            String token = JwtUtil.generateToken(client.getUserName(), "client");
            return ResponseEntity.ok(token);
        }

        return ResponseEntity.status(401).body("Identifiants incorrects");
    }
}

//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
//
//        // Vérification admin
//        Admin admin = adminService.findByUserName(request.getUserName());
//        if (admin != null && passwordEncoder.matches(request.getPassword(), admin.getPassword())) {
//            String token = JwtUtil.generateToken(admin.getUserName(), "ROLE_ADMIN");            return ResponseEntity.ok(token);
//        }
//
//        // Vérification client
//        Client client = clientService.findByUserName(request.getUserName());
//        if (client != null && passwordEncoder.matches(request.getPassword(), client.getPassword())) {
//            String token = JwtUtil.generateToken(client.getUserName(), "ROLE_CLIENT");            return ResponseEntity.ok(token);
//        }
//
//        // Si aucun ne correspond
//        return ResponseEntity.status(401).body("Identifiants incorrects");
//    }
//}
    // ---------------- REGISTER CLIENT ----------------
//    @PostMapping("/register")
//    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
//
//        // Vérifier si username existe déjà
//        if (clientService.findByUserName(request.getUserName()) != null) {
//            return ResponseEntity.badRequest().body("Username already exists");
//        }
//
//        // Créer client
//        Client client = new Client();
//        client.setUserName(request.getUserName());
//        client.setPassword(passwordEncoder.encode(request.getPassword())); // Hash du mot de passe
//        client.setEmail(request.getEmail());
//        client.setPhone(request.getPhone());
//        client.setRole(Role.client);
//        client.setCompanyName(request.getCompanyName());
//        clientService.save(client);
//
//        // Générer JWT après inscription
//        String token = JwtUtil.generateToken(client.getUserName(), "client");
//        return ResponseEntity.ok(token);
//    }
