package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features",glue={"stepDefination"}
             ,plugin={"pretty","html:target/testreport/report.html"} ,tags ="@reg",dryRun =false )

public class Runner {
	    //features -  path of features  path
		//glue  -step definition files name
		//tags  -tags
		//plugin -report generation
		//dryRun  -true
		//monochrome - -console  more  readable

}
