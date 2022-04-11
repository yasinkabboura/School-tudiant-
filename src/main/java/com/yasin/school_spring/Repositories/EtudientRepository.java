package com.yasin.school_spring.Repositories;

import com.yasin.school_spring.entities.Etudiant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudientRepository extends JpaRepository<Etudiant,Long> {
    Page<Etudiant> findByNomContains(String keyword, Pageable pageable);
}
