package com.dev.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public Base() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\dev\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
//		String browserName = prop.getProperty("browser");
//		if(browserName.equals("chrome")) {
//			System.setProperty(prop.getProperty("chromewebdriver"), prop.getProperty("chromedriverpath") );
//			driver = new ChromeDriver();
//		}
//		else if(browserName.equals("firefox")) {
//			System.setProperty(prop.getProperty("geckowebdriver"), prop.getProperty("geckodriverpath") );
//			driver = new FirefoxDriver();
//		}
//		else {
//			System.out.println("Please pass the correct browser value from {chrome, firefox}");
//		}
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(prop.getProperty("url"));
	}

}
