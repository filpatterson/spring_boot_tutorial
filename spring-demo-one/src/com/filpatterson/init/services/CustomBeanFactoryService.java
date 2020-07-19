package com.filpatterson.init.services;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class CustomBeanFactoryService implements DisposableBean, BeanPostProcessor, BeanFactoryAware {

	private BeanFactory beanFactory;
	private final List<Object> prototypeBeans = new LinkedList<>();
	
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if(beanFactory.isPrototype(beanName))
			//	protect object for being modified by many threads at moment 
			synchronized (prototypeBeans) {
				prototypeBeans.add(bean);
			}
		
		return bean;
	}

	@Override
	public void destroy() throws Exception {
		Object bean = null;
		synchronized (prototypeBeans) {
			for(int i = 0; i < prototypeBeans.size(); i++) {
				bean = prototypeBeans.get(i);
				
				//	check if bean is of removable type and if it is, then remove it from system using
				// written destroy()
				if(bean instanceof DisposableBean) {
					DisposableBean disposable = (DisposableBean) bean;
					try {
						disposable.destroy();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
			}
		}
	}

}
