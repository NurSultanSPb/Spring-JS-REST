package com.nurs_projects.springjsrest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nurs_projects.springjsrest.db.StandartRoles;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "role")
@Getter
@Setter
public class Role implements GrantedAuthority {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role", unique = true)
    private String role;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();

    public Role() {}


    public Role(StandartRoles standartRole){
        this.role = standartRole.name();
    }

    public Role(Long id, String role) {
        this.id = id;
        this.role = role;
    }

    public void addUserToRole(User user){
        users.add(user);
    }

    public void addUsersToRole(User ... user){
        users.addAll(Arrays.asList(user));
    }

    @Override
    @JsonIgnore
    public String getAuthority() {
        return role;
    }

    @Override
    public String toString() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role1 = (Role) o;
        return Objects.equals(role, role1.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role);
    }
}
