package com.socialanime.core.appuser;

import com.socialanime.core.appuser.role.AppUserRole;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.repository.Temporal;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID uuid;

    @NotBlank(message = "{username.not.blank}")
    @Column(nullable = false, unique = true, length = 20)
    private String username;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "{email.not.blank}")
    @Email(message = "{email.not.valid}")
    private String email;

    @Column(length = 30)
    @NotBlank(message = "{password.not.blank}")
    private String password;

    @OneToMany
    private Collection<AppUserRole> roles;

    @CreatedDate
    private LocalDate creationDate;

    private Boolean activeAccount = false;  //via email validation

    public AppUser() {   }
    public AppUser(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.creationDate = LocalDate.now();
    }

    public AppUser(String username, String email, String password, Set<AppUserRole> roles) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.creationDate = LocalDate.now();
    }

    public UUID getUuid() { return uuid; }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Collection<AppUserRole> getRoles() {return roles;}
    public void setRoles(Collection<AppUserRole> roles) {this.roles = roles;}
    public LocalDate getCreationDate() {
        return creationDate;
    }
    public Boolean getActiveAccount() {return activeAccount;}
    public void setActiveAccount(Boolean activeAccount) {this.activeAccount = activeAccount;}
}
