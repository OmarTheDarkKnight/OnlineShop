package com.Bat;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@SuppressWarnings({"deprecation", "rawtypes", "unchecked" })
public class Operator {

	public static List<String> signUp(String firstName,String lastName,String email,String password) {
		List<String> retValue = new ArrayList<String>();
		try{
			boolean errors = false;
			SessionFactory factory = new Configuration().configure().buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			
			Users user = null;
			
			Query query = session.createQuery("select email from Admins");
			List<String> mailList = query.list();
			
			for(String mail : mailList) {
				if(mail.equalsIgnoreCase(email)) {
					retValue.add(0, "false");
					retValue.add(1, "Admin can not be an user");
					errors = true;
				}
			}
			
			if(!errors) {
				query = session.createQuery("select email from Users");
				mailList = query.list();
				
				for(String mail : mailList) {
					if(mail.equalsIgnoreCase(email)) {
						retValue.add(0, "false");
						retValue.add(1, "Duplicate email address");
						errors = true;
					}
				}
			}

			
			if(!errors) {
				user = new Users(firstName, lastName, email, password);
				session.save(user);
				
				retValue.add(0, "true");
				retValue.add(1, user.toStringUserID());
			}
			
			transaction.commit();
			session.close();
			return retValue;
		} catch (Exception e) {
			e.printStackTrace();
			retValue.add(0, "false");
			retValue.add(1, "Exception Occured");
			return retValue;
		}
	}
	
	
	public static List<String> adminLogIn(int adminID, String password) {
		List<String> retValue = new ArrayList<String>();
		try{
			SessionFactory factory = new Configuration().configure().buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			
			Admins admin = session.get(Admins.class, new Integer(adminID));
				
			if(admin != null) {
				if(admin.getPassword().equals(password)) {
					retValue.add(0, "true");
					retValue.add(1, admin.toStringAdminID());
					retValue.add(2, admin.getFirstname());
					retValue.add(3, admin.getLastname());
					retValue.add(4, admin.getEmail());
				} else {
					retValue.add(0, "false");
					retValue.add(1, "Password did not match");
				}
			} else {
				retValue.add(0, "false");
				retValue.add(1, "No admin found");
			}
			
			transaction.commit();
			session.close();
			return retValue;
		} catch (Exception e) {
			e.printStackTrace();
			retValue.add(0, "false");
			retValue.add(1, "Exception Occured");
			return retValue;
		}
	}


	public static List<String> userLogIn(int userID, String password) {
		List<String> retValue = new ArrayList<String>();
		try{
			SessionFactory factory = new Configuration().configure().buildSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			
			Users user = session.get(Users.class, new Integer(userID));
				
			if(user != null) {
				if(user.getPassword().equals(password)) {
					retValue.add(0, "true");
				} else {
					retValue.add(0, "false");
					retValue.add(1, "Password did not match");
				}
			} else {
				retValue.add(0, "false");
				retValue.add(1, "No user found");
			}
			
			transaction.commit();
			session.close();
			return retValue;
		} catch (Exception e) {
			e.printStackTrace();
			retValue.add(0, "false");
			retValue.add(1, "Exception Occured");
			return retValue;
		}
	}
}
