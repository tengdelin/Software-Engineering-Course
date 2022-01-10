package selenium.test;

import java.awt.Choice;
import java.awt.Dimension;
import java.security.cert.PKIXRevocationChecker.Option;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import javax.swing.text.Document;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v94.tethering.model.Accepted;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test {
	public static void main(String[] args) throws InterruptedException {
		// ChromeDriver chromeDriver = new ChromeDriver();
		//// chromeDriver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		// Options option = chromeDriver.manage();
		// option.window().maximize();
		// chromeDriver.get("https://www.baidu.com/");
		//
		// chromeDriver.findElement(By.cssSelector("#kw")).sendKeys("pyhton");
		// WebDriverWait driverWait = new WebDriverWait(chromeDriver, 5);
		// driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#su")));
		// chromeDriver.findElement(By.cssSelector("#su")).click();
		// System.out.println(chromeDriver.getCurrentUrl());
		// Thread.sleep(1100);
		// chromeDriver.findElement(By.cssSelector("#\\31 > h3 >
		// a.OP_LOG_LINK.c-text.c-text-public.c-text-mult.c-gap-left-small")).click();
		//// chromeDriver.close();
		// System.out.println(chromeDriver.getCurrentUrl());
		// org.openqa.selenium.Dimension dimension= option.window().getSize();
		// System.out.println(dimension.getHeight());
		// System.out.println(dimension.height);
		// System.out.println(option.window().getPosition().getX());
		// System.out.println(option.window().getPosition().x);
		//
		// chromeDriver.navigate().to("http://my.tdl.cool");
		// chromeDriver.navigate().refresh();
		// chromeDriver.navigate().back();
		// chromeDriver.navigate().forward();
		// chromeDriver.quit();
		test5();
	}

	public static void test1() {
		ChromeDriver chromeDriver = new ChromeDriver();
		chromeDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		chromeDriver.get("http://www.baidu.com");
		chromeDriver.findElement(By.cssSelector("#kw")).sendKeys("pyhton");
		chromeDriver.findElement(By.cssSelector("#su")).click();
		chromeDriver
				.findElement(
						By.cssSelector("#\\31  > h3 > a.OP_LOG_LINK.c-text.c-text-public.c-text-mult.c-gap-left-small"))
				.click();
		Set<String> handle = chromeDriver.getWindowHandles();
		for (String h : handle) {
			chromeDriver.switchTo().window(h);
			if (chromeDriver.getTitle().equals("ÐÅÓþVÈÏÖ¤")) {
				break;
			}
		}
		chromeDriver.findElement(By.cssSelector("#form-realname")).sendKeys("tdl");
	}

	private static void test2() {
		ChromeDriver chromeDriver = new ChromeDriver();
		chromeDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		chromeDriver.get("http://www.baidu.com");
		chromeDriver.findElement(By.cssSelector("#s-usersetting-top")).click();
		chromeDriver.findElement(By.cssSelector("#s-user-setting-menu > div > a:nth-child(2)")).click();

		// WebElement Elementdriver = chromeDriver.findElement(
		// By.cssSelector("#adv-setting-gpc > div > div.c-select-selection"));
		// Select select = new Select(Elementdriver);
		// select.selectByIndex(1);
		// select.selectByIndex(2);
		// select.selectByIndex(3);
		// select.selectByIndex(4);
		// chromeDriver
		// .findElement(By.cssSelector(
		// "#adv-setting-gpc > div > div.c-select-dropdown > div.c-select-dropdown-list
		// > p:nth-child(2)"))
		// .click();
		// chromeDriver
		// .findElement(
		// By.cssSelector("#adv-setting-gpc > div > div.c-select-selection >
		// i.c-icon.c-select-arrow"))
		// .click();
		// chromeDriver
		// .findElement(By.cssSelector(
		// "#adv-setting-gpc > div > div.c-select-dropdown > div.c-select-dropdown-list
		// > p:nth-child(5)"))
		// .click();
	}

	public static void test3() throws InterruptedException {
		ChromeDriver chromeDriver = new ChromeDriver();
		chromeDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		chromeDriver.get("https://www.12306.cn/index/");
		JavascriptExecutor javascriptExecutor = chromeDriver;
		javascriptExecutor.executeScript("document.querySelector(\"#train_date\").value=''");
		chromeDriver.findElement(By.cssSelector("#train_date")).clear();
		chromeDriver.findElement(By.cssSelector("#train_date")).sendKeys("2000-11-23");
	}

	public static void test4() {

		ChromeDriver chromeDriver = new ChromeDriver();
		chromeDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		chromeDriver.get("http://www.treejs.cn/v3/demo/cn/exedit/drag.html");
		WebElement Element1=chromeDriver.findElement(By.cssSelector("#treeDemo_2_span"));
		WebElement Element2=chromeDriver.findElement(By.cssSelector("#treeDemo_3_span"));
		Actions actions=new Actions(chromeDriver);
		actions.clickAndHold(Element1).moveToElement(Element2).release().build().perform();
	}
	
	public static void test5() throws InterruptedException {
		ChromeDriver chromeDriver = new ChromeDriver();
		chromeDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		chromeDriver.get("https://www.wjx.cn/jq/27265670.aspx");
		chromeDriver.findElement(By.cssSelector("#fileUpload")).click();
		Thread.sleep(1000);
		chromeDriver.findElement(By.cssSelector("#html5_1fib8vcuu2421c61aoj1ksfbug4")).sendKeys("E:\\1.png");
		
	}
}
