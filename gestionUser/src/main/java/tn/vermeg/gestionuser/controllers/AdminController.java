package tn.vermeg.gestionuser.controllers;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import tn.vermeg.gestionuser.entities.Admin;
import tn.vermeg.gestionuser.services.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

        private final AdminService adminService;

        public AdminController(AdminService adminService) {
            this.adminService = adminService;}

        @PreAuthorize("hasRole('ADMIN')")
        @PostMapping("/createAdmin")
        public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
            return ResponseEntity.ok(adminService.createAdmin(admin));
        }

        @PreAuthorize("hasRole('ADMIN')")
        @GetMapping("/getAllAdmins")
        public ResponseEntity<List<Admin>> getAllAdmins() {
            return ResponseEntity.ok(adminService.getAllAdmins());
        }

        @PreAuthorize("hasRole('ADMIN')")
        @GetMapping("/getAdminById/{idUser}")
        public ResponseEntity<Admin> getAdminById(@PathVariable String idUser) {
            return ResponseEntity.ok(adminService.getAdminById(idUser));}

        @PreAuthorize("hasRole('ADMIN')")
        @PutMapping("/updateAdmin/{idUser}")
        public ResponseEntity<Admin> updateAdmin(
                @PathVariable String idUser,
                @RequestBody Admin admin) {
            return ResponseEntity.ok(adminService.updateAdmin(idUser, admin));
        }

        @PreAuthorize("hasRole('ADMIN')")
        @DeleteMapping("/deleteAdmin/{idUser}")
        public ResponseEntity<String> deleteAdmin(@PathVariable String idUser) {
            adminService.deleteAdmin(idUser);
            return ResponseEntity.ok("Admin supprimé avec succès !");
        }
    }
