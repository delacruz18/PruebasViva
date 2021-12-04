package VivaAir.Steps;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import net.thucydides.core.annotations.Step;

public class Questions {

	private WebDriver driver;

	public Questions(WebDriver driver) {
		this.driver = driver;
	}

	@Step
	public void impliciWait() {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Step
	public void tiempoSegundos(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}