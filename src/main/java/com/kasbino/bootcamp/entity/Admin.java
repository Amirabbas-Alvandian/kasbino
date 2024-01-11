package com.kasbino.bootcamp.entity;

import com.kasbino.bootcamp.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "admin")
public class Admin extends Person{

    public Admin(String name, String lastname, String username, String password) {
        super(name, lastname, username, password,Role.ROLE_ADMIN );
    }

    public Admin() {
        this.role = Role.ROLE_ADMIN;
        this.enabled = true;
    }
    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", enabled=" + enabled +
                '}';
    }
}
