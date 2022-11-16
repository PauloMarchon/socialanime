package com.socialanime.core.appuser;

import com.socialanime.core.exception.EmailAlreadyRegisteredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/appuser")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @PostMapping("/register")
     public ResponseEntity<AppUserDto> registerAppUser(@RequestBody AppUserDto appUserDto){
        return ResponseEntity.ok(appUserService.registerUser(appUserDto));
    }

}
