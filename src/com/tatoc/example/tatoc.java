package com.tatoc.example;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class tatoc {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver = new FirefoxDriver();
		//starting off
		driver.get("http://10.0.1.86");
		WebElement t= driver.findElement(By.xpath("//a[@href='/tatoc']"));
		t.click();
		Thread.sleep(300);
		//task 1
		WebElement t1= driver.findElement(By.xpath("//a[@href='/tatoc/basic']"));
		t1.click();
		Thread.sleep(300);
		driver.findElement(By.xpath("//*[contains(@class, 'greenbox')]")).click();
		//task 2
		driver.switchTo().frame(0);
		String we= driver.findElement(By.cssSelector("div#answer")).getAttribute("class");
		String s="xyz";
		while (s.equals(we)== false){
			driver.switchTo().frame("child");
			s=	driver.findElement(By.cssSelector("div#answer")).getAttribute("class");
			if(s.equals(we)== true)
				break;
			driver.switchTo().defaultContent();
			driver.switchTo().frame(0);
			WebElement w = driver.findElement(By.xpath("//a[@href='#']"));
			w.click();
	        
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		List<WebElement> sd= driver.findElements(By.xpath("//a[@href='#']"));
		sd.get(1).click();
		//task 3
		Actions action = new Actions(driver);
		WebElement Sourcelocator = driver.findElement(By.cssSelector("div#dragbox"));
		WebElement Destinationlocator = driver.findElement(By.cssSelector("div#dropbox"));
		action.dragAndDrop(Sourcelocator, Destinationlocator).build().perform();
		driver.findElement(By.xpath("//a[@href='#']")).click();
		String  handle= driver.getWindowHandle(); 
		driver.findElement(By.xpath("//a[@href='#']")).click();
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		driver.findElement(By.id("name")).sendKeys("Nikhil");
		driver.findElement(By.id("submit")).click();
		driver.switchTo().window(handle);
		List<WebElement> ds= driver.findElements(By.xpath("//a[@href='#']"));
		ds.get(1).click();
		//task 4
		driver.findElement(By.xpath("//a[@href='#']")).click();
		String ck= driver.findElement(By.id("token")).getText();
		int y= ck.length(); String z="";
		for(int x=7;x<y ; x++){
			z+=ck.charAt(x);
		}
		Cookie token = new Cookie("Token", z);
		driver.manage().addCookie(token);
		List<WebElement> dd= driver.findElements(By.xpath("//a[@href='#']"));
		dd.get(1).click();
		Thread.sleep(1000);
		driver.quit();
		
		
		
		
	}

}
