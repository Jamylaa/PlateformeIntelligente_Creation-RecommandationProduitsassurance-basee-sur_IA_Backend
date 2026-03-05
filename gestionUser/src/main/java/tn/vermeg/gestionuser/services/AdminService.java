package tn.vermeg.gestionuser.services;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.vermeg.gestionuser.entities.Admin;
import tn.vermeg.gestionuser.repositories.AdminRepository;
import java.util.Date;
import java.util.List;

@Service
public class AdminService {

        private final AdminRepository adminRepository;
        private final EmailService emailService;
        private final PasswordEncoder passwordEncoder;

        public AdminService(AdminRepository adminRepository,
                            EmailService emailService,
                            PasswordEncoder passwordEncoder) {
            this.adminRepository = adminRepository;
            this.emailService = emailService;
            this.passwordEncoder = passwordEncoder;
        }
        // CREATE ADMIN
        public Admin createAdmin(Admin admin) {
            admin.setRole("ROLE_ADMIN");
            admin.setDateCreation(new Date());
            admin.setActive(true);
            admin.setPassword(passwordEncoder.encode(admin.getPassword()));
            Admin savedAdmin = adminRepository.save(admin);

            emailService.sendEmail(
                    savedAdmin.getEmail(),
                    "Compte Admin créé",
                    "Votre compte administrateur a été créé."
            );
            return savedAdmin;
        }
        //  GET ALL
        public List<Admin> getAllAdmins() {
            return adminRepository.findAll();
        }
        //  GET BY ID
        public Admin getAdminById(String idUser) {
            return adminRepository.findById(idUser)
                    .orElseThrow(() -> new RuntimeException("Admin not found"));
        }
        //  UPDATE
        public Admin updateAdmin(String idUser, Admin updatedAdmin) {
            Admin admin = getAdminById(idUser);
            admin.setUserName(updatedAdmin.getUserName());
            admin.setEmail(updatedAdmin.getEmail());
            admin.setPhone(updatedAdmin.getPhone());
            admin.setDepartment(updatedAdmin.getDepartment());
            admin.setActive(updatedAdmin.getActive());

            if (updatedAdmin.getPassword() != null &&
                    !updatedAdmin.getPassword().isEmpty()) {
                admin.setPassword(passwordEncoder.encode(updatedAdmin.getPassword()));
            }

            return adminRepository.save(admin);
        }
        //  DELETE
        public void deleteAdmin(String idUser) {
            Admin admin = getAdminById(idUser);
            adminRepository.delete(admin);
        }
    }