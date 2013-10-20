package main.de.nordakademie.nakp.business;

import java.io.Serializable;

public class Product implements Serializable {

	private String name;
	private String description;
	private String price;

	public Product(final String name, final String description,
			final String price) {
		this.setName(name);
		this.setDescription(description);
		this.setPrice(price);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
