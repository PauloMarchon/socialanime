package com.socialanime.core.appuser;

import com.socialanime.core.appuser.role.AppUserRole;
import com.socialanime.core.appuser.role.AppUserRoleRepository;
import com.socialanime.core.appuser.role.EAppUserRole;
import com.socialanime.core.exception.EmailAlreadyRegisteredException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService{

    private final PasswordEncoder passwordEncoder;
    private final AppUserRepository userRepository;
    private final AppUserRoleRepository appUserRoleRepository;

    @Override
    @Transactional
    public AppUserDto registerUser(AppUserDto appUserDto) throws EmailAlreadyRegisteredException {

        if (existsByEmail(appUserDto.getEmail())) {
            throw new EmailAlreadyRegisteredException();
        } else {
            AppUser newAppUser = new AppUser();
            newAppUser.setUsername(appUserDto.getUsername());
            newAppUser.setEmail(appUserDto.getEmail());
            newAppUser.setPassword(passwordEncoder.encode(
                    appUserDto.getPassword())
            );
            newAppUser.setRoles(
                    setDefaultRoleToNewUser()
            );
            userRepository.save(newAppUser);

            return appUserDto;
        }
    }

    @Override
    public void changeUsername(UUID userUUID) {
        //A FAzer
    }

    @Override
    public void changePassword(UUID userUUID) {
        //A fazer
    }

    @Override
    @Transactional
    public void deleteUserByUUID(UUID userUUID) {
        userRepository.deleteById(userUUID);
    }

    @Override
    public Optional<AppUser> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<AppUser> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
       return userRepository.existsByEmail(email);
    }

    public Collection<AppUserRole> setDefaultRoleToNewUser(){

        Set<AppUserRole> roles = new HashSet<>();

        Optional<AppUserRole> userRole = appUserRoleRepository.findByName(EAppUserRole.USER);

        if (userRole.isPresent()){
            roles.add(userRole.get());
        }
        return roles;
    }

}
