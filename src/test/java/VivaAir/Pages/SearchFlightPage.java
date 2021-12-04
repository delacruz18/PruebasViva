package VivaAir.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import VivaAir.Steps.ButtonPages;
import net.thucydides.core.annotations.Step;

public class SearchFlightPage {

	private WebDriver driver;	
		private ButtonPages buttonPages;
	
	

	

	public SearchFlightPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;	
		this.buttonPages = new ButtonPages(driver);
	}

	@Step
	public void Serch() {		
			buttonPages.Origen();
			buttonPages.Destino();
			buttonPages.Fecha();
	    	
	}

	
	

}
