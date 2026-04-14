package edu.cibertec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import edu.cibertec.entity.CursoEntity;
import io.swagger.v3.oas.annotations.tags.Tag;

@RepositoryRestResource(collectionResourceRel = "cursos", path = "cursos")
@Tag(name = "Cursos") // Cuando utilizo el tag en el repository no funciona la descipcion.
public interface CursoRepository  extends JpaRepository<CursoEntity, Integer> {
    
}
