package main.de.nordakademie.nakp.ui;

import java.util.List;

import main.de.nordakademie.nakp.business.Product;
import main.de.nordakademie.nakp.business.ProductService;

import org.apache.wicket.event.IEvent;
import org.apache.wicket.markup.head.CssReferenceHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.spring.injection.annot.SpringBean;

public class ProductListViewPanel extends Panel {
	@SpringBean
	private ProductService productService;

	public ProductListViewPanel(String id) {
		super(id);
		setOutputMarkupId(true);
		add(new ListView<Product>("productListView", new AbstractReadOnlyModel<List<Product>>() {
          public List<Product> getObject() {
                  return productService.findAll();
          }}) {

			@Override
			protected void populateItem(ListItem<Product> item) {
				item.add(new Label("productName", item.getModelObject()
						.getName()));
				item.add(new Label("description", item.getModelObject()
						.getDescription()));
				item.add(new Label("price", item.getModelObject().getPrice()));
			}

			@Override
			public void onEvent(IEvent<?> event) {
				super.onEvent(event);
				if (event.getPayload() instanceof ProductCreatedEvent) {
					((ProductCreatedEvent) event.getPayload()).getTarget().add(ProductListViewPanel.this);
				}
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
