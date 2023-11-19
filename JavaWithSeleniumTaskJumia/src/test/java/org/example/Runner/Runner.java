package org.example.Runner;


import io.cucumber.core.gherkin.Feature;
import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features",
        glue = "org/example/StepDefinition",
        plugin = {
                "pretty",
                "html:target/cucumberReports/cucumber-pretty.html",
                "html:target/cucumber-reports",
                "json:target/cucumberReports/cucumber-TestReport.json",
                "rerun:target/cucumberReports/rerun.txt",
                "junit:target/cucumberReports/cukes.xml",
        },
        tags = "@Runner"
)

public class Runner extends AbstractTestNGCucumberTests {

}

