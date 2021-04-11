package com.imooc.homepage.org.mybatis.spring;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * <h2>定义一个Spring的Bean注册器(用来将BeanFactory生成的Bean注册到IOC容器)</h2>
 * 自定义的Bean注册器需要继承Spring的注册器接口
 *
 * @author JavaLi
 * @date 2021/1/24 18:01:38
 */
public class TestImportBeanDefinitionRegistarar implements ImportBeanDefinitionRegistrar {




    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {

        //扫描路径,需要自定义一个扫描类
        String path = "com.imooc.homepage.t.mapper";
        TestBeanDefinitionScanner beanDefinitionScanner = new TestBeanDefinitionScanner(beanDefinitionRegistry);
        //为扫描器添加一个过滤器，将返回值重写为true (不是很懂)
        beanDefinitionScanner.addIncludeFilter(new TypeFilter() {
            @Override
            public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
                return true;
            }
        });


        int num = beanDefinitionScanner.scan(path);
        System.out.println(num);

    }
}
