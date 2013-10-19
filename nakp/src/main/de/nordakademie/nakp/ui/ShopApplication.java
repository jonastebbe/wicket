package main.de.nordakademie.nakp.ui;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.wicketstuff.annotation.scan.AnnotatedMountScanner;

public class ShopApplication extends WebApplication {

	@Override
	public Class<? extends Page> getHomePage() {
		return HomePage.class;
	}

	@Override
	protected void init() {
		super.init();
		new AnnotatedMountScanner().scanPackage("main.de.nordakademie.nakp.ui")
				.mount(this);
		getComponentInstantiationListeners().add(
				new SpringComponentInjector(this));

	}
}
