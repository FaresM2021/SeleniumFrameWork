package runner;

import io.cucumber.testng.CucumberOptions;
import tests.TestBase;

@CucumberOptions(features = "src/test/java/featuers",glue = {"steps"},plugin = {"pretty","html:target/cucumber-html-report"})
public class TestRunner extends TestBase 
{

}
