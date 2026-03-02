package tn.vermeg.gestionuser.controllers;

import org.springframework.http.ResponseEntity;
import tn.vermeg.gestionuser.entities.Admin;
import tn.vermeg.gestionuser.entities.Client;
import tn.vermeg.gestionuser.entities.Department;
import tn.vermeg.gestionuser.services.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

    private final AdminService adminService;
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/createAdmin")
    public Admin createAdmin(@RequestBody Admin admin) {
        return adminService.createAdmin(admin); }

    @GetMapping("/getAllAdmins")
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("getAdminById/{idUser}")
    public Admin getAdminById(@PathVariable String idUser) {
        return adminService.getAdminById(idUser);
    }
    // Mise à jour avec un objet Admin complet
    @PutMapping("/updateAdmin/{idUser}")
    public ResponseEntity<Admin> updateAdmin(
            @PathVariable String idUser,
            @RequestBody Admin admin) {
        Admin updatedAdmin = adminService.updateAdmin(idUser, admin);
        return ResponseEntity.ok(updatedAdmin);
    }
    //delete
    @DeleteMapping("deleteAdmin/{idUser}")
    public ResponseEntity<String> deleteAdmin(@PathVariable String idUser) {
        adminService.deleteAdmin(idUser);
        return ResponseEntity.ok("Admin supprimé avec succès !");
    }
}
//    public Admin updateAdmin(
//            @PathVariable String idUser,
//            @RequestParam String userName,
//            @RequestParam String email,
//            @RequestParam String password,
//            @RequestParam int phone,
//            @RequestParam Department department
//    ) {
//        return adminService.updateAdmin(idUser, userName, email, password, phone, department);
//    }
