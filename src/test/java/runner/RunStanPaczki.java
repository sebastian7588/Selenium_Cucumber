package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/cucumber_json_reports/home-page.json", "html:target/cucumber_html_reports/home-page-html-report"},
        features = "src/main/features/StanPaczki",
        glue = "steps")
public class RunStanPaczki {
}
