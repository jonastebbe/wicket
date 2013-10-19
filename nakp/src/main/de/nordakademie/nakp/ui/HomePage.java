package main.de.nordakademie.nakp.ui;

import main.de.nordakademie.nakp.business.Product;
import main.de.nordakademie.nakp.business.ProductService;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.spring.injection.annot.SpringBean;

public class HomePage extends WebPage {
	@SpringBean
	private ProductService productService;

	public HomePage() {
		add(new ListView<Product>("productListView", productService.findAll()) {

			@Override
			protected void populateItem(ListItem<Product> item) {
				item.add(new Label("productName", item.getModelObject()
						.getName()));
			}
		});
	}
}
