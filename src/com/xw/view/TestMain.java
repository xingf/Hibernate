package com.xw.view;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.xw.domain.Employee;
import com.xw.util.MySessionFactory;

public class TestMain {

	public static void main(String[] args) {
		//addEmployee();
		//updateEmployee();
		//deleteEmployee();
		
	}

	private static void deleteEmployee() {
		//ɾ��
		Session session = MySessionFactory.getSessionFactory().openSession();
		//1. ��ȡ�ù�Ա 2. ɾ��
		Transaction ts = session.beginTransaction();
		Employee emp = (Employee) session.load(Employee.class, 3);
		session.delete(emp);
		ts.commit();
		session.close();
	}

	private static void updateEmployee() {
		//��ȡһ���Ự
		Session session = MySessionFactory.getSessionFactory().openSession();
		
		//�޸��û�  1. ��ȡҪ��õ��û�  2. �޸�
		//load ��������ͨ���������ԣ���ȡ�ö���ʵ��
		Employee employee = (Employee) session.load(Employee.class, 3);
		Transaction ts = session.beginTransaction();
		employee.setName("��˳ƽ");
		employee.setEmail("abc.sohu@com");
		ts.commit();
		session.close();
	}

	private static void addEmployee() {
		
		Session session = MySessionFactory.getSessionFactory().openSession();
		//4. ����hibernate���ԣ�Ҫ�����Ա�����ӣ�ɾ�����޸ĵ�ʱ��ʹ����������ύ��������Ч,  ��ѯ���Բ�ʹ������
		Transaction transaction = session.beginTransaction();
		//���һ����Ա
		Employee employee = new Employee();
		employee.setName("xing wang");
		employee.setEmail("xing_wangsz@hotmail.com");
		employee.setHiredDate(new Date());
		
		//insert ....
		// save
		session.save(employee);
		transaction.commit();
		session.close();
	}

}
