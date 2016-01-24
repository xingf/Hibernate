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
		//删除
		Session session = MySessionFactory.getSessionFactory().openSession();
		//1. 获取该雇员 2. 删除
		Transaction ts = session.beginTransaction();
		Employee emp = (Employee) session.load(Employee.class, 3);
		session.delete(emp);
		ts.commit();
		session.close();
	}

	private static void updateEmployee() {
		//获取一个会话
		Session session = MySessionFactory.getSessionFactory().openSession();
		
		//修改用户  1. 获取要求该的用户  2. 修改
		//load 方法可以通过主键属性，获取该对象实例
		Employee employee = (Employee) session.load(Employee.class, 3);
		Transaction ts = session.beginTransaction();
		employee.setName("韩顺平");
		employee.setEmail("abc.sohu@com");
		ts.commit();
		session.close();
	}

	private static void addEmployee() {
		
		Session session = MySessionFactory.getSessionFactory().openSession();
		//4. 对于hibernate而言，要求程序员在增加，删除，修改的时候使用事务进行提交，否则不生效,  查询可以不使用事务
		Transaction transaction = session.beginTransaction();
		//添加一个雇员
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
