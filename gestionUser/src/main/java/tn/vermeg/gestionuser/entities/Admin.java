package tn.vermeg.gestionuser.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "admins")
public class Admin extends User {
    private Department department;

    public Department getDepartment() {return department;}
    public void setDepartment(Department department) {this.department = department;}
}