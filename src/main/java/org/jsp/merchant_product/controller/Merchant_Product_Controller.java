package org.jsp.merchant_product.controller;

import java.util.Scanner;

import org.jsp.merchant_product.dao.MerchantDao;
import org.jsp.merchant_product.dao.ProductDao;
import org.jsp.merchant_product.dto.Merchant;
import org.jsp.merchant_product.dto.Product;

public class Merchant_Product_Controller {
	static Scanner sc = new Scanner(System.in);
	static MerchantDao mdao = new MerchantDao();
	static ProductDao pdao = new ProductDao();
	
	public static void main(String[] args) {
		while(true) {
			System.out.println("1. Save Merchant.");
			System.out.println("2. Update Merchant.");
			System.out.println("3. Find Merchant By Id.");
			System.out.println("4. Find Merchant By Name And Password.");
			System.out.println("5. Find Merchant Product Id.");
			
			System.out.println("6. Add Product.");
			System.out.println("7. Update Product.");
			System.out.println("8. Find All Product.");
			System.out.println("9. Find Product By Merchant Name.");
			System.out.println("10. Find Product By Merchant Gst_num And password.");
			System.out.println("11. Exit ....");
			
			System.out.println("Enter Your Choice : ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				saveMerchant();
				break;
			case 2:
				updateMerchant();
			break;
			case 3:
				findMerchantById();
			break;
			case 4:
				findMerchantByNameAndPassword();
			break;
			case 5:
				findMerchantByProductId();
				break;
			case 6:
				addProduct();
				break;
			case 7:
				updateProduct();
				break;
			case 8:
				findAllProduct();
				break;
			case 9 : 
				findProductByMerchantName();
				break;
			case 10:
				findProductByMerchantGstNumAndPassword();
				break;
			case 11:
				System.exit(0);
				break;
			default:
				System.err.println("Invalid Choice !!!");
				break;
			}
		}
	}

	private static void findProductByMerchantGstNumAndPassword() {
		System.out.println("Enter Merchant's info to find Products : ");
		System.out.println("Enter Merchant GST Number : ");
		String gst_num = sc.next();
		System.out.println("Enter Password : ");
		String password = sc.next();
		
		pdao.findProductByMerchantGstNumAndPassword(gst_num , password);
	}

	private static void findProductByMerchantName() {
		System.out.println("Enter Merchant Name to find Product : ");
		String name = sc.next();
		pdao.findProductBuMerchantName(name);
	}

	private static void findAllProduct() {
		pdao.findAllProduct();
	}

	private static void updateProduct() {
		System.out.println("Enter Product Details to update : ");
		Product p = new Product();
		System.out.println("Id : ");
		p.setId(sc.nextInt());
		System.out.println("Name : ");
		p.setName(sc.next());
		System.out.println("Brand : ");
		p.setBrand(sc.next());
		System.out.println("Category : ");
		p.setCategory(sc.next());
		System.out.println("Price : ");
		p.setPrice(sc.nextDouble());
		
		p = pdao.updateProduct(p);
		if (p != null) {
			System.out.println("Product Details with id : "+p.getId()+" Updated ");
		}
		else {
			System.err.println("No record found product id is invalid !!!");
		}
	}

	private static void addProduct() {
		System.out.println("Enter Merchant Id for adding product : ");
		int mid = sc.nextInt();
		Product p = new Product();
		System.out.println("Enter Product Details : ");
		System.out.println("Name : ");
		p.setName(sc.next());
		System.out.println("Brand : ");
		p.setBrand(sc.next());
		System.out.println("Category : ");
		p.setCategory(sc.next());
		System.out.println("Price : ");
		p.setPrice(sc.nextDouble());
		
		p = pdao.addProduct(mid,p);
		if(p != null) {
			System.out.println("Product with Id : " + p.getId() + " has been added to Merchant with Id  : " + mid);
		}
		else {
			System.err.println("No Product added since Merchant Id is invalid !!!");
		}
	}

	private static void findMerchantByProductId() {
		System.out.println("Enter Product Id to find Merchant : ");
		int pid = sc.nextInt();
		mdao.findMerchantByProductId(pid);
	}

	private static void findMerchantByNameAndPassword() {
		System.out.println("Enter Merchant Name : ");
		String name = sc.next();
		System.out.println("Enter Merchant Password : ");
		String password = sc.next();
		mdao.findMerchantByNameAndPassword(name,password);
	}

	private static void findMerchantById() {
		System.out.println("Enter Merchant Id : ");
		int mid = sc.nextInt();
		mdao.findMerchantById(mid);
		
	}

	private static void updateMerchant() {
		Merchant m = new Merchant();
		System.out.println("Enter Merchant's Info to Update : ");
		System.out.println("Id : ");
		m.setId(sc.nextInt());
		System.out.println("Name : ");
		m.setName(sc.next());
		System.out.println("GST Number : ");
		m.setGst_num(sc.next());
		System.out.println("Email : ");
		m.setEmail(sc.next());
		System.out.println("Password : ");
		m.setPassword(sc.next());
		System.out.println("Phone : ");
		m.setPhone(sc.nextLong());
		
		m = mdao.updateMerchant(m);
		if(m!= null) {
			System.out.println("Merchant's Details Updated with id : " + m.getId());
		}
		else {
			System.err.println("No Record Found Merchant id is invalid !!!");
		}
	}

	private static void saveMerchant() {
		Merchant m = new Merchant();
		System.out.println("Enter Merchant's Info : ");
		System.out.println("Name : ");
		m.setName(sc.next());
		System.out.println("GST Number : ");
		m.setGst_num(sc.next());
		System.out.println("Email : ");
		m.setEmail(sc.next());
		System.out.println("Password : ");
		m.setPassword(sc.next());
		System.out.println("Phone : ");
		m.setPhone(sc.nextLong());
		
		m = mdao.saveMerchant(m);
		System.out.println("Merchant saved with id : " + m.getId());
	}
}
