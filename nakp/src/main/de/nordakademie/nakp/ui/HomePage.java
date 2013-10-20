package main.de.nordakademie.nakp.ui;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.html.WebPage;

public class HomePage extends WebPage {

	public HomePage() {
		add(new ProductListViewPanel("productListViewPanel"));
	}

	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		response.render(JavaScriptHeaderItem.forReference(getApplication()
				.getJavaScriptLibrarySettings().getJQueryReference()));
	}
}
