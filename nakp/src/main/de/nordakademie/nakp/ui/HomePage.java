package main.de.nordakademie.nakp.ui;

import main.de.nordakademie.nakp.business.Product;
import main.de.nordakademie.nakp.business.ProductService;

import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.request.resource.CssResourceReference;
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

	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		response.render(JavaScriptHeaderItem.forReference(getApplication()
				.getJavaScriptLibrarySettings().getJQueryReference()));
		response.render(CssReferenceHeaderItem
				.forReference(new CssResourceReference(HomePage.class,
						"HomePage.css")));
	}
}
