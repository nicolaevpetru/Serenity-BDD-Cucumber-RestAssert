package com.SerenityBDD.step_definitions;

import com.SerenityBDD.utils.Environment;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Hooks {
    private final static Logger log = LogManager.getLogger(Hooks.class);

    @Before
    public void setUp(Scenario scenario) {
        scenario.log("#### TESTING IN [ " + Environment.getEnvironment() + " ] ENVIRONMENT.");
        RestAssured.baseURI = Environment.getProperty("baseURI");
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.log(scenario.getName() + "####### [ TEST FAILED ].");
            log.info(scenario);
        } else {
            scenario.log("\n #######  [ TEST PASS ] \n");
//            scenario.log(scenario.getName());
        }
        RestAssured.reset();
    }
}