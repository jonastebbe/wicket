package main.de.nordakademie.nakp.business;

import java.util.List;

import com.mongodb.BasicDBObject;

public interface ProductService {
	List<Product> findAll();

	void insert(BasicDBObject document);
}
