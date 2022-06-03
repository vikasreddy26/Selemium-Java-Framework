package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import lib.cucumberBase.CucumberBaseTest;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\main\\java\\Features",glue={"stepDefinitions"})
public class TestRunner extends CucumberBaseTest {


}
