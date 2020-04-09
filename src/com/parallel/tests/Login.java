package com.parallel.tests;

import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;




public class Login {
	public String baseUrl = "https://services.empirix.com";
	String expected_homepageTitle = "VoiceWatch";
	public String chrome_driverPath = System.getProperty("user.dir")+"/drivers/chromedriver";
	public String firefox_driverPath = System.getProperty("user.dir")+"/drivers/geckodriver";
	public WebDriver driver;
	
  @BeforeTest
  @Parameters("browser")
  public void openLoginPage(String browser) throws Exception {
	  
	  if (browser.equalsIgnoreCase("Chrome")) {  
		  System.setProperty("webdriver.chrome.driver",chrome_driverPath);

	     //Opening the Browser Window
		  driver = new ChromeDriver();
	  
		  //Maximizing the Browser Window
		  driver.manage().window().maximize();
	  
		  //Opening the Login Page
		  driver.get(baseUrl);
		  System.out.println("Opening the Website on Chrome");
	  
		  //Waiting for page to load
		  driver.manage().timeouts().implicitlyWait(50000, TimeUnit.MILLISECONDS);
	  }
	  
	  else if (browser.equalsIgnoreCase("Firefox")) {
		  
		  System.setProperty("webdriver.gecko.driver",firefox_driverPath);

		  //Opening the Browser Window
		  driver = new FirefoxDriver();
		  
		  //Maximizing the Browser Window
		  driver.manage().window().maximize();
		  
		  //Opening the Login Page
		  driver.get(baseUrl);
		  System.out.println("Opening the Website on FireFox");
		  
		  //Waiting for page to load
		  driver.manage().timeouts().implicitlyWait(50000, TimeUnit.MILLISECONDS);
		  
	  }
	  
	  else {
		//If no browser passed throw exception
			throw new Exception("Browser is not correct");
	  }
  }
  
  @Test
  public void verifyLogin() {
	 try {
		 
	 //Getting the WebElement corresponding to the UserName TextField 
	 WebElement username = driver.findElement(By.name("callback_0"));
	 
	 //Getting the WebElement corresponding to the Password TextField
	 WebElement password = driver.findElement(By.name("callback_1"));
	 
	 //Getting the WebElement corresponding to the Password TextField
	 WebElement signin_Btn = driver.findElement(By.name("callback_2"));
	 
	 //
	 username.sendKeys("QA_traininguser25");
	 System.out.println("Entering the username");
	 
	 password.sendKeys("Empirix!");
	 System.out.println("Entering the password");
	 
	 
	 signin_Btn.click();
	 System.out.println("Clicking on the Sign-In button");
	 
	 Thread.sleep(30000);
	 
	 //Getting the title of the page
	 String actual_homePageTitle = driver.getTitle();
	 
	 //Verify the successful Login
	 if (actual_homePageTitle.equals(expected_homepageTitle)) { 
		System.out.println("User Login is successful"); 
	 }
	 else {
		 System.out.println("Failure in Login");
	 }
}
	 catch (Exception e) {
		 e.printStackTrace();
	 } 
  }

}
