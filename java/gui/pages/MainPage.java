package gui.pages;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class MainPage extends VerticalLayout
{
	private static final long serialVersionUID = -6125224633763538070L;
	
	public MainPage()
	{
		getStyle().set("background-color", "white").set("opacity", "0.9");
		setSizeFull();
	}
}
