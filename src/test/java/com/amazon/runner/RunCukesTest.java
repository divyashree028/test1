package com.amazon.runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(
			
	features = {
			"Features/amazon.feature"
	}
	
	,plugin = {"html:target/cucumber-html-report","json:target/cucumber-reports/cucumber.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
	
	,glue = {
			"com.amazon.stepDefinition"
	 }
	
	,tags = "@P1"

)
	
public class RunCukesTest {
	
	private TestNGCucumberRunner testNGCucumberRunner;
	private BaseClass refBaseClass = new BaseClass();
	

	@BeforeSuite
	public void TestNGBeforeSuite() {
	
	}
	
	@BeforeClass(alwaysRun = true)
	public void BeforeClass() throws Exception {
		refBaseClass.LaunchBrowser();
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}
		
	@Test(groups = "cucumber scenarios", dataProvider = "scenarios")
	public void scenario(PickleEventWrapper pickleEvent, CucumberFeatureWrapper cucumberFeature) throws Throwable {
		testNGCucumberRunner.runScenario(pickleEvent.getPickleEvent());
	}
	
	@DataProvider(parallel = false)
	public Object[][] scenarios(){
		return testNGCucumberRunner.provideScenarios();
	}
	
	@AfterClass
	public void AfterClass() throws Exception {
		refBaseClass.closeBrowser();
		testNGCucumberRunner.finish();
	}
	
	@AfterSuite
	public void TestNGAfterSuite() throws Exception{
		
		
	}


}