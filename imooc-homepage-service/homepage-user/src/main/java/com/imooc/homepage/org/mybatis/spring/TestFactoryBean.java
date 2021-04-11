package com.imooc.homepage.org.mybatis.spring;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <h2>自定义的SpringBean工厂，用来为spring生成Bean并放入IOC容器</h2>
 * @author JavaLi
 * @date 2021/1/24 17:30:41
 */
public class TestFactoryBean implements FactoryBean {

    private Class mapperClass;


    /**
     * 通过构造器的方式，动态的给需要生成的Bean提供类型
     * 可通过BeanDefinition对象 给即将生产的Bean提供构造方法的入参
     * (虽然我们的目的是生成用户自定义的Bean对象，但是产生SpringBean的过程中必须要先生成FactoryBean这个Bean对象
     *  这样才能为spring提供生成bean的服务)
     * @param mapperClass
     */
    public TestFactoryBean(Class mapperClass){
        this.mapperClass = mapperClass;
    }


    @Override
    public Object getObject() throws Exception {

        //通过JDK的动态代理生成代理对象,此处只是模拟
        Object proxyInstance = Proxy.newProxyInstance(TestFactoryBean.class.getClassLoader()
                , new Class[]{mapperClass}
                , (Object proxy, Method method,Object[] args)->{
                   return null;
                });


        return proxyInstance;
    }

    @Override
    public Class<?> getObjectType() {
        return mapperClass;
    }


    /**
     * 此方法 Spring的 FactoryBean自带了实现，非必须实现方法
     * 此方法用来定义生产出来的Bean是否为单例Bean
     * @return
     */
    @Override
    public boolean isSingleton() {
        return false;
    }
}
