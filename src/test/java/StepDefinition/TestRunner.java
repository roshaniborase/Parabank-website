package StepDefinition;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/Feature",glue= {"StepDefinition"},
plugin= {"pretty","html:target/htmlReport/report.html"}, monochrome=true 
)
public class TestRunner {

}
