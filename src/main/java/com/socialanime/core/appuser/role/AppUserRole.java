package com.socialanime.core.appuser.role;

import javax.persistence.*;

@Entity
@Table(name = "appuser_role")
public class AppUserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "role_name", unique = true)
    @Enumerated(EnumType.STRING)
    private EAppUserRole name;

    public AppUserRole(){}

    public AppUserRole(EAppUserRole name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }
    public EAppUserRole getName() {
        return name;
    }
}
