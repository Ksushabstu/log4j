package com.github.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

		private WebDriver driver;

		/*@FindBy(linkText = "Sign in")
		private WebElement exit;*/

		@FindBy(id = "login_field")
		private WebElement name;

		@FindBy(id = "password")
		private WebElement password;
		
	    @FindBy (name = "commit")
		private WebElement buttonSubmit;

		
		public LoginPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
	        this.driver = driver;
		}
		
		public void login(String username, String pass) {
			name.sendKeys(username);
			password.sendKeys(pass);
			buttonSubmit.click();
		}
}
