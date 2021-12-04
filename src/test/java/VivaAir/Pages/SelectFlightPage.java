package VivaAir.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import VivaAir.Steps.ButtonPages;

import net.thucydides.core.annotations.Step;

public class SelectFlightPage {

	private WebDriver driver;
	private ButtonPages buttonPages;


	
	public SelectFlightPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.buttonPages = new ButtonPages(driver);
		

	}

	@Step
	public void selectFlightM() {		
		buttonPages.ORigenRes();
		buttonPages.DestinoRes();
		buttonPages.FechaRes();

		}

	

	@Step
	public void flightInformationM() throws InterruptedException {
		buttonPages.Resumen();
		buttonPages.PopUp();
		buttonPages.Datos();
	}
}
