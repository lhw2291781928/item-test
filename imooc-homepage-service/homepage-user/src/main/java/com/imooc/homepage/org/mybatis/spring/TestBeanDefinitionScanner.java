package com.imooc.homepage.org.mybatis.spring;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

import java.util.Set;

/**
 *
 * <h2>自定义的Spring的扫描类</h2>
 * 需要继承Spring的 ClassPathBeanDefinitionScanner
 *
 * 此类的目的是重写Spring的扫描逻辑，因为Spring的默认扫描逻辑是只扫描Class而不会去扫描接口
 * 而mybatis需要扫描的巧巧全是接口
 * @author JavaLi
 * @date 2021/1/24 18:13:17
 */
public class TestBeanDefinitionScanner extends ClassPathBeanDefinitionScanner {



    public TestBeanDefinitionScanner(BeanDefinitionRegistry registry) {

        super(registry);
    }


    /**
     * Spring的默认扫描逻辑是只扫描Class,故在此处重写为扫描接口
     * @param beanDefinition
     * @return
     */
    @Override
    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        //return super.isCandidateComponent(beanDefinition);

        return beanDefinition.getMetadata().isInterface();
    }


    /**
     * 在此方法中重写 自定义BeanFactory的注册逻辑
     * @param basePackages
     * @return
     */
    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
        Set<BeanDefinitionHolder> beanDefinitionHolders = super.doScan(basePackages);

        for (BeanDefinitionHolder beanDefinitionHolder:beanDefinitionHolders) {

            BeanDefinition beanDefinition = beanDefinitionHolder.getBeanDefinition();
            beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(beanDefinition.getBeanClassName());
            beanDefinition.setBeanClassName(TestFactoryBean.class.getName());
        }
        return beanDefinitionHolders;
    }
}
