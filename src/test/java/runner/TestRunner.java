package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = ".//features",
      //  features = {".//Features/createAccount.feature",".//Features/login.feature"},
        glue = "stepDefinitions",
        dryRun = false,
        plugin={"pretty","html:test-output.html","json:target/cucumber.json"},
        tags= "@sanity or @regression"
)
public class TestRunner {

}
