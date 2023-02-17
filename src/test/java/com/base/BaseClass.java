package com.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.swing.Action;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.Table.Cell;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author Gugan
 * @see used to create reusable method
 * @date 15-12-2022
 *
 */
public class BaseClass {

	public static WebDriver driver;

	/**
	 * @see used to take screenshot
	 * @return byte[]
	 */
	public byte[] screenshot() {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		byte[] screenshotAs = screenshot.getScreenshotAs(OutputType.BYTES);
		return screenshotAs;

	}

	/**
	 * @see used for explicit wait
	 * @param element
	 */
	public static void elementVisibility(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	/**
	 * @see used to launch the browser
	 * @param browserType
	 */
	public static void browserLaunch(String browserType) {

		switch (browserType) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

			break;

		default:
			break;
		}

	}

	/**
	 * @see used to get the url
	 * @param url
	 */
	public static void getUrl(String url) {
		driver.get(url);

	}

	/**
	 * @see used to maximize window
	 */
	public static void maximize() {
		driver.manage().window().maximize();

	}

	/**
	 * @see used to get current project path
	 * @return String
	 */
	public static String getProjectPath() {
		String property = System.getProperty("user.dir");
		return property;

	}

	/**
	 * @see used to get cureent project's property files
	 * @param key
	 * @return String
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(getProjectPath() + "\\Config\\Config.properties"));
		// java.lang.Object object = properties.get(key);
		// String string=(String) object;
		// return string;
		return (String) properties.get(key);

	}

	/**
	 * @see used for implicit wait
	 */
	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	/**
	 * @see used to press enter key
	 * @throws AWTException
	 */
	public static void robotEnter() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	/**
	 * @see used to press tab key
	 * @throws AWTException
	 */
	public static void robotTab() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}

	/**
	 * @see used to close all windows
	 */

	public static void quit() {

		driver.quit();
	}

	/**
	 * @see used to select options by visible text
	 * @param element
	 * @param text
	 */
	public void selectVisibleText(WebElement element, String text) {
		elementVisibility(element);
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	/**
	 * @see used to send values
	 * @param element
	 * @param data
	 */
	public static void sendKeys(WebElement element, String data) {
		elementVisibility(element);
		element.sendKeys(data);
	}

	/**
	 * @see used to click ok in alert propmt
	 * 
	 */
	public void alertHandlingAccept() {
		driver.switchTo().alert().accept();
	}

	/**
	 * @see used to click cancel in alert prompt
	 * 
	 */
	public void alertHandlingDismiss() {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * @see used to click webelement
	 * @param element
	 */
	public void click(WebElement element) {
		elementVisibility(element);
		element.click();
	}

	/**
	 * @see used to clear the textbox
	 * @param element
	 */
	public void clear(WebElement element) {
		elementVisibility(element);
		element.clear();

	}

	/**
	 * @see used to get attribute
	 * @param element
	 * @param name
	 * @return String
	 */
	public String getAttribute(WebElement element) {
		elementVisibility(element);
		String string = element.getAttribute("value");
		return string;
	}

	/**
	 * @see used to get text from webpage
	 * @param element
	 * @return String
	 */
	public String getText(WebElement element) {
		String string = element.getText();
		return string;
	}

}
