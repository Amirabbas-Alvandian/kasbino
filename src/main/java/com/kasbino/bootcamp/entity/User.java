package com.kasbino.bootcamp.entity;

import com.kasbino.bootcamp.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
public class User extends Person{

    public User(String name, String lastname, String username, String password) {
        super(name, lastname, username, password, Role.ROLE_USER);
    }

    public User() {
        this.role = Role.ROLE_USER;
        this.enabled = true;
    }

    @Override
    public String toString() {
        return "User{" +
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
