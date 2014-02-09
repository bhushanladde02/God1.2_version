package com.onine.god;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.onine.model.Device;
import com.onine.model.Gaali;

public class GaaliDAO {

	public List<Gaali> getGaalis(String id) {
		List<Gaali> gaalis = null;
		EntityManagerFactory e = Persistence
				.createEntityManagerFactory("GODJPADB");
		EntityManager em = e.createEntityManager();
		try {
			Device ts = new Device();
			EntityTransaction entr = em.getTransaction();
			entr.begin();
			TypedQuery<Gaali> query = em.createQuery(
					"SELECT a FROM Gaali a where a.id > "+ id, Gaali.class);
			gaalis = query.getResultList();

			entr.commit();
		} finally {
			em.close();
		}
		return gaalis;

	}

	public Gaali getGaaliDetails(int id) {

		EntityManagerFactory e = Persistence
				.createEntityManagerFactory("GODJPADB");
		Gaali gaali = new Gaali();
		EntityManager em = e.createEntityManager();
		try {

			EntityTransaction entr = em.getTransaction();

			gaali.setId(id);
			
			entr.begin();
			gaali = em.find(Gaali.class,id); // works as save or update
			entr.commit();
		} catch (Exception e1) {
			System.out.println(e1);
		} finally {
			em.close();
	
		}
		return gaali;
	}
	/*public static void main(String[] args) {
		GaaliDAO gaaliDAO = new GaaliDAO();
		List<Gaali> out = gaaliDAO.getGaalis();
		System.out.println(out.get(1).getDescription1());
		
		
	}*/
}
