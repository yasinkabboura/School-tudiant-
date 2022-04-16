package com.yasin.school_spring.sec.Repositories;

import com.yasin.school_spring.sec.service.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
    AppRole findByRoleName(String roleName);
}
