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
			"com.amazon.featurefile//amazon_01.feature"
	}
	
	,plugin = {"html:target/site/cucumber-pretty","json:target/cucumber.json"}
	
	,glue = {
			"com.amazon.stepDefinition"
	 }
	
	,tags = "@P1"

)
	
public class TestRunner {
	
	private TestNGCucumberRunner testNGCucumberRunner;

	@BeforeSuite
	public void TestNGBeforeSuite() {
	
	}
	
	@BeforeClass(alwaysRun = true)
	public void BeforeClass() {
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
	public void AfterClass() {
		testNGCucumberRunner.finish();
	}
	
	@AfterSuite
	public void TestNGAfterSuite() throws Exception{
		
	}


}