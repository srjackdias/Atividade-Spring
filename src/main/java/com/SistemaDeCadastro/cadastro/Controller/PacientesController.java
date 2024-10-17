package com.SistemaDeCadastro.cadastro.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SistemaDeCadastro.cadastro.Dto.request.CreatePacienteDto;
import com.SistemaDeCadastro.cadastro.Dto.resp.ShowPacienteDto;
import com.SistemaDeCadastro.cadastro.service.PacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacientesController {

    @Autowired
    PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<?> createFuncionario(@RequestBody CreatePacienteDto dto) {

        System.out.println(dto.getNome());
        System.out.println(dto.getMedico().getNome());
        System.out.println(dto.getMedico().getEspecialidade());

        System.out.println(dto.getConsultas().get(0).getData());
        System.out.println(dto.getConsultas().get(0).getDescricao());


        pacienteService.CreatePaciente(dto);

        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity<?> getAllFuncionarios() {

        List<ShowPacienteDto> pacientes = pacienteService.getAllPacientes();

        return ResponseEntity.status(200).body(pacientes);
    }

}
