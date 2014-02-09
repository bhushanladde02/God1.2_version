package com.onine.god;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.onine.model.Device;

public class RegisterDevice {
	public static void main(String[] args) // unit test
	{
		RegisterDevice register = new RegisterDevice();

		// register.addDevice("sdfsddfdf");
		List<String> list = register.getActiveCustomers();
		System.out.println(list);
	}

	public void mergeDevice(String id, int status) {

		EntityManagerFactory e = Persistence
				.createEntityManagerFactory("GODJPADB");
		EntityManager em = e.createEntityManager();
		try {

			EntityTransaction entr = em.getTransaction();

			Device data = new Device();
			data.setId(id);
			data.setStatus(status);
			entr.begin();
			em.merge(data); // works as save or update
			entr.commit();
		} catch (Exception e1) {
			System.out.println(e1);
		} finally {
			em.close();
		}

	}

	/*
	 * public static void updateStatusOfCustomer(int id,String statusValue) {
	 * 
	 * EntityManagerFactory e=
	 * Persistence.createEntityManagerFactory("GODJPADB"); EntityManager
	 * em=e.createEntityManager(); try{
	 * 
	 * EntityTransaction entr=em.getTransaction(); entr.begin(); Device data=new
	 * Device(); data.setId("sdfsdf"); data.setStatus(1); em.merge(data);
	 * entr.commit(); } catch(Exception e1){ System.out.println(e1); } finally{
	 * em.close(); }
	 * 
	 * 
	 * 
	 * }
	 */
	/*public static void deleteCustomer(String id) {

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("GODJPADB");
		EntityManager em = emf.createEntityManager();
		try {
			EntityTransaction entr = em.getTransaction();
			entr.begin();
			Device device = em.find(Device.class, id);
			entr.commit();
		} finally {
			em.close();
		}
	}*/

	public List<String> getActiveCustomers() {
		List<String> devices = null;
		EntityManagerFactory e = Persistence
				.createEntityManagerFactory("GODJPADB");
		EntityManager em = e.createEntityManager();
		try {
			Device ts = new Device();
			EntityTransaction entr = em.getTransaction();
			entr.begin();
			TypedQuery<String> query = em.createQuery(
					"SELECT a.id FROM Device a where a.status = 1",
					String.class);
			devices = query.getResultList();

			entr.commit();
		} finally {
			em.close();
		}

		return devices;
	}
}
