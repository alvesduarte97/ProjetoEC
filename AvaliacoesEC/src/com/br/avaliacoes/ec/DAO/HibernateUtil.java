package com.br.avaliacoes.ec.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory(){
		if(sessionFactory == null) {
			Configuration configuration = new Configuration().configure();
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties());
		
		sessionFactory = configuration.buildSessionFactory(builder.build());
		}
		
		return sessionFactory;
		
}
	
	
	
	public static void main(String[] args) {
		
		SessionFactory sf =  HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		if(session != null) {
			System.out.println("Open session successfully");
		}else {
			System.out.println("Error in session");
		}

		sf.close();
		
	}

}
