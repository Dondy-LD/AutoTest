package com.pagetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	WebDriver driver;
	private final int timeout = 10;//超时时间
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	//
	public void sendkeys(WebElement element, String s) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(s);
	}
	//
	public void click(WebElement element) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		element.click();
	}
}
