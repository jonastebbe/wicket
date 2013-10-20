package main.de.nordakademie.nakp.ui;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import main.de.nordakademie.nakp.business.ProductService;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.util.string.StringValue;

import java.net.UnknownHostException;

public class SuccessPage extends WebPage {

	@SpringBean
	private ProductService productService;

	public SuccessPage(final PageParameters parameters) {

		StringValue productName = parameters.get("productName");
		StringValue description = parameters.get("description");
		StringValue price = parameters.get("price");

		BasicDBObject document = new BasicDBObject();
		document.put("_id", productName.toString());
		document.put("description", description.toString());
		document.put("price", price.toString());

		productService.insert(document);

		final Label result = new Label("result", "productName : " + productName
				+ "<br>description: " + description + "<br>price: " + price);
		add(result);

	}

}
