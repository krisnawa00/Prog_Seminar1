package lv.venta.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Product;

public interface ProductRepo extends CrudRepository<Product, Integer> {
	public abstract boolean existsByTitleAndDescAndCena(
			
			String title, String description, float price);
	
	public abstract Product findByTitleAndDescAndCena(String title, String description, float price);
		
	
}