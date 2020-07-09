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

import net.asam.openscenario.common.IParserMessageLogger;
import net.asam.openscenario.v1_0.common.OscConstants;
import net.asam.openscenario.simple.struct.IndexedElement;
import net.asam.openscenario.parser.ParserContext;
import net.asam.openscenario.v1_0.parser.CatalogReferenceParserContext;
import net.asam.openscenario.common.FileContentMessage;
import net.asam.xml.indexer.Position;
import net.asam.openscenario.common.Textmarker;
import net.asam.openscenario.common.ErrorLevel;
import java.util.List;

import net.asam.openscenario.v1_0.impl.TrafficSignalActionImpl;
import net.asam.openscenario.v1_0.impl.InfrastructureActionImpl;


import net.asam.openscenario.parser.modelgroup.XmlAllParser;
import java.util.Map;
import java.util.Hashtable;
import java.util.ArrayList;
import net.asam.openscenario.parser.type.XmlComplexTypeParser;


/**
 * This is a automatic generated file according to the OpenSCENARIO specification version 1.0
 * Filling a InfrastructureActionImpl instance from an xml tree.
 * 
 * @author RA Consulting OpenSCENARIO generation facility
*/
public class InfrastructureActionXmlParser extends XmlComplexTypeParser<InfrastructureActionImpl> {

	/**
	 * Constructor
	 * @param messageLogger to log messages during parsing
	 * @param filename to locate the messages in a file
	 */
	public InfrastructureActionXmlParser(IParserMessageLogger messageLogger, String filename) {
		super(messageLogger, filename);
		subElementParser = new SubElementParser(messageLogger, filename);
	}
	@Override
	public void parseElement(IndexedElement indexedElement, ParserContext parserContext,InfrastructureActionImpl object) {
		messageLogger.logMessage(new FileContentMessage("Start Parsing InfrastructureAction", ErrorLevel.DEBUG, new Textmarker(indexedElement.getStartElementLocation().getLine(), indexedElement.getStartElementLocation().getColumn(), filename))); 
		super.parseElement(indexedElement,  parserContext, object);
		messageLogger.logMessage(new FileContentMessage("End Parsing InfrastructureAction", ErrorLevel.DEBUG, new Textmarker(indexedElement.getEndElementLocation().getLine(), indexedElement.getEndElementLocation().getColumn(), filename))); 
	
	}			
	
	@Override
	protected  Map<String, IAttributeParser<InfrastructureActionImpl>> getAttributeNameToAttributeParserMap()
	{
		Map<String, IAttributeParser<InfrastructureActionImpl>> result  = new Hashtable<String, IAttributeParser<InfrastructureActionImpl>>();
		return result;
	}

	/**
	 * Parser for all subelements
	 */
	private class SubElementParser extends XmlAllParser<InfrastructureActionImpl>{
		/**
		 * Constructor
		 * @param messageLogger to log messages during parsing
		 * @param filename to locate the messages in a file
		 */
		public SubElementParser (IParserMessageLogger messageLogger, String filename) {
			super(messageLogger,filename);	
		}
		/*
		 * Creates a list of parser
		 */
		protected  List<IElementParser<InfrastructureActionImpl>> createParserList()
		{
			List<IElementParser<InfrastructureActionImpl>> result = new ArrayList<IElementParser<InfrastructureActionImpl>>();
			result.add(new SubElementTrafficSignalActionParser());
			return result;
		
		}	
	}
	/**
	 * A parser for subelement trafficSignalAction
	 */
	private class SubElementTrafficSignalActionParser implements IElementParser<InfrastructureActionImpl> {
	
		/**
		 * Constructor
		 */
		public SubElementTrafficSignalActionParser()
		{
			super();
			trafficSignalActionXmlParser = new TrafficSignalActionXmlParser(messageLogger, filename);
		}
		private TrafficSignalActionXmlParser trafficSignalActionXmlParser;
		
		@Override
		public void parse(IndexedElement indexedElement, ParserContext parserContext,InfrastructureActionImpl object)
		{
			TrafficSignalActionImpl trafficSignalAction = new TrafficSignalActionImpl();
			// Setting the parent
			trafficSignalAction.setParent(object);
			trafficSignalActionXmlParser.parseElement(indexedElement,parserContext, trafficSignalAction);

			object.setTrafficSignalAction( trafficSignalAction);
			
		}

		@Override
		public int getMinOccur()
		{
			return 1;
		}
		
		@Override
		public int getMaxOccur()
		{
			return 1;
		}
		
		@Override
		public boolean doesMatch(String elementName)
		{
			return
				elementName.equals(OscConstants.ELEMENT__TRAFFIC_SIGNAL_ACTION) ;
		}
		
		@Override
		public String[] getExpectedTagNames()
		{		 	return new String[]{
				OscConstants.ELEMENT__TRAFFIC_SIGNAL_ACTION
					};
		}
	}
}

