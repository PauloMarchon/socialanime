package com.socialanime.core.appuser;

import java.util.UUID;

public interface AppUserService {

    AppUser registerUser(AppUserDto appUserDto);

    //verificar melhor forma
    void changeUsername(UUID userUUID);

    void changePassword(UUID userUUID);

    void deleteUserByUUID(UUID userUUID);


}
