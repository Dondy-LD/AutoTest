package com.pagetest;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class MyTestNG {
	static {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dondy\\git\\Auto\\Auto\\BrowserDriver\\chromedriver.exe");
		}
	private WebDriver driver = new ChromeDriver();
  @Test
  public void f2() {
	  Assert.assertEquals("b", "b");
  }
  @Test
  public void baidu_search() {
      MyPage myPage = PageFactory.initElements(driver, MyPage.class);
      driver.get("https://www.baidu.com");
      driver.manage().window().maximize();//窗口最大化
      myPage.kw_sendkeys("helenMemery");
      myPage.su_click();
      driver.close();
  }
  @AfterMethod
  public void afterMethod() {
	  //driver.close();
  }

}
