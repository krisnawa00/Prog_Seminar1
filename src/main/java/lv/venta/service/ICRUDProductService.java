package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Product;

public interface ICRUDProductService {
	
	
	//C
	public abstract void create(String title, String desc, float cena,int quantity);
	
	//R
	
	public abstract ArrayList<Product> retrieveAll() throws Exception;
	
	//R
	
	public abstract Product retrieveById(int id) throws Exception;
	
	//U - Update
	
	public abstract void updateById (int id, float price, int quantity) throws Exception;
	
	//D - Delete
	
	public abstract void deleteById(int id) throws Exception;

}
