/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qlbh.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("deprecation")
public class HibernateUtil {
	private static SessionFactory factory = null;
	private static Configuration conf;

	public static SessionFactory buildSessionFactory() {
		try {
			conf = new Configuration();
			conf.configure("hibernate.cfg.xml");
			System.out.println("configuration");
			factory = conf.buildSessionFactory();
			return factory;
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		if (factory == null) {
			factory = buildSessionFactory();
		}
		return factory;
	}

}
// private static SessionFactory sessionFactory;
// private static ServiceRegistry serviceRegistry;
//
// static {
// try {
// Configuration configuration = new Configuration().configure();
// serviceRegistry = new
// ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
// sessionFactory = configuration.buildSessionFactory(serviceRegistry);
// } catch (Throwable ex) {
// System.err.println("Initial SessionFactory creation failed." + ex);
// throw new ExceptionInInitializerError(ex);
// }
// }
//
// public static SessionFactory getSessionFactory() {
// return sessionFactory;
// }

// }
// import org.hibernate.Session;
// import org.hibernate.SessionFactory;
// import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
// import org.hibernate.cfg.Configuration;
//
// public class HibernateUtil {
//
// private static final SessionFactory sessionFactory;
//
// static {
// try {
// // Create the SessionFactory from hibernate.cfg.xml
// Configuration configuration = new Configuration();
// configuration.configure("hibernate.cfg.xml");
// StandardServiceRegistryBuilder ssrb = new
// StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
// sessionFactory = configuration.buildSessionFactory(ssrb.build());
// Session session = sessionFactory.openSession();
//
// } catch (Throwable ex) {
// // Make sure you log the exception, as it might be swallowed
// System.err.println("Initial SessionFactory creation failed." + ex);
// throw new ExceptionInInitializerError(ex);
// }
// }
//
// public static SessionFactory getSessionFactory() {
// return sessionFactory;
// }
//
// }