package com.tutorial.music.repository;

import com.tutorial.music.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByNameIgnoreCase(String name);

    Set<Role> findByNameIn(Set<String> roleName);

}
