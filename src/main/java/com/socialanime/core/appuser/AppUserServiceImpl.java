package com.socialanime.core.appuser;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService{

    private final AppUserRepository userRepository;

    @Override
    public AppUser registerUser(AppUserDto appUserDto) {

        return null;
    }

    @Override
    public void changeUsername(UUID userUUID) {

    }

    @Override
    public void changePassword(UUID userUUID) {

    }

    @Override
    public void deleteUserByUUID(UUID userUUID) {

    }

    @Override
    public Boolean checkIfExistsByEmail(String email) {
        return null;
    }

    @Override
    public Boolean checkIfExistsByUsername(String username) {
        return null;
    }

}
