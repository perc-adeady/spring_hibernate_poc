package com.concreatepage.config;

import com.concreatepage.dao.PersonDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;


@Configuration
@ImportResource("classpath:/database.cfg.xml")
public class AppConfig
{
    @Bean
    public PersonDao personDao() {
        return new PersonDao();
    }
//    @Bean
//    public HibernateTransactionManager hibTransMan(){
//        return new HibernateTransactionManager(sessionFactory());
//    }
//
//    private SessionFactory sessionFactory() {
//    }
}

//@Configuration
//@EnableTransactionManagement
//public class AppConfig {
//    @Bean
//    public HibernateTemplate hibernateTemplate() {
//        return new HibernateTemplate(sessionFactory());
//    }
//    @Bean
//    public SessionFactory sessionFactory() {
//        return new LocalSessionFactoryBuilder(getDataSource())
//                .addAnnotatedClasses(Person.class)
//                .buildSessionFactory();
//    }
//    @Bean
//    public DataSource getDataSource() {
//        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/concretepage");
//        dataSource.setUsername("root");
//        dataSource.setPassword("");
//
//        return dataSource;
//    }
//}
