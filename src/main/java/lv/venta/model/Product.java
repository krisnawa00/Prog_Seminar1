package lv.venta.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class Product {
	@Setter(value = AccessLevel.NONE)
	private int id;
	
	private String title;
	private String desc;
	private float cena;
	private int quantity;
	@Setter(value = AccessLevel.NONE)
	@Getter(value = AccessLevel.NONE)
	private static int counter = 0;
	
	public void setId() {
		id = counter;
		counter++;
	}
	
	public Product(String inputTitle, String inputDesc, float inputPrice, int inputQuantity) {
		setId();
		setTitle(inputTitle);
		setDesc(inputDesc);
		setCena(inputPrice);
		setQuantity(inputQuantity);
	}
	
}
