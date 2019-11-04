package com.mitthsb.qa.util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.mitthsb.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static final long PAGE_LOAD_TIMEOUT = 30;
	// public static long PAGE_LOAD_TIMEOUT = 20;
	// public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT = 20;
	

	public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir")
			+ "/src/main/java/com/mitthsb/qa/testdata/data.xlsx";
	
		
	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;
	public static SimpleDateFormat formatter;
	public static Date date;
	public int day;

	public void switchToFrame(String frameId) {

		driver.switchTo().frame(frameId);

	}

	public static String getNewChildWindowId() {

		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
		it.next();// pointing to first value of window handle
		// System.out.println("parent window id "+ ParentWindowId);
		String ChildWindowId = it.next();// pointing to second value of window handle child window
		return ChildWindowId;

	}
	
	public static boolean getRoleResult(String rolePrevilege, int ElementSize ) {

		boolean flag = false;

		if (ElementSize > 0)
			switch (rolePrevilege) {
			case "x":
				System.out.println("insideElementsize role x");
				flag = true;
				futheraction=true;
				
				break;
			case "no":
				System.out.println("insideElementsize role no");
				flag = false;
				break;
			}

		else

			switch (rolePrevilege) {
			case "x":
				System.out.println("outsideElementsize role x");
				flag = false;
				break;
			case "no":
				System.out.println("outsideElementsize role no");
				flag = true;
				futheraction=false;
				break;
			}
		
		return flag;

	}
	
	public static String retrieveRole(String Method, String Role) {
		System.out.println("method name" + Method);
		String RolePrevilege = null;
		FileInputStream file = null;
		boolean flag = false;
		int roleColumn=0;

		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet = book.getSheet("Roles");
		
		//to get the column of the user role
		for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
			
			if(sheet.getRow(0).getCell(j).toString().equals(Role))
			{
				roleColumn=j;
				System.out.println("matching role col is"+roleColumn);
		}
		}
		
		for (int k = 0; k < sheet.getLastRowNum(); k++) {

			String testCaseMethodName = sheet.getRow(k + 1).getCell(1).toString();			

			if (testCaseMethodName.equals(Method)) {
				RolePrevilege = sheet.getRow(k + 1).getCell(roleColumn).toString();
				flag = true;
				System.out.println("method matched");
			}

			if (flag)
				break;

		}

		return RolePrevilege;

	}
	
	public static void pause(long sleepTime) {

		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// used to read the data from excel.

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				// data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				if (k == 0)
					data[i][k] = String.valueOf((long) sheet.getRow(i + 1).getCell(k).getNumericCellValue());
				else
					data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				System.out.println(data[i][k]);
			}
		}
		return data;
	}

	// to store the excel data into hash map and use hashmap in data provider
	// (advantage is while calling the test methods you can directly give hash map
	// instead of all the keys /variables
	// in excel and advantage is when you have more no of colmns/ keys in the data
	// and map can be easily traversed based on keys names rather than excel
	// indexes.

	public static Object[][] getTestDataFromHashMap(String sheetName) throws Exception {
		File file = new File(TESTDATA_SHEET_PATH);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(0).getLastCellNum();
		// define 2d array
		Object[][] obj = new Object[rowcount][1];

		for (int i = 0; i < rowcount; i++) {
			Map<Object, Object> datamap = new HashMap<Object, Object>();
			for (int j = 0; j < colcount; j++) {
				if (j == 0)
					datamap.put(sheet.getRow(0).getCell(j).toString(),
							(long) sheet.getRow(i + 1).getCell(j).getNumericCellValue());
				else
					datamap.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i + 1).getCell(j).toString());
			}
			obj[i][0] = datamap;

		}
		return obj;
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		String screenshotDestination = currentDir + "/screenshots/" + dateName + ".png";
		// FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" +
		// System.currentTimeMillis() + ".png"));
		System.out.println("screenshotfilepath is" + screenshotDestination);
		FileUtils.copyFile(scrFile, new File(screenshotDestination));
		// return screenshotDestination;

	}


	public static String getCurrentDateTime() {
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy-HH-mm-ss");
		return formatter.format(currentDate.getTime());
	}

	public static void runTimeInfo(String messageType, String message) throws InterruptedException {
		js = (JavascriptExecutor) driver;
		// Check for jQuery on the page, add it if need be
		js.executeScript("if (!window.jQuery) {"
				+ "var jquery = document.createElement('script'); jquery.type = 'text/javascript';"
				+ "jquery.src = 'https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js';"
				+ "document.getElementsByTagName('head')[0].appendChild(jquery);" + "}");
		Thread.sleep(5000);

		// Use jQuery to add jquery-growl to the page
		js.executeScript("$.getScript('https://the-internet.herokuapp.com/js/vendor/jquery.growl.js')");

		// Use jQuery to add jquery-growl styles to the page
		js.executeScript("$('head').append('<link rel=\"stylesheet\" "
				+ "href=\"https://the-internet.herokuapp.com/css/jquery.growl.css\" " + "type=\"text/css\" />');");
		Thread.sleep(5000);

		// jquery-growl w/ no frills
		js.executeScript("$.growl({ title: 'GET', message: '/' });");
//'"+color+"'"
		if (messageType.equals("error")) {
			js.executeScript("$.growl.error({ title: 'ERROR', message: '" + message + "' });");
		} else if (messageType.equals("info")) {
			js.executeScript("$.growl.notice({ title: 'Notice', message: 'your notice message goes here' });");
		} else if (messageType.equals("warning")) {
			js.executeScript("$.growl.warning({ title: 'Warning!', message: 'your warning message goes here' });");
		} else
			System.out.println("no error message");
		// jquery-growl w/ colorized output
//		js.executeScript("$.growl.error({ title: 'ERROR', message: 'your error message goes here' });");
//		js.executeScript("$.growl.notice({ title: 'Notice', message: 'your notice message goes here' });");
//		js.executeScript("$.growl.warning({ title: 'Warning!', message: 'your warning message goes here' });");
		Thread.sleep(5000);
	}

	public static int brokenLinks() {

		List<WebElement> links = driver.findElements(By.tagName("a"));

		System.out.println("Total links are " + links.size());

		int BrokenlinkCount = 0;

		for (int i = 0; i < links.size(); i++) {

			WebElement ele = links.get(i);

			String linkUrl = ele.getAttribute("href");

			try {
				URL url = new URL(linkUrl);

				HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();

				httpURLConnect.setConnectTimeout(3000);

				httpURLConnect.connect();

				if (httpURLConnect.getResponseCode() == 200)
					System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());

				if (httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
					BrokenlinkCount++;
					System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + " - "
							+ HttpURLConnection.HTTP_NOT_FOUND);
				}
			} catch (Exception e) {

			}

		}
		System.out.println("No of brokenlinkcount is" + BrokenlinkCount);
		return BrokenlinkCount;

	}

	// reading json data using json simple classes.

	public static Object[][] getJSONdata(String JSON_path, String JSON_data, int JSON_attributes)
			throws FileNotFoundException, IOException, ParseException {
		/**
		 * JSON_attributes => like Column in Excel, total column hence total attributes
		 * need to provide this is using json simple jar file
		 */

		Object obj = new JSONParser().parse(new FileReader(JSON_path));
		JSONObject jo = (JSONObject) obj;
		JSONArray js = (JSONArray) jo.get(JSON_data);

		Object[][] arr = new String[js.size()][JSON_attributes];
		for (int i = 0; i < js.size(); i++) {
			JSONObject obj1 = (JSONObject) js.get(i);
			arr[i][0] = String.valueOf(obj1.get("username"));
			// System.out.println("login user is"+arr[i][0]);
			arr[i][1] = String.valueOf(obj1.get("pwd"));
			arr[i][2] = String.valueOf(obj1.get("role"));
		}
		return arr;
	}

	public static String getTomorrowDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd");
		Date date = new Date(System.currentTimeMillis());
		int day = Integer.parseInt(formatter.format(date));
		day++;
		String dayString = String.valueOf(day);
		return (dayString);

	}

}
