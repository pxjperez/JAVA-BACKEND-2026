package edu.cibertec.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import jakarta.persistence.EntityManagerFactory;

@Configuration //Traiga todas las configuraciones de Spring
@ComponentScan(basePackages = "edu.cibertec") // Escanear los componentes en el paquete edu.cibertec
@EnableWebMvc //Configurar el framework de  Spring MVC
@EnableJpaRepositories(basePackages = "edu.cibertec.repository") //Habilitar los repositorios JPA
@EnableTransactionManagement //Habilitar el manejo de transacciones
public class AppConfig implements WebMvcConfigurer {

    //Inicio configuracion de thymeleaf
    //Configuracion del template resolver de thymeleaf
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setPrefix("/view/"); // Carpeta donde se encuentran las vistas
        templateResolver.setSuffix(".html"); // Extension de las vistas
        templateResolver.setCharacterEncoding("UTF-8");
        return templateResolver;
    }

    //Configuracion del Template Engine de thymeleaf
    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }
    //Configuraicon de View Resolver de thymeleaf
    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setCharacterEncoding("UTF-8");
        return viewResolver;
    }
    //Fin configuracion de thymeleaf

    //Bean para la carga de archivos estáticos (CSS, JS, IMAGENES)
    @Bean
    public MultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }

    //Mapear la ruta de archivos estaticos del aplicativo
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**") //Ruta publica
                .addResourceLocations("/static/"); //Ruta interna donde se encuentran los archivos
    }

    //Configuracion del DataSource
    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        //Aqui ingresar las propiedades de su BD
        String host = "localhost";
        String port = "3306";
        String dbName = "matricula";
        String user="root";
        String password="root";
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://" + host + ":" + port + "/" + dbName);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    //Habilitando el adaptador de JPA con Hibernate
    @Bean
    public HibernateJpaVendorAdapter hibernateJpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect"); //Cambia segun la base de datos que uses
        adapter.setShowSql(true);//Muestra las consultas SQL en la consola
        adapter.setGenerateDdl(false);//Crea o actualizar las tablas automaticamente (Recomendacion es no habilitarlo)
        return adapter;
    }

    //Configurar el EntityManagerFactory
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource);
        entityManagerFactory.setPackagesToScan("edu.cibertec.entity"); //Paquete donde se encuentran las entidades
        entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter);
        return entityManagerFactory;
    }

    //Configurar el TransactionManager(Para manejar las transacciones)
    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
    
}
