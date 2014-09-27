package org.vaadin.tunis.saif.testxmlcontainer;

import javax.servlet.annotation.WebServlet;

import org.vaadin.tunis.saif.xmlcontainer.XMLContainer;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("testxmlcontainer")
public class TestxmlcontainerUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = TestxmlcontainerUI.class)
	public static class Servlet extends VaadinServlet {
	}

	private static final String FOLDER_PATH = "D:/";

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		XMLContainer xmlDataSource = XMLContainer.Factory.newInstance(FOLDER_PATH+"/adr.xml", Address.class);

		
		Table xmlTable = new Table("LoadXmlData",xmlDataSource);
		layout.addComponent(xmlTable);
		xmlTable.setSizeFull();
		
		
	}

}