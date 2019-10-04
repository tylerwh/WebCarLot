package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.SalesPerson;

public class SalesPersonHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("UsedCarLot");
	
	public void insertSalesPerson(SalesPerson sp) {
		System.out.println("Made it to sph");
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(sp);
		em.getTransaction().commit();
		em.close();
		System.out.println("Made it to end of sph");
		
	}
	
	public List<SalesPerson> showSalesPersons() {
		EntityManager em = emfactory.createEntityManager();
		List<SalesPerson> sales = em.createQuery("SELECT i FROM salesperson i").getResultList();
		return sales;
	}
	
	

}
