package com.concreatepage.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;

/**
 * Singleton responsible for initializing the Spring application context.  Provides
 * methods for accessing the context as well as helpers for creating new beans.
 */
final public class SpringApplicationFactory
{
    private static SpringApplicationFactory _instance;


//    private transient AnnotationConfigApplicationContext _ctx;
    private transient GenericApplicationContext _ctx;

    private SpringApplicationFactory()
    {
        // empty
    }

    public static synchronized SpringApplicationFactory getInstance()
    {
        if( _instance == null )
        {
            _instance = new SpringApplicationFactory();
            _instance.init();
        }

        return _instance;
    }

    private void init()
    {
        _ctx = new GenericGroovyApplicationContext("classpath:/config.groovy");
        new ClassPathBeanDefinitionScanner(_ctx).scan("com.concretepage");
//        _ctx = new AnnotationConfigApplicationContext();
//        _ctx.register(AppConfig.class);
//        _ctx.refresh();
    }

    /**
     * Helper method to get a bean from the Spring Application Context
     * @param clazz The bean class to get
     * @return The spring bean
     */
    public <T> T getBean(final Class<T> clazz)
    {
        return _ctx.getBean(clazz);
    }

    public ApplicationContext getContext()
    {
        return _ctx;
    }
}
