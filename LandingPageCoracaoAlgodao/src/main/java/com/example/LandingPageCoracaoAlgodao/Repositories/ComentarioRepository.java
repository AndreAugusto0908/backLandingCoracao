package com.example.LandingPageCoracaoAlgodao.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.LandingPageCoracaoAlgodao.Entity.Comentario;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {
    
}
