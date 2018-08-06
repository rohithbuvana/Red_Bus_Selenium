package com.capgemini.RedBus;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BookingStepws {
	WebDriver driver=null;
	@Given("^: that user loads the redbus page$")
	public void that_user_loads_the_redbus_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver.exe");
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver(options);
		driver.get("https://www.redbus.in"); 
	}

	@When("^: User enters the source as \"([^\"]*)\"$")
	public void user_enters_the_source_as(String arg1) throws Throwable {
	    driver.findElement(By.id("src")).sendKeys(arg1);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);				
	    driver.findElement(By.xpath("//*[@id=\"search\"]/div/div[1]/div/ul/li[1]")).click();
	}

	@When("^: User enters the destination as \"([^\"]*)\"$")
	public void user_enters_the_destination_as(String arg1) throws Throwable {
		 driver.findElement(By.id("dest")).sendKeys(arg1);
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		 driver.findElement(By.xpath("//*[@id=\"search\"]/div/div[2]/div/ul/li[1]")).click();
	}

	@When("^: User enters the onward date as \"([^\"]*)\"$")
	public void user_enters_the_onward_date_as(String arg1) throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"search\"]/div/div[3]/div/label")).click();
		WebElement dateWidget = driver.findElement(By.xpath("//*[@id=\"rb-calendar_onward_cal\"]"));
		Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(arg1);
		List<WebElement> columns=dateWidget.findElements(By.tagName("td"));

		for (WebElement cell: columns){
		   if (cell.getText().equals(String.valueOf(date1.getDate()))){
		     cell.click();
		      break;
		 }
		}
	}

	@When("^: User clicks on search buses button$")
	public void user_clicks_on_search_buses_button() throws Throwable {
	    driver.findElement(By.id("search_btn")).click();
	}

	@When("^: User clicks on the view seats button$")
	public void user_clicks_on_the_view_seats_button() throws Throwable {
	  driver.findElement(By.xpath("//*[@id=\"8368723\"]/div/div[2]/div[1]")).click(); 
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}

	@When("^: User selects the seat$")
	public void user_selects_the_seat() throws Throwable {
		Actions clickAt = new Actions(driver);
		clickAt.moveToElement(driver.findElement(By.xpath("//*[@id=\"rt_8368723\"]/div/div/div/div[2]/div[2]/div[2]/canvas")), 60, 30).click().build().perform();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^: User selects the boarding point$")
	public void user_selects_the_boarding_point() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"8368723\"]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[1]/ul/li[1]/span[2]")).click();
	}

	@When("^: User clicks on proceed$")
	public void user_clicks_on_proceed() throws Throwable {
	  driver.findElement(By.xpath("//*[@id=\"8368723\"]/div[2]/div[2]/div[2]/div[2]/div[2]/div/div[6]/button")).click();
	}

	@When("^: User enters the name as \"([^\"]*)\"$")
	public void user_enters_the_name_as(String arg1) throws Throwable {
	   driver.findElement(By.xpath("//*[@id=\"seatno-04\"]")).sendKeys(arg1);
	}

	@When("^: User selects gender as \"([^\"]*)\"$")
	public void user_selects_gender_as(String arg1) throws Throwable {
	   if(arg1.toLowerCase().equals("male"))
	   {
		   driver.findElement(By.xpath("//*[@id=\"22_0\"]")).click();
	   }
	   else
	   {
		   driver.findElement(By.xpath("//*[@id=\"23_0\"]")).click();
	   }
	}

	@When("^: User enters age as\"([^\"]*)\"$")
	public void user_enters_age_as(String arg1) throws Throwable {
		 driver.findElement(By.xpath("//*[@id=\"seatno-01\"]")).sendKeys(arg1);
	}

	@When("^: User enters the email as \"([^\"]*)\"$")
	public void user_enters_the_email_as(String arg1) throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"seatno-05\"]")).sendKeys(arg1);
	} 

	@When("^: User enters the phone number as \"([^\"]*)\"$")
	public void user_enters_the_phone_number_as(String arg1) throws Throwable {
		 driver.findElement(By.xpath("//*[@id=\"seatno-06\"]")).sendKeys(arg1);
	}

	@When("^: User clicks proceed to pay$")
	public void user_clicks_proceed_to_pay() throws Throwable {
	    driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[4]/div/div/div[2]/div[2]/input")).click();
	}

	@Then("^: the user booked successfully$")
	public void the_user_booked_successfully() throws Throwable {
	    
	}


}
