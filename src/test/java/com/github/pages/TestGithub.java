package com.github.pages;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.github.utils.Utils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class TestGithub {

	private static final Logger logger = LogManager.getLogger(TestGithub.class);
	
	@Test
	public void loginGithubAndCreateRepo() {
		
		logger.info("Начало теста");
		WebDriver driver = new FirefoxDriver();

		driver.get("http://www.github.com");
		driver.findElement(By.linkText("Sign in")).click();

		logger.info("LoginPage");
		LoginPage loginPage = new LoginPage(driver);
		String username = "Ksushabstu";
		String pass = "ksusha123";
		String rep_name = "123" + Utils.getRandomString(5);
		loginPage.login(username, pass);

		driver.get("https://github.com/new");
		logger.info("CreateRepositori");
		CreateRepositori newRepo = new CreateRepositori(driver);
		newRepo.create(rep_name);
		
		logger.info("Завершение теста");
	}

}
