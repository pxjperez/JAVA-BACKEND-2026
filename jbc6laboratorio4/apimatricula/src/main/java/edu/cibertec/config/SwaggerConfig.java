package edu.cibertec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;

@Configuration //Esto lo pueden manejar desde el archivo properties, pero lo dejo aquí para que vean como se hace desde código
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        //Para el caso de utilizar solo spring data rest debo de agregar la descripcion de el tag a travez de la configucion de swagger por este archivo.
        return new OpenAPI()
                            .info(new Info()
                                .title("API de Matricula")
                                .version("1.0")
                                .description("API para la gestion de matriculas y cursos"))
                            .addTagsItem(new Tag()
                                .name("Cursos")
                                .description("Operaciones CRUD para la gestión de cursos usando Spring Data REST"))
                            .addTagsItem(new Tag()
                                .name("Matriculas")
                                .description("Operaciones CRUD para la gestión de matriculas usando Spring Data REST"));
    }
}
