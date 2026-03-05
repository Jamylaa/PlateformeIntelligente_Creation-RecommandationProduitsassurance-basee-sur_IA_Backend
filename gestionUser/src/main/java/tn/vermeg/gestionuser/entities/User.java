package tn.vermeg.gestionuser.entities;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
@Document(collection = "users")
public abstract class User {

    @Id
    private String idUser;  //MongoDB génère ObjectId
    private String userName;
    private String password;
    private String email;
    private int phone;
    private boolean active=true;
    private Date dateCreation;
    private Date lastLogin;
    private String role; // ADMIN, CLIENT

    public User(String role, Date lastLogin,
                Date dateCreation, boolean active, int phone, String email,
                String password, String userName, String idUser) {
        this.role = role;
        this.lastLogin = lastLogin;
        this.dateCreation = dateCreation;
        this.active = active;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.idUser = idUser;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public Date getLastLogin() {
        return lastLogin;
    }
    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }
    public Date getDateCreation() {
        return dateCreation;
    }
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public Boolean getActive() {return active;}
    public void setActive(Boolean active) {this.active = active;}
    public String getIdUser() {return idUser;}
    public void setIdUser(String idUser) {this.idUser = idUser;}
    public String getUserName() {return userName;}
    public void setUserName(String userName) {this.userName = userName;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public int getPhone() {return phone;}
    public void setPhone(int phone) {this.phone = phone;}
    public User() {}
    public User(String idUser, String userName,
                String password, String email,
                int phone, Boolean active) {
        this.idUser = idUser;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.active = active;
    }
}