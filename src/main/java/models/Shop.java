package models;

import javax.persistence.*;

@Entity
@Table(name = "shop")
public class Shop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long product_id;
	
	private String product_name;
	private double product_price;
	
	// Constructors
	public Shop() {
		// Empty Constructor
	}
	
	public Shop(String product_name, double product_price) {
		super();
		this.product_name = product_name;
		this.product_price = product_price;
	}



	// Getters && Setters:
	public long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public double getProduct_price() {
		return product_price;
	}

	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}
	
	


	

}
