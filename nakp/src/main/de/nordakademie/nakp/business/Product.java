package main.de.nordakademie.nakp.business;

import java.io.Serializable;

public class Product implements Serializable{

	private String name;

	public Product(final String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
