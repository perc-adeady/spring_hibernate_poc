import com.concreatepage.dao.PersonDao
import org.springframework.core.io.ClassPathResource
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.jdbc.datasource.SimpleDriverDataSource
import org.springframework.orm.hibernate4.HibernateTransactionManager
import org.springframework.orm.hibernate4.LocalSessionFactoryBean


//def properties = new Properties()
//properties.load(new ClassPathResource('database.properties').inputStream);
//println properties
beans {

    dataSource(SimpleDriverDataSource) { bean ->
        driverClass = org.postgresql.Driver
        url = "jdbc:postgresql://localhost:5432/spring"
        username = "spring"
        password = "spring"
    }

    sessionFactory(LocalSessionFactoryBean) { bean ->

        packagesToScan = 'com.concreatepage.entity'
        dataSource = ref('dataSource')

        hibernateProperties = [
                "hibernate.hbm2ddl.auto": "create",
                "hibernate.show_sql":     "false",
                "hibernate.dialect": "org.hibernate.dialect.PostgreSQL82Dialect",
        ]
    }

    personDao(PersonDao) { bean ->
//        bean.autowire = "byType"
        sessionFactory = ref('sessionFactory')
    }


    transactionManager(HibernateTransactionManager) { bean ->

        sessionFactory = ref('sessionFactory')
    }

}