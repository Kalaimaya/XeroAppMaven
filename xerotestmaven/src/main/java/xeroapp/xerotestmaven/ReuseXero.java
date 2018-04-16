package xeroapp.xerotestmaven;


	import java.io.File;
	import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
	import java.util.Properties;
	import java.util.concurrent.TimeUnit;

	import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
	import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


	public class ReuseXero extends Base {
		public static HSSFWorkbook wb;
		public static WebDriver driver;
		public static ExtentHtmlReporter htmlReporter;
		public static ExtentReports extent;
		public static ExtentTest logger;
		public static Properties xeroProp;
		
		static{
			xeroProp = new Properties();
			try {
				xeroProp.load(new FileInputStream(System.getProperty("user.dir") + "/xeroData.properties"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


		public static WebDriver launchBrowser(String name){
			//System.setProperty("webdriver.firefox.bin","C:/Program Files/Mozilla Firefox53/firefox.exe");
			if(name.equalsIgnoreCase("firefox")){
				System.setProperty("webdriver.gecko.driver","./src/utilities/geckodriver.exe");
				log("2.1");
				FirefoxOptions options = new FirefoxOptions();
				options.setLogLevel(FirefoxDriverLogLevel.INFO);
				driver=new FirefoxDriver(options);
				log("2.2");
			}
			else if(name.equalsIgnoreCase("chrome")){
				System.out.println("chrome entered");
				System.setProperty("webdriver.chrome.driver","./src/utilities/chromedriver1.exe");
				driver=new ChromeDriver();
			}
			else if(name.equalsIgnoreCase("ie")){
				System.out.println("IE entered");
				System.setProperty("webdriver.ie.driver","./src/utilities/IEDriverServer.exe");
				driver=new InternetExplorerDriver();
			}

			driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
			driver.manage().window().maximize();
			return driver;
		}
		
    	public static void log(String str) {
    		System.out.println(str);
    	}
    	public static void displayFrames(WebDriver driver) {
    		int i=0;
    		for (WebElement e:driver.findElements(By.tagName("iframe"))) {
    			log(String.format("Frame %d=%s",i++, e.getTagName()+e.getText()));
    		}
    		
    	}
		public static void closeBrowser(WebDriver driver){
			try{
				driver.quit();
			}
			catch(Exception e){
				
			}
		}
		
		public static String[][] readXlSheet1(String link,String sheetName) throws IOException{
			FileInputStream fio=new FileInputStream(new File(link));
			wb=new HSSFWorkbook(fio);
			HSSFSheet sheet=wb.getSheet(sheetName);
			int trow=sheet.getLastRowNum()+1;
			int tcol=sheet.getRow(0).getLastCellNum();
			String[][] s = new String[trow][tcol];
			System.out.println("total rows="+trow+" and total column="+tcol);
			for(int i=0;i<trow;i++){
				for(int j=0;j<tcol;j++){
					int cellType=sheet.getRow(i).getCell(j).getCellType();
					if(cellType==HSSFCell.CELL_TYPE_NUMERIC)
						s[i][j]=String.valueOf((int)sheet.getRow(i).getCell(j).getNumericCellValue());
					else
					s[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();	
			
				}
			}
			
			return s;
		}
		public static ExtentReports startReport(String reportPath){
    		//System.getProperty("user.dir") +"/test-output/STMExtentReport.html"
    		htmlReporter = new ExtentHtmlReporter(reportPath);
    		ExtentReports extent=new ExtentReports();
    		extent.attachReporter(htmlReporter);
    		extent.setSystemInfo("Host Name", "Xero QA");
    		extent.setSystemInfo("Environment", "Automation Testing");
    		extent.setSystemInfo("User Name", "Kalai");
    		
    		htmlReporter.config().setDocumentTitle("report status");
    		htmlReporter.config().setReportName("customized report");
    		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
    		htmlReporter.config().setTheme(Theme.STANDARD);
    		return extent;
    	}
    	
    	public static ExtentTest createTestReport(String testName,ExtentReports extent){
    		logger = extent.createTest(testName);
    		//logger.log(Status.PASS,MarkupHelper.createLabel("testcase passed",ExtentColor.GREEN));

    		return logger;
    	}
    	public static void endReport(ExtentReports extent){
    		extent.flush();
    	}
    	public static String[][] readXlSheet(String link,String sheetName) throws IOException{
    		FileInputStream fio=new FileInputStream(new File(link));
    		wb=new HSSFWorkbook(fio);
    		HSSFSheet sheet=wb.getSheet(sheetName);
    		int trow=sheet.getLastRowNum()+1;
    		int tcol=sheet.getRow(0).getLastCellNum();
    		String[][] s = new String[trow][tcol];
    		System.out.println("total rows="+trow+" and total column="+tcol);
    		for(int i=0;i<trow;i++){
    			for(int j=0;j<tcol;j++){
    				int cellType=sheet.getRow(i).getCell(j).getCellType();
    				if(cellType==HSSFCell.CELL_TYPE_NUMERIC)
    					s[i][j]=String.valueOf((int)sheet.getRow(i).getCell(j).getNumericCellValue());
    				else
    				s[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();	
    		
    			}
    		}
    		
    		return s;
    	}
    	
    	public static void writeXlSheet(String link, String sheetName,String text,int row,int col) throws IOException {
    		File f=new File(link);
    		FileInputStream fio=new FileInputStream(f);
    		HSSFWorkbook wb=new HSSFWorkbook(fio);
    		HSSFSheet sheet=wb.getSheet(sheetName);
    		sheet.getRow(row).getCell(col).setCellValue(text);
    		FileOutputStream fop=new FileOutputStream(f);
    		wb.write(fop);
    		fop.flush();
    		fop.close();
    		}
    	
    	
    	public static void setXlColorStyle(String link,String sheetName,int iRow,int iCol,String status) throws IOException{
    		File f=new File(link);
    		FileInputStream fio=new FileInputStream(f);
    		HSSFWorkbook wb=new HSSFWorkbook(fio);
    		HSSFSheet sheet=wb.getSheet(sheetName);
    		
    		
    		HSSFRow row = sheet.getRow(iRow);
    		HSSFCell cell = row.getCell(iCol);
    		
    		if(status.equalsIgnoreCase("pass"))
    			fillBackgroundColor(wb, "green", cell);
    			
    		else
    			fillBackgroundColor(wb, "red", cell);
    		
    		FileOutputStream fop=new FileOutputStream(f);
    		wb.write(fop);
    		fop.flush();
    		fop.close();
    		}
    	public static void fillBackgroundColor(HSSFWorkbook wb,String color,HSSFCell cell){
    		HSSFCellStyle style=(HSSFCellStyle) wb.createCellStyle();
    		if(color.equalsIgnoreCase("green")){
    			style.setFillForegroundColor(new HSSFColor.GREEN().getIndex());
    			}
    		else if(color.equalsIgnoreCase("red")){
    			style.setFillForegroundColor(new HSSFColor.RED().getIndex());
    			}
    		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
    		cell.setCellStyle(style);
    	}
    	


}
