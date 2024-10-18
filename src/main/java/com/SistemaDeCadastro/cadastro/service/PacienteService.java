package com.SistemaDeCadastro.cadastro.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.SistemaDeCadastro.cadastro.Dto.resp.ShowConsultasDto;
import com.SistemaDeCadastro.cadastro.Dto.resp.ShowMedicoDto;
import com.SistemaDeCadastro.cadastro.Dto.resp.ShowPacienteDto;
import com.SistemaDeCadastro.cadastro.entities.ConsultasEntity;

import com.SistemaDeCadastro.cadastro.entities.PacientesEntity;
import com.SistemaDeCadastro.cadastro.enums.Profissao;
import com.SistemaDeCadastro.cadastro.models.ClinicoGeral;
import com.SistemaDeCadastro.cadastro.models.Consultas;
import com.SistemaDeCadastro.cadastro.models.Medico;
import com.SistemaDeCadastro.cadastro.models.Ortopedia;
import com.SistemaDeCadastro.cadastro.models.Paciente;
import com.SistemaDeCadastro.cadastro.models.Radiologia;
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
    public void CreatePaciente(Paciente paciente) {

        PacientesEntity pacientesEntity = new PacientesEntity();
        pacientesEntity.setNome(paciente.getNome());

        pacientesEntity = pacienteRepository.save(pacientesEntity);

        List<ConsultasEntity> consultasEntities = new ArrayList<>();

        for (Consultas consultas : paciente.getConsultas()) {

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

        consultasRepository.saveAll(consultasEntities);
    }

    public List<ShowPacienteDto> getAllPacientes() {
        List<PacientesEntity> pacientesEntity = pacienteRepository.findAll();

        return pacientesEntity

                .stream()
                .map(paciente -> {

                    ShowPacienteDto pacienteDto = new ShowPacienteDto();
                    ShowMedicoDto medicoDto = new ShowMedicoDto();
                    List<ShowConsultasDto> consultasDto = new ArrayList<>();

                    for (ConsultasEntity consultasEntity : paciente.getConsultas()) {
                        ShowConsultasDto consultaDto = new ShowConsultasDto();
                        consultaDto.setData(consultasEntity.getData());
                        consultaDto.setDescricao(consultasEntity.getDescricao());
                        consultasDto.add(consultaDto);

                    }

                    medicoDto.setNome(paciente.getMedico().getNome());
                    medicoDto.setEspecialidade((paciente.getMedico().getEspecialidade()));

                    pacienteDto.setId_paciente(paciente.getId_paciente());
                    pacienteDto.setNome(paciente.getNome());
                    pacienteDto.setMedico(medicoDto);
                    pacienteDto.setConsultas(consultasDto);

                    return pacienteDto;

                }).toList();

    }

    public Paciente getPacienteById(long id){

        Optional<PacientesEntity> optionalPacienteEntity = pacienteRepository.findById(id);


        if(optionalPacienteEntity.isEmpty()){

        }

        PacientesEntity pacientesEntity = optionalPacienteEntity.get();

        Paciente paciente = new Paciente();

        paciente.setId(pacientesEntity.getId_paciente());
        paciente.setNome(pacientesEntity.getNome());

        Profissao profissao = Profissao.valueOf(pacientesEntity.getProfissao());
        paciente.setProfissao(profissao);

        Medico medico = new Medico();
        medico.setNome(pacientesEntity.getMedico().getNome());
        medico.setEspecialidade(pacientesEntity.getMedico().getEspecialidade());

        paciente.setMedico(medico);


        for(ConsultasEntity entity : pacientesEntity.getConsultas()){
            Consultas consulta = null;

            if (entity.getTipo().equals("CLINICOGERAL")) {
                consulta = new ClinicoGeral();
            }

            if (entity.getTipo().equals("ORTOPEDIA")) {
                consulta = new Ortopedia();
            }


            
            if (entity.getTipo().equals("RADIOLOGIA")) {
                consulta = new Radiologia();
            }

            consulta.setData(entity.getData());
            consulta.setDescricao(entity.getDescricao());

            paciente.setConsultas(consulta);

        }

        return paciente;


    }
}
