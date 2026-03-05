package tn.vermeg.gestionuser.dto;
import tn.vermeg.gestionuser.entities.Department;

public class RegisterRequest {

    private String userName;
    private String password;
    private String email;
    private int phone;
    private Department department;
    private String companyName;

    public Department getDepartment() {return department;}
    public void setDepartment(Department department) {this.department = department;}
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    public String getCompanyName() {return companyName;}
    public void setCompanyName(String companyName) {this.companyName = companyName ;}
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public int getPhone() { return phone; }
    public void setPhone(int phone) { this.phone = phone; }
}
// private Role role;