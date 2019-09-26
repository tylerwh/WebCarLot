package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Vehicle;

public class VehicleHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("UsedCarLot"); //Changed from ("UsedCarLot")
	
	// Persists new vehicle to database
	public void insertVehicle(Vehicle veh) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(veh);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public void removeVehicle(Vehicle toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		// Using ID and Make for query
		TypedQuery<Vehicle> typedQuery = em.createQuery("select i from Vehicle i WHERE i.model = :selectedModel AND i.make = :selectedMake AND i.year = :selectedYear AND i.price = :selectedPrice", Vehicle.class);
		
		typedQuery.setParameter("selectedModel", toDelete.getModel());
		typedQuery.setParameter("selectedMake", toDelete.getMake());
		typedQuery.setParameter("selectedYear", toDelete.getYear());
		typedQuery.setParameter("selectedPrice", toDelete.getPrice());
		
		//Make sure only one result displays
		typedQuery.setMaxResults(1);
		
		// Capture single result
		Vehicle result = typedQuery.getSingleResult();
		
		// Remove selected vehicle from Inventory database
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	//This locates the vehicle sought after by MODEL attribute
	public List<Vehicle> findVehiclesByModel(String model) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Vehicle> typedQuery = em.createQuery("select v from Vehicle v where v.model = :selectedModel", Vehicle.class);
		typedQuery.setParameter("selectedModel", model);
		
		List<Vehicle> foundVehicles = typedQuery.getResultList();
		em.close();
		return foundVehicles;
	}

	public Vehicle searchForVehicleById(int id) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Vehicle found = em.find(Vehicle.class, id);
		em.close();
		return found;
	}

	public void updateVehicle(Vehicle editedVehicle) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(editedVehicle);
		em.getTransaction().commit();
		em.close();
		
	}
	
	// This method returns a list of the vehicles in the inventory table
		public List<Vehicle> showInventory() {
			EntityManager em = emfactory.createEntityManager();
			List<Vehicle> inventory = em.createQuery("SELECT i FROM Vehicle i").getResultList();
			return inventory;
		}
	
	// This method closes the EntityManagerFactory upon exiting the program
		public void cleanUp() {
			emfactory.close();
		}

}
