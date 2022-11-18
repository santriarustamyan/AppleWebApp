import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/bdd/ui", glue = "stepDefinitions", tags = "@sanity",
        plugin = {"pretty", "html:target/cucumber-reports/reports.html"})

public class Runner {
}