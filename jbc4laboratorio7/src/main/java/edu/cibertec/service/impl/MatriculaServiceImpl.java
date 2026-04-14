package edu.cibertec.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.cibertec.entity.MatriculaEntity;
import edu.cibertec.entity.MatriculaPersonalizadaEntity;
import edu.cibertec.repository.MatriculaRepository;
import edu.cibertec.service.MatriculaService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MatriculaServiceImpl implements MatriculaService {
    private final MatriculaRepository matriculaRepository;

    @Override
    public List<MatriculaEntity> listarMatriculas() {
        return matriculaRepository.findAll();
    }
    
    @Override
    public List<MatriculaPersonalizadaEntity> listarMatriculasPersonalizada() {
        return matriculaRepository.listarMatriculasPersonalizada();
    }

    @Override
    public List<MatriculaPersonalizadaEntity> listarMatriculasPersonalizadaNativa() {
        return matriculaRepository.listarMatriculasPersonalizadaNativa();
    }

    @Override
    public MatriculaEntity obtenerMatricula(Integer idMatricula) {       
        return matriculaRepository.findById(idMatricula).orElse(null);
    }

    @Override
    public MatriculaEntity registrarMatricula(MatriculaEntity matricula) {
        return matriculaRepository.save(matricula);
    }

    @Override
    public MatriculaEntity actualizarMatricula(MatriculaEntity matricula) {
        return matriculaRepository.save(matricula);
    }

    @Override
    public MatriculaEntity eliminarMatricula(Integer idMatricula) {
        MatriculaEntity matricula = obtenerMatricula(idMatricula);
        matricula.setEstado(0);
        return matriculaRepository.save(matricula);
    }
}
