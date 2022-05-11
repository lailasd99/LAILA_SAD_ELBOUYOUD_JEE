package com.example.etudiantsmvc.respositories;

import com.example.etudiantsmvc.entities.etudiant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface etudiantRespository extends JpaRepository<etudiant, Long> {
    Page<etudiant> findByNomContains(String kw, Pageable pageable);
}


