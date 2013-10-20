package main.de.nordakademie.nakp.business;

import java.util.List;

import com.mongodb.BasicDBObject;

public interface ProductDAO {
	public List<Product> findAll();

	public void insert(BasicDBObject document);
}
