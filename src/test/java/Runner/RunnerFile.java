package Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(features = {"src/test/java/resources/features"},
        glue = {"StepDef"},
        tags = "@test1",
        plugin = {"pretty","html:target/cucumber-reports","rerun:target/failed_scenario.txt"})

public class RunnerFile {


    @BeforeClass
    public static void start()
    {
        System.out.println("-----------------------START-----------------------");
    }


    @AfterClass
    public static void end()
    {
        System.out.println("Ending Execution");
    }

}
