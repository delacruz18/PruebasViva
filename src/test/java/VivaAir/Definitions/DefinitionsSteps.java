package VivaAir.Definitions;

import org.openqa.selenium.WebDriver;

import VivaAir.Pages.SearchFlightPage;
import VivaAir.Pages.SelectFlightPage;
import VivaAir.Steps.Connection;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class DefinitionsSteps {

	private WebDriver driver;
	private Connection connection = new Connection();
	private SearchFlightPage searchFlightPage = new SearchFlightPage(driver);
	private SelectFlightPage selectFlightPage = new SelectFlightPage(driver);

	@Given("^open browser page Avianca$")
	public void abrir_navegador() {
		this.connection = new Connection();
		this.driver = this.connection.openBrowser();

	}

	@And("^search Flight from and destination$")
	public void searchFligth() {
		this.searchFlightPage = new SearchFlightPage(driver);
		this.searchFlightPage.Serch();

	}
	

	@And("^select Fligh$")
	public void searchDates() {
		this.selectFlightPage = new SelectFlightPage(driver);
		this.selectFlightPage.selectFlightM();	
	}	
	
	
	
	@Then("^show the flight information$")
	public void information() throws InterruptedException {
		this.selectFlightPage = new SelectFlightPage(driver);
		this.selectFlightPage.flightInformationM();
	}

}