package tn.vermeg.gestionuser.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "users")
public abstract class User {

    @Id
    private String idUser; // MongoDB génère ObjectId
    private String userName;
    private String password;
    private String email;
    private int phone;
    private boolean active=true;

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
// private Role role; // enum
//  public Role getRole() {return role;}
//public void setRole(Role role) {this.role = role;}
