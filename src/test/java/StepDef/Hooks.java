package StepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

Scenario scenario;
    @Before()
    public void BeforeScenario(Scenario scenario) {
        System.out.println("*Before**");
        this.scenario = scenario;


    }

    @After()
    public void AfterScenario(){
        System.out.println("After***");
        DriverSetup.getLocal().close();
    }


}
