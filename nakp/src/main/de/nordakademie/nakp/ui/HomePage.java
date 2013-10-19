package main.de.nordakademie.nakp.ui;

import java.util.Arrays;

import main.de.nordakademie.nakp.business.Product;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;

public class HomePage extends WebPage {
	public HomePage() {
		add(new ListView<Product>("productListView", Arrays.asList(new Product("produkt1"), new Product("produkt2"), new Product("produkt3"))) {
			
			@Override
			protected void populateItem(ListItem<Product> item) {
				item.add(new Label("productName", item.getModelObject()
						.getName()));
			}
		});
	}
}
