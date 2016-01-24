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
		// ����ʹ��hibernate���crud��������������ֻ�����󣬲�����

				//1. ����configuration, �ö������ڶ�ȡhibernate.cfg.xml������ɳ�ʼ��
				Configuration configuration = new Configuration().configure();
				
				//2. ����SessionFactory����һ���Ự��������һ���������Ķ���
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
				mySessionFactory = configuration.buildSessionFactory(serviceRegistry);
				
				//3. ����session, �൱��jdbc conncetion[servelt httpsession ��Ҳ����jsp session]			
				//Session session = sessionFactory.openSession();
	}
	
	public static SessionFactory getSessionFactory(){
		return mySessionFactory;
	}
}
