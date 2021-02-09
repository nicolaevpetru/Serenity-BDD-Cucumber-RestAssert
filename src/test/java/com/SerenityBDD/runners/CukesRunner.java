package com.SerenityBDD.runners;


import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/SerenityBDD/step_definitions",
        tags = "@TestingType=Regression"
)
public class CukesRunner{
}