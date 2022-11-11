package com.tutorial.music.service;

import com.tutorial.music.dto.ApplicationUserRequestDto;
import com.tutorial.music.dto.ApplicationUserResponseDto;
import com.tutorial.music.exception.ResourceNotFoundException;
import com.tutorial.music.exception.UserExistsAlreadyException;
import com.tutorial.music.mapping.ApplicationUserMapper;
import com.tutorial.music.model.ApplicationUser;
import com.tutorial.music.model.Role;
import com.tutorial.music.repository.ApplicationUserRepository;
import com.tutorial.music.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
@Slf4j
public class ApplicationUserServiceImpl implements ApplicationUserService, UserDetailsService {

    private final ApplicationUserMapper applicationUserMapper;
    private final ApplicationUserRepository applicationUserRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    public ApplicationUserServiceImpl(
            ApplicationUserMapper applicationUserMapper,
            ApplicationUserRepository applicationUserRepository,
            RoleRepository roleRepository,
            PasswordEncoder passwordEncoder) {
        this.applicationUserMapper = applicationUserMapper;
        this.applicationUserRepository = applicationUserRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public ApplicationUserResponseDto save(ApplicationUserRequestDto requestDto) {
        String email = requestDto.getEmail();
        Optional<ApplicationUser> existing = applicationUserRepository.findByEmail(email);
        if (existing.isPresent()) {
            throw new UserExistsAlreadyException(email);
        }
        ApplicationUser applicationUser = applicationUserMapper.fromRequest(requestDto);
        applicationUser.setPassword(passwordEncoder.encode(requestDto.getPassword()));
        applicationUser.setCreated(LocalDateTime.now());
        Set<Role> roles = roleRepository.findByNameIn(requestDto.getRoles());
        applicationUser.setRoles(roles);

        applicationUserRepository.save(applicationUser);

        return applicationUserMapper.toResponse(applicationUser);
    }

    @Override
    @Transactional(readOnly = true)
    public ApplicationUserResponseDto findById(Integer id) {
        ApplicationUser applicationUser = applicationUserRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ApplicationUser.class, id));
        return applicationUserMapper.toResponse(applicationUser);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        ApplicationUser applicationUser = applicationUserRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Cannot find user with name: " + email));

        log.info("user {} found with id {}", email, applicationUser.getId());

        return User.builder()
                .username(applicationUser.getEmail())
                .password(applicationUser.getPassword())
                .roles(applicationUser.getRoles().stream().map(Role::getName).toArray(String[]::new))
                .build();
    }
}
