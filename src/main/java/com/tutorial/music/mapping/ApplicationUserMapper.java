package com.tutorial.music.mapping;

import com.tutorial.music.dto.ApplicationUserRequestDto;
import com.tutorial.music.dto.ApplicationUserResponseDto;
import com.tutorial.music.model.ApplicationUser;
import com.tutorial.music.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ApplicationUserMapper {

    @Mapping(ignore = true, target = "roles")
    ApplicationUser fromRequest(ApplicationUserRequestDto requestDto);

    @Mapping(ignore = true, target = "roles")
    ApplicationUser fromResponse(ApplicationUserResponseDto responseDto);

    @Mapping(ignore = true, target = "password")
    @Mapping(ignore = true, target = "passwordConfirm")
    ApplicationUserResponseDto toResponse(ApplicationUser applicationUser);

    default String toRoleDto(Role role) {
        if (role == null) {
            return null;
        }
        return role.getName();
    }

}
