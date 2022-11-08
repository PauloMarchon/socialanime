package com.socialanime.core.appuser;

import java.util.UUID;

public interface AppUserService {
    AppUser registerUser(AppUserDto appUserDto);
    void changeUsername(UUID userUUID); //Verificar melhor argumento a se receber para realizar o metodo
    void changePassword(UUID userUUID); //Verificar melhor argumento a se receber para realizar o metodo
    void deleteUserByUUID(UUID userUUID);
    Boolean checkIfExistsByEmail(String email);
    Boolean checkIfExistsByUsername(String username);


}
