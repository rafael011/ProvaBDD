package br.com.auditeste.runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		 features = "src/test/resources/FeaturesGherkins/", 
		 glue={"br.com.rsi.hub3.automacao.bdd.steps"}, 
		 snippets = SnippetType.CAMELCASE,
		 monochrome = true//,
		 )
public class Runner {

}
