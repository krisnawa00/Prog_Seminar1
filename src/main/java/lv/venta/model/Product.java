package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
	
	
	
	@NotNull
	@Pattern(regexp = "[A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēūīļķģšāžčņ ]{3,30}")
	@Column(name = "Title")
	private String title;
	
	
	@NotNull
	@Pattern(regexp = "[A-ZĒŪĪĻĶĢŠĀŽČŅa-zēūīļķģšāžčņ ,]{4,100}")
	@Column(name = "Description")
	private String desc;
	
	
	@Min(0)
	@Max(10000)
	@Column(name = "Price")
	private float cena;
	
	
	@Min(0)
	@Max(10000)
	@Column(name = "Quantity")
	private int quantity;

	public Product(String inputTitle, String inputDesc, float inputPrice, int inputQuantity) {
	
		setTitle(inputTitle);
		setDesc(inputDesc);
		setCena(inputPrice);
		setQuantity(inputQuantity);
	}
	
}
