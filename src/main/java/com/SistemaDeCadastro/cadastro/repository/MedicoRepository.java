package com.SistemaDeCadastro.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SistemaDeCadastro.cadastro.entities.MedicoEntity;

public interface MedicoRepository extends JpaRepository<MedicoEntity, Long> {
    
}
