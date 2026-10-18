package org.jsp.merchant_product.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.jsp.merchant_product.dto.Merchant;

public class MerchantDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("M15");
	EntityManager em = emf.createEntityManager();
	public Merchant saveMerchant(Merchant m) {
		EntityTransaction etran = em.getTransaction();
		etran.begin();
		em.persist(m);
		etran.commit();
		return m;
	}
	public Merchant updateMerchant(Merchant m) {
		EntityTransaction etran = em.getTransaction();
		etran.begin();
		Merchant mdb = em.find(Merchant.class, m.getId());
		if(mdb != null) {
			mdb.setPhone(m.getPhone());
			mdb.setPassword(m.getPassword());
			mdb.setName(m.getName());
			mdb.setEmail(m.getEmail());
			mdb.setGst_num(m.getGst_num());
			etran.commit();
			return mdb;
		}
		else {
			return null;
		}
	}
	public void findMerchantById(int mid) {
		Merchant  m = em.find(Merchant.class, mid);
		if(m != null) {
			System.out.println(m);
		}
		else {
			System.err.println("No Record Found !!!");
		}
	}
	public void findMerchantByNameAndPassword(String name, String password) {
		TypedQuery<Merchant> q = em.createQuery("select m from Merchant m where name = ?1 and password = ?2" , Merchant.class);
		q.setParameter(1, name);
		q.setParameter(2, password);
		List<Merchant> ml = q.getResultList();
		if(!ml.isEmpty()) {
			ml.forEach(System.out::println);
		}
		else {
			System.err.println("No Record Found !!!");
		}
	}
	public void findMerchantByProductId(int pid) {
		TypedQuery<Merchant> q = em.createQuery("select p.m from Product p where p.id = ?1" , Merchant.class);
		q.setParameter(1, pid);
		List<Merchant> ml = q.getResultList();
		if(!ml.isEmpty()) {
			ml.forEach(System.out::println);
		}
		else {
			System.err.println("No Record Found !!!");
		}
	}
	
}
