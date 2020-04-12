package com.empirix.test;

import org.testng.annotations.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstTest {
	private WebDriver driver;
	public String baseUrl = "https://services.empirix.com";
	public String expected_homepageTitle = "VoiceWatch";
	public String chrome_driverPath = System.getProperty("user.dir")+"/drivers/chromedriver";
	public String firefox_driverPath = System.getProperty("user.dir")+"/drivers/geckodriver";
	Logger log = Logger.getLogger("devpinoyLogger");
	
		@Test
  		public void verify_Login() {
			
			  try {
					 
					 //Getting the WebElement corresponding to the UserName TextField 
					 WebElement username = driver.findElement(By.name("callback_0"));
					 log.debug("Getting the username field Web element");
					 
					 //Getting the WebElement corresponding to the Password TextField
					 WebElement password = driver.findElement(By.name("callback_1"));
					 log.debug("Getting the Password field Web element");
					 
					 //Getting the WebElement corresponding to the Password TextField
					 WebElement signin_Btn = driver.findElement(By.name("callback_2"));
					 log.debug("Getting the sign-in button web element");
					 
					 //entering the username
					 username.sendKeys("QA_traininguser25");
					 log.debug("Entering the username");
					 
					 //entering the password
					 password.sendKeys("Empirix!");
					 log.debug("Entering the password");
					 
					 //clicking on Sign-In button 
					 signin_Btn.click();
					 log.debug("Clicking on the Sign-In button");
					 
					 //Wait for 30 seconds
					 Thread.sleep(30000);
					 
					 //Fetching the title of the opened page
					 String actual_homePageTitle = driver.getTitle();
					 
					 
					 //Verify the successful Login
					 if (actual_homePageTitle.equals(expected_homepageTitle)) { 
						log.info("User Login is successful"); 
					 }
					 else {
						 log.error("Failure in Login");
					 }
				}
					 catch (Exception e) {
						 e.printStackTrace();
					 } 
}
	  
  
  		@BeforeTest
  		@Parameters("browser")
  		public void open_Website(String browser) throws Exception{
  			 if (browser.equalsIgnoreCase("Chrome")) {  
  				  System.setProperty("webdriver.chrome.driver",chrome_driverPath);

  			     //Opening the Browser Window
  				  driver = new ChromeDriver();
  			  
  				  //Maximizing the Browser Window
  				  driver.manage().window().maximize();
  			  
  				  //Opening the Login Page
  				  driver.get(baseUrl);
  				  log.debug("Opening the Website on Chrome");
  			  
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
  				  log.debug("Opening the Website on FireFox");
  				  
  				  //Waiting for page to load
  				  driver.manage().timeouts().implicitlyWait(50000, TimeUnit.MILLISECONDS);
  				  
  			  }
  			  
  			  else {
  				//If no browser passed throw exception
  					throw new Exception("Browser is not correct");
  			  }
  }
  		
  @AfterTest
  public void afterTest() {
	  
	  //closing the Browser
	  driver.quit();
	  
  }

}
