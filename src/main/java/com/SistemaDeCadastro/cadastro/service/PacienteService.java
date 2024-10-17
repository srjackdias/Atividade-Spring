package com.SistemaDeCadastro.cadastro.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SistemaDeCadastro.cadastro.Dto.request.CreateConsultasDto;
import com.SistemaDeCadastro.cadastro.Dto.request.CreatePacienteDto;
import com.SistemaDeCadastro.cadastro.Dto.resp.ShowConsultasDto;
import com.SistemaDeCadastro.cadastro.Dto.resp.ShowMedicoDto;
import com.SistemaDeCadastro.cadastro.Dto.resp.ShowPacienteDto;
import com.SistemaDeCadastro.cadastro.entities.ConsultasEntity;
import com.SistemaDeCadastro.cadastro.entities.MedicoEntity;
import com.SistemaDeCadastro.cadastro.entities.PacientesEntity;
import com.SistemaDeCadastro.cadastro.repository.ConsultasRepository;
import com.SistemaDeCadastro.cadastro.repository.MedicoRepository;
import com.SistemaDeCadastro.cadastro.repository.PacienteRepository;

import jakarta.transaction.Transactional;

@Service
public class PacienteService {
    


    @Autowired

    ConsultasRepository consultasRepository;

    @Autowired

    MedicoRepository medicoRepository;


    @Autowired

    PacienteRepository pacienteRepository;

    @Transactional
    public void CreatePaciente(PacientesEntity paciente) {

        PacientesEntity pacientesEntity = new PacientesEntity();
        pacientesEntity.setNome(paciente.getNome());



        pacientesEntity = pacienteRepository.save(pacientesEntity);

        List<ConsultasEntity>  consultasEntities = new ArrayList<>();

        for(ConsultasEntity consultas : paciente.getConsultas()){

            ConsultasEntity consultasEntity = new ConsultasEntity();
            consultasEntity.setData(consultas.getData());
            consultasEntity.setDescricao(consultas.getDescricao());

            if (consultas instanceof ClinicoGeral) {
                consultasEntity.setTipo("CLINICOGERAL");
            }

            if (consultas instanceof Ortopedia) {
                consultasEntity.setTipo("ORTOPEDIA");
            }

            if (consultas instanceof Radiologia) {
                consultasEntity.setTipo("RADIOLOGIA");
            }

            consultasEntity.setPaciente(pacientesEntity);

            consultasEntities.add(consultasEntity);
        }
        
        consultasRepository.saveAll(consultasEntity);
    }


    public List<ShowPacienteDto> getAllPacientes(){
        .stream()
        .map(paciente =>{
            ShowPacienteDto pacienteDto = new ShowPacienteDto







        })







    }
}

