package com.SistemaDeCadastro.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SistemaDeCadastro.cadastro.entities.PacientesEntity;

public interface PacienteRepository  extends JpaRepository<PacientesEntity,Long>{

   
}
