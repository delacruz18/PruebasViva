package VivaAir.Steps;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.Before;
import net.thucydides.core.annotations.Step;

public class Connection {

	private WebDriver driver;

	@Before
	@Step
	public WebDriver openBrowser() {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.vivaair.com/#/co/es");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return this.driver;

	}

}
