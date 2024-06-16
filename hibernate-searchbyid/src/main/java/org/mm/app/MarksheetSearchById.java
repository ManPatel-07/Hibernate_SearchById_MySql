package org.mm.app;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.mm.model.Marksheet;

public class MarksheetSearchById 
{
	public static void main(String[] args)
	{
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
												.configure()
												.build();
		
		SessionFactory sf = new MetadataSources(registry)
							.buildMetadata()
							.buildSessionFactory();
		
		Session s = sf.openSession();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Id :- ");
		int id = sc.nextInt();
		
		Marksheet m = s.get(Marksheet.class, id);	
		
		if(m == null)
		{
			System.out.println("Record not found ...");
		}
		else
		{
			System.out.println(m.getName()+","+ m.getRollno()+","+m.getMaths());
		}
		
		
		s.close();
	}
}
