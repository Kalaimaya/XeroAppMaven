package xeroapp.xerotestmaven;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import xeroapp.xerotestmaven.*;

public class AutoScripts extends Base {

	private static final WebElement ContackClick = null;
	public static WebDriver driver;
	public static ExtentTest logger;
	
	
	public static void LoginToXero1A(String browser) throws InterruptedException{
		String expString="Please enter your password.";
		
		log("Browser: " + browser);
		driver= ReuseXero.launchBrowser(browser);
		log(2);
		driver.get(ReuseXero.xeroProp.getProperty("url"));
		driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[2]/a")).click();
		log(3);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(ReuseXero.xeroProp.getProperty("username"));
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(ReuseXero.xeroProp.getProperty("password"));
		driver.findElement(By.xpath(".//*[@id='submitButton']")).click();
		Thread.sleep(6000);

		String homeTiltle=driver.getTitle();
		if(homeTiltle.contains("Xero"))
			System.out.println("Xero page verified");
		else
			System.out.println("Xero page is not verified");
		driver.close();
	}
	public static void LoginToXero1B(String browser) throws InterruptedException{
		
		log(1);
		driver= ReuseXero.launchBrowser(browser);
		log(2);
		driver.get(ReuseXero.xeroProp.getProperty("url"));
		driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[2]/a")).click();
		log(3);
		driver.manage().window().maximize();
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("kalaiarun@gmail.com");
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("Kalai");
		driver.findElement(By.xpath(".//*[@id='submitButton']")).click();
		Thread.sleep(6000);
		String expString="Your email or password is incorrect";
		String actualText=driver.findElement(By.xpath(".//*[@id='contentTop']/div[2]/div[1]/div[2]/p")).getText();
		if(actualText.equalsIgnoreCase(expString))
			System.out.println("error message verified");
		else
			System.out.println("error message is not verified...testcase failed");
		driver.close();
	}
	public static void LoginToXero1C(String browser) throws InterruptedException{

		log(1);
		driver= ReuseXero.launchBrowser(browser);
		log(2);
		driver.get(ReuseXero.xeroProp.getProperty("url"));
		driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[2]/a")).click();
		log(3);
		driver.manage().window().maximize();

		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("kalaiarun1@gmail.com");
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("Kalai123");
		driver.findElement(By.xpath(".//*[@id='submitButton']")).click();
		Thread.sleep(6000);
		String expString="Your email or password is incorrect";
		String actualText=driver.findElement(By.xpath(".//*[@id='contentTop']/div[2]/div[1]/div[2]/p")).getText();
		if(actualText.equalsIgnoreCase(expString))
			System.out.println("error message verified");
		else
			System.out.println("error message is not verified...testcase failed");
		driver.close();
	}
	public static void LoginToXero1D(String browser) throws InterruptedException{

		String expString="Please check your email";

		log(1);
		driver= ReuseXero.launchBrowser(browser);
		log(2);
		driver.get(ReuseXero.xeroProp.getProperty("url"));
		driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[2]/a")).click();

		log(3);
		driver.manage().window().maximize();
		driver.findElement(By.xpath(".//*[@id='contentTop']/div[2]/div[1]/a")).click();
		Thread.sleep(6000);
		if(driver.getTitle().contains("Forgotten your password?"))
			System.out.println("forgot password page is verified");
		else
			System.out.println("forgot password page is not verified");


		driver.findElement(By.xpath(".//*[@id='UserName']")).sendKeys("kalaiarun@gmail.com");
		driver.findElement(By.xpath(".//*[@id='submitButton']/a/span")).click();
		Thread.sleep(2000);
		String actText=driver.findElement(By.xpath(".//*[@id='contentTop']/div/h2")).getText();
		if(actText.equalsIgnoreCase(expString))
			System.out.println("reset message verified");
		else
			System.out.println("reset message is not verified");
		driver.close();

	}

	public static void XerTest2A(String browser){
		log(1);
		driver= ReuseXero.launchBrowser(browser);
		log(2);
		driver.get(ReuseXero.xeroProp.getProperty("url"));
		log(3);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[2]/div/div/div[3]/a")).click();
		String expString="30 day free trial";
		String actText=driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[1]/h2")).getText();
		if(actText.equalsIgnoreCase(expString))
			System.out.println("message verified");
		else
			System.out.println("message is not verified");
		driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[2]/label/input")).sendKeys("Kalai");
		driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[3]/label/input")).sendKeys("Maya");
		driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[4]/label/input")).sendKeys("kalaiarun@gmail.com");
		driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[5]/label/input")).sendKeys("415 123 4567");
		WebElement dropdown=driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[6]/label/span/select"));
		Select select= new Select(dropdown);
		select.selectByVisibleText("United States");
		driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[8]/div/label/input")).click();
		driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[9]/span/button")).click();
		String expString1="Kalai, an email is on its way";
		String actText1=driver.findElement(By.xpath("html/body/main/div/div/div/div[1]/div/div/div[2]/h1")).getText();
		if(actText1.equalsIgnoreCase(expString1))
			System.out.println("Inbox page verified");
		else
			System.out.println("Inbox page is not verified");
		driver.close();
	}
	public static void XeroTest2B(String browser){
		log(1);
		driver= ReuseXero.launchBrowser(browser);
		log(2);
		driver.get(ReuseXero.xeroProp.getProperty("url"));
		log(3);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[2]/div/div/div[3]/a")).click();
		driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[2]/label/input")).sendKeys("");
		driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[3]/label/input")).sendKeys("");
		driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[4]/label/input")).sendKeys("");
		driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[5]/label/input")).sendKeys("");
		driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[8]/div/label/input")).click();
		driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[9]/span/button")).click();
		System.out.println("Error message displyed");
	}
	public static void XeroTest2B1(String browser){
		log(1);
		driver= ReuseXero.launchBrowser(browser);
		log(2);
		driver.get(ReuseXero.xeroProp.getProperty("url"));
		log(3);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[2]/div/div/div[3]/a")).click();
		driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[2]/label/input")).sendKeys("");
		driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[3]/label/input")).sendKeys("");
		driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[4]/label/input")).sendKeys("kal@123.com");
		driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[5]/label/input")).sendKeys("");
		driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[8]/div/label/input")).click();
		driver.findElement(By.xpath("html/body/div[6]/main/div[1]/div/div/form/div[9]/span/button")).click();
		System.out.println("Error message displyed");
	}
	public static void XeroTest2C(String browser){
		log(1);
		driver= ReuseXero.launchBrowser(browser);
		log(2);
		driver.get(ReuseXero.xeroProp.getProperty("url"));
		log(3);
		driver.manage().window().maximize();
		driver.findElement(By.xpath(".//*[@id='section-id-signup']/div/div[1]/div/div/p[2]/a")).click();
		String expString="Offer details";
		String actText=driver.findElement(By.xpath("html/body/div[6]/main/div/div[1]/div/div/h1")).getText();
		if(actText.equalsIgnoreCase(expString))
			System.out.println("message verified");
		else
			System.out.println("message is not verified");
		driver.findElement(By.xpath("html/body/div[6]/main/div/div[2]/div[1]/div/p[6]/span/a")).click();
		String expString1="Xero Terms of Use";
		String actText1=driver.findElement(By.xpath("html/body/main/div[2]/div/div/div[1]/h2")).getText();
		if(actText1.equalsIgnoreCase(expString1))
			System.out.println("message verified");
		else
			System.out.println("message is not verified");
		driver.close();
	}
	
	public static void XeroTest2D(String browser){
		log(1);
		driver= ReuseXero.launchBrowser(browser);
		log(2);
		driver.get(ReuseXero.xeroProp.getProperty("url"));
		log(3);
		driver.manage().window().maximize();
		driver.findElement(By.xpath(".//*[@id='section-id-signup']/div/div[1]/div/div/p[2]/a")).click();
		String expString="Offer details";
		String actText=driver.findElement(By.xpath("html/body/div[6]/main/div/div[1]/div/div/h1")).getText();
		if(actText.equalsIgnoreCase(expString))
			System.out.println("message verified");
		else
			System.out.println("message is not verified");
		driver.close();

	}

	public static void XeroTest2E(String browser){
		log(1);
		driver= ReuseXero.launchBrowser(browser);
		log(2);
		driver.get(ReuseXero.xeroProp.getProperty("url"));
		log(3);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[1]/a")).click();
		driver.findElement(By.xpath("html/body/div[6]/main/div[2]/div/div/div/p/a")).click();
		String expString=" Let’s get started ";
		String actText=driver.findElement(By.xpath("html/body/div[6]/main/div/div[1]/div/div/h2")).getText();
		if(actText.equalsIgnoreCase(expString))
			System.out.println("Page displayed");
		else
			System.out.println("page is not displayed");
		driver.close();

	}
	public static void XeroTest3A(String browser) throws InterruptedException{
		log(1);
		driver= ReuseXero.launchBrowser(browser);
		log(2);
		driver.get(ReuseXero.xeroProp.getProperty("url"));
		driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[2]/a")).click();

		log(3);
		driver.manage().window().maximize();

		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(ReuseXero.xeroProp.getProperty("username"));
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(ReuseXero.xeroProp.getProperty("password"));
		driver.findElement(By.xpath(".//*[@id='submitButton']")).click();
		//Thread.sleep(6000);
		driver.findElement(By.xpath(".//*[@id='Dashboard']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='Accounts']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath(".//*[@id='Payroll']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath(".//*[@id='Reports']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath(".//*[@id='Contacts']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath(".//*[@id='Settings']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath(".//*[@id='quicklaunchTab']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[2]/ul/li[2]/a")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[2]/ul/li[3]/a")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[2]/ul/li[4]/a")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[2]/ul/li[5]/a")).click();
		Thread.sleep(2000);

		System.out.println("All the links are displaying the pages");
		driver.close();
	}
	public static void XeroTest4A(String browser){
		log(1);
		driver= ReuseXero.launchBrowser(browser);
		log(2);
		driver.get(ReuseXero.xeroProp.getProperty("url"));
		driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[2]/a")).click();

		log(3);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(ReuseXero.xeroProp.getProperty("username"));
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(ReuseXero.xeroProp.getProperty("password"));
		driver.findElement(By.xpath(".//*[@id='submitButton']")).click();
		driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[2]/a")).click();
		driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[2]/div/ul/li[3]/a")).click();
		System.out.println("Logged out successfully");
		driver.close();
	}
	public static void XeroTest6A(String browser) throws InterruptedException{
		log(1);
		driver= ReuseXero.launchBrowser(browser);
		log(2);
		driver.get(ReuseXero.xeroProp.getProperty("url"));
		driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[2]/a")).click();

		log(3);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(ReuseXero.xeroProp.getProperty("username"));
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(ReuseXero.xeroProp.getProperty("password"));
		driver.findElement(By.xpath(".//*[@id='submitButton']")).click();
		driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[2]/a")).click();
		driver.findElement(By.xpath(".//*[@id='xero-nav']/div/div[1]/div[2]/div/ul/li[1]/a")).click();
		driver.findElement(By.xpath(".//*[@id='button-1041-btnInnerEl']")).click();
		//FluentWait<WebDriver> wait = null;
//		String account=".//*[@id='filefield-1174-button-fileInputEl']";
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		//driver.findElement(By.xpath("//div[@id='photoSection']/div")).click();
		String f1=".//*[@id='filefield-1174-button-fileInputEl']";
		Thread.sleep(2000);
		//wait1.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(f1))));
		driver.findElement(By.xpath(f1)).sendKeys("C:\\Users\\meta\\Desktop\\Capture.png");
	   // WebElement browse=wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='filefield-1174-button-fileInputEl']")));
		//browse.sendKeys("C:\\Users\\meta\\Desktop\\Capture.png");
		//driver.findElement(By.xpath(".//*[@id='filefield-1174-button-fileInputEl']")).click();
		driver.findElement(By.xpath(".//*[@id='button-1178-btnInnerEl']")).click();
        System.out.println("Picture uploded");
        driver.close();
	}
	public static void XeroTest8A(String browser){
		log(1);
		driver= ReuseXero.launchBrowser(browser);
		log(2);
		driver.get(ReuseXero.xeroProp.getProperty("url"));
		driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[2]/a")).click();

		log(3);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(ReuseXero.xeroProp.getProperty("username"));
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(ReuseXero.xeroProp.getProperty("password"));
		driver.findElement(By.xpath(".//*[@id='submitButton']")).click();
		driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[1]/div/h2/a")).click();
		driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[1]/div/div/div/a")).click();
		String expString="My Xero";
		String actText=driver.findElement(By.xpath(".//*[@id='page_title']/div/h1")).getText();
		if(actText.equalsIgnoreCase(expString))
			System.out.println("Page displayed");
		else
			System.out.println("page is not displayed");
		driver.findElement(By.xpath(".//*[@id='ext-gen1042']")).click();
		driver.findElement(By.xpath(".//*[@id='text-1022-inputEl']")).sendKeys("Tekarch");
		driver.findElement(By.xpath(".//*[@id='ext-gen1096']")).click();
		driver.findElement(By.xpath(".//*[@id='countryCmb-boundlist-listEl']/ul/li[229]")).click();
		driver.findElement(By.xpath(".//*[@id='ext-gen1100']")).click();
		driver.findElement(By.xpath(".//*[@id='cmbTimeZone-boundlist-listEl']/ul/li[115]/span[2]")).click();
		driver.findElement(By.xpath(".//*[@id='industrysearchcombofield-1025-inputEl']")).sendKeys("Accounting");
		driver.findElement(By.xpath(".//*[@id='ext-gen1119']")).click();
		driver.findElement(By.xpath(".//*[@id='combo-1029-boundlist-listEl']/ul/li[6]")).click();
        driver.findElement(By.xpath(".//*[@id='simplebutton-1035']")).click();
        System.out.println("Values are added");
        driver.close();
	}
	public static void XeroTest8B(String browser){
		log(1);
		driver= ReuseXero.launchBrowser(browser);
		log(2);
		driver.get(ReuseXero.xeroProp.getProperty("url"));
		driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[2]/a")).click();

		log(3);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(ReuseXero.xeroProp.getProperty("username"));
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(ReuseXero.xeroProp.getProperty("password"));
		driver.findElement(By.xpath(".//*[@id='submitButton']")).click();
		driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[1]/div/h2/a")).click();
		driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[1]/div/div/div/a")).click();
		String expString="My Xero";
		String actText=driver.findElement(By.xpath(".//*[@id='page_title']/div/h1")).getText();
		if(actText.equalsIgnoreCase(expString))
			System.out.println("Page displayed");
		else
			System.out.println("page is not displayed");
		driver.findElement(By.xpath(".//*[@id='ext-gen1043']")).click();
		driver.findElement(By.xpath(".//*[@id='text-1022-inputEl']")).sendKeys("Self");
		driver.findElement(By.xpath(".//*[@id='ext-gen1096']")).click();
		driver.findElement(By.xpath(".//*[@id='countryCmb-boundlist-listEl']/ul/li[229]")).click();
		driver.findElement(By.xpath(".//*[@id='ext-gen1100']")).click();
		driver.findElement(By.xpath(".//*[@id='cmbTimeZone-boundlist-listEl']/ul/li[115]/span[2]")).click();
		driver.findElement(By.xpath(".//*[@id='industrysearchcombofield-1025-inputEl']")).sendKeys("Accounting");
		driver.findElement(By.xpath(".//*[@id='ext-gen1119']")).click();
		driver.findElement(By.xpath(".//*[@id='combo-1029-boundlist-listEl']/ul/li[6]")).click();
        driver.findElement(By.xpath(".//*[@id='simplebutton-1036']")).click();
        System.out.println("Purchase plan should be displayed");
        driver.close();
	}
	public static void XeroTest8C(String browser){
		log(1);
		driver= ReuseXero.launchBrowser(browser);
		log(2);
		driver.get(ReuseXero.xeroProp.getProperty("url"));
		driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[2]/a")).click();

		log(3);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(ReuseXero.xeroProp.getProperty("username"));
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(ReuseXero.xeroProp.getProperty("password"));
		driver.findElement(By.xpath(".//*[@id='submitButton']")).click();
		driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[1]/div/h2/a")).click();
		driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[1]/div/div/div/a")).click();
		String expString="My Xero";
		String actText=driver.findElement(By.xpath(".//*[@id='page_title']/div/h1")).getText();
		if(actText.equalsIgnoreCase(expString))
			System.out.println("Page displayed");
		else
			System.out.println("page is not displayed");
		driver.findElement(By.xpath(".//*[@id='ext-gen1043']")).click();
		driver.findElement(By.xpath(".//*[@id='text-1022-inputEl']")).sendKeys("Self");
		driver.findElement(By.xpath(".//*[@id='ext-gen1096']")).click();
		driver.findElement(By.xpath(".//*[@id='countryCmb-boundlist-listEl']/ul/li[229]")).click();
		driver.findElement(By.xpath(".//*[@id='ext-gen1100']")).click();
		driver.findElement(By.xpath(".//*[@id='cmbTimeZone-boundlist-listEl']/ul/li[115]/span[2]")).click();
		driver.findElement(By.xpath(".//*[@id='industrysearchcombofield-1025-inputEl']")).sendKeys("Accounting");
		driver.findElement(By.xpath(".//*[@id='ext-gen1119']")).click();
		driver.findElement(By.xpath(".//*[@id='combo-1029-boundlist-listEl']/ul/li[6]")).click();
        driver.findElement(By.xpath(".//*[@id='simplebutton-1036']")).click();
        System.out.println("Purchase plan should be displayed");
        driver.findElement(By.xpath(".//*[@id='PRODUCTOPTION/ORG/SOLO']/div[1]/label")).click();
        driver.findElement(By.xpath(".//*[@id='frmMain']/div/div[2]/div/main/div[10]/button")).click();
        driver.findElement(By.xpath(".//*[@id='POAddress']")).sendKeys("3450 granada ave");
        driver.findElement(By.xpath(".//*[@id='POCity']")).sendKeys("Santa Clara");
        WebElement dropdown=driver.findElement(By.xpath(".//*[@id='PORegionDropdown']"));
		Select select= new Select(dropdown);
		select.selectByVisibleText("California");
        //driver.findElement(By.xpath(".//*[@id='PORegionDropdown']")).sendKeys("Ca");
        driver.findElement(By.xpath(".//*[@id='POPostalCode']")).sendKeys("95051");
        driver.findElement(By.xpath(".//*[@id='frmMain']/div/div/div/main/div[3]/div/div[2]/div/button")).click();
        driver.findElement(By.xpath(".//*[@id='card-element']")).sendKeys("1234567812345678");
        driver.findElement(By.xpath(".//*[@id='card-expiry']")).sendKeys("06/18");
        driver.findElement(By.xpath(".//*[@id='card-cvc']")).sendKeys("486");
        driver.findElement(By.xpath(".//*[@id='cardholder-name']")).sendKeys("KalaiMaya");
        driver.findElement(By.xpath(".//*[@id='authoriseStripeButton']")).click();
        System.out.println("Authorization Confirmed");        
        driver.close();
	}
	public static void XeroTest8D(String browser){
		log(1);
		driver= ReuseXero.launchBrowser(browser);
		log(2);
		driver.get(ReuseXero.xeroProp.getProperty("url"));
		driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[2]/a")).click();

		log(3);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(ReuseXero.xeroProp.getProperty("username"));
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(ReuseXero.xeroProp.getProperty("password"));
		driver.findElement(By.xpath(".//*[@id='submitButton']")).click();
		driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[1]/div/h2/a")).click();
		driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[1]/div/div/div/a")).click();
		String expString="My Xero";
		String actText=driver.findElement(By.xpath(".//*[@id='page_title']/div/h1")).getText();
		if(actText.equalsIgnoreCase(expString))
			System.out.println("Page displayed");
		else
			System.out.println("page is not displayed");
		driver.findElement(By.xpath(".//*[@id='ext-gen1043']")).click();
		driver.findElement(By.xpath(".//*[@id='text-1022-inputEl']")).sendKeys("Self");
		driver.findElement(By.xpath(".//*[@id='ext-gen1096']")).click();
		driver.findElement(By.xpath(".//*[@id='countryCmb-boundlist-listEl']/ul/li[229]")).click();
		driver.findElement(By.xpath(".//*[@id='ext-gen1100']")).click();
		driver.findElement(By.xpath(".//*[@id='cmbTimeZone-boundlist-listEl']/ul/li[115]/span[2]")).click();
		driver.findElement(By.xpath(".//*[@id='industrysearchcombofield-1025-inputEl']")).sendKeys("Accounting");
		driver.findElement(By.xpath(".//*[@id='ext-gen1119']")).click();
		driver.findElement(By.xpath(".//*[@id='combo-1029-boundlist-listEl']/ul/li[6]")).click();
        driver.findElement(By.xpath(".//*[@id='simplebutton-1036']")).click();
        System.out.println("Purchase plan should be displayed");
        driver.findElement(By.xpath(".//*[@id='PRODUCTOPTION/ORG/STANDARD']/div[1]/label")).click();
        driver.findElement(By.xpath(".//*[@id='frmMain']/div/div[2]/div/main/div[10]/button")).click();
        driver.findElement(By.xpath(".//*[@id='POAddress']")).sendKeys("3450 granada ave");
        driver.findElement(By.xpath(".//*[@id='POCity']")).sendKeys("Santa Clara");
        WebElement dropdown=driver.findElement(By.xpath(".//*[@id='PORegionDropdown']"));
		Select select= new Select(dropdown);
		select.selectByVisibleText("California");
        //driver.findElement(By.xpath(".//*[@id='PORegionDropdown']")).sendKeys("Ca");
        driver.findElement(By.xpath(".//*[@id='POPostalCode']")).sendKeys("95051");
        driver.findElement(By.xpath(".//*[@id='frmMain']/div/div/div/main/div[3]/div/div[2]/div/button")).click();
        driver.findElement(By.xpath(".//*[@id='card-element']")).sendKeys("1234567812345678");
        driver.findElement(By.xpath(".//*[@id='card-expiry']")).sendKeys("06/18");
        driver.findElement(By.xpath(".//*[@id='card-cvc']")).sendKeys("486");
        driver.findElement(By.xpath(".//*[@id='cardholder-name']")).sendKeys("KalaiMaya");
        driver.findElement(By.xpath(".//*[@id='authoriseStripeButton']")).click();
        System.out.println("Authorization Confirmed");        
        driver.close();
	}
	public static void XeroTest8E(String browser){
		log(1);
		driver= ReuseXero.launchBrowser(browser);
		log(2);
		driver.get(ReuseXero.xeroProp.getProperty("url"));
		driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[2]/a")).click();

		log(3);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(ReuseXero.xeroProp.getProperty("username"));
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(ReuseXero.xeroProp.getProperty("password"));
		driver.findElement(By.xpath(".//*[@id='submitButton']")).click();
		driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[1]/div/h2/a")).click();
		driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[1]/div/div/div/a")).click();
		String expString="My Xero";
		String actText=driver.findElement(By.xpath(".//*[@id='page_title']/div/h1")).getText();
		if(actText.equalsIgnoreCase(expString))
			System.out.println("Page displayed");
		else
			System.out.println("page is not displayed");
		driver.findElement(By.xpath(".//*[@id='ext-gen1043']")).click();
		driver.findElement(By.xpath(".//*[@id='text-1022-inputEl']")).sendKeys("Self");
		driver.findElement(By.xpath(".//*[@id='ext-gen1096']")).click();
		driver.findElement(By.xpath(".//*[@id='countryCmb-boundlist-listEl']/ul/li[229]")).click();
		driver.findElement(By.xpath(".//*[@id='ext-gen1100']")).click();
		driver.findElement(By.xpath(".//*[@id='cmbTimeZone-boundlist-listEl']/ul/li[115]/span[2]")).click();
		driver.findElement(By.xpath(".//*[@id='industrysearchcombofield-1025-inputEl']")).sendKeys("Accounting");
		driver.findElement(By.xpath(".//*[@id='ext-gen1119']")).click();
		driver.findElement(By.xpath(".//*[@id='combo-1029-boundlist-listEl']/ul/li[6]")).click();
        driver.findElement(By.xpath(".//*[@id='simplebutton-1036']")).click();
        System.out.println("Purchase plan should be displayed");
        driver.findElement(By.xpath(".//*[@id='PRODUCTOPTION/ORG/PRO']/div[1]/label")).click();
        driver.findElement(By.xpath(".//*[@id='frmMain']/div/div[2]/div/main/div[10]/button")).click();
        driver.findElement(By.xpath(".//*[@id='POAddress']")).sendKeys("3450 granada ave");
        driver.findElement(By.xpath(".//*[@id='POCity']")).sendKeys("Santa Clara");
        WebElement dropdown=driver.findElement(By.xpath(".//*[@id='PORegionDropdown']"));
		Select select= new Select(dropdown);
		select.selectByVisibleText("California");
        //driver.findElement(By.xpath(".//*[@id='PORegionDropdown']")).sendKeys("Ca");
        driver.findElement(By.xpath(".//*[@id='POPostalCode']")).sendKeys("95051");
        driver.findElement(By.xpath(".//*[@id='frmMain']/div/div/div/main/div[3]/div/div[2]/div/button")).click();
        driver.findElement(By.xpath(".//*[@id='card-element']")).sendKeys("1234567812345678");
        driver.findElement(By.xpath(".//*[@id='card-expiry']")).sendKeys("06/18");
        driver.findElement(By.xpath(".//*[@id='card-cvc']")).sendKeys("486");
        driver.findElement(By.xpath(".//*[@id='cardholder-name']")).sendKeys("KalaiMaya");
        driver.findElement(By.xpath(".//*[@id='authoriseStripeButton']")).click();
        System.out.println("Authorization Confirmed");        
        driver.close();
	}
	public static void XeroTest8F(String browser){
		log(1);
		driver= ReuseXero.launchBrowser(browser);
		log(2);
		driver.get(ReuseXero.xeroProp.getProperty("url"));
		driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[2]/a")).click();

		log(3);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(ReuseXero.xeroProp.getProperty("username8"));
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(ReuseXero.xeroProp.getProperty("password8"));
		driver.findElement(By.xpath(".//*[@id='submitButton']")).click();
		driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[1]/div/h2/a")).click();
		driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[1]/div[1]/div/div/div/a")).click();
		String expString="My Xero";
		String actText=driver.findElement(By.xpath(".//*[@id='page_title']/div/h1")).getText();
		if(actText.equalsIgnoreCase(expString))
			System.out.println("Page displayed");
		else
			System.out.println("page is not displayed");
		driver.findElement(By.xpath(".//*[@id='ext-gen1043']")).click();
		driver.findElement(By.xpath(".//*[@id='text-1022-inputEl']")).sendKeys("Self");
		driver.findElement(By.xpath(".//*[@id='ext-gen1096']")).click();
		driver.findElement(By.xpath(".//*[@id='countryCmb-boundlist-listEl']/ul/li[229]")).click();
		driver.findElement(By.xpath(".//*[@id='ext-gen1100']")).click();
		driver.findElement(By.xpath(".//*[@id='cmbTimeZone-boundlist-listEl']/ul/li[115]/span[2]")).click();
		driver.findElement(By.xpath(".//*[@id='industrysearchcombofield-1025-inputEl']")).sendKeys("Accounting");
		driver.findElement(By.xpath(".//*[@id='ext-gen1119']")).click();
		driver.findElement(By.xpath(".//*[@id='combo-1029-boundlist-listEl']/ul/li[2]")).click();
		driver.findElement(By.xpath(".//*[@id='simplebutton-1036']")).click();
		String expString1="Select a plan";
		String actText1=driver.findElement(By.xpath(".//*[@id='frmMain']/div/div[2]/div/main/div[2]/h3")).getText();
		if(actText1.equalsIgnoreCase(expString1))
			System.out.println("Plan Page displayed");
		else
			System.out.println("Plan page is not displayed");
		driver.close();
		
	}
	public static void XeroTest10A(String browser){
		//public static WebDriver driver;
		log(1);
		driver= ReuseXero.launchBrowser(browser);
		log(2);
		driver.get(ReuseXero.xeroProp.getProperty("url"));
		driver.findElement(By.xpath("html/body/div[6]/header/nav/div[2]/div/div[1]/div/div/ul/li[2]/a")).click();

		log(3);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(ReuseXero.xeroProp.getProperty("username"));
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(ReuseXero.xeroProp.getProperty("password"));
		driver.findElement(By.xpath(".//*[@id='submitButton']")).click();
		driver.findElement(By.xpath(".//*[@id='Accounts']")).click();
		driver.findElement(By.xpath(".//*[@id='xero-nav']/div[2]/div[2]/div[1]/ul/li[2]/ul/li[4]/a")).click();String expString=" Let’s get started ";
		String expString1="Checks";
		String actText=driver.findElement(By.xpath(".//*[@id='title']")).getText();
		if(actText.equalsIgnoreCase(expString1))
			System.out.println("Page should be displayed");
		else
			System.out.println("page is not displayed");
		
		driver.close();
	}
}