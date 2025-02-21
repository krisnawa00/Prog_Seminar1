package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table (name = "Product")
@Entity
public class Product {
	@Setter(value = AccessLevel.NONE)
	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "Title")
	private String title;
	@Column(name = "Description")
	private String desc;
	@Column(name = "Price")
	private float cena;
	@Column(name = "Quantity")
	private int quantity;

	public Product(String inputTitle, String inputDesc, float inputPrice, int inputQuantity) {
	
		setTitle(inputTitle);
		setDesc(inputDesc);
		setCena(inputPrice);
		setQuantity(inputQuantity);
	}
	
}
