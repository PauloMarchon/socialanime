package com.socialanime.core.appuser;

import com.socialanime.core.util.BaseMapper;
import org.springframework.beans.BeanUtils;

public class AppUserMapper extends BaseMapper<AppUser, AppUserDto> {

    @Override
    public AppUser convertToEntity(AppUserDto dto, Object... args) {
        AppUser appUserEntity = new AppUser();
        if (dto != null)
            BeanUtils.copyProperties(dto, appUserEntity);

        return appUserEntity;
    }

    @Override
    public AppUserDto convertToDto(AppUser appUserEntity, Object... args) {
        AppUserDto appUserDto = new AppUserDto();

        if (appUserEntity != null)
            BeanUtils.copyProperties(appUserEntity, appUserDto);

        return appUserDto;
    }
}
