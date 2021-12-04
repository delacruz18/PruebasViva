package VivaAir.Steps;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ButtonPages {

	private WebDriver driver;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Solo ida')]")
	private WebElement Solo_ida;

	@FindBy(how = How.ID, using = "station")
	private WebElement Btnorigen;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Bogotá')]")
	private WebElement Bogota;

	@FindBy(how = How.ID, using = "filter-station-second")
	private WebElement Btndestino;

	@FindBy(how = How.ID, using = "station-second")
	private WebElement Destino;


	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Barranquilla')]")
	private WebElement Barranquilla;

	@FindBy(how = How.ID, using = "date")
	private WebElement date;


	@FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='Dom'])[6]/following::div[2]")
	private WebElement FechaSalida;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Buscar')]")
	private WebElement BuscarVuelo;

	@FindBy(how = How.XPATH, using = "//body/app-root[1]/div[1]/app-booking[1]/div[1]/div[2]/app-flight-results[1]/app-flight[2]/div[1]/div[2]")
	private WebElement SegundoVuelo;

	@FindBy(how = How.ID, using = "booking-continue-btn")
	private WebElement btn_continue;

	@FindBy(how = How.CSS, using = "h4.route__text")
	private WebElement OrigPart;

	@FindBy(how = How.XPATH, using = "//h2[@class='date departure__date']")
	private WebElement FechaResumen;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Ver detalles')]")
	private WebElement PopUpdetalles;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'×')]")
	private WebElement CerrarPopUp;

	@FindBy(how = How.ID, using = "nombre1ADT")
	private WebElement nombre;

	@FindBy(how = How.ID, using = "apellido1ADT")
	private WebElement apellido;

	@FindBy(how = How.ID, using = "correo-electronico1ADT")
	private WebElement correo;

	@FindBy(how = How.ID, using = "telefono")
	private WebElement telefono;

	@FindBy(how = How.ID, using = "identificacion1ADT")
	private WebElement identificacion;






	String origen =null;
	String origenI =null;
	String destino=null;
	String DEST=null;
	String fecha = null;
	String SalidaLlegada = null;
	String[] parts = null;
	String OrigenRes = null;
	String DestRes = null;
	String FechaR = null;





	public ButtonPages(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		new Questions(driver);

	}


	public   void  Origen() {
		Solo_ida.click();
		Btnorigen.click();
		Bogota.click();
		origen=Btnorigen.getAttribute("value").replace(" ","");
		origenI = origen.substring(0, origen.length()-5);

		}


		public   void  Destino() {

		Barranquilla.click();
		 destino = Destino.getAttribute("value").replace(" ","");
		 DEST = destino.substring(0, destino.length()-5);

		}


		public   void  Fecha() {

		FechaSalida.click();
		 fecha = date.getAttribute("value");
		BuscarVuelo.click();

	}


	public void ORigenRes() {

		  WebDriverWait wait = new WebDriverWait(driver,10);
		  SegundoVuelo.click();
		  JavascriptExecutor scroll = (JavascriptExecutor) driver;
		  scroll.executeScript("arguments[0].scrollIntoView();", btn_continue);
	      btn_continue.click();
	      wait.until(ExpectedConditions.visibilityOf(OrigPart));
	      SalidaLlegada = OrigPart.getAttribute("innerText").replace(" ","");// se toma el elemento que contienen la el destino y origen -- se eliminan espacios
		  parts = SalidaLlegada.split("-"); // se divide la caddena de caracteres a partir del -
		  OrigenRes = parts[0]; // origen en resumen

	}

		  public   void  DestinoRes() {
			   SalidaLlegada = OrigPart.getAttribute("innerText").replace(" ","");
			  parts = SalidaLlegada.split("-");
			   DestRes = parts[1]; // destino en resumen

		  }


		  public   void  FechaRes() {
		   FechaR = FechaResumen.getAttribute("innerText").replace("/01","/1");

	}

		public void Resumen() {

			origen=Btnorigen.getAttribute("value").replace(" ","");
			origenI = origen.substring(0, origen.length()-5);
			 System.out.println(origenI);

			 destino = Destino.getAttribute("value").replace(" ","");
			 DEST = destino.substring(0, destino.length()-5);
			 System.out.println(DEST);


			  fecha = date.getAttribute("value").replace("/1","/01");
			  System.out.println(fecha);


			  SalidaLlegada = OrigPart.getAttribute("innerText").replace(" ","");
			  parts = SalidaLlegada.split("-");
			  OrigenRes = parts[0];
			  System.out.println(OrigenRes);

			  SalidaLlegada = OrigPart.getAttribute("innerText").replace(" ","");
			  parts = SalidaLlegada.split("-");
			   DestRes = parts[1];
			  System.out.println(DestRes);

			   FechaR = FechaResumen.getAttribute("innerText").replace("/22","/2022");
			  System.out.println(FechaR);


			  if(origenI.equals(OrigenRes) & DEST.equals(DestRes) & fecha.equals(FechaR)){

				  System.out.println("Prueba Exitosa");

			  }
			  else{

				  System.out.println("El resumen de la compra no concuerda con los datos iniciales");
				  driver.quit();

			  }

	}
	public void PopUp() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(PopUpdetalles));
		Thread.sleep(4000);
		PopUpdetalles.click();
		Thread.sleep(2000);
		CerrarPopUp.click();

	}
	public void Datos() {
		nombre.clear();
		nombre.sendKeys("carlos");
		apellido.clear();
		apellido.sendKeys("delacruz");
		correo.clear();
		correo.sendKeys("c1delacruz@gmail.com");
		telefono .clear();
		telefono.sendKeys("3106604843");
		identificacion.clear();
		identificacion.sendKeys("1298969425");


	}




}
