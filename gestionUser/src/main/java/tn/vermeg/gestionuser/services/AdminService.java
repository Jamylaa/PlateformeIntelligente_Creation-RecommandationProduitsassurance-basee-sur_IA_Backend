package tn.vermeg.gestionuser.services;

import org.springframework.stereotype.Service;
import tn.vermeg.gestionuser.entities.Admin;
import tn.vermeg.gestionuser.entities.Department;
import tn.vermeg.gestionuser.entities.User;
import tn.vermeg.gestionuser.repositories.AdminRepository;

import java.util.List;

@Service
public class AdminService {
    private final AdminRepository adminRepository;
    private final EmailService emailService;

    public AdminService(AdminRepository adminRepository, EmailService emailService) {
        this.adminRepository = adminRepository;
        this.emailService = emailService;
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Admin getAdminById(String idUser) {
        return adminRepository.findById(idUser)
                .orElseThrow(() -> new RuntimeException("Admin not found"));
    }
    // Mettre à jour un admin avec un objet Admin complet + envoi par mail
    public Admin updateAdmin(String idUser, Admin updatedAdmin) {
        Admin admin = getAdminById(idUser);

        admin.setUserName(updatedAdmin.getUserName());
        admin.setEmail(updatedAdmin.getEmail());
        admin.setPassword(updatedAdmin.getPassword());
        admin.setPhone(updatedAdmin.getPhone());
        admin.setDepartment(updatedAdmin.getDepartment());
        admin.setActive(updatedAdmin.getActive());
        Admin savedAdmin = adminRepository.save(admin);

        // Envoi du mail après modification
        String subject = "Mise à jour de votre compte Admin";
        String body = "Bonjour " + savedAdmin.getUserName() + ",\n\n" +
                "Votre compte admin a été mis à jour avec succès.\n\n" +
                "Nouvelles informations :\n" +
                "Email: " + savedAdmin.getEmail() + "\n" +
                "Téléphone: " + savedAdmin.getPhone() + "\n\n" +
                "Si vous n'êtes pas à l'origine de cette modification, veuillez contacter l'administrateur.\n\n" +
                "Cordialement,\nL'équipe.";

        emailService.sendEmail(savedAdmin.getEmail(), subject, body);

        return savedAdmin;
    }

    //create Admin+ envoi par mail
    public Admin createAdmin(Admin admin) {
        Admin savedAdmin = adminRepository.save(admin);

        // Envoi du mail après création
        String subject = "Bienvenue dans le système";
        String body = "Bonjour " + admin.getUserName() + ",\n\n" +
                "Votre compte admin a été créé avec succès.\n" +
                "Email: " + admin.getEmail() + "\n" +
                "Mot de passe: " + admin.getPassword() + "\n\n" +
                "Cordialement,\nL'équipe.";
        emailService.sendEmail(admin.getEmail(), subject, body);

        return savedAdmin;
    }
    public void deleteAdmin(String idUser) {Admin admin = getAdminById(idUser);
        adminRepository.delete(admin);}
    public Admin findByUserName(String userName) { return adminRepository.findByUserName(userName);}
    public Admin save(Admin admin) {return adminRepository.save(admin); }

}