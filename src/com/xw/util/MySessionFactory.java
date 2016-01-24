package com.xw.util;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.xw.domain.Employee;

final public class MySessionFactory {
	
	public static SessionFactory mySessionFactory = null;
	private MySessionFactory(){
		
	}
	
	static{
		// 我们使用hibernate完成crud操作，这里我们只见对象，不见表

				//1. 创建configuration, 该对象用于读取hibernate.cfg.xml，并完成初始化
				Configuration configuration = new Configuration().configure();
				
				//2. 创建SessionFactory这是一个会话工厂，是一个重量级的对象
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
				mySessionFactory = configuration.buildSessionFactory(serviceRegistry);
				
				//3. 创建session, 相当于jdbc conncetion[servelt httpsession ，也不是jsp session]			
				//Session session = sessionFactory.openSession();
	}
	
	public static SessionFactory getSessionFactory(){
		return mySessionFactory;
	}
}
