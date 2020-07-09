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

import net.asam.openscenario.v1_0.impl.TrafficDefinitionImpl;
import net.asam.openscenario.v1_0.impl.TrafficSourceActionImpl;
import net.asam.openscenario.v1_0.impl.PositionImpl;


import net.asam.openscenario.parser.modelgroup.XmlAllParser;
import java.util.Map;
import java.util.Hashtable;
import java.util.ArrayList;
import net.asam.openscenario.parser.type.XmlComplexTypeParser;


/**
 * This is a automatic generated file according to the OpenSCENARIO specification version 1.0
 * Filling a TrafficSourceActionImpl instance from an xml tree.
 * 
 * @author RA Consulting OpenSCENARIO generation facility
*/
public class TrafficSourceActionXmlParser extends XmlComplexTypeParser<TrafficSourceActionImpl> {

	/**
	 * Constructor
	 * @param messageLogger to log messages during parsing
	 * @param filename to locate the messages in a file
	 */
	public TrafficSourceActionXmlParser(IParserMessageLogger messageLogger, String filename) {
		super(messageLogger, filename);
		subElementParser = new SubElementParser(messageLogger, filename);
	}
	@Override
	public void parseElement(IndexedElement indexedElement, ParserContext parserContext,TrafficSourceActionImpl object) {
		messageLogger.logMessage(new FileContentMessage("Start Parsing TrafficSourceAction", ErrorLevel.DEBUG, new Textmarker(indexedElement.getStartElementLocation().getLine(), indexedElement.getStartElementLocation().getColumn(), filename))); 
		super.parseElement(indexedElement,  parserContext, object);
		messageLogger.logMessage(new FileContentMessage("End Parsing TrafficSourceAction", ErrorLevel.DEBUG, new Textmarker(indexedElement.getEndElementLocation().getLine(), indexedElement.getEndElementLocation().getColumn(), filename))); 
	
	}			
	
	@Override
	protected  Map<String, IAttributeParser<TrafficSourceActionImpl>> getAttributeNameToAttributeParserMap()
	{
		Map<String, IAttributeParser<TrafficSourceActionImpl>> result  = new Hashtable<String, IAttributeParser<TrafficSourceActionImpl>>();
		result.put(OscConstants.ATTRIBUTE__RATE, new IAttributeParser<TrafficSourceActionImpl>() {
			@Override
			public void parse(Position startPosition, Position endPosition, String attributeName, String attributeValue, TrafficSourceActionImpl object)
			{
				
				Textmarker startMarker = new Textmarker(startPosition.getLine(), startPosition.getColumn(),filename);
				Textmarker endMarker = new Textmarker(endPosition.getLine(), endPosition.getColumn(),filename);
				if (isParametrized(attributeValue))
				{
					object.setAttributeParameter(OscConstants.ATTRIBUTE__RATE, stripDollarSign(attributeValue), startMarker); 
				}else
				{
					// Parse value
					// Simple type
					object.setRate(parseDouble(attributeValue,startMarker));
				}
				object.putPropertyStartMarker(OscConstants.ATTRIBUTE__RATE, startMarker);
				object.putPropertyEndMarker(OscConstants.ATTRIBUTE__RATE, endMarker);
				
			}
			

			@Override
			public int getMinOccur() {
				return 1;
			}
			
		});
		result.put(OscConstants.ATTRIBUTE__RADIUS, new IAttributeParser<TrafficSourceActionImpl>() {
			@Override
			public void parse(Position startPosition, Position endPosition, String attributeName, String attributeValue, TrafficSourceActionImpl object)
			{
				
				Textmarker startMarker = new Textmarker(startPosition.getLine(), startPosition.getColumn(),filename);
				Textmarker endMarker = new Textmarker(endPosition.getLine(), endPosition.getColumn(),filename);
				if (isParametrized(attributeValue))
				{
					object.setAttributeParameter(OscConstants.ATTRIBUTE__RADIUS, stripDollarSign(attributeValue), startMarker); 
				}else
				{
					// Parse value
					// Simple type
					object.setRadius(parseDouble(attributeValue,startMarker));
				}
				object.putPropertyStartMarker(OscConstants.ATTRIBUTE__RADIUS, startMarker);
				object.putPropertyEndMarker(OscConstants.ATTRIBUTE__RADIUS, endMarker);
				
			}
			

			@Override
			public int getMinOccur() {
				return 1;
			}
			
		});
		result.put(OscConstants.ATTRIBUTE__VELOCITY, new IAttributeParser<TrafficSourceActionImpl>() {
			@Override
			public void parse(Position startPosition, Position endPosition, String attributeName, String attributeValue, TrafficSourceActionImpl object)
			{
				
				Textmarker startMarker = new Textmarker(startPosition.getLine(), startPosition.getColumn(),filename);
				Textmarker endMarker = new Textmarker(endPosition.getLine(), endPosition.getColumn(),filename);
				if (isParametrized(attributeValue))
				{
					object.setAttributeParameter(OscConstants.ATTRIBUTE__VELOCITY, stripDollarSign(attributeValue), startMarker); 
				}else
				{
					// Parse value
					// Simple type
					object.setVelocity(parseDouble(attributeValue,startMarker));
				}
				object.putPropertyStartMarker(OscConstants.ATTRIBUTE__VELOCITY, startMarker);
				object.putPropertyEndMarker(OscConstants.ATTRIBUTE__VELOCITY, endMarker);
				
			}
			

			@Override
			public int getMinOccur() {
				return 0;
			}
			
		});
		return result;
	}

	/**
	 * Parser for all subelements
	 */
	private class SubElementParser extends XmlAllParser<TrafficSourceActionImpl>{
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
		protected  List<IElementParser<TrafficSourceActionImpl>> createParserList()
		{
			List<IElementParser<TrafficSourceActionImpl>> result = new ArrayList<IElementParser<TrafficSourceActionImpl>>();
			result.add(new SubElementPositionParser());
			result.add(new SubElementTrafficDefinitionParser());
			return result;
		
		}	
	}
	/**
	 * A parser for subelement position
	 */
	private class SubElementPositionParser implements IElementParser<TrafficSourceActionImpl> {
	
		/**
		 * Constructor
		 */
		public SubElementPositionParser()
		{
			super();
			positionXmlParser = new PositionXmlParser(messageLogger, filename);
		}
		private PositionXmlParser positionXmlParser;
		
		@Override
		public void parse(IndexedElement indexedElement, ParserContext parserContext,TrafficSourceActionImpl object)
		{
			PositionImpl position = new PositionImpl();
			// Setting the parent
			position.setParent(object);
			positionXmlParser.parseElement(indexedElement,parserContext, position);

			object.setPosition( position);
			
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
				elementName.equals(OscConstants.ELEMENT__POSITION) ;
		}
		
		@Override
		public String[] getExpectedTagNames()
		{		 	return new String[]{
				OscConstants.ELEMENT__POSITION
					};
		}
	}
	/**
	 * A parser for subelement trafficDefinition
	 */
	private class SubElementTrafficDefinitionParser implements IElementParser<TrafficSourceActionImpl> {
	
		/**
		 * Constructor
		 */
		public SubElementTrafficDefinitionParser()
		{
			super();
			trafficDefinitionXmlParser = new TrafficDefinitionXmlParser(messageLogger, filename);
		}
		private TrafficDefinitionXmlParser trafficDefinitionXmlParser;
		
		@Override
		public void parse(IndexedElement indexedElement, ParserContext parserContext,TrafficSourceActionImpl object)
		{
			TrafficDefinitionImpl trafficDefinition = new TrafficDefinitionImpl();
			// Setting the parent
			trafficDefinition.setParent(object);
			trafficDefinitionXmlParser.parseElement(indexedElement,parserContext, trafficDefinition);

			object.setTrafficDefinition( trafficDefinition);
			
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
				elementName.equals(OscConstants.ELEMENT__TRAFFIC_DEFINITION) ;
		}
		
		@Override
		public String[] getExpectedTagNames()
		{		 	return new String[]{
				OscConstants.ELEMENT__TRAFFIC_DEFINITION
					};
		}
	}
}

