package com.SistemaDeCadastro.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SistemaDeCadastro.cadastro.entities.ConsultasEntity;

public interface ConsultasRepository  extends JpaRepository<ConsultasEntity,Long>{
    
}
