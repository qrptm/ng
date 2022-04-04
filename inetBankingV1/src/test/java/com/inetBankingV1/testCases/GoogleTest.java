package com.inetBankingV1.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class GoogleTest extends BaseClass {
	@Test
	public void testGoogle() throws Exception {
		driver.get("https://www.google.co.in");
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("Hel");

		WebElement list = driver.findElement(By.className("wM6W7d"));
		Thread.sleep(2000);
//		WebDriverWait w = new WebDriverWait(driver, 5);
//		w.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul")));
//		list.findElement(By.partialLinkText("Helen Keller"))
//				.click();
		driver.findElement(By.cssSelector(
				"li.sbct:nth-child(6) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > span:nth-child(1)"))
				.click();

	}

}
