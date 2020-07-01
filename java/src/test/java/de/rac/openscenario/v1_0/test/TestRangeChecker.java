package de.rac.openscenario.v1_0.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import de.rac.openscenario.v1_0.api.IOpenScenario;
import de.rac.openscenario.v1_0.checker.impl.ScenarioCheckerImpl;
import de.rac.openscenario.v1_0.checker.range.RangeCheckerHelper;
import de.rac.openscenario.v1_0.common.ErrorLevel;
import de.rac.openscenario.v1_0.common.FileContentMessage;
import de.rac.openscenario.v1_0.common.Textmarker;
import de.rac.openscenario.v1_0.loader.ScenarioLoaderException;

public class TestRangeChecker extends TestBase {


	private void applyCheckerRules( IOpenScenario openScenario)
	{
		ScenarioCheckerImpl scenarioChecker = new ScenarioCheckerImpl();
		RangeCheckerHelper.addAllRangeCheckerRules(scenarioChecker);
		scenarioChecker.checkScenario(messageLogger, openScenario);
	}

	@Test
	public void testParamsFailure() {
		try {
			String filename = inputDir + "DoubleLaneChangerCheckerErrors.xosc";
			IOpenScenario openScenario=executeParsing(filename);
			applyCheckerRules(openScenario);
			List<FileContentMessage> messages = new ArrayList<FileContentMessage>();
	

			messages.add(new FileContentMessage(
					"Range error: Rule (maxAcceleration>=0) is violated (value: -2.0)",
					ErrorLevel.ERROR, new Textmarker(44, 57, filename)));
			messages.add(new FileContentMessage(
					"Range error: Rule (maxDeceleration>=0) is violated (value: -10.0)",
					ErrorLevel.ERROR, new Textmarker(44, 20, filename)));
			messages.add(new FileContentMessage(
					"Range error: Rule (maxSteering<=PI) is violated (value: 7.0)",
					ErrorLevel.ERROR, new Textmarker(46, 75, filename)));
			messages.add(new FileContentMessage(
					"Range error: Rule (wheelDiameter>0) is violated (value: -12.0)",
					ErrorLevel.ERROR, new Textmarker(46, 55, filename)));
			messages.add(new FileContentMessage(
					"Range error: Rule (trackWidth>=0) is violated (value: -12.0)",
					ErrorLevel.ERROR, new Textmarker(46, 38, filename)));
			messages.add(new FileContentMessage(
					"Range error: Rule (positionX>=0) is violated (value: -2.0)",
					ErrorLevel.ERROR, new Textmarker(46, 91, filename)));
			messages.add(new FileContentMessage(
					"Range error: Rule (positionZ>=0) is violated (value: -13.0)",
					ErrorLevel.ERROR, new Textmarker(46,22, filename)));
			

			Assertions.assertTrue(assertMessages(messages, ErrorLevel.ERROR, messageLogger));

		} catch (ScenarioLoaderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	
}
