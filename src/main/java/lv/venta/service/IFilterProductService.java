package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Product;

public interface IFilterProductService {

	public abstract ArrayList<Product> filterProductByPriceLessThan(float threashold) throws Exception;
	
	public abstract ArrayList<Product> filterProductByContainingText(String search) throws Exception;
	
	public abstract float calculateIncome() throws Exception;
	
	
}
