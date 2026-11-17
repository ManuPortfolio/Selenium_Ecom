package Test.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsNG {

    public ExtentReports getReportObject(){
        String path = System.getProperty("user.dir") + "//reports//index.html";
        ExtentSparkReporter  reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation tests");
        reporter.config().setDocumentTitle("Cart tests");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester","Manoj");
        extent.createTest(path);
        return extent;

    }
}
