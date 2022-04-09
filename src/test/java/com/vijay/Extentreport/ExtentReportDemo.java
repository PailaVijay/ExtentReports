package com.vijay.Extentreport;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReportDemo {
	ExtentReports extent;
@BeforeTest
public void config()
{
	String path=System.getProperty("user.dir")+ "\\reports\\index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("Web Automation Result");
	reporter.config().setDocumentTitle("Test Result");
	
    extent = new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("tester", "vijay");
			
}
	
	
@Test
	public void initialDemo()
	{
     	extent.createTest("initial Demo");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vijay\\Downloads\\chromedriver_win32 (1)//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://rahulshettyacademy.com");
		System.out.println( driver.getTitle());
		extent.flush();
	}
}
