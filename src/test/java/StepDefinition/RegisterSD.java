package StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class RegisterSD {
	WebDriver driver;
	
	@Given("browser is open And user is on registration page")
	public void browser_is_open_and_user_is_on_registration_page() 
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		
		driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/p[2]/a")).click();
		
	}
	
	@When("user enters values")
	public void user_enters_values()
	{
		driver.findElement(By.id("customer.firstName")).sendKeys("roshani");
		driver.findElement(By.id("customer.lastName")).sendKeys("borase");
		driver.findElement(By.id("customer.address.street")).sendKeys("dhule");
		driver.findElement(By.id("customer.address.city")).sendKeys("dhule");
		driver.findElement(By.id("customer.address.state")).sendKeys("maharashtra");
		driver.findElement(By.id("customer.address.zipCode")).sendKeys("424005");
		driver.findElement(By.id("customer.phoneNumber")).sendKeys("1234567890");
		driver.findElement(By.id("customer.ssn")).sendKeys("123");
		driver.findElement(By.id("customer.username")).sendKeys("roshaniborase");
		driver.findElement(By.id("customer.password")).sendKeys("1234");
		driver.findElement(By.id("repeatedPassword")).sendKeys("1234");
		
	}
	
	@When("click on register button")
	public void click_on_register_button() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@value='Register']")).click();
		Thread.sleep(2000);
	}
	
	@Then("message displayed login successfully")
	public void message_displayed_login_successfully()
	{
		String expectedText="Welcome roshaniborase";
	    String actualText=driver.findElement(By.xpath("//h1[@class='title']")).getText();
	    
	    Assert.assertTrue("Registration not successful", expectedText.equals(actualText));
	      

		driver.close();
	}
	
	@When("user enters some values")
	public void user_enters_some_values() {
		driver.findElement(By.id("customer.firstName")).sendKeys("roshani");
		driver.findElement(By.id("customer.address.street")).sendKeys("dhule");
		driver.findElement(By.id("customer.address.city")).sendKeys("dhule");
		driver.findElement(By.id("customer.address.state")).sendKeys("maharashtra");
	}

	@Then("display message {string}")
	public void display_message(String string) 
	{
	  String expectedText="Last name is required.";
	  String actualText=driver.findElement(By.id("customer.lastName.errors")).getText();
	    
	  Assert.assertTrue("Test case failed", expectedText.equals(actualText));
	  driver.close();
	}
	
	@When("user enters values and different password")
	public void user_enters_values_and_different_password() {
		driver.findElement(By.id("customer.firstName")).sendKeys("roshani");
		driver.findElement(By.id("customer.lastName")).sendKeys("borase");
		driver.findElement(By.id("customer.address.street")).sendKeys("dhule");
		driver.findElement(By.id("customer.address.city")).sendKeys("dhule");
		driver.findElement(By.id("customer.address.state")).sendKeys("maharashtra");
		driver.findElement(By.id("customer.address.zipCode")).sendKeys("424005");
		driver.findElement(By.id("customer.phoneNumber")).sendKeys("1234567890");
		driver.findElement(By.id("customer.ssn")).sendKeys("123");
		driver.findElement(By.id("customer.username")).sendKeys("roshani4");
		driver.findElement(By.id("customer.password")).sendKeys("1234");
		driver.findElement(By.id("repeatedPassword")).sendKeys("123456");
	}

	@Then("message displayed {string}")
	public void message_displayed(String string) 
	{
	    String expectedText="Passwords did not match.";
	    String actualText=driver.findElement(By.id("repeatedPassword.errors")).getText();
	    
	    Assert.assertTrue("Test failed", expectedText.equals(actualText));
	    driver.close();
	}
	
	@When("user enters values and existing username")
	public void user_enters_values_and_existing_username() {
		driver.findElement(By.id("customer.firstName")).sendKeys("roshani");
		driver.findElement(By.id("customer.lastName")).sendKeys("borase");
		driver.findElement(By.id("customer.address.street")).sendKeys("dhule");
		driver.findElement(By.id("customer.address.city")).sendKeys("dhule");
		driver.findElement(By.id("customer.address.state")).sendKeys("maharashtra");
		driver.findElement(By.id("customer.address.zipCode")).sendKeys("424005");
		driver.findElement(By.id("customer.phoneNumber")).sendKeys("1234567890");
		driver.findElement(By.id("customer.ssn")).sendKeys("123");
		driver.findElement(By.id("customer.username")).sendKeys("roshaniborase");
		driver.findElement(By.id("customer.password")).sendKeys("1234");
		driver.findElement(By.id("repeatedPassword")).sendKeys("1234");
	}

	@Then("message is displayed {string}")
	public void message_is_displayed(String string) throws InterruptedException {
		String expectedText="This username already exists.";
	    String actualText=driver.findElement(By.id("customer.username.errors")).getText();
	    
	    Assert.assertTrue("With existing username log in is done", expectedText.equals(actualText));
	    Thread.sleep(3000);
	    driver.close();
	}
	
	@When("user enters alphanumeric values")
	public void user_enters_alphanumeric_values() {
		driver.findElement(By.id("customer.firstName")).sendKeys("1165");
		driver.findElement(By.id("customer.lastName")).sendKeys("borase");
		driver.findElement(By.id("customer.address.street")).sendKeys("dhule");
		driver.findElement(By.id("customer.address.city")).sendKeys("dhu876");
		driver.findElement(By.id("customer.address.state")).sendKeys("maharashtra");
		driver.findElement(By.id("customer.address.zipCode")).sendKeys("424005");
		driver.findElement(By.id("customer.phoneNumber")).sendKeys("fdfdxfsfgdf");
		driver.findElement(By.id("customer.ssn")).sendKeys("123");
		driver.findElement(By.id("customer.username")).sendKeys("roshani3");
		driver.findElement(By.id("customer.password")).sendKeys("1234");
		driver.findElement(By.id("repeatedPassword")).sendKeys("1234");
	}

	@Then("message is display {string}")
	public void message_is_display(String string) throws InterruptedException {
		String expectedText="Please enter valid details.";
	    String actualText=driver.findElement(By.xpath("//h1[@class='title']")).getText();
	    
	    Assert.assertTrue("Registration complete with invalid details", expectedText.equals(actualText));
	    Thread.sleep(3000);
	    driver.close();
	}
	
	@When("^user enters (.*) and (.*) and (.*)$")
	public void user_enters_valid_username_and_password(String phoneno,String username,String password) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.id("customer.firstName")).sendKeys("roshani");
		driver.findElement(By.id("customer.lastName")).sendKeys("borase");
		driver.findElement(By.id("customer.address.street")).sendKeys("dhule");
		driver.findElement(By.id("customer.address.city")).sendKeys("dhule");
		driver.findElement(By.id("customer.address.state")).sendKeys("maharashtra");
		driver.findElement(By.id("customer.address.zipCode")).sendKeys("424005");
		driver.findElement(By.id("customer.phoneNumber")).sendKeys(phoneno);
		driver.findElement(By.id("customer.ssn")).sendKeys("123");
		driver.findElement(By.id("customer.username")).sendKeys(username);
		driver.findElement(By.id("customer.password")).sendKeys(password);
		driver.findElement(By.id("repeatedPassword")).sendKeys(password);
	  
	}
	
	

}
