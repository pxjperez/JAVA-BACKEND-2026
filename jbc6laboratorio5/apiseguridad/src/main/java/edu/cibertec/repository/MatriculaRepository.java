package edu.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import edu.cibertec.entity.MatriculaEntity;
import io.swagger.v3.oas.annotations.tags.Tag;

@RepositoryRestResource(collectionResourceRel = "matriculas", path = "matriculas")
@Tag(name = "Matriculas", description = "Operaciones CRUD para la gestión de matriculas usando Spring Data REST")
public interface MatriculaRepository extends JpaRepository<MatriculaEntity, Integer> {
    
}
