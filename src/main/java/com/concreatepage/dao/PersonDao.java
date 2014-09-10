package com.concreatepage.dao;

import com.concreatepage.entity.Person;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class PersonDao {

    @Autowired
    SessionFactory _sessionFactory;

    public void savePerson() {
        Person person = new Person();
        person.setId(1);
        person.setName("Ram");
        _sessionFactory.getCurrentSession().save(person);
    }
}
