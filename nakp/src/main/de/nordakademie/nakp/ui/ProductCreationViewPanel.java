package main.de.nordakademie.nakp.ui;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;

import main.de.nordakademie.nakp.business.ProductService;

import com.mongodb.BasicDBObject;

public class ProductCreationViewPanel extends Panel {
	@SpringBean
	private ProductService productService;

	public ProductCreationViewPanel(String id) {
		super(id);
		final TextField<String> productName = new TextField<String>(
				"productName", Model.of(""));
		productName.setRequired(true);
		final TextField<String> description = new TextField<String>(
				"description", Model.of(""));
		final TextField<String> price = new TextField<String>("price",
				Model.of(""));

		Form<?> form = new Form<Void>("productForm") {

			@Override
			protected void onSubmit() {

				final String productNameValue = productName.getModelObject();
				final String descriptionValue = description.getModelObject();
				final String priceValue = price.getModelObject();

				BasicDBObject document = new BasicDBObject();
				document.put("_id", productNameValue);
				document.put("description", descriptionValue);
				document.put("price", priceValue);
				productService.insert(document);
			}

		};
		add(form);
		form.add(productName);
		form.add(description);
		form.add(price);

	}

}
