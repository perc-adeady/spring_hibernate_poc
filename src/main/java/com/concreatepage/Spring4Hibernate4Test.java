package com.concreatepage;

import com.concreatepage.config.AppConfig;
import com.concreatepage.config.SpringApplicationFactory;
import com.concreatepage.dao.PersonDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Spring4Hibernate4Test {
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplicationFactory.getInstance().getContext();

        PersonDao pdao = ctx.getBean(PersonDao.class);
        pdao.savePerson();
        System.out.println("Done");
    }
}
