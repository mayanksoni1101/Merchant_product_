package org.jsp.merchant_product.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.jsp.merchant_product.dto.Merchant;
import org.jsp.merchant_product.dto.Product;

public class ProductDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("M15");
	EntityManager em = emf.createEntityManager();
	public Product addProduct(int mid, Product p) {
		EntityTransaction etran = em.getTransaction();
		etran.begin();
		Merchant m = em.find(Merchant.class, mid);
		if (m != null) {
			p.setM(m);
			List<Product> prods = m.getProds();
			prods.add(p);
			em.persist(p);
			etran.commit();
			return p;
		}
		else {
			return null;
		}
	}
	public Product updateProduct(Product p) {
		EntityTransaction etran = em.getTransaction();
		etran.begin();
		Product pdb = em.find(Product.class, p.getId());
		if(pdb != null) {
			pdb.setPrice(p.getPrice());
			pdb.setBrand(p.getBrand());
			pdb.setCategory(p.getCategory());
			pdb.setName(p.getName());
			em.persist(pdb);
			etran.commit();
			return pdb;
		}
		else {
			return null;
		}
	}
	public void findAllProduct() {
		TypedQuery<Product> q = em.createQuery("select p from Product p ", Product.class);
		List<Product> pl = q.getResultList();
		if(!pl.isEmpty()) {
			pl.forEach(System.out::println);
		}
		else {
			System.err.println("No Record found !!");
		}
	}
	public void findProductBuMerchantName(String name) {
		TypedQuery<Product> q = em.createQuery("select p from Product p where p.m.name = ?1", Product.class);
		q.setParameter(1, name);
		List<Product> pl = q.getResultList();
		if(!pl.isEmpty()) {
			pl.forEach(System.out::println);
		}
		else {
			System.err.println("No Record Found !!!");
		}
	}
	public void findProductByMerchantGstNumAndPassword(String gst_num, String password) {
		TypedQuery<Product> q = em.createQuery("select p from Product p where p.m.gst_num = ?1 and p.m.password = ?2", Product.class);
		q.setParameter(1, gst_num);
		q.setParameter(2, password);
		List<Product> pl = q.getResultList();
		if(!pl.isEmpty()) {
			pl.forEach(System.out::println);
		}
		else {
			System.err.println("No Record Found !!!");
		}
	}

}
