package VivaAir.Test;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = { "src/test/resources/features/SearchFlight.feature" }, glue = { "VivaAir.Definitions" })

public class RunnersFeature {

}
