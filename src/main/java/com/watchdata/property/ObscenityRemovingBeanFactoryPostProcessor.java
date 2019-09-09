package com.watchdata.property;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionVisitor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.StringValueResolver;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhibin.wang
 * @create 2019-06-03 16:26
 * @desc
 **/
public class ObscenityRemovingBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    private Set<String> obsc;

    public ObscenityRemovingBeanFactoryPostProcessor() {
        this.obsc = new HashSet<String>();
    }

    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

        String[] beanDefinitionNames = configurableListableBeanFactory.getBeanDefinitionNames();

        for (String beanName : beanDefinitionNames
             ) {
            BeanDefinition bd = configurableListableBeanFactory.getBeanDefinition(beanName);
            StringValueResolver stringValueResolver = new StringValueResolver() {
                public String resolveStringValue(String s) {
                    if (isObscene(s)){
                        return  "*****";
                    }
                    return s;
                }
            };
            BeanDefinitionVisitor visitor = new BeanDefinitionVisitor(stringValueResolver);
            visitor.visitBeanDefinition(bd );
        }

    }

    public boolean isObscene(Object value){
       String po =  value.toString();
       System.out.println(obsc.contains(po));
        return obsc.contains(po);
    }

    public Set<String> getObsc() {
        return obsc;
    }

    public void setObsc(Set<String> obsc) {

        this.obsc.clear();

            this.obsc.addAll(obsc);

    }
}
