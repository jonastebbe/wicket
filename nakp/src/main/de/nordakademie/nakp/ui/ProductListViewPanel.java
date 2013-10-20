package main.de.nordakademie.nakp.ui;

import main.de.nordakademie.nakp.business.Product;
import main.de.nordakademie.nakp.business.ProductService;

import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.spring.injection.annot.SpringBean;

public class ProductListViewPanel extends Panel {
	@SpringBean
	private ProductService productService;

	public ProductListViewPanel(String id) {
		super(id);
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
		response.render(CssReferenceHeaderItem
				.forReference(new CssResourceReference(HomePage.class,
						"ProductListViewPanel.css")));
	}
}
