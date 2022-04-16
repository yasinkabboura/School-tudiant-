package com.yasin.school_spring.sec.Repositories;

import com.yasin.school_spring.sec.service.AppUser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,String> {
    AppUser findByUsername(String username);
}
