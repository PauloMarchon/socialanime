package com.socialanime.core.appuser.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRoleRepository extends JpaRepository<AppUserRole, Integer> {

    Optional<AppUserRole> findByName (EAppUserRole name);
}
