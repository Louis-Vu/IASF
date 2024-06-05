package org.example.Repository;

import org.example.model.Role;
import org.example.model.RoleId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, RoleId> {
    List<Role> findByUserId(String userId);
}

