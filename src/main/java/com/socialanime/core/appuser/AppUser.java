package com.socialanime.core.appuser;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class AppUser {

    @Id
    @GeneratedValue
    private UUID uuid;
    private String username;
    private String email;
    private String password;
    private LocalDate creationDate;

    public AppUser(String username, String email, String password, LocalDate creationDate) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.creationDate = creationDate.getChronology().dateNow();
    }

}
