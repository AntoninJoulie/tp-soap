package main.java.config;

import javax.sql.DataSource;

import main.java.dao.AuthorDAO;
import main.java.dao.AuthorDAOImpl;
import main.java.dao.BookDAO;
import main.java.dao.BookDAOImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages="main.java")
@EnableWebMvc
public class MvcConfiguration implements WebMvcConfigurer {
    @Bean
    public ViewResolver getViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("MariaDB - tpSoap@localhost");
        dataSource.setUrl("jdbc:mariadb://localhost:3306/tpSoap");
        dataSource.setUsername("root");
        dataSource.setPassword("rootdevops");

        return dataSource;
    }

    @Bean
    public AuthorDAO getAuthorDAO() {
        return new AuthorDAOImpl(getDataSource());
    }

    @Bean
    public BookDAO getBookDAO() {
        return new BookDAOImpl(getDataSource());
    }
}
