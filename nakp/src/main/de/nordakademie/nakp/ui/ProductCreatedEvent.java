package main.de.nordakademie.nakp.ui;

import org.apache.wicket.ajax.AjaxRequestTarget;

public class ProductCreatedEvent {

	private AjaxRequestTarget target;

	public ProductCreatedEvent(AjaxRequestTarget target) {
		this.target = target;
	}

	public AjaxRequestTarget getTarget() {
		return target;
	}

}
