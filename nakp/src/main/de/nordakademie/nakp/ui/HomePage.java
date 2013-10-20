package main.de.nordakademie.nakp.ui;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class HomePage extends WebPage {
	public HomePage() {

		add(new NavbarViewPanel("navbarViewPanel"));
		add(new ProductCreationViewPanel("productCreationViewPanel"));
		add(new ProductListViewPanel("productListViewPanel"));
	}

	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		response.render(JavaScriptHeaderItem.forReference(getApplication()
				.getJavaScriptLibrarySettings().getJQueryReference()));
	}

}
