package com.socialanime.core.appuser;

import com.socialanime.core.exception.EmailAlreadyRegisteredException;

import java.util.Optional;
import java.util.UUID;

public interface AppUserService {
    AppUserDto registerUser(AppUserDto appUserDto) throws EmailAlreadyRegisteredException;
    void changeUsername(UUID userUUID); //Verificar melhor argumento a se receber para realizar o metodo
    void changePassword(UUID userUUID); //Verificar melhor argumento a se receber para realizar o metodo
    void deleteUserByUUID(UUID userUUID);
    Optional<AppUser> findByUsername(String username);
    Optional<AppUser> findByEmail(String email);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

}
