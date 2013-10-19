package main.de.nordakademie.nakp.ui;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

public class ShopApplication extends WebApplication {
	
	@Override
	public Class<? extends Page> getHomePage() {
		return HomePage.class;
	}

}
