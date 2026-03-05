package tn.vermeg.gestionuser.controllers;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import tn.vermeg.gestionuser.dto.AuthRequest;
import tn.vermeg.gestionuser.dto.RegisterRequest;
import tn.vermeg.gestionuser.entities.Admin;
import tn.vermeg.gestionuser.entities.Client;
import tn.vermeg.gestionuser.repositories.AdminRepository;
import tn.vermeg.gestionuser.repositories.ClientRepository;
import tn.vermeg.gestionuser.services.AdminService;
import tn.vermeg.gestionuser.services.ClientService;
import tn.vermeg.gestionuser.utils.JwtUtil;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

        private final AdminService adminService;
       // private final ClientService clientService;
        private final PasswordEncoder passwordEncoder;
    private final AdminRepository adminRepository;
    private final ClientRepository clientRepository;

    @GetMapping("/token")
    public String getToken() {
        return JwtUtil.generateToken("user1", "client");
    }
    public AuthController(AdminService adminService,
                          PasswordEncoder passwordEncoder,
                          AdminRepository adminRepository, ClientRepository clientRepository) {
            this.adminService = adminService;
          //  this.clientService = clientService;
            this.passwordEncoder = passwordEncoder;
        this.adminRepository = adminRepository;
        this.clientRepository = clientRepository;
    }

        //  REGISTER ADMIN
        @PostMapping("/register/admin")
        public ResponseEntity<?> registerAdmin(@RequestBody RegisterRequest request) {

            if (adminRepository.findByUserName(request.getUserName()) != null) {
                return ResponseEntity.badRequest().body("Username already exists");
            }

            Admin admin = new Admin();
            admin.setUserName(request.getUserName());
            admin.setPassword(request.getPassword()); //  pAS d'encodage ici
            admin.setEmail(request.getEmail());
            admin.setPhone(request.getPhone());
            admin.setDepartment(request.getDepartment());

            Admin savedAdmin = adminService.createAdmin(admin);

            String token = JwtUtil.generateToken(
                    savedAdmin.getUserName(),
                    "ROLE_ADMIN"
            );

            return ResponseEntity.ok(token);
        }

        //  LOGIN  ====
        @PostMapping("/login")
        public ResponseEntity<?> login(@RequestBody AuthRequest request) {
            // 🔹 Vérification ADMIN
            Admin admin = adminRepository.findByUserName(request.getUserName());

            if (admin != null &&
                    passwordEncoder.matches(request.getPassword(), admin.getPassword())) {

                String token = JwtUtil.generateToken(
                        admin.getUserName(),
                        "ROLE_ADMIN"
                );

                return ResponseEntity.ok(token);
            }

            // 🔹 Vérification CLIENT
            Client client = clientRepository.findByUserName(request.getUserName());

            if (client != null &&
                    passwordEncoder.matches(request.getPassword(), client.getPassword())) {

                String token = JwtUtil.generateToken(
                        client.getUserName(),
                        "ROLE_CLIENT"
                );
                return ResponseEntity.ok(token);
            }
            return ResponseEntity.status(401).body("Identifiants incorrects");
        }
    }