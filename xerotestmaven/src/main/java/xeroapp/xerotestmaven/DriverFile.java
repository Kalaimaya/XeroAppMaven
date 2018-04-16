package xeroapp.xerotestmaven;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

//import net.bytebuddy.jar.asm.commons.Method;
//cd C:\Users\meta\workspace\XeroAppMaven\xerotestmaven
//mvn exec:java -Dexec.mainClass="xeroapp.xerotestmaven.DriverFile"
import xeroapp.xerotestmaven.*;

public class DriverFile extends Base{
public static boolean  status=true;
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	
	
	public static void main(String[] args) throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InterruptedException {
		String cur_dir = System.getProperty("user.dir");

		String suitePath="C:/Users/meta/Documents/Testsuit1.xls";
		extent=ReuseXero.startReport(cur_dir + "/ExtentReport/ExtentReport.html");
		//ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/ExtendReport/NewReport.html");
        
       // extent=ReuseXero.createTestReport(testName, extent)
		String[][] recData = ReuseXero.readXlSheet1(suitePath, "Sheet1");
		//String testCase,flag,firefoxStatus;


		String testCase,flag,firefoxStatus,chromeStatus,ieStatus;
		
		for (int i = 1; i < recData.length; i++) {
			testCase = recData[i][0];
			flag = recData[i][1];
			if(flag.equalsIgnoreCase("y")){
				
				firefoxStatus=recData[i][2];
				chromeStatus=recData[i][4];
			//	ieStatus=recData[i][6];
				
				log(String.format("ffstatus:%s chromestatus:%s", firefoxStatus, chromeStatus));
				
				if(firefoxStatus.equalsIgnoreCase("y")){
					log("Launching in firefox");
					logger=ReuseXero.createTestReport(testCase+" in firefox",extent);
				//	logger.log(Status.PASS,MarkupHelper.createLabel("testcase passed",ExtentColor.GREEN));

					log(testCase);
					Method tc = AutoScripts.class.getMethod(testCase,String.class);
					tc.invoke(new AutoScripts(),"firefox");
					if(status==true){
						Modules.writeXlSheet(suitePath,"Sheet1","pass",i,3);
						Modules.setXlColorStyle(suitePath,"Sheet1",i,3,"pass");
						logger.log(Status.PASS,MarkupHelper.createLabel("testcase passed",ExtentColor.GREEN));
					}
					else{
						Modules.writeXlSheet(suitePath,"Sheet1","fail",i,3);
						Modules.setXlColorStyle(suitePath,"Sheet1",i,3,"fail");
						logger.log(Status.FAIL,MarkupHelper.createLabel("testcase passed",ExtentColor.RED));
					}
				}
				
				if(chromeStatus.equalsIgnoreCase("y")){
					log("Launching in chrome");
					Thread.sleep(5000);
					logger=ReuseXero.createTestReport(testCase+" in chrome",extent);
					Method tc = AutoScripts.class.getMethod(testCase,String.class);
					tc.invoke(new AutoScripts(),"chrome");
					if(status==true){
						Modules.writeXlSheet(suitePath,"Sheet1","pass",i,5);
						Modules.setXlColorStyle(suitePath,"Sheet1",i,5,"pass");
						logger.log(Status.PASS,MarkupHelper.createLabel("testcase passed",ExtentColor.GREEN));
					}
					else{
						Modules.writeXlSheet(suitePath,"Sheet1","fail",i,5);
						Modules.setXlColorStyle(suitePath,"Sheet1",i,5,"fail");
						logger.log(Status.FAIL,MarkupHelper.createLabel("testcase passed",ExtentColor.RED));

					}
				}
				
				
			}
		}
		extent.close();
	//	ReuseXero.endReport(extent);
	//	extent.flush();


	//	extent.flush();


//
//		for (int i = 1; i < recData.length; i++) {
//			testCase = recData[i][0];
//			flag = recData[i][1];
//			if(flag.equalsIgnoreCase("y")){
//				firefoxStatus=recData[i][2];
//				if(firefoxStatus.equalsIgnoreCase("y")){
//					System.out.println("Executing testcase: " + testCase);
//					java.lang.reflect.Method tc = AutoScripts.class.getMethod(testCase);
////					tc.invoke(tc);
//				}
//			}
//
//		}
		
//
	}

}

