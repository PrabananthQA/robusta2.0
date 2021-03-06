package com.robusta.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class TC01 {
    public static void main(String args[]){
  //      WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://cosmocode.io/automation-practice-webtable/");
        driver.manage().window().maximize();
        String ActualTitle = driver.getTitle();
        System.out.println(ActualTitle);
        String ExpectedTitle="Automation Practice | WebTable � CosmoCode (Formerly TeachMeSelenium)";
        if(ActualTitle.equalsIgnoreCase(ExpectedTitle)) {
        	System.out.println("Title verified");
        }else {
        	driver.close();
        }
//        Assert.assertEquals("Title Verified", ActualTitle, ExpectedTitle);       
        WebElement table = driver.findElement(By.xpath("//div[@class='entry-content']//following::table"));
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();", table);
        List<WebElement> rowSize = table.findElements(By.xpath("//*[@id=\"countries\"]/tbody/tr"));
        int size = rowSize.size();
        System.out.println("No of countries in list is "+size+ "\n"+"**********"+"\n"+" " );
        String x1="//*[@id=\"countries\"]/tbody/tr[";
        String x2="]/td[2]/strong";
        for(int i=2;i<139;i++)
        {
            String xp=x1+i+x2;
            WebElement ele = driver.findElement(By.xpath(xp));
            System.out.println((i-1)+"."+ele.getText());
        }
        driver.close();
    }
}
