/*
 * Copyright 2020 RA Consulting
 *
 * RA Consulting GmbH licenses this file under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.asam.openscenario.v1_0.parser.xml;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import net.asam.openscenario.common.ErrorLevel;
import net.asam.openscenario.common.FileContentMessage;
import net.asam.openscenario.common.IParserMessageLogger;
import net.asam.openscenario.common.Textmarker;
import net.asam.openscenario.parser.modelgroup.XmlSequenceParser;
import net.asam.openscenario.parser.type.XmlComplexTypeParser;
import net.asam.openscenario.v1_0.api.Rule;
import net.asam.openscenario.v1_0.common.OscConstants;
import net.asam.openscenario.v1_0.impl.SimulationTimeConditionImpl;
import net.asam.xml.indexer.Position;

/**
 * This is a automatic generated file according to the OpenSCENARIO specification version 1.0
 * Filling a SimulationTimeConditionImpl instance from an xml tree.
 *
 * @author RA Consulting OpenSCENARIO generation facility
 */
public class SimulationTimeConditionXmlParser
    extends XmlComplexTypeParser<SimulationTimeConditionImpl> {

  /**
   * Constructor
   *
   * @param messageLogger to log messages during parsing
   * @param filename to locate the messages in a file
   */
  public SimulationTimeConditionXmlParser(IParserMessageLogger messageLogger, String filename) {
    super(messageLogger, filename);
    this.subElementParser = new SubElementParser(messageLogger, filename);
  }

  @Override
  protected Map<String, IAttributeParser<SimulationTimeConditionImpl>>
      getAttributeNameToAttributeParserMap() {
    Map<String, IAttributeParser<SimulationTimeConditionImpl>> result = new Hashtable<>();
    result.put(
        OscConstants.ATTRIBUTE__VALUE,
        new IAttributeParser<SimulationTimeConditionImpl>() {
          @SuppressWarnings("synthetic-access")
          @Override
          public void parse(
              Position startPosition,
              Position endPosition,
              String attributeName,
              String attributeValue,
              SimulationTimeConditionImpl object) {

            Textmarker startMarker =
                new Textmarker(
                    startPosition.getLine(),
                    startPosition.getColumn(),
                    SimulationTimeConditionXmlParser.this.filename);
            Textmarker endMarker =
                new Textmarker(
                    endPosition.getLine(),
                    endPosition.getColumn(),
                    SimulationTimeConditionXmlParser.this.filename);
            if (isParametrized(attributeValue)) {
              object.setAttributeParameter(
                  OscConstants.ATTRIBUTE__VALUE, stripDollarSign(attributeValue), startMarker);
            } else {
              // Parse value
              // Simple type
              object.setValue(parseDouble(attributeValue, startMarker));
            }
            object.putPropertyStartMarker(OscConstants.ATTRIBUTE__VALUE, startMarker);
            object.putPropertyEndMarker(OscConstants.ATTRIBUTE__VALUE, endMarker);
          }

          @Override
          public int getMinOccur() {
            return 1;
          }
        });
    result.put(
        OscConstants.ATTRIBUTE__RULE,
        new IAttributeParser<SimulationTimeConditionImpl>() {
          @SuppressWarnings("synthetic-access")
          @Override
          public void parse(
              Position startPosition,
              Position endPosition,
              String attributeName,
              String attributeValue,
              SimulationTimeConditionImpl object) {

            Textmarker startMarker =
                new Textmarker(
                    startPosition.getLine(),
                    startPosition.getColumn(),
                    SimulationTimeConditionXmlParser.this.filename);
            Textmarker endMarker =
                new Textmarker(
                    endPosition.getLine(),
                    endPosition.getColumn(),
                    SimulationTimeConditionXmlParser.this.filename);
            if (isParametrized(attributeValue)) {
              object.setAttributeParameter(
                  OscConstants.ATTRIBUTE__RULE, stripDollarSign(attributeValue), startMarker);
            } else {
              // Parse value
              // Enumeration Type
              Rule result = Rule.getFromLiteral(attributeValue);
              if (result != null) {
                object.setRule(result);
              } else {
                SimulationTimeConditionXmlParser.this.messageLogger.logMessage(
                    new FileContentMessage(
                        "Value '" + attributeValue + "' is not allowed.",
                        ErrorLevel.ERROR,
                        startMarker));
              }
            }
            object.putPropertyStartMarker(OscConstants.ATTRIBUTE__RULE, startMarker);
            object.putPropertyEndMarker(OscConstants.ATTRIBUTE__RULE, endMarker);
          }

          @Override
          public int getMinOccur() {
            return 1;
          }
        });
    return result;
  }

  /** Parser for all subelements */
  private class SubElementParser extends XmlSequenceParser<SimulationTimeConditionImpl> {
    /**
     * Constructor
     *
     * @param messageLogger to log messages during parsing
     * @param filename to locate the messages in a file
     */
    public SubElementParser(IParserMessageLogger messageLogger, String filename) {
      super(messageLogger, filename);
    }
    /*
     * Creates a list of parser
     */
    @Override
    protected List<IElementParser<SimulationTimeConditionImpl>> createParserList() {
      List<IElementParser<SimulationTimeConditionImpl>> result = new ArrayList<>();
      return result;
    }
  }
}
