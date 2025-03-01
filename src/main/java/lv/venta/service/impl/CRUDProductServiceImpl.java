package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Product;
import lv.venta.repo.ProductRepo;
import lv.venta.service.ICRUDProductService;

@Service
public class CRUDProductServiceImpl implements ICRUDProductService{

	@Autowired
	private ProductRepo prodRepo;
	
	@Override
	public void create(String title, String desc, float cena, int quantity) throws Exception {
		if(title == null || desc == null || cena < 0 || quantity == 0 ) {
			throw new Exception ("Error");
		}
		if(prodRepo.existsByTitleAndDescAndCena(title, desc, cena)) 
		{
			Product existingProduct = prodRepo.findByTitleAndDescAndCena(title, desc, cena);
			
			int newQuantity = existingProduct.getQuantity() + quantity;
			existingProduct.setQuantity(newQuantity);
			prodRepo.save(existingProduct);
		}
		else
		{
			Product newProduct = new Product(title, desc, cena, quantity);
			prodRepo.save(newProduct);
		}
	}

	@Override
	public ArrayList<Product> retrieveAll() throws Exception {
		if (prodRepo.count()==0) {
				throw new Exception ("Tabula nav ierakstu");
		}
		ArrayList<Product> allProducts = (ArrayList<Product>) prodRepo.findAll();
		return allProducts;
	}

	@Override
	public Product retrieveById(int id) throws Exception {
		if(id<0) {
			
			throw new Exception ("Id nevar but negativs");
		}
		if(!prodRepo.existsById(id)) {
			throw new Exception ("Produkts ar tadu id nepastav!");
		}
		Product retrievedProduct = prodRepo.findById(id).get();
		return retrievedProduct;
	}

	@Override
	public void updateById(int id, float cena, int quantity) throws Exception {
		Product retrievedProduct = retrieveById(id);
		
		if(retrievedProduct.getCena() != cena) {
			retrievedProduct.setCena(cena);
			
		}
		if(retrievedProduct.getQuantity() != quantity) {
			retrievedProduct.setQuantity(quantity);//ar set saglabajam jauno vērtību java pusē
		}
		
			prodRepo.save(retrievedProduct);//saglabajam izmaiņas arī datubāzē (šeit būs update vaicajums, jo produkts eksistē
		
	}
		
	@Override
	public void deleteById(int id) throws Exception {
		if(id < 0) {
			
			throw new Exception ("Id nevar but negativs");
		}
		if(!prodRepo.existsById(id)) {
			throw new Exception ("Produkts ar tadu id nepastav!");
		}
		prodRepo.deleteById(id);;
		
	}
		
	}


